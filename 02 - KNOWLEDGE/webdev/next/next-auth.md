# [AUTHJS](https://authjs.dev/)


```shell
npm install next-auth
```


[Setup and Use NextAuth.js in Next.js 13 App Directory 2023 (codevoweb.com)](https://codevoweb.com/setup-and-use-nextauth-in-nextjs-13-app-directory/)


## Setup Next Auth API Route


NextAuth options

`app/api/auth/[...nextauth]/route.ts`

```tsx
import { authOptions } from "@/lib/auth";
import NextAuth from "next-auth";

const handler = NextAuth(authOptions);
export { handler as GET, handler as POST };
```


> [!export error]
> However, some users encountered export errors when running the code. 
> To address this issue, we can define and export the NextAuth options in a separate file, such as the `lib/auth.ts` file.
> 
> To implement this solution, navigate to the `src` directory and create a new folder called `lib`. Inside the `lib` folder, create a file named `auth.ts` and copy the following NextAuth configuration code into it. 

`src/lib/auth.ts`

```ts
import type { NextAuthOptions } from "next-auth";
import CredentialsProvider from "next-auth/providers/credentials";

export const authOptions: NextAuthOptions = {
  session: {
    strategy: "jwt",
  },
  providers: [
    CredentialsProvider({
      name: "Sign in",
      credentials: {
        email: {
          label: "Email",
          type: "email",
          placeholder: "example@example.com",
        },
        password: { label: "Password", type: "password" },
      },
      async authorize(credentials) {
        const user = { id: "1", name: "Admin", email: "admin@admin.com" };
        return user;
      },
    }),
  ],
};
```


- first we imported the `CredentialsProvider` module, which we’ll use for **validation**
- we defined an object called ‘**authOptions**‘ that contains the configuration for our authentication process
- In the `credentials` key of the `CredentialsProvider()` method, we listed the **email** and **password** fields, which will be available on the sign-in form.


The next step is to create an API route that can handle authentication requests from NextAuth. We’ll use the `NextAuth()` method to create an API handler and then export it as **GET** and **POST** functions for use in our application


`src/app/api/auth/[…nextauth]/route.ts`

```ts
import { authOptions } from "@/lib/auth";
import NextAuth from "next-auth";

const handler = NextAuth(authOptions);
export { handler as GET, handler as POST };
```


## Create Reusable Buttons


```tsx
"use client";

import { signIn, signOut } from "next-auth/react";
import Link from "next/link";

export const LoginButton = () => {
  return (
    <button style={{ marginRight: 10 }} onClick={() => signIn()}>
      Sign in
    </button>
  );
};

export const RegisterButton = () => {
  return (
    <Link href="/register" style={{ marginRight: 10 }}>
      Register
    </Link>
  );
};

export const LogoutButton = () => {
  return (
    <button style={{ marginRight: 10 }} onClick={() => signOut()}>
      Sign Out
    </button>
  );
};

export const ProfileButton = () => {
  return <Link href="/profile">Profile</Link>;
};
```


## .env

Before testing the authentication flow, we need to configure the required environment variables for NextAuth to function properly. 

These variables include a secret for JWT encryption and the root URL of your application.

Although it’s possible to avoid setting these variables if you’re only working with client-side logic, we must set them since we’ll be working with server-side rendering. To set these variables, create a `.env` file in the root directory and add the following environment variables to it.

`.env`

```ts
NEXTAUTH_SECRET=my_ultra_secure_nextauth_secret
NEXTAUTH_URL=http://localhost:3000
```

## To view the cookies

open the Application tab of your browser’s developer tool and click on `http://localhost:3000/` in the Cookies section.

## Getting the NextAuth Session Data

### Get the Session in a Server Component

This can be done by calling the `getServerSession` function and providing the ‘**authOptions**‘ object that was exported from the `lib/auth.ts` file during the NextAuth setup.

To implement this, simply replace the content of `src/app/page.tsx` with the code snippet below. Once you’ve done this, start the Next.js development server and navigate to `http://localhost:3000/` to view the session data output on the screen.

`src/app/page.tsx`

```tsx
import {
  LoginButton,
  LogoutButton,
  ProfileButton,
  RegisterButton,
} from "@/components/buttons.component";
import { getServerSession } from "next-auth";
import { authOptions } from "@/lib/auth";

export default async function Home() {
  const session = await getServerSession(authOptions);
  console.log(session);

  return (
    <main
      style={{
        display: "flex",
        justifyContent: "center",
        alignItems: "center",
        height: "70vh",
      }}
    >
      <div>
        <LoginButton />
        <RegisterButton />
        <LogoutButton />
        <ProfileButton />

        <h1>Server Session</h1>
        <pre>{JSON.stringify(session)}</pre>
      </div>
    </main>
  );
}

```

### Get the Session in an API Route

we’ll use the `getServerSession` function and provide the `authOptions` to acquire the session data.

Create a `route.ts` file in a new “**session**” directory within the `src/app/api` folder. Here’s the code to include:

`src/app/api/session/route.ts`

```tsx
import { getServerSession } from "next-auth";
import { authOptions } from "@/lib/auth";
import { NextResponse } from "next/server";

export async function GET(request: Request) {
  const session = await getServerSession(authOptions);

  return NextResponse.json({
    authenticated: !!session,
    session,
  });
}
```


http://localhost:3000/api/session


### Get the Session in a Client Component

NextAuth requires a session provider to be set up on the client-side

Once the provider is in place and wraps around your application, you can use a client-side hook called `useSession` to obtain the session information

Since the client can’t decode the JSON Web Token (JWT) on its own, the `useSession` hook makes an HTTP request to the server to retrieve the session information. The server decodes the JWT and sends it back, and NextAuth stores the session data in the provider, which the `useSession` hook can then access.

>[!Info]
>It’s worth noting that there may be some latency added when making the session request for the first time, as the server needs to decode the JWT. But once the data is stored in the provider, subsequent requests will be fast and seamless.


To create the session provider, simply create a `providers.tsx` file in the “**src/app**” directory and add the following code.

`src/app/providers.tsx`

```tsx
"use client";

import { SessionProvider } from "next-auth/react";

type Props = {
  children?: React.ReactNode;
};

export const NextAuthProvider = ({ children }: Props) => {
  return <SessionProvider>{children}</SessionProvider>;
};

```

After creating the session provider, wrap it around `{children}` in the `src/app/layout.tsx` file so that all client-side components can access the session data. Here’s the code you can use

`src/app/layout.tsx`

```tsx
import { NextAuthProvider } from "./providers";

export const metadata = {
  title: "Create Next App",
  description: "Generated by create next app",
};

export default function RootLayout({
  children,
}: {
  children: React.ReactNode;
}) {
  return (
    <html lang="en">
      <body>
        <NextAuthProvider>{children}</NextAuthProvider>
      </body>
    </html>
  );
}

```


## 

Now, we’ll create a new component that will allow us to use the `useSession` hook to retrieve the session data and display it on the client-side. 

First, navigate to the ‘**components**‘ directory and create a new file named `user.component.tsx`. Then, paste the following code into the new file.


`src/components/user.component.tsx`

```tsx
"use client";

import { useSession } from "next-auth/react";

export const User = () => {
  const { data: session } = useSession();

  return (
    <>
      <h1>Client Session</h1>
      <pre>{JSON.stringify(session)}</pre>
    </>
  );
};

```


## Implement the NextAuth Authentication Code

`async authorize(credentials) {}` function to first verify if the email and password information were included in the request body.

`src/lib/auth.ts`

```tsx
import { prisma } from "@/lib/prisma";
import { compare } from "bcryptjs";
import type { NextAuthOptions } from "next-auth";
import CredentialsProvider from "next-auth/providers/credentials";

export const authOptions: NextAuthOptions = {
  session: {
    strategy: "jwt",
  },
  providers: [
    CredentialsProvider({
      name: "Sign in",
      credentials: {
        email: {
          label: "Email",
          type: "email",
          placeholder: "example@example.com",
        },
        password: { label: "Password", type: "password" },
      },
      async authorize(credentials) {
        if (!credentials?.email || !credentials.password) {
          return null;
        }

        const user = await prisma.user.findUnique({
          where: {
            email: credentials.email,
          },
        });

        if (!user || !(await compare(credentials.password, user.password))) {
          return null;
        }

        return {
          id: user.id,
          email: user.email,
          name: user.name,
          randomKey: "Hey cool",
        };
      },
    }),
  ],
};

```


## Store Custom Keys in the Session

NextAuth provides two handy callbacks – `jwt` and `session` – that allows us to add our own custom information to the session object.

To add your custom keys, you can modify these two callbacks in the `callbacks` property of the NextAuth configuration


`src/lib/auth.ts`

```tsx
import type { NextAuthOptions } from "next-auth";
import CredentialsProvider from "next-auth/providers/credentials";

export const authOptions: NextAuthOptions = {
    session: {
        strategy: "jwt",
    },
    providers: [
        CredentialsProvider({
            name: "Sign in",
            credentials: {
                username: {
                    label: "Username",
                    type: "text",
                    placeholder: "username",
                },
                password: { label: "Password", type: "password" },
            },
            async authorize(credentials) {
                if (!credentials?.username || !credentials.password)
                    return null;

                const credentialsRecord: Record<string, string> = {
                    ...credentials,
                };

                const res = await fetch("http://127.0.0.1:8000/auth/login", {
                    method: "POST",
                    body: new URLSearchParams(credentialsRecord),
                });

                if (!res.ok) return null;

                const token = (await res.json()) as string;

                console.log(token);

                return {
                    id: "23",
                    name: credentials.username,
                    email: "johndoe@email.com",
                    accessToken: token,
                };
            },
        }),
    ],
    callbacks: {
        session: async ({ session, token }) => {
            // Send properties to the client, like an access_token and user id from a provider.
            // session.accessToken = token.accessToken
            console.log("Session Callback", { session, token });

            return {
                ...session,
                user: {
                    ...session.user,
                    id: token.id,
                    token: token.accessToken,
                },
            };
        },
        jwt: async ({ token, user }) => {
            console.log("JWT Callback", { token, user });

            if (user) {
                const u = user as unknown as any;
                return {
                    ...token,
                    accessToken: u.accessToken,
                };
            }
            return token;
        },
    },
};
```


## Different Ways to Protect Routes

One of the most crucial parts of any authentication system is protecting certain routes, whether it’s a whole section of your app, a single page, or an API endpoint. In Next.js, 

there are four main ways to implement route protection: 
- in a server component
- in a client component
- in an API route
- using middleware.

generally recommended to use server-side protection or middleware


### Client-Side Route Protection

The first way to implement protected routes is to use the `useSession` hook in a client-side component to load the session. This approach is similar to what we’ve seen before, but this time we’ll add an `onUnauthenticated()` method to the object passed to the hook, which will be called when the user is not logged in.


To see this in action, let’s create a new folder called “**profile**” inside the “**src/app**” directory. Inside the “**profile**” folder, create a `page.tsx` file and add the following code. This page will serve as our private page that only authenticated users can access. Once the user is authenticated, a list of users will be displayed.

`src/app/profile/page.tsx`

```tsx
"use client";

import { redirect } from "next/navigation";
import { useSession } from "next-auth/react";
import { cache, use } from "react";

type User = {
  id: number;
  name: string;
  email: string;
};

const getUsers = cache(() =>
  fetch("https://jsonplaceholder.typicode.com/users").then((res) => res.json())
);

export default function Profile() {
  const { status } = useSession({
    required: true,
    onUnauthenticated() {
      redirect("/api/auth/signin");
    },
  });

  if (status === "loading") {
    return <p>Loading....</p>;
  }

  let users = use<User[]>(getUsers());

  return (
    <main style={{ maxWidth: 1200, marginInline: "auto", padding: 20 }}>
      <div
        style={{
          display: "grid",
          gridTemplateColumns: "1fr 1fr 1fr 1fr",
          gap: 20,
        }}
      >
        {users.map((user) => (
          <div
            key={user.id}
            style={{ border: "1px solid #ccc", textAlign: "center" }}
          >
            <img
              src={`https://robohash.org/${user.id}?set=set2&size=180x180`}
              alt={user.name}
              style={{ height: 180, width: 180 }}
            />
            <h3>{user.name}</h3>
          </div>
        ))}
      </div>
    </main>
  );
}

```


http://localhost:3000/profile

You will immediately be redirected to the sign-in page. However, there will be a brief loading period because the `useSession` hook needs to make an HTTP request to the server to decode the JWT

After it receives the result from the server, it will check if you have a valid session. If you do not, it will trigger the `onUnauthenticated()` method, which in turn will call the `redirect()` function to redirect you to the sign-in page



### Server-Side Route Protection


we’ll utilize the `getServerSession` function to retrieve the session information, and then use an `if` statement to check if the session was successfully retrieved. If the user isn’t logged in, `null` will be returned, and we can redirect them to the sign-in page.

`src/app/profile/page.tsx`

```tsx
import { getServerSession } from "next-auth";
import { authOptions } from "@/lib/auth";
import { redirect } from "next/navigation";

type User = {
  id: number;
  name: string;
  email: string;
};

export default async function Profile() {
  const session = await getServerSession(authOptions);

  if (!session) {
    redirect("/api/auth/signin");
  }

  const users: User[] = await fetch(
    "https://jsonplaceholder.typicode.com/users"
  ).then((res) => res.json());

  return (
    <main style={{ maxWidth: 1200, marginInline: "auto", padding: 20 }}>
      <div
        style={{
          display: "grid",
          gridTemplateColumns: "1fr 1fr 1fr 1fr",
          gap: 20,
        }}
      >
        {users.map((user) => (
          <div
            key={user.id}
            style={{ border: "1px solid #ccc", textAlign: "center" }}
          >
            <img
              src={`https://robohash.org/${user.id}?set=set2&size=180x180`}
              alt={user.name}
              style={{ height: 180, width: 180 }}
            />
            <h3>{user.name}</h3>
          </div>
        ))}
      </div>
    </main>
  );
}

```

To test this approach, ensure that you have signed out from your account on the homepage. Then, try to access the profile page again. You will be redirected to the signin page, but unlike the previous approach, there won’t be any loading period. This is because the server component immediately checks if the user is authenticated before serving the page. This creates a seamless and secure user experience.



### Protect an API Route

To achieve this, we can use the `getServerSession` function to obtain the session information and check if it exists. If it doesn’t, we can return an unauthorized error with the message “**You are not logged in**“.

`src/app/api/session/route.ts`

```tsx
import { getServerSession } from "next-auth";
import { authOptions } from "@/lib/auth";
import { NextResponse } from "next/server";

export async function GET(request: Request) {
  const session = await getServerSession(authOptions);

  if (!session) {
    return new NextResponse(
      JSON.stringify({ status: "fail", message: "You are not logged in" }),
      { status: 401 }
    );
  }

  return NextResponse.json({
    authenticated: !!session,
    session,
  });
}

```


To test this approach, first sign out from your account on the homepage. Then, visit the API route at `http://localhost:3000/api/session`. If you are not logged in, you should see an unauthorized error sent by the server, which includes a message stating “**You are not logged in**“. This confirms that the API route is properly protected and unauthorized users cannot access it.

![[Unauthorized-Response-From-the-Next.js-API-Route.webp]]


### Middleware Route Protection

The final and most preferable approach to protecting routes is by using middleware

This is the best way because it enables you to protect an entire subdirectory or all pages of your application, rather than adding route protection logic to each individual page

To protect all pages of your Next.js application with NextAuth, you can simply create a `middleware.ts` file in your `src` directory and export the default middleware wrapper provided by NextAuth using the following line of code:

`src/middleware.ts`

```tsx
export { default } from "next-auth/middleware";
```

If you need to protect single or multiple pages, or API routes, you can export a config object with a `matcher` key. The `matcher` is an array that can contain the routes you want to protect. In the code below, we added `"/((?!register|api|login).*)"` to the `matcher` array. This ensures that any route other than those for the **register**, **login**, and **api** directories will be protected.

`src/middleware.ts`

```tsx
export { default } from "next-auth/middleware";

export const config = {
  // matcher: ["/profile"],
  matcher: ["/((?!register|api|login).*)"],
};
```


## Implement the Account Registration Logic

### Create the API Route to Register Users

Now, let’s create an API route to handle user registration. We’ll define a route handler that extracts the user’s credentials from the request body and send a request to the backend

`src/app/api/register/route.ts`

```tsx
import { NextResponse } from "next/server";

export async function POST(req: Request) {
    try {
        const { name, password } = (await req.json()) as {
            name: string;
            password: string;
        };

        const res = await fetch("http://127.0.0.1:8000/auth/login", {
            method: "POST",
            body: new URLSearchParams({ name, password }),
        });

        const token = (await res.json()) as string;

        console.log(token);

        return NextResponse.json({
            user: {
                id: "23",
                name: name,
                email: "johndoe@email.com",
                accessToken: token,
            },
        });
    } catch (error: any) {
        return new NextResponse(
            JSON.stringify({
                status: "error",
                message: error.message,
            }),
            { status: 500 }
        );
    }
}
```


### Create the Form Component

Now that we have the API logic in place, let’s create a form component for user registration. Since we’ll be handling the form using hooks and DOM events, it’s important to make sure this component is only rendered in the browser. You can achieve this by adding the `"use client";` flag at the top of the file.

The registration form will allow users to input their registration details and submit them to the API. To get started, create a ‘**register**‘ directory within the ‘**src/app**‘ directory. Then, inside the ‘**register**‘ directory, create a file called `form.tsx`. This file will contain the code for the registration form.

`src/app/register/form.tsx`

```tsx
"use client";

import { signIn } from "next-auth/react";
import { ChangeEvent, useState } from "react";

export const RegisterForm = () => {
  let [loading, setLoading] = useState(false);
  let [formValues, setFormValues] = useState({
    name: "",
    email: "",
    password: "",
  });

  const onSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    setLoading(true);

    try {
      const res = await fetch("/api/register", {
        method: "POST",
        body: JSON.stringify(formValues),
        headers: {
          "Content-Type": "application/json",
        },
      });

      setLoading(false);
      if (!res.ok) {
        alert((await res.json()).message);
        return;
      }

      signIn(undefined, { callbackUrl: "/" });
    } catch (error: any) {
      setLoading(false);
      console.error(error);
      alert(error.message);
    }
  };

  const handleChange = (event: ChangeEvent<HTMLInputElement>) => {
    const { name, value } = event.target;
    setFormValues({ ...formValues, [name]: value });
  };

  return (
    <form
      onSubmit={onSubmit}
      style={{
        display: "flex",
        flexDirection: "column",
        width: 500,
        rowGap: 10,
      }}
    >
      <label htmlFor="name">Name</label>
      <input
        required
        type="text"
        name="name"
        value={formValues.name}
        onChange={handleChange}
        style={{ padding: "1rem" }}
      />
      <label htmlFor="email">Email</label>
      <input
        required
        type="email"
        name="email"
        value={formValues.email}
        onChange={handleChange}
        style={{ padding: "1rem" }}
      />
      <label htmlFor="password">Password</label>
      <input
        required
        type="password"
        name="password"
        value={formValues.password}
        onChange={handleChange}
        style={{ padding: "1rem" }}
      />
      <button
        style={{
          backgroundColor: `${loading ? "#ccc" : "#3446eb"}`,
          color: "#fff",
          padding: "1rem",
          cursor: "pointer",
        }}
        disabled={loading}
      >
        {loading ? "loading..." : "Register"}
      </button>
    </form>
  );
};

```


### Create the Account Registration Page

`src/app/register/page.tsx`

```tsx
import { RegisterForm } from "./form";

export default function RegisterPage() {
  return (
    <div
      style={{
        display: "flex",
        height: "70vh",
        justifyContent: "center",
        alignItems: "center",
      }}
    >
      <div>
        <h1>Register</h1>
        <RegisterForm />
      </div>
    </div>
  );
}

```
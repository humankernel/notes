---

excalidraw-plugin: parsed
tags: [excalidraw]

---
==⚠  Switch to EXCALIDRAW VIEW in the MORE OPTIONS menu of this document. ⚠==


# Text Elements
api/auth/[...nextauth]/route.ts ^U86nQjvn

next-auth options ^rtQxCf13

const handler = NextAuth(authOptions);
export { handler as GET, handler as POST }; ^PZtPsX8f

this is where next-auth will
receive the authOptions ^h7KKXaR4

1 ^JYQAGWX9

2 ^KkPordYr

import type { NextAuthOptions } from "next-auth";
import CredentialsProvider from "next-auth/providers/credentials";

export const authOptions: NextAuthOptions = {
    session: {
        strategy: "jwt",
    },
    providers: [...],
    callbacks: {...},
    },
};
 ^RbP7eb8r

authOptions contains
- pages (custom routes)
- session: {}
- providers: []
- callbacks: {} ^UQyQrYLT

3 ^5xLLdL50

lib/auth.ts  or  api/auth/[...nextaut]/options.ts ^XwmQJg8U

.env.local ^XiKMzFDe

this is where

- NEXTAUTH_SECRET
- NEXTAUTH_URL ^JSYUOzES

generate a secret token with

$ openssl rand -base64 32 ^dthKzowe

NEXTAUTH_SECRET=my_ultra_secure_nextauth_secret
NEXTAUTH_URL=http://localhost:3000

GITHUB_SECRET=
GITHUB_ID=
... ^ZgWf2bIq

providers: [...] ^GPHEnGP3

GitHubProvider({
    clientId: process.env.GITHUB_ID,
    clientSecret: process.env.GITHUB_SECRET,
}), ^xmTBOyyp

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
}) ^dXKUKYza

The CredentialsProvider is where you
do authorization with 
username, email, password 



name: the name of your provider

credentials: {
    username: {
        label: string
        type: "text" | "email" | "password"
        placeholder:
    }
}


async authorize(credentials) {
    
    this function does the authorization
    this is where you want to authorize the
    user in the server with a fetch or store
    the user in the DB 
    

    receives => credentials
    returns  => user object | null

}
 ^tUWdjz84

4 ^24rxYoxT

middleware
This file tells next
what routes you want 
to "protect" ^ZZbRUYV6

middleware.ts ^Gea43MSi

//without the matcher, this line applies next-auth
//to the entire project

//this means that when you want to access a page you 
//have not access because your aren't logged in Next-Auth
//will redirect you to the /signin page 

export { default } from "next-auth/middleware";



export const config = {
    // matcher: ["/profile"],
    matcher: ["/((?!register|api|login).*)"],
}; ^pb9Xm0du

5 ^sAUgpRzJ

use getServerSession(authOptions)
for get the session in a server
component ^aXH5sn5W

app/page.tsx ^Nm2tw9m1

export default async function Home() {
    const session = await getServerSession(authOptions);

    return (
        <main>
            <div>
                <LoginButton />
                <RegisterButton />
                <LogoutButton />
                <ProfileButton />

                <h1>Server Session</h1>
                <pre>{JSON.stringify(session)}</pre>

                <User />
            </div>
        </main>
    );
}
 ^F9rKKSUR

in the home server component
we get the session   ^rr59fJK1

6 ^9IdfJRYb

context for sharing 
the user session to 
client components ^y0IvRP9Z

context/AuthProvider.tsx ^kppWGtOU

"use client";

import { SessionProvider } from "next-auth/react";

const AuthProvider = ({ children }) => (
    <SessionProvider> {children} </SessionProvider>
);

export default AuthProvider;

 ^xoNF9kch

this is a client component ^vAjGa3pS

7 ^rPnpG5DG

now we wrap the app/layout.tsx
with the AuthProvider ^2roJFnLU

context/AuthProvider.tsx ^M6ZZi56Y

export default function RootLayout({
    children,
}: {
    children: React.ReactNode;
}) {
    return (
        <html lang="en">
            <body className={inter.className}>
                <AuthProvider>{children}</AuthProvider>
            </body>
        </html>
    );
}


 ^7qz2yRIo

THIS IS ONLY NECESSARY for the client component
that need the session ^lijyImYy

"use client";

// Remeber you must use an AuthProvider for
// client components to useSession

import { useSession } from "next-auth/react";
import { redirect } from "next/navigation";

const ClientPage = () => {
    const { data: session } = useSession({
        required: true,
        onUnauthenticated() {
            redirect("/api/auth/signin?callbackUrl=/client");
        },
    });

    return (
        <section>
            <div>
                username: {session?.user?.name}
                email: {session?.user?.email}
            </div>
        </section>
    );
};

export default ClientPage;
 ^uSgzaNBE

callbacks: {
        session: async ({ session, token }) => {
            // Send properties to the client, like an access_token 
            // and user id from a provider.
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
    }, ^EqAAu9xA

8 ^fBDFme29

signin function ^maruae8Z

signIn("credentials", {
    username: userName.current,
    password: pass.current,
    redirect: true,
    callbackUrl: "/"
}) ^cJlZe4nU

custom login page
 ^y3dTA4rr

pages nextauth options ^nQTfN4mj

export const authOptions: NextAuthOptions = {
    session: {...},
    pages: {
        signIn: "/signin",
    },
    providers: [...] ^Nz25xx75

redirect: true   <- this tells nextauth
                    that redirect to the callbackUrl
                    ones the signin is complete
callbackUrl: "/" <- where to redirect ^tpKL5b2C

%%
# Drawing
```compressed-json
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

RhAMwB5UMrBiAN4jpoOAB+0D7hGQiwwQINOAgAA=
```
%%
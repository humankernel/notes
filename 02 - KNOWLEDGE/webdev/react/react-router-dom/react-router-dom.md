
- `react-router-dom` 
- `localforage`: localForage is a JavaScript storage library that improves the offline experience of web apps by using asynchronous storage with a simple, localStorage-like API



```shell
pnpm install react-router-dom
```



##  Adding a Router

First thing to do is create a [Browser Router](https://reactrouter.com/en/main/routers/create-browser-router) and configure our first route. This will enable client side routing for our web app.

The `main.jsx` file is the entry point. Open it up and we'll put React Router on the page.

**Create and render a [browser router](https://reactrouter.com/en/main/routers/create-browser-router) in `main.jsx`**


`src/main.jsx`

```tsx
import * as React from "react";
import * as ReactDOM from "react-dom/client";
import {
  createBrowserRouter,
  RouterProvider,
} from "react-router-dom";
import "./index.css";

const router = createBrowserRouter([
  {
    path: "/",
    element: <div>Hello world!</div>,
  },
]);

ReactDOM.createRoot(document.getElementById("root")).render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>
);
```


This first route is what we often call the "root route" since the rest of our routes will render inside of it. It will serve as the root layout of the UI, we'll have nested layouts as we get farther along.


##  The Root Route

**The key point here is the <Outlet />** (this will tell react-router-dom) to render the root children in that location


Create `src/routes` and `src/routes/root.jsx`

```tsx
export default function Root() {
  return (
    <>
      <div id="sidebar">
        <h1>React Router Contacts</h1>
        <div>
          <form id="search-form" role="search">
            <input
              id="q"
              aria-label="Search contacts"
              placeholder="Search"
              type="search"
              name="q"
            />
            <div
              id="search-spinner"
              aria-hidden
              hidden={true}
            />
            <div
              className="sr-only"
              aria-live="polite"
            ></div>
          </form>
          <form method="post">
            <button type="submit">New</button>
          </form>
        </div>
        <nav>
          <ul>
            <li>
              <a href={`/contacts/1`}>Your Name</a>
            </li>
            <li>
              <a href={`/contacts/2`}>Your Friend</a>
            </li>
          </ul>
        </nav>
      </div>
      <div id="detail"></div>
    </>
  );
}
```

this is the root layout, it renders a sidebar with the contact list




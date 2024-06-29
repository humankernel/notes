
## Install Tailwind CSS with Vite

1.  ## Create your project
    
    Start by creating a new Vite project if you don’t have one set up already. The most common approach is to use [Create Vite](https://vitejs.dev/guide/#scaffolding-your-first-vite-project).
    
    Terminal
    
    ```shell
    npm create vite@latest my-project -- --template react
    cd my-project
    ```
    
2.  ## Install Tailwind CSS
    
    Install `tailwindcss` and its peer dependencies via npm, and then run the init command to generate both `tailwind.config.cjs` and `postcss.config.cjs`.
    
    Terminal
    
    ```shell
    npm install -D tailwindcss postcss autoprefixernpx 
    npx tailwindcss init -p
    ```
    
3.  ## Configure your template paths
    
    Add the paths to all of your template files in your `tailwind.config.cjs` file.
    
    `tailwind.config.cjs`
    
    ```cjs
    /** @type {import('tailwindcss').Config} */
    module.exports = {
      content: [
        "./index.html",
        "./src/**/*.{js,ts,jsx,tsx}",
      ],
      theme: {
        extend: {},
      },
      plugins: [],
    }
    ```
    
4.  ## Add the Tailwind directives to your CSS
    
    Add the `@tailwind` directives for each of Tailwind’s layers to your `./src/index.css` file.
    
    index.css
    ```css
    @tailwind base;
    @tailwind components;
    @tailwind utilities;
    ```
    
5.  ## Start your build process
    
    Run your build process with `npm run dev`.
    
    Terminal
    
    ```shell
    npm run dev
    ```
    
6.  ## Start using Tailwind in your project
    
    Start using Tailwind’s utility classes to style your content.
    
    App.jsx
    
    ```jsx
    export default function App() {
      return (
        <h1 className="text-3xl font-bold underline">
          Hello world!
        </h1>
      )
    }
    ```
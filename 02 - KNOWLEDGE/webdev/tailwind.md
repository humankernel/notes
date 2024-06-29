
## Install
[Install Tailwind CSS with Vite - Tailwind CSS](https://tailwindcss.com/docs/guides/vite)

```shell
npm install -D tailwindcss postcss autoprefixer
npx tailwindcss init -p
```



tailwind.config.js
```
/** @type {import('tailwindcss').Config} */
export default {
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


index.css

```
@tailwind base;
@tailwind components;
@tailwind utilities;
```

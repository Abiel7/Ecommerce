/** @type {import('tailwindcss').Config} */
module.exports = {
    purge: {
      enabled: process.env.PURGE_CSS === "production" ? true : false,
      content: ["./src/**/*.{js,jsx,ts,tsx}", "./public/index.html"],
    },
    darkMode: false, // or 'media' or 'class'
    theme: {
      extend: {},
    },
    variants: {
      extend: {},
    },
    plugins: [],
  };

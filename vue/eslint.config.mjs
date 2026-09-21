import js from "@eslint/js";
import globals from "globals";
import pluginVue from "eslint-plugin-vue";

export default [

  // Files that should not be linted
  {
    ignores: [
      "dist/**",
      "node_modules/**"
    ]
  },

  // Recommended JavaScript rules
  js.configs.recommended,

  // Essential Vue 3 rules
  ...pluginVue.configs["flat/essential"],

  // Application configuration
  {
    files: [
      "src/**/*.{js,vue}"
    ],

    languageOptions: {
      ecmaVersion: "latest",
      sourceType: "module",

      globals: {
        ...globals.browser
      }
    },

    rules: {
      "no-unused-vars": "off"
    }
  }

];

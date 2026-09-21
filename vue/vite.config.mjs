import { fileURLToPath, URL } from "node:url";
import { defineConfig } from "vite";
import vue from "@vitejs/plugin-vue";

export default defineConfig({

  plugins: [
    vue()
  ],

  // Load environment variables from the project root
  envDir: "..",

  resolve: {
    alias: {
      "@": fileURLToPath(
        new URL("./src", import.meta.url)
      )
    }
  },

  // Send API requests to the Spring Boot server
  server: {
    proxy: {
      "/api": {
        target: "http://localhost:9000",
        changeOrigin: true
      }
    }
  }

});

import { fileURLToPath, URL } from 'node:url';
import { defineConfig } from 'vite';
import vue from '@vitejs/plugin-vue';

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue()],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url))
    }
  }
  // 1st try Google Maps:
  // optimizeDeps: {
  //   include: [
  //     "@fawmi/vue-google-maps",
  //     "fast-deep-equal",
  //   ]
  // }
});

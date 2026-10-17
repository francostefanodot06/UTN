import { defineConfig } from 'vite';
import { resolve } from 'path';

export default defineConfig({
  build: {
    rollupOptions: {
      input: {
        index: resolve(__dirname, 'index.html'),
        authRegistro: resolve(__dirname, 'src/pages/auth/registro/registro.html'),
        authLogin: resolve(__dirname, 'src/pages/auth/login/login.html'),
        clientHome: resolve(__dirname, 'src/pages/client/home/home.html'),
        clientCart: resolve(__dirname, 'src/pages/client/cart/cart.html')
      },
    },
  },
  base: './'
});
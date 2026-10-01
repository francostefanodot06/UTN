import type { IUser } from './types/IUser';
import { Rol } from './types/Rol';

function routeGuard() {
    const path = window.location.pathname;
    const isAuthPage = path.includes('/auth/');
    
    let user: IUser | null = null;
    
    // Evita que un JSON roto en el navegador crashee la aplicación
    try {
        const userDataStr = localStorage.getItem('userData');
        user = userDataStr ? JSON.parse(userDataStr) : null;
    } catch (error) {
        localStorage.removeItem('userData'); 
    }

    // 1. Manejo específico para destrabar la ruta principal "/"
    if (path === '/') {
        if (user) {
            window.location.href = user.rol === Rol.ADMIN ? '/src/pages/admin/index.html' : '/src/pages/client/index.html';
        } else {
            window.location.href = '/src/pages/auth/login/index.html';
        }
        return;
    }

    // 2. Si no hay sesión y trata de entrar a admin o client, mandarlo a login
    if (!user && !isAuthPage) {
        window.location.href = '/src/pages/auth/login/index.html';
        return;
    }

    // 3. Si hay sesión y trata de entrar a una vista bloqueada o a login/registro
    if (user) {
        if (path.includes('/admin/') && user.rol !== Rol.ADMIN) {
            alert('Acceso denegado. Redirigiendo a tu panel...');
            window.location.href = '/src/pages/client/index.html';
            return;
        }
        
        // Evitar que vuelva al login/registro si ya está logueado
        if (isAuthPage) {
            const redirectUrl = user.rol === Rol.ADMIN ? '/src/pages/admin/index.html' : '/src/pages/client/index.html';
            window.location.href = redirectUrl;
        }
    }
}

routeGuard();
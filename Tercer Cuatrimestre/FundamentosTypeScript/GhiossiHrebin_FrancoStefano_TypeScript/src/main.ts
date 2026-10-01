import { IUser } from './types/IUser';
import { Rol } from './types/Rol';

function routeGuard() {
    const path = window.location.pathname;
    const isAuthPage = path.includes('/auth/');
    
    const userDataStr = localStorage.getItem('userData');
    const user: IUser | null = userDataStr ? JSON.parse(userDataStr) : null;

    // Si no hay sesión y trata de entrar a admin o client, mandarlo a login
    if (!user && !isAuthPage) {
        window.location.href = '/src/pages/auth/login/index.html';
        return;
    }

    // Si hay sesión y trata de entrar a una vista bloqueada por su rol
    if (user) {
        if (path.includes('/admin/') && user.rol !== Rol.ADMIN) {
            alert('Acceso denegado. Redirigiendo a tu panel...');
            window.location.href = '/src/pages/client/index.html';
        }
        
        // Evitar que vuelva al login si ya está logueado
        if (isAuthPage) {
            const redirectUrl = user.rol === Rol.ADMIN ? '/src/pages/admin/index.html' : '/src/pages/client/index.html';
            window.location.href = redirectUrl;
        }
    }
}

// Ejecutar al cargar la página
routeGuard();
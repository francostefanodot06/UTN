import { IUser } from '../../../types/IUser';

const loginForm = document.getElementById('loginForm') as HTMLFormElement;

loginForm?.addEventListener('submit', (e: Event) => {
    e.preventDefault();

    const email = (document.getElementById('email') as HTMLInputElement).value;
    const password = (document.getElementById('password') as HTMLInputElement).value;

    const users: IUser[] = JSON.parse(localStorage.getItem('users') || '[]');
    
    const validUser = users.find(u => u.email === email && u.password === password);

    if (validUser) {
        localStorage.setItem('userData', JSON.stringify(validUser));
        
        // Redirigir según el rol
        if (validUser.rol === 'admin') {
            window.location.href = '../../admin/index.html';
        } else {
            window.location.href = '../../client/index.html';
        }
    } else {
        alert('Credenciales incorrectas.');
    }
});
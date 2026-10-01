import { IUser } from '../../../types/IUser';
import { Rol } from '../../../types/Rol';

const registerForm = document.getElementById('registerForm') as HTMLFormElement;

registerForm?.addEventListener('submit', (e: Event) => {
    e.preventDefault();

    const email = (document.getElementById('email') as HTMLInputElement).value;
    const password = (document.getElementById('password') as HTMLInputElement).value;

    // Por defecto, registramos a todos como CLIENT. 
    // Podrías crear un admin manual en localStorage si necesitas probar esa vista.
    const newUser: IUser = { email, password, rol: Rol.CLIENT };

    const existingUsers = JSON.parse(localStorage.getItem('users') || '[]');
    
    // Evitar duplicados
    const userExists = existingUsers.some((u: IUser) => u.email === newUser.email);
    if (userExists) {
        alert('El usuario ya existe.');
        return;
    }

    existingUsers.push(newUser);
    localStorage.setItem('users', JSON.stringify(existingUsers));
    
    alert('Registro exitoso. Ya podés iniciar sesión.');
    window.location.href = '../login/index.html';
});
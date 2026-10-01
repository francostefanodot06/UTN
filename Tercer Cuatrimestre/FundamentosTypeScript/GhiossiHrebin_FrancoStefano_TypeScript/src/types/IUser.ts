import { Rol } from './Rol';

export interface IUser {
    email: string;
    password: string;
    rol: Rol;
}
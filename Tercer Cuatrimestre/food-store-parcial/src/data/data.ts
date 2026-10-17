import { IProduct } from "../types/IProduct";
import { ICategoria } from "../types/ICategoria";

export const getCategories = (): ICategoria[] => {
  return [
    { id: 1, name: "Hamburguesas" },
    { id: 2, name: "Pizzas" },
    { id: 3, name: "Bebidas" }
  ];
};

export const PRODUCTS: IProduct[] = [
  { id: 1, name: "Hamburguesa Clásica", price: 5000, categoryId: 1, image: "burger.jpg" },
  { id: 2, name: "Pizza Muzza", price: 8000, categoryId: 2, image: "pizza.jpg" },
  { id: 3, name: "Coca Cola 1.5L", price: 2000, categoryId: 3, image: "coca.jpg" }
];
import type { IProduct } from "../types/IProduct";
import type { ICategoria } from "../types/categoria";

export const getCategories = (): ICategoria[] => {
  return [
    { id: 1, name: "Hamburguesas" },
    { id: 2, name: "Pizzas" },
    { id: 3, name: "Bebidas" }
  ];
};

export const PRODUCTS: IProduct[] = [
  { id: 1, name: "Hamburguesa Clásica", price: 5000, categoryId: 1, image: "https://images.unsplash.com/photo-1568901346375-23c9450c58cd?w=500&q=80" },
  { id: 2, name: "Pizza Muzza", price: 8000, categoryId: 2, image: "https://images.unsplash.com/photo-1513104890138-7c749659a591?w=500&q=80" },
  { id: 3, name: "Coca Cola 1.5L", price: 2000, categoryId: 3, image: "https://images.unsplash.com/photo-1622483767028-3f66f32aef97?w=500&q=80" }
];
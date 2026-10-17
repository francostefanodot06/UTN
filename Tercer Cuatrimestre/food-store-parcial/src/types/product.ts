export interface IProduct {
  id: number;
  name: string;
  price: number;
  categoryId: number;
  image: string;
}

export interface ICartItem extends IProduct {
  quantity: number;
}
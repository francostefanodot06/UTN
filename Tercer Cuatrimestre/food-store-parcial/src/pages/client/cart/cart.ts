import { getCartItems, getCartTotal } from '../../../utils/cart';

const cartContainer = document.getElementById('cart-container') as HTMLDivElement;
const totalContainer = document.getElementById('total-container') as HTMLDivElement;
const btnBackToHome = document.getElementById('back-to-home') as HTMLButtonElement;

const renderCart = () => {
  const items = getCartItems();
  cartContainer.innerHTML = '';

  if (items.length === 0) {
    cartContainer.innerHTML = '<p>Tu carrito está vacío.</p>';
    totalContainer.innerHTML = '';
    return;
  }

  items.forEach(item => {
    const div = document.createElement('div');
    div.className = 'cart-item';
    div.innerHTML = `
      <div>
        <h3>${item.name}</h3>
        <p>Precio unitario: $${item.price}</p>
      </div>
      <div>
        <p>Cantidad: ${item.quantity}</p>
        <p>Subtotal: $${item.price * item.quantity}</p>
      </div>
    `;
    cartContainer.appendChild(div);
  });

  totalContainer.innerHTML = `Total: $${getCartTotal()}`;
};

btnBackToHome.addEventListener('click', () => {
  window.location.href = '../home/home.html';
});

document.addEventListener('DOMContentLoaded', renderCart);
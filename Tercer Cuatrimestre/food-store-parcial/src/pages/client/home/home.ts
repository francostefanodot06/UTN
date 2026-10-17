import { PRODUCTS, getCategories } from '../../../data/data';
import { addToCart } from '../../../utils/cart';
import type { IProduct } from '../../../types/product';

const productsContainer = document.getElementById('products-container') as HTMLDivElement;
const searchInput = document.getElementById('search-input') as HTMLInputElement;
const categoryFilter = document.getElementById('category-filter') as HTMLSelectElement;
const btnGoToCart = document.getElementById('go-to-cart') as HTMLButtonElement;

const renderProducts = (productsToRender: IProduct[]) => {
  productsContainer.innerHTML = '';

  if (productsToRender.length === 0) {
    productsContainer.innerHTML = '<p>No se encontraron productos.</p>';
    return;
  }

  productsToRender.forEach(product => {
    const card = document.createElement('div');
    card.className = 'product-card';
    card.innerHTML = `
      <h3>${product.name}</h3>
      <p>Precio: $${product.price}</p>
      <button class="add-to-cart-btn" data-id="${product.id}">Agregar al carrito</button>
    `;
    productsContainer.appendChild(card);
  });

  const addToCartBtns = document.querySelectorAll('.add-to-cart-btn');
  addToCartBtns.forEach(btn => {
    btn.addEventListener('click', (e) => {
      const target = e.target as HTMLButtonElement;
      const productId = parseInt(target.getAttribute('data-id') || '0');
      const product = PRODUCTS.find(p => p.id === productId);
      
      if (product) {
        addToCart(product);
        alert(`¡${product.name} agregado al carrito!`);
      }
    });
  });
};

const renderCategories = () => {
  const categories = getCategories();
  categories.forEach(cat => {
    const option = document.createElement('option');
    option.value = cat.id.toString();
    option.textContent = cat.name;
    categoryFilter.appendChild(option);
  });
};

const filterAndSearch = () => {
  const searchTerm = searchInput.value.toLowerCase();
  const selectedCategory = categoryFilter.value;

  const filteredProducts = PRODUCTS.filter(product => {
    const matchesSearch = product.name.toLowerCase().includes(searchTerm);
    const matchesCategory = selectedCategory === 'all' || product.categoryId.toString() === selectedCategory;
    return matchesSearch && matchesCategory;
  });

  renderProducts(filteredProducts);
};

searchInput.addEventListener('input', filterAndSearch);
categoryFilter.addEventListener('change', filterAndSearch);

btnGoToCart.addEventListener('click', () => {
  window.location.href = '../cart/cart.html'; 
});
renderCategories();
renderProducts(PRODUCTS);
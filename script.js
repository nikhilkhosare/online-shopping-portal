// Sample product data
const products = [
    { id: 1, name: "Laptop", price: 800.00 },
    { id: 2, name: "Smartphone", price: 500.00 },
    { id: 3, name: "Headphones", price: 50.00 },
    { id: 4, name: "Keyboard", price: 30.00 },
  ];
  
  let cart = [];
  
  // Load products into the product list
  function loadProducts() {
    const productList = document.getElementById("product-list");
    products.forEach(product => {
      const productDiv = document.createElement("div");
      productDiv.classList.add("product");
      productDiv.innerHTML = `
        <span>${product.name} - $${product.price.toFixed(2)}</span>
        <button onclick="addToCart(${product.id})">Add to Cart</button>
      `;
      productList.appendChild(productDiv);
    });
  }
  
  // Add product to the cart
  function addToCart(productId) {
    const product = products.find(p => p.id === productId);
    const existingItem = cart.find(item => item.id === productId);
    if (existingItem) {
      existingItem.quantity += 1;
    } else {
      cart.push({ ...product, quantity: 1 });
    }
    updateCart();
  }
  
  // Update the cart display
  function updateCart() {
    const cartItems = document.getElementById("cart-items");
    const cartTotal = document.getElementById("cart-total");
    cartItems.innerHTML = "";
  
    let total = 0;
    cart.forEach(item => {
      total += item.price * item.quantity;
      const cartItem = document.createElement("div");
      cartItem.classList.add("cart-item");
      cartItem.innerHTML = `
        <span>${item.name} x${item.quantity} - $${(item.price * item.quantity).toFixed(2)}</span>
        <button onclick="removeFromCart(${item.id})">Remove</button>
      `;
      cartItems.appendChild(cartItem);
    });
  
    cartTotal.textContent = total.toFixed(2);
  }
  
  // Remove an item from the cart
  function removeFromCart(productId) {
    cart = cart.filter(item => item.id !== productId);
    updateCart();
  }
  
  // Checkout functionality
  function checkout() {
    if (cart.length === 0) {
      alert("Your cart is empty!");
    } else {
      alert("Checkout successful! Thank you for your purchase.");
      cart = [];
      updateCart();
    }
  }
  
  // Initialize the portal
  loadProducts();
  
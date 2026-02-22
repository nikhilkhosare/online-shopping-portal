let productsData = [];
let cart = [];

// Fetch products from backend
fetch('/products')
    .then(response => response.json())
    .then(data => {
        productsData = data;
        displayProducts(data);
    });

// Display products
function displayProducts(products) {
    let output = "";
    products.forEach(product => {
        output += `
            <div class="card">
                <h3>${product.name}</h3>
                <p>Price: ₹${product.price}</p>
                <button onclick="addToCart(${product.id})">
                    Add to Cart
                </button>
            </div>
        `;
    });
    document.getElementById("products").innerHTML = output;
}

// Add to cart
function addToCart(id) {
    let product = productsData.find(p => p.id === id);
    cart.push(product);
    updateCart();
}

// Update cart UI
function updateCart() {
    let cartOutput = "";
    let total = 0;

    cart.forEach((item, index) => {
        total += item.price;
        cartOutput += `
            <div>
                ${item.name} - ₹${item.price}
                <button onclick="removeFromCart(${index})">Remove</button>
            </div>
        `;
    });

    document.getElementById("cartItems").innerHTML = cartOutput;
    document.getElementById("cartCount").innerText = cart.length;
    document.getElementById("totalPrice").innerText = total;
}

// Remove from cart
function removeFromCart(index) {
    cart.splice(index, 1);
    updateCart();
}

// Checkout / Payment Simulation
function checkout() {
    if (cart.length === 0) {
        alert("Cart is empty!");
        return;
    }

    alert("Payment Successful! 🎉\nTotal Paid: ₹" + 
          document.getElementById("totalPrice").innerText);

    cart = [];
    updateCart();
}

// Search functionality
document.getElementById("searchInput").addEventListener("keyup", function () {
    let value = this.value.toLowerCase();
    let filtered = productsData.filter(p =>
        p.name.toLowerCase().includes(value)
    );
    displayProducts(filtered);
});

// Explore section filter
function filterProducts(category) {
    if (category === 'all') {
        displayProducts(productsData);
        return;
    }

    let filtered = productsData.filter(p =>
        p.name.toLowerCase().includes(category.toLowerCase())
    );

    displayProducts(filtered);
}
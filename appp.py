<!DOCTYPE html>
<html>
<head>
    <title>Product Details</title>

    <style>
        body {
            font-family: Arial;
        }

        .details {
            width: 300px;
            margin: 40px auto;
            padding: 15px;
            background: #f0f0f0;
        }
    </style>
</head>

<body>
    <div class="details">
        <h2>Product Details</h2>

        <p>Name: {{ product.name }}</p>
        <p>Price: {{ product.price }}</p>
        <p>Category: {{ product.category }}</p>
        <p>Quantity: {{ product.quantity }}</p>
    </div>
</body>
</html>

from flask import Flask, render_template_string

app = Flask(__name__)

products = [
    {
        "name": "حاسوب محمول",
        "price": 3500,
        "category": "إلكترونيات",
        "quantity": 5,
        "image": "https://via.placeholder.com/250"
    },
    {
        "name": "هاتف ذكي",
        "price": 1800,
        "category": "إلكترونيات",
        "quantity": 10,
        "image": "https://via.placeholder.com/250"
    },
    {
        "name": "سماعات رأس",
        "price": 300,
        "category": "إكسسوارات",
        "quantity": 20,
        "image": "https://via.placeholder.com/250"
    }
]

html_template = """
<!DOCTYPE html>
<html lang="ar" dir="rtl">
<head>
    <meta charset="UTF-8">
    <title>عرض المنتجات</title>

    <style>
        body {
            font-family: Tahoma, Arial;
            background-color: #f4f6f8;
        }

        .container {
            width: 80%;
            margin: 30px auto;
        }

        h2 {
            text-align: center;
            margin-bottom: 30px;
        }

        .product-card {
            background: white;
            border-radius: 10px;
            box-shadow: 0 0 12px rgba(0,0,0,0.1);
            padding: 20px;
            margin-bottom: 25px;
            display: flex;
            gap: 20px;
        }

        img {
            border-radius: 8px;
        }

        .details {
            width: 100%;
        }

        .details p {
            margin: 8px 0;
        }

        .label {
            font-weight: bold;
        }
    </style>
</head>

<body>
    <div class="container">
        <h2>قائمة المنتجات</h2>

        {% for product in products %}
        <div class="product-card">
            <img src="{{ product.image }}" width="200">

            <div class="details">
                <p><span class="label">الاسم:</span> {{ product.name }}</p>
                <p><span class="label">السعر:</span> {{ product.price }} ل.س</p>
                <p><span class="label">الفئة:</span> {{ product.category }}</p>
                <p><span class="label">الكمية:</span> {{ product.quantity }}</p>
            </div>
        </div>
        {% endfor %}
    </div>
</body>
</html>
"""

@app.route("/", methods=["GET", "POST"])
def view_products():
    return render_template_string(html_template, products=products)

if __name__ == "__main__":
    app.run(debug=True)

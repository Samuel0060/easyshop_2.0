🛒 E-Commerce API Project
Overview
This project is a Java-based e-commerce API designed to allow customers to browse, search, and manage products easily. The system is connected to a MySQL database and was tested and used via Postman to ensure smooth API functionality.

![image](https://github.com/user-attachments/assets/b79cb906-d583-4aba-ace7-d7b2642bc780)

The API makes it easier for customers to:

✅ Search for products
✅ Filter products by minimum and maximum price
✅ Browse products by specific categories
✅ Manage their shopping cart

Key Features
-🔎 Product Search & Filtering:
 Customers can search for products using minimum and maximum price filters to find exactly what they need within their budget.

-🗂️ Category Selection:
 Customers can easily browse products by selecting the category they’re interested in.
 ![image](https://github.com/user-attachments/assets/96308f7c-4f91-48ee-98e7-c09fcf6f8535)

 ![image](https://github.com/user-attachments/assets/372f8e31-a92b-4042-b955-3aae98007efc)


-🛒 Shopping Cart System:
 Logged-in users can add products to their cart, update quantities, and remove items.

-🔒 Role-Based Security:
-Only authenticated users can add items to their cart.
-Only admins can create, update, or delete products and categories.

✅ Unit Testing Coverage:
Unit tests ensure that the minimum and maximum price filtering works correctly.
Unit tests confirm that updating products fully updates all related fields and works as expected.
![image](https://github.com/user-attachments/assets/5e21cb84-449c-4ba8-88c6-2f0086cc5d2d)


-Technologies Used
 💻 Java
 🛢️ MySQL Database
 🔧 Postman (for API testing)
 🔒 Spring Security (for login and role-based access)
 🚀 Spring Boot (for API development)

 How to Test
Run the Spring Boot application.

Use Postman to send API requests to http://localhost:8080.

Example request to filter products:

GET http://localhost:8080/products?minPrice=100&maxPrice=500
Only authenticated users can manage their shopping cart.

Future Improvements
In the future, I would like to:

✅ Add product review functionality, allowing users to leave a review and rating after they purchase and receive the item.
✅ Build a checkout system to convert shopping carts into orders.
✅ Add user-specific order history and order tracking.

String Functions:
a) Given a table named employees with columns first_name and last_name, write a query to retrieve 
the full names of all employees in uppercase.

SELECT UPPER(CONCAT(first_name, ' ', last_name)) AS full_name
FROM employees;

b) In the table products, there is a column named description which contains product descriptions. 
Write a query to find the number of products whose descriptions contain the word 'electronics'.

SELECT COUNT(*)
FROM products
WHERE description LIKE '%electronics%';
 
Aggregate Functions:
a) The table orders has columns order_id, customer_id, and total_amount. Write a query to find the 
total amount spent by each customer.

SELECT customer_id, SUM(total_amount) AS total_spent
FROM orders
GROUP BY customer_id;

b) Calculate the average price of products in the table products with the column price.
SELECT AVG(price) AS average_price
FROM products;

b) Update the age of the student with student_id 101 in the students table to 20.
UPDATE students

SET age = 20
WHERE student_id = 101;
c) Delete all records from the table employees where the department is 'HR'.

DELETE FROM employees
WHERE department = 'HR';

Advanced Commands:
a) Write a SQL query to create a new table named orders with columns order_id, customer_id, 
order_date, and total_amount. The order_id should be an auto-incrementing primary key.


b) Assume you have a large table named logs with columns log_id, timestamp, and message. Write a 
query to delete all logs that are older than one year.

CREATE TABLE orders (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT,
    order_date DATE,
    total_amount DECIMAL(10, 2)
);

DELETE FROM logs
WHERE timestamp < DATE_SUB(NOW(), INTERVAL 1 YEAR);

c) Assume you have two tables: users and orders. The users table contains user_id and name, while the 
orders table contains order_id, user_id, and order_date. Write a query to retrieve the names of users 
who have placed at least three orders. 

SELECT u.name
FROM users u
JOIN orders o ON u.user_id = o.user_id
GROUP BY u.user_id, u.name
HAVING COUNT(o.order_id) >= 3;

e)Calculate the total revenue generated from each product and order the results in descending order of 
revenue.
SELECT product_id, product_name, total_revenue
FROM (
    SELECT p.product_id,
           p.product_name,
           (SELECT SUM(quantity * price) FROM orders o WHERE o.product_id = p.product_id) AS total_revenue
    FROM products p
) AS revenue_summary
ORDER BY total_revenue DESC;


SELECT p.product_id,
       p.product_name,
       SUM(o.quantity * p.price) AS total_revenue
FROM products p
JOIN orders o ON p.product_id = o.product_id
GROUP BY p.product_id, p.product_name
ORDER BY total_revenue DESC;

f) Find the products that have generated revenue greater than $50.

SELECT product_id, product_name
FROM products
WHERE product_id IN (
    SELECT product_id
    FROM orders
    GROUP BY product_id
    HAVING SUM(quantity * price) > 50
);

SELECT p.product_id,
       p.product_name,
       SUM(o.quantity * p.price) AS total_revenue
FROM products p
JOIN orders o ON p.product_id = o.product_id
GROUP BY p.product_id, p.product_name
HAVING SUM(o.quantity * p.price) > 50
ORDER BY total_revenue DESC;

g) Calculate the total number of sales made.

SELECT SUM(quantity) AS total_sales
FROM orders;

h) Determine the product that has the lowest price per unit.

SELECT product_id, product_name, price
FROM products
ORDER BY price ASC
LIMIT 1;

1. What does SQL stand for, and what is its primary purpose?
2. Explain the difference between SQL's SELECT and INSERT statements.
The SELECT statement is used to retrieve data from one or more tables in a database.
SELECT column1, column2
FROM table_name
WHERE condition;

3. Write an SQL query to retrieve all columns from a table named "employees."
SELECT *
FROM employees;

4. What is a primary key in a database table, and why is it important?
 Every value in the primary key column(s) must be unique within the table.
 This ensures that no two rows can have the same primary key value.

5. Describe the purpose of the WHERE clause in SQL queries.
It helps you tell the database what specific information you want to retrieve from a table.
You can think of it as a question you're asking the database, like "Give me all the records where this condition is true."
SELECT *
FROM employees
WHERE department = 'Sales';

**Section 2: Data Retrieval (30 Marks)**
6. Write an SQL query to retrieve all unique values from a column named "product_category" in a table named "products."

SELECT DISTINCT product_category
FROM products;


7. What is the difference between INNER JOIN and LEFT JOIN in SQL? Provide an example of when to use each.

INNER JOIN and LEFT JOIN are two types of SQL joins used to combine rows from multiple
tables based on a related column. Here's the difference between them and
examples of when to use each:

SELECT orders.order_id, customers.customer_name
FROM orders
INNER JOIN customers ON orders.customer_id = customers.customer_id;


SELECT employees.employee_name, departments.department_name
FROM employees
LEFT JOIN departments ON employees.department_id = departments.department_id;

 it's nothing stop nci::::
8. Explain the concept of subqueries and provide an example of how they can be used in SQL.
Subqueries in SQL, also known as nested queries or subselects, are queries that are 
embedded within another query.

SELECT customer_name
FROM customers
WHERE customer_id IN (
    SELECT customer_id
    FROM orders
    WHERE order_country = 'USA'
);

9. Write an SQL query to retrieve the total number of records in a table named "orders."
SELECT COUNT(*) AS total_records
FROM orders;

10. How can you sort the result of an SQL query in descending order based on a specific column?
SELECT product_name, price
FROM products
ORDER BY price DESC;

**Section 3: Data Manipulation (25 Marks)**

11. Write an SQL query to update the price of a product with the ID 1001 to $19.99 in a
table named "products."
UPDATE products
SET price = 19.99
WHERE product_id = 1001;

12. Explain the purpose of the SQL DELETE statement and provide an example of its usage.
Delete specific rows: You can use the DELETE statement to remove rows from a table
based on a condition. This is useful for removing outdated or irrelevant data.
 DELETE FROM customers
WHERE customer_id = 101;

13. What is an SQL transaction, and why is it important in database management?
An SQL transaction is a sequence of one or more SQL statements that are 
executed as a single unit of work
Atomicity: Consistency: Isolation: Durability: Data Integrity: Concurrency Control: 

14. Write an SQL query to insert a new record into a table named "customers" with the following values: (CustomerID: 101, FirstName: 'John', 
LastName: 'Doe', Email: 'john@example.com').
INSERT INTO customers (CustomerID, FirstName, LastName, Email)
VALUES (101, 'John', 'Doe', 'john@example.com');

15. Describe the differences between the SQL functions COUNT, AVG, and SUM, and provide an example for each.
SELECT COUNT(*) FROM customers;
SELECT AVG(price) FROM products;
SELECT SUM(total_amount) FROM orders;

COUNT counts rows or records.
AVG calculates the average of numeric values.
SUM calculates the total sum of numeric values.

**Section 4: Advanced Topics (25 Marks)**

16. What is normalization in the context of database design, and why is it essential?
Normalization in the context of database design is a systematic and structured process of organizing data in a 
relational database to reduce data redundancy and improve data integrity

17. Write an SQL query to create a new table named "orders" with appropriate columns for storing order information.
CREATE TABLE orders (
    order_id INT PRIMARY KEY,
    customer_id INT,
    order_date DATE,
    total_amount DECIMAL(10, 2)
);

18. Describe the purpose of stored procedures and triggers in SQL databases.
Stored procedures are precompiled sets of one or more SQL statements that can 
be executed as a single unit. They are typically used to encapsulate a series of
SQL operations into a reusable, callable routine.

1.Consider a database with two tables: "students" and "courses." The "students" table has columns: student_id, first_name, last_name, and 
course_id. The "courses" table has columns: course_id and course_name.
Write an SQL query to retrieve the first and last names of students who are enrolled in the course with the course_name 'Mathematics 101.'
SELECT s.first_name, s.last_name
FROM students s
JOIN courses c ON s.course_id = c.course_id
WHERE c.course_name = 'Mathematics 101';

**Question 2: 
Data Update (10 Marks)**
You have a table named "products" with columns: product_id, product_name, and price. Write an SQL query to increase the price of all 
products by 10%.
UPDATE products
SET price = price * 1.10;

**Question 3: 
Data Insertion (15 Marks)**

Assume you have a table named "employees" with columns: employee_id, first_name, last_name, 
and department_id. Write an SQL query to insert a new employee with the following details: (employee_id: 101, first_name: 'Alice', last_name: 
'Smith', department_id: 3)
INSERT INTO employees (employee_id, first_name, last_name, department_id)
VALUES (101, 'Alice', 'Smith', 3);

**Question 4: Joining Tables (20 Marks)**

You have two tables: "orders" and "customers." The "orders" table has columns: order_id, customer_id, and order_date. The "customers" table 
has columns: customer_id and customer_name.
Write an SQL query to retrieve a list of customer names along with the total number of orders they have placed. Sort the results in descending 
order of the total number of orders.

SELECT c.customer_name, COUNT(o.order_id) AS total_orders
FROM customers c
LEFT JOIN orders o ON c.customer_id = o.customer_id
GROUP BY c.customer_name
ORDER BY total_orders DESC;

**Question 5: Subqueries (20 Marks)**

Consider a database with three tables: "employees," "departments," and "salaries." The "employees" table has columns: employee_id, 
first_name, last_name, and department_id. The "departments" table has columns: department_id and department_name. The "salaries" table 
has columns: employee_id and salary_amount.
Write an SQL query to find the department with the highest average salary. Display the department name and the average salary.

SELECT d.department_name, AVG(s.salary_amount) AS average_salary
FROM departments d
JOIN employees e ON d.department_id = e.department_id
JOIN salaries s ON e.employee_id = s.employee_id
GROUP BY d.department_name
ORDER BY average_salary DESC
LIMIT 1;


**Question 6: Data Deletion (10 Marks)**
You have a table named "orders" with columns: order_id, order_date, and status.
Write an SQL query to delete all orders that have a status of 'cancelled.'

DELETE FROM orders
WHERE status = 'cancelled';

**Question 7: Aggregate Functions (10 Marks)**

In a sales database, there is a table named "sales" with columns: sale_id, sale_date, and sale_amount. 
Write an SQL query to calculate the total sales amount for the year 2023.

SELECT SUM(sale_amount) AS total_sales_amount
FROM sales
WHERE YEAR(sale_date) = 2023;


These practical questions should help assess your ability to apply SQL concepts to real-world scenarios. 
Make sure to adapt them to your specific needs or level of difficulty as required.

SELECT SUM(sale_amount) AS total_sales_amount
FROM sales
WHERE sale_date >= '2023-01-01' AND sale_date <= '2023-12-31';

**SQL Employee Database Questions**:

1. Retrieve the first and last names of all employees who were born after January 1, 1990.
SELECT first_name, last_name
FROM employees
WHERE birth_date > '1990-01-01';

2. Calculate the total number of employees in each department and display the department name along 
with the count. Exclude departments with no employees.
SELECT d.department_name, COUNT(e.employee_id) AS total_employees
FROM departments d
LEFT JOIN employees e ON d.department_id = e.department_id
GROUP BY d.department_name;


3. List the names of employees who are working on the project with the name 'ProjectX.'
SELECT d.department_name, COUNT(e.employee_id) AS total_employees
FROM departments d
INNER JOIN employees e ON d.department_id = e.department_id
GROUP BY d.department_name;

4. Find the average salary of employees in the 'Marketing' department.
SELECT AVG(e.salary) AS average_salary
FROM employees e
JOIN departments d ON e.department_id = d.department_id
WHERE d.department_name = 'Marketing';

5. Update the salary of all employees in the 'IT' department by increasing it by 10%.
UPDATE employees e
JOIN departments d ON e.department_id = d.department_id
SET e.salary = e.salary * 1.10
WHERE d.department_name = 'IT';

-- Assign to Employee 1
INSERT INTO Employee_Project_Assignments (employee_id, project_id)
VALUES (1, new_project_id); -- Replace 1 with the actual employee_id

-- Assign to Employee 2
INSERT INTO Employee_Project_Assignments (employee_id, project_id)
VALUES (2, new_project_id); -- Replace 2 with the actual employee_id


6. Insert a new project with the name 'ProjectY' into the Projects table and assign it to at least two 
employees.

INSERT INTO Projects (project_name)
VALUES ('ProjectY');
SELECT LAST_INSERT_ID() AS new_project_id;


7. Delete all employees who have a salary less than $30,000.

DELETE FROM employees
WHERE salary < 30000;

8. Create a new table named 'EmployeeSkills' with columns: `EmployeeID` (Foreign Key), `SkillName`.

CREATE TABLE EmployeeSkills (
    EmployeeID INT, -- You should specify the data type for EmployeeID (e.g., INT)
    SkillName VARCHAR(255) -- You can adjust the length (e.g., VARCHAR(50)) based on your needs
);


9. Insert a record into the 'EmployeeSkills' table indicating that EmployeeID 101 has the skill 'SQL.'
INSERT INTO EmployeeSkills (EmployeeID, SkillName)
VALUES (101, 'SQL');

10. Provide a list of employees who have the skill 'SQL' based on the 'EmployeeSkills' table.
SELECT e.*
FROM Employees e
JOIN EmployeeSkills es ON e.EmployeeID = es.EmployeeID
WHERE es.SkillName = 'SQL';

**SQL Sales Database Questions**:
1. Retrieve the first and last names of customers who have placed orders with a total amount greater 
than $500.

SELECT c.first_name, c.last_name
FROM customers c
JOIN orders o ON c.customer_id = o.customer_id
GROUP BY c.customer_id, c.first_name, c.last_name
HAVING SUM(o.total_amount) > 500;

2. Calculate the total revenue generated by each product category and display the category name along 
with the revenue. Sort the results in descending order of revenue.

SELECT c.category_name, SUM(p.price) AS total_revenue
FROM categories c
JOIN products p ON c.category_id = p.category_id
GROUP BY c.category_name
ORDER BY total_revenue DESC;

3. List the names of products that have been ordered by at least five different customers.

SELECT Products.ProductName
FROM Products
JOIN OrderDetails ON Products.ProductID = OrderDetails.ProductID
JOIN Orders ON OrderDetails.OrderID = Orders.OrderID
GROUP BY Products.ProductName
HAVING COUNT(DISTINCT Orders.CustomerID) >= 5;

4. Find the average total order amount for customers who have placed more than three orders.

SELECT Customers.CustomerID, AVG(TotalAmount) AS AvgOrderAmount
FROM (
    SELECT CustomerID, OrderID, SUM(UnitPrice * Quantity) AS TotalAmount
    FROM Orders
    JOIN OrderDetails ON Orders.OrderID = OrderDetails.OrderID
    GROUP BY CustomerID, OrderID
    HAVING COUNT(OrderID) > 3
) AS CustomerOrders
JOIN Customers ON CustomerOrders.CustomerID = Customers.CustomerID
GROUP BY Customers.CustomerID;

5. Update the unit price of all products in the 'Electronics' category by reducing it by 5%.

UPDATE Products
SET UnitPrice = UnitPrice * 0.95
WHERE Category = 'Electronics';

6. Insert a new customer record into the 'Customers' table.

INSERT INTO Customers (CustomerName, ContactName, Address, City, PostalCode, Country)
VALUES ('John Doe', 'Jane Doe', '123 Main St', 'New York', '10001', 'USA');

7. Delete all orders placed by the customer with the email 'example@email.com'.

DELETE FROM Orders
WHERE CustomerID = (SELECT CustomerID FROM Customers WHERE Email = 'example@email.com');

8. Create a new table named 'ProductReviews' with columns: `ProductID` (Foreign Key), `ReviewText`, 
`Rating`.

CREATE TABLE ProductReviews (
    ReviewID INT PRIMARY KEY AUTO_INCREMENT,
    ProductID INT,
    ReviewText TEXT,
    Rating INT,
    FOREIGN KEY (ProductID) REFERENCES Products(ProductID)
);

9. Insert a product review for a product of your choice into the 'ProductReviews' table.

INSERT INTO ProductReviews (ProductID, ReviewText, Rating)
VALUES (SELECT ProductID FROM Products WHERE ProductName = 'Product Name'), 'Great product!', 5);

10. Provide a list of products along with their average rating based on the 'ProductReviews' table. Sort 
the results by average rating in descending order.

SELECT Products.ProductName, AVG(ProductReviews.Rating) AS AvgRating
FROM Products
LEFT JOIN ProductReviews ON Products.ProductID = ProductReviews.ProductID
GROUP BY Products.ProductName
ORDER BY AvgRating DESC;
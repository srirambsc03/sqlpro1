CREATE DATABASE BANK_MANAGEMENT3;
USE BANK_MANAGEMENT3;
-- drop database bank_management3;
-- Create the Customers table
CREATE TABLE Customers (
    CustomerID INT PRIMARY KEY,
    FirstName VARCHAR(50),
    LastName VARCHAR(50),
    Address VARCHAR(100),
    Phone VARCHAR(15),
    Email VARCHAR(100)
);

-- Insert values for the first 5 customers
INSERT INTO Customers (CustomerID, FirstName, LastName, Address, Phone, Email)
VALUES
    (1, 'John', 'Doe', '123 Main St', '555-123-4567', 'john.doe@email.com'),
    (2, 'Jane', 'Smith', '456 Elm St', '555-987-6543', 'jane.smith@email.com'),
    (3, 'Michael', 'Johnson', '789 Oak St', '555-555-1234', 'michael.johnson@email.com'),
    (4, 'Emily', 'Brown', '101 Pine St', '555-222-3333', 'emily.brown@email.com'),
    (5, 'David', 'Lee', '321 Cedar St', '555-888-7777', 'david.lee@email.com');

-- Create the Deposits table
CREATE TABLE Deposits (
    DepositID INT PRIMARY KEY,
    Customer_ID INT,
    AccountNumber INT,
    Amount DECIMAL(10, 2),
    DepositDate DATE,CustomerID INT,foreign key(customerID) references customers(customerID)
);

-- Insert values for deposits
INSERT INTO Deposits (DepositID, Customer_ID, AccountNumber, Amount, DepositDate)
VALUES
    (11, 1, 1001, 5000.00, '2023-09-19'),
    (12, 2, 1002, 3000.50, '2023-09-20'),
    (13, 3, 1003, 7500.75, '2023-09-21'),
    (14, 4, 1004, 2000.25, '2023-09-22'),
    (15, 5, 1005, 10000.00, '2023-09-23');

-- Create a sample table
CREATE TABLE PAN_DETAILS (
    ID INT PRIMARY KEY,
    Name VARCHAR(255),
    Age INT,
   pan_number double unique,CustomerID INT,foreign key(customerID) references customers(customerID)
);
-- Insert values into the table
INSERT INTO PAN_DETAILS (ID, Name, Age, pan_number)
VALUES
    (100, 'sri ram', 30, 98765434567890),
    (102, 'ram Smith', 25, 87654567898765),
    (103, 'srisriram', 35, 9876543457886543);

-- Create the ATMs table
CREATE TABLE ATMs (
    ATMID INT PRIMARY KEY,
    Location VARCHAR(255),
    Address VARCHAR(255),
    Status VARCHAR(50) ,AccountTypeID INT, foreign key(AccountTypeID) references Accounttypes(AccountTypeID));

-- Insert values into the ATMs table
INSERT INTO ATMs (ATMID, Location, Address, Status)
VALUES
    (1001, 'Main Branch', '123 Main St', 'Operational'),
    (1002, 'Downtown Branch', '456 Elm St', 'Out of Service'),
    (1003, 'Westside Branch', '789 Oak St', 'Operational'),
    (1004, 'Eastside Branch', '101 Pine St', 'Maintenance'),
    (1005, 'Northside Branch', '321 Cedar St', 'Operational');
    SELECT * FROM ATMS;

-- Create the AccountTypes table
CREATE TABLE AccountTypes (
    AccountTypeID INT PRIMARY KEY,
    TypeName VARCHAR(50),
    Description VARCHAR(255),CustomerID INT,foreign key(customerID) references customers(customerID));

-- Insert values into the AccountTypes table
INSERT INTO AccountTypes (AccountTypeID, TypeName, Description)
VALUES
    (501, 'Savings', 'Basic savings account'),
    (502, 'Checking', 'Standard checking account'),
    (503, 'Fixed Deposit', 'High-interest fixed deposit account'),
    (504, 'Business', 'Business checking account'),
    (505, 'Credit Card', 'Credit card account');
select * from AccountTypes;
-- drop table accountypes;
select t.typename from accounttype as t join atm as b
on t.AccounttypeId.atmid = b.atm.atmId ;
 
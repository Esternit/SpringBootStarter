DROP TABLE IF EXISTS Run;

CREATE TABLE IF NOT EXISTS Run (
   id INT NOT NULL,
   title varchar(250) NOT NULL,
   start_time timestamp NOT NULL,
   end_time timestamp NOT NULL,
   miles INT NOT NULL,
   location varchar(10) NOT NULL,
   version INT,
   PRIMARY KEY (id)
);

DROP TABLE IF EXISTS my_user;

CREATE TABLE IF NOT EXISTS my_user (
    id UUID PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phone VARCHAR(255),
    address VARCHAR(255),
    contact_info VARCHAR(255),
    version INT
);

CREATE TABLE IF NOT EXISTS Products_EU (
    id INT PRIMARY KEY,
    source_url VARCHAR(255),
    name VARCHAR(255),
    product_type VARCHAR(100),
    size VARCHAR(50),
    color VARCHAR(50),
    weight DOUBLE PRECISION,
    purchase_price DOUBLE PRECISION,
    customer_delivery_price DOUBLE PRECISION,
    packaging DOUBLE PRECISION,
    additional_expense_1 DOUBLE PRECISION,
    additional_expense_2 DOUBLE PRECISION,
    cost_price DOUBLE PRECISION,
    selling_price DOUBLE PRECISION,
    net_profit DOUBLE PRECISION,
   version INT
);

CREATE TABLE IF NOT EXISTS Products_RU (
    id INT PRIMARY KEY,
    source_url VARCHAR(255),
    name VARCHAR(255),
    product_type VARCHAR(100),
    size VARCHAR(50),
    color VARCHAR(50),
    weight DOUBLE PRECISION,
    purchase_price DOUBLE PRECISION,
    delivery_price_NP DOUBLE PRECISION,
    delivery_price_R5 DOUBLE PRECISION,
    customer_delivery_price DOUBLE PRECISION,
    packaging DOUBLE PRECISION,
    additional_expense_1 DOUBLE PRECISION,
    additional_expense_2 DOUBLE PRECISION,
    cost_price DOUBLE PRECISION,
    cost_price_in_rubles DOUBLE PRECISION,
    selling_price_in_rubles DOUBLE PRECISION,
    net_profit DOUBLE PRECISION,
    version INT
);

DROP TABLE IF EXISTS Orders;

CREATE TABLE IF NOT EXISTS Orders (
    id UUID PRIMARY KEY,
    customer_id UUID,
    address VARCHAR(255),
    order_date timestamp,
    receipt_date timestamp,
    full_payment_date timestamp,
    version INT
);

CREATE TABLE IF NOT EXISTS Ordered_Products (
    id INT PRIMARY KEY,
    order_id INT,
    product_status VARCHAR(50),
    product_id_ru INT,
    product_id_eu INT,
    tracking_number VARCHAR(100),
    version INT
);

CREATE TABLE IF NOT EXISTS Customers (
    id INT PRIMARY KEY,
    system_id VARCHAR(100),
    password VARCHAR(255),
    phone VARCHAR(50),
    address VARCHAR(255),
    location_eu_ru VARCHAR(10),
    email VARCHAR(100),
    contact_info VARCHAR(255),
    orders INT,
    version INT
);

CREATE TABLE IF NOT EXISTS CartItem (
    id INT PRIMARY KEY,
    product_id INT,
    version INT
);
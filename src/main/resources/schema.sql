DROP TABLE IF EXISTS Run;



--TODO remove all drops
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

DROP TABLE IF EXISTS products_ru;

CREATE TABLE IF NOT EXISTS products_ru (
    id UUID PRIMARY KEY,
    source_url TEXT,
    name VARCHAR(255),
    product_type VARCHAR(100),
    size VARCHAR(50),
    color VARCHAR(50),
    weight DOUBLE PRECISION,
    purchase_price DOUBLE PRECISION,
    tax DOUBLE PRECISION,
    delivery_price_NP DOUBLE PRECISION,
    delivery_price_RB DOUBLE PRECISION,
    delivery_price_RU DOUBLE PRECISION,
    packaging1 DOUBLE PRECISION,
    packaging2 DOUBLE PRECISION,
    additional_expense DOUBLE PRECISION,
    cost_price DOUBLE PRECISION,
    cost_price_in_rubles DOUBLE PRECISION,
    selling_price_in_rubles DOUBLE PRECISION,
    net_profit DOUBLE PRECISION,
    slug VARCHAR(255),
    main_photo TEXT,
    description TEXT,
    version INT
);

DROP TABLE IF EXISTS images;

CREATE TABLE IF NOT EXISTS images (
    id UUID PRIMARY KEY,
    url TEXT,
    product_id UUID,
    width INT,
    height INT,
    slug VARCHAR(255),
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

DROP TABLE IF EXISTS ordered_products;

CREATE TABLE IF NOT EXISTS ordered_products (
    id UUID PRIMARY KEY,
    order_id UUID,
    product_status VARCHAR(50),
    product_id UUID,
    product_location VARCHAR(25),
    tracking_number VARCHAR(250),
    version INT
);

--DROP TABLE IF EXISTS cart_item;

CREATE TABLE IF NOT EXISTS cart_item (
    id UUID PRIMARY KEY,
    user_id UUID,
    product_id UUID,
    product_location VARCHAR(25),
    version INT
);
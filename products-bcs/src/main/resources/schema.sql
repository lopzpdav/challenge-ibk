CREATE TABLE product
(
    id  INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    customer_id INT NOT NULL,
    product_type VARCHAR(12) NOT NULL,
    product_name VARCHAR(16) NOT NULL,
    balance DECIMAL(10,2) NOT NULL,
    created  timestamp  NOT NULL DEFAULT CURRENT_TIMESTAMP,
    modified  timestamp  NOT NULL DEFAULT CURRENT_TIMESTAMP
);
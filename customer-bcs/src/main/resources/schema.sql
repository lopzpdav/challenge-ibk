CREATE TABLE customer
(
    id  INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name  VARCHAR(255) NOT NULL,
    last_name VARCHAR(255),
    document_type VARCHAR(9) NOT NULL,
    document_number INT NOT NULL,
    created  timestamp  NOT NULL DEFAULT CURRENT_TIMESTAMP,
    modified  timestamp  NOT NULL DEFAULT CURRENT_TIMESTAMP
    );
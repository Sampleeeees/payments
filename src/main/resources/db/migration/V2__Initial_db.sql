CREATE TABLE client
(
    id         BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name  VARCHAR(50) NOT NULL,
    age        INT
);

CREATE TABLE account
(
    id         BIGSERIAL PRIMARY KEY,
    balance    NUMERIC(12, 2) NOT NULL DEFAULT 0.00,
    is_blocked BOOLEAN        NOT NULL DEFAULT FALSE,
    client_id  BIGINT         NOT NULL,
    FOREIGN KEY (client_id) REFERENCES client (id) ON DELETE CASCADE
);

CREATE TABLE credit_card
(
    id          BIGSERIAL PRIMARY KEY,
    card_number VARCHAR(16) NOT NULL UNIQUE,
    account_id  BIGINT      NOT NULL,
    FOREIGN KEY (account_id) REFERENCES account (id) ON DELETE CASCADE
);

CREATE TABLE administrator
(
    id   BIGSERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE account_log
(
    id               BIGSERIAL PRIMARY KEY,
    account_id       BIGINT      NOT NULL,
    administrator_id BIGINT      NOT NULL,
    action           VARCHAR(20) NOT NULL,
    action_timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (account_id) REFERENCES account (id) ON DELETE CASCADE,
    FOREIGN KEY (administrator_id) REFERENCES administrator (id) ON DELETE CASCADE
);

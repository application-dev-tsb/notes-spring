--liquibase formatted sql

--changeset codefactory:00000_initial_db
--comment: initial database with order and order_item
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";


CREATE TABLE "order"
(
    order_id UUID NOT NULL DEFAULT gen_random_uuid(),

    description VARCHAR(255),
    total DECIMAL,

    PRIMARY KEY(order_id)
);

CREATE TABLE order_item
(
    order_item_id UUID NOT NULL DEFAULT gen_random_uuid(),
    order_id UUID NOT NULL,

    sort_position INTEGER NOT NULL,
    description VARCHAR(255),
    quantity INTEGER NOT NULL DEFAULT 1,
    unit_price DECIMAL NOT NULL DEFAULT 0,
    amount DECIMAL NOT NULL DEFAULT 0,

    PRIMARY KEY(order_item_id),
    CONSTRAINT fk_order
        FOREIGN KEY(order_id)
	    REFERENCES "order"(order_id)
);
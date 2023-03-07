--liquibase formatted sql

--changeset codefactory:00000_initial_db
--comment: initial database with user and auth-related entries
CREATE TABLE SHOPPING_CART_ENTITY
(
    ID UUID NOT NULL
        CONSTRAINT AUTHORITY_PKEY PRIMARY KEY,
    CART_NAME VARCHAR(255)
);
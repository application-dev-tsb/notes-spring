--liquibase formatted sql

--changeset lbibera:00000_init
--comment: initial database
create table if not exists registration
(
    id bigserial not null
        constraint registration_pkey
            primary key,
    name varchar(255),
    age int
);
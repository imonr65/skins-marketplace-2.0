create table if not exists agents_templates(
    id serial primary key,
    agent_name varchar(80) not null unique,
    image_url text,
    agent_rarity varchar(100) not null
);

create table if not exists containers_templates(
    id serial primary key,
    container_name varchar(80) not null unique,
    rarity varchar(50) not null,
    image_url text
);

create table if not exists gloves_templates(
    id serial primary key,
    gloves_name varchar(80) not null unique,
    image_url text,

    wear varchar(50) not null,
    gloves_rarity varchar(50) not null,
    gloves_model varchar(50) not null,
);

create table if not exists stickers_templates(
    id serial primary key,
    image_url text,

    sticker_name varchar(80) unique not null,
    sticker_rarity varchar(50) not null
);

create table if not exists weapons_templates(
    id serial primary key,
    weapon_name varchar(80) unique not null,
    image_url text,

    wear varchar(50) not null,
    weapon_model varchar(50) not null,
    weapon_rarity varchar(50) not null,
);
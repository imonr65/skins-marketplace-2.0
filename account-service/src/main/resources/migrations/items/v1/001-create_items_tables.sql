
ДОБАВЬ ТАБЛИЦУ ПОЛЬЗОВАТЕЛЕЙ И В ТАБЛИЦЫ ТИПОВ ПРЕДМЕТОВ ДОБАВЬ FK на USER_TABLE
create table if not exists users(
    id UUID primary key,
    username varchar (50) not null,
    email varchar(255) not null unique,
    password varchar(255) not null
);

ПЕРЕНЕСИ В ДРУГОЙ СЕРВИС
create table if not exists users(
    id uuid primary key,
    user_name varchar(255) not null,
    email varchar(255) not null unique,
    avatar text
);

create table if not exists weapons_templates(
    id serial primary key,
    weapon_name varchar(150) not null unique,
    image_url text not null,

    wear varchar(50) not null,
    item_type varchar(50) not null,
    weapon_model varchar(50) not null,
    weapon_rarity varchar(50) not null,
);




create table if not exists gloves_templates(
    id serial primary key,
    gloves_name varchar(150) not null unique,
    image_url text not null unique,

    wear varchar(50) not null,
    gloves_model varchar(50) not null,
    item_type varchar(50) not null,
    gloves_rarity - varchar(50) not null
);


create table if not exists containers(
    id serial primary key,
    container_name varchar(150) not null unique,
    image_url text not null,

    rarity varchar(50) not null,
    item_type varchar(50) not null,

--     fk item_pool_id будет на таблицу, хранящая в себе информацию, какие предметы в себе содержит контейнер

);

create table if not exists agents(
    id serial primary key,
    agent_name varchar(150) not null unique,
    image_url text not null,

    agent_rarity varchar(50) not null,
    item_type varchar(50) not null
);

create table if not exists stikers(
    id serial primary key,
    stiker_name varchar(150) not null unique,
    image_url text not null,

    stiker_rarity varchar(50) not null,
    item_type varchar(50) not null,

);



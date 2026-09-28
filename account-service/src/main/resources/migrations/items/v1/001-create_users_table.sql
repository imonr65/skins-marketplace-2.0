create table if not exists users(
    id UUID primary key,
    username varchar (100) not null,
    email varchar(255) not null unique,
    password varchar(255) not null,
    user_role varchar(50) not null,
    image_url text
);
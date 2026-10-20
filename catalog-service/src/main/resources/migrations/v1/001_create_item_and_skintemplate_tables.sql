create table if not exists items(
    id uuid primary key,
    image_url text not null,
    item_name varchar(80) not null,
    category varchar(40) not null,
    rarity varchar(40) not null,
    description VARCHAR(1000) not null,

    market_hash_name varchar(255) not null unique,
    external_id varchar(100) unique not null,

    item_type varchar(40)
);

create table if not exists skins_templates(
    item_id uuid primary key,

    skin_model varchar(50) not null,
    min_float double precision not null,
    max_float double precision not null,
    stattrak boolean not null,
    souvenir boolean not null,
    team varchar(40) not null,

    constraint fk_skins_templates_item
        foreign key(item_id) references items(id)
        on delete cascade
);

create table if not exists skin_template_wears(
    skin_id uuid not null,
    wear varchar(40) not null,

    primary key (skin_id, wear),

    constraint fk_skin_template_wears_skin
    foreign key (skin_id) references items(id)
    on delete cascade
);




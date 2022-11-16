
create table if not exists "user"
(
    id bigserial primary key ,
    username varchar(100) not null unique,
    name varchar(100) not null,
    surname varchar(100) not null,
    patronymic varchar(100),
    image_url varchar,
    date_of_birthday date,
    comment text,
    organisation_id bigint references organisation(id),
    post_id bigint references post(id),
    password varchar (250) not null,
    status     varchar(25) not null default 'ACTIVE',
    created    timestamp default CURRENT_TIMESTAMP(10) not null,
    updated    timestamp default CURRENT_TIMESTAMP(10) not null

);

create table if not exists address(
                                     id bigserial primary key ,
                                     name varchar(500) not null,
                                     user_id bigint references "user" (id) not null ,
                                     created    timestamp default CURRENT_TIMESTAMP(10) not null,
                                     updated    timestamp default CURRENT_TIMESTAMP(10) not null

);
create table if not exists address_type(
                                     id bigserial primary key ,
                                     name varchar(100) not null,
                                     address_id bigint references address (id) not null ,
                                     created    timestamp default CURRENT_TIMESTAMP(10) not null,
                                     updated    timestamp default CURRENT_TIMESTAMP(10) not null

);
create table if not exists email(
                                     id bigserial primary key ,
                                     email varchar(250) not null unique ,
                                     user_id bigint references "user" (id) not null ,
                                     created    timestamp default CURRENT_TIMESTAMP(10) not null,
                                     updated    timestamp default CURRENT_TIMESTAMP(10) not null

);
create table if not exists email_type(
                                           id bigserial primary key ,
                                           name varchar(100) not null,
                                           email_id bigint references email (id) not null ,
                                           created    timestamp default CURRENT_TIMESTAMP(10) not null,
                                           updated    timestamp default CURRENT_TIMESTAMP(10) not null

);
create table if not exists organisation(
                                    id bigserial primary key ,
                                    name varchar(250) not null,
                                    created    timestamp default CURRENT_TIMESTAMP(10) not null,
                                    updated    timestamp default CURRENT_TIMESTAMP(10) not null

);
create table if not exists phone(
                                    id bigserial primary key ,
                                    phone_number varchar(250) not null unique ,
                                    user_id bigint references "user" (id) not null ,
                                    created    timestamp default CURRENT_TIMESTAMP(10) not null,
                                    updated    timestamp default CURRENT_TIMESTAMP(10) not null
);
create table if not exists phone_type(
                                         id bigserial primary key ,
                                         name varchar(100) not null,
                                         phone_id bigint references phone (id) not null ,
                                         created    timestamp default CURRENT_TIMESTAMP(10) not null,
                                         updated    timestamp default CURRENT_TIMESTAMP(10) not null

);
create table if not exists post(
                                         id bigserial primary key ,
                                         name varchar(100) not null,
                                         created    timestamp default CURRENT_TIMESTAMP(10) not null,
                                         updated    timestamp default CURRENT_TIMESTAMP(10) not null

);

create table if not exists organisation_post(
    organisation_id bigint references organisation(id),
    post_id bigint references post(id)
)









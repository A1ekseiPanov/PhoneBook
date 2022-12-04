
create table if not exists person
(
    id bigserial primary key ,
    name varchar(100) not null,
    surname varchar(100) not null,
    patronymic varchar(100),
    image_url varchar,
    date_of_birthday date,
    comment text,
    organisation_id bigint references organisation(id),
    post_id bigint references post(id),
    user_id bigint references users(id),
    created    timestamp default CURRENT_TIMESTAMP(10) not null,
    updated    timestamp default CURRENT_TIMESTAMP(10) not null

);
insert into person (name, surname, patronymic, image_url,
                    date_of_birthday, comment,
                    organisation_id, post_id, user_id)
                    values ('al','alie','alievi','asdasd',to_date('2000-10-22','YYYY-MM-DD'),'test',1,1,1);
drop table users cascade ;
create table if not exists users
(
    id bigserial primary key ,
    username varchar(100) not null unique,
    password varchar (250) not null,
    name varchar(100) not null,
    surname varchar(100) not null,
    date_of_birthday date,
    email varchar not null unique ,
    status     varchar(25) not null default 'ACTIVE',
    created    timestamp default CURRENT_TIMESTAMP(10) not null,
    updated    timestamp default CURRENT_TIMESTAMP(10) not null

);
insert into users (username, password, name, surname, date_of_birthday, email)
values ('aq','qw','alievi','asdasd',to_date('2000-10-22','YYYY-MM-DD'),'test');


drop table address cascade ;
create table if not exists address(
                                     id bigserial primary key ,
                                     name varchar(500) not null,
                                     person_id bigint references person (id) not null ,
                                     created    timestamp default CURRENT_TIMESTAMP(10) not null,
                                     updated    timestamp default CURRENT_TIMESTAMP(10) not null

);

insert into address (name, person_id) values ('perm',1);

create table if not exists address_type(
                                     id bigserial primary key ,
                                     name varchar(100) not null unique ,
                                     address_id bigint references address (id) not null ,
                                     created    timestamp default CURRENT_TIMESTAMP(10) not null,
                                     updated    timestamp default CURRENT_TIMESTAMP(10) not null

);
insert into address_type (name, address_id) values ('dom',3);
drop table email cascade ;
create table if not exists email(
                                     id bigserial primary key ,
                                     email varchar(250) not null unique ,
                                     person_id bigint references person (id) not null ,
                                     created    timestamp default CURRENT_TIMESTAMP(10) not null,
                                     updated    timestamp default CURRENT_TIMESTAMP(10) not null

);
insert into email (email, person_id) values ('a@r.r',1);
drop table email_type cascade ;
create table if not exists email_type(
                                           id bigserial primary key ,
                                           name varchar(100) not null unique ,
                                           email_id bigint references email (id) not null ,
                                           created    timestamp default CURRENT_TIMESTAMP(10) not null,
                                           updated    timestamp default CURRENT_TIMESTAMP(10) not null

);

insert into email_type (name, email_id) VALUES ('dom',1);

create table if not exists organisation(
                                    id bigserial primary key ,
                                    name varchar(250) not null,
                                    created    timestamp default CURRENT_TIMESTAMP(10) not null,
                                    updated    timestamp default CURRENT_TIMESTAMP(10) not null

);
insert into organisation (name) values ('plakart');
drop  table phone cascade ;
create table if not exists phone(
                                    id bigserial primary key ,
                                    phone_number varchar(250) not null unique ,
                                    person_id bigint references person (id) not null ,
                                    created    timestamp default CURRENT_TIMESTAMP(10) not null,
                                    updated    timestamp default CURRENT_TIMESTAMP(10) not null
);
insert into phone (phone_number, person_id) values ('+7912', 1);
create table if not exists phone_type(
                                         id bigserial primary key ,
                                         name varchar(100) not null unique ,
                                         phone_id bigint references phone (id) not null ,
                                         created    timestamp default CURRENT_TIMESTAMP(10) not null,
                                         updated    timestamp default CURRENT_TIMESTAMP(10) not null

);

insert into phone_type (name, phone_id) VALUES ('dom',1);
create table if not exists post(
                                         id bigserial primary key ,
                                         name varchar(100) not null,
                                         created    timestamp default CURRENT_TIMESTAMP(10) not null,
                                         updated    timestamp default CURRENT_TIMESTAMP(10) not null

);

insert into post (name) values ('loh');

create table if not exists organisation_post(
    organisation_id bigint references organisation(id),
    post_id bigint references post(id),
    primary key (organisation_id, post_id)
);
insert into organisation_post (organisation_id, post_id) values (1,1);





create table if not exists roles
(
    id      bigserial primary key,
    name    varchar(100)                            not null unique,
    created timestamp default CURRENT_TIMESTAMP(10) not null,
    updated timestamp default CURRENT_TIMESTAMP(10) not null
);


create table if not exists user_roles
(
    user_id BIGINT references users (id) ON DELETE CASCADE ON UPDATE RESTRICT,
    role_id BIGINT references roles (id) ON DELETE CASCADE ON UPDATE RESTRICT,
    primary key (user_id, role_id)
);





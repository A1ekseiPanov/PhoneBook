
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


drop table address  ;
create table if not exists address(
                                     id bigserial primary key ,
                                     name varchar(500) not null,
                                     person_id bigint references person (id) not null ,
                                     adresstype_id bigint references address_type (id) not null,
                                     created    timestamp default CURRENT_TIMESTAMP(10) not null,
                                     updated    timestamp default CURRENT_TIMESTAMP(10) not null

);

insert into address (name, person_id,adresstype_id) values ('perm',1,1);
drop table address_type;

create table if not exists address_type(
                                     id bigserial primary key ,
                                     name varchar(100) not null unique ,
                                     created    timestamp default CURRENT_TIMESTAMP(10) not null,
                                     updated    timestamp default CURRENT_TIMESTAMP(10) not null

);
insert into address_type (name) values ('Домашний');
insert into address_type (name) values ('Рабочий');
insert into address_type (name) values ('Другой');
drop table email ;
create table if not exists email(
                                     id bigserial primary key ,
                                     email varchar(250) not null unique ,
                                     person_id bigint references person (id) not null ,
                                     created    timestamp default CURRENT_TIMESTAMP(10) not null,
                                     updated    timestamp default CURRENT_TIMESTAMP(10) not null,
                                     email_type_id bigint references email_type (id) not null
);
alter table email add column email_type_id bigint references email_type(id) ;
update email set email_type_id =1 where id =1;
alter table email alter column email_type_id set not null ;
delete from email where id = 5;

insert into email (email, person_id,email_type_id) values ('ev@yasa23.ru',1,3);
drop table email_type cascade  ;
create table if not exists email_type(
                                           id bigserial primary key ,
                                           name varchar(100) not null unique ,
                                           created    timestamp default CURRENT_TIMESTAMP(10) not null,
                                           updated    timestamp default CURRENT_TIMESTAMP(10) not null

);
drop table email_type;
-- alter table email_type drop column email_id;
--
insert into email_type (name) VALUES ('Личный');
insert into email_type (name) VALUES ('Рабочий');
insert into email_type (name) VALUES ('Другой');

create table if not exists organisation(
                                    id bigserial primary key ,
                                    name varchar(250) not null,
                                    created    timestamp default CURRENT_TIMESTAMP(10) not null,
                                    updated    timestamp default CURRENT_TIMESTAMP(10) not null

);
insert into organisation (name) values ('plakart');
drop  table phone  ;
create table if not exists phone(
                                    id bigserial primary key ,
                                    phone_number varchar(250) not null unique ,
                                    person_id bigint references person (id) not null ,
                                    phonetype_id bigint references phone_type (id) not null ,
                                    created    timestamp default CURRENT_TIMESTAMP(10) not null,
                                    updated    timestamp default CURRENT_TIMESTAMP(10) not null
);
insert into phone (phone_number, person_id,phonetype_id) values ('+7912', 1,1);
create table if not exists phone_type(
                                         id bigserial primary key ,
                                         name varchar(100) not null unique ,
                                         created    timestamp default CURRENT_TIMESTAMP(10) not null,
                                         updated    timestamp default CURRENT_TIMESTAMP(10) not null

);
drop table phone_type;
insert into phone_type (name) VALUES ('Мобильный');
insert into phone_type (name) VALUES ('Рабочий');
insert into phone_type (name) VALUES ('Домашний');
insert into phone_type (name) VALUES ('Другой');
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
insert into roles (name) values ('ROLE_USER');


create table if not exists user_roles
(
    user_id BIGINT references users (id) ON DELETE CASCADE ON UPDATE RESTRICT,
    role_id BIGINT references roles (id) ON DELETE CASCADE ON UPDATE RESTRICT,
    primary key (user_id, role_id)
);
insert into user_roles (user_id, role_id) VALUES (1,1);
insert into user_roles (user_id, role_id) VALUES (3,1);
delete from user_roles where user_id = 1;






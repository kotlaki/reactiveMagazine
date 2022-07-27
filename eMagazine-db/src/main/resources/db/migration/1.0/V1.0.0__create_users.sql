/*==============================================================*/
/* Project name:  eMagazine                                     */
/* DBMS name:     PostgreSQL 14.4                               */
/* Created on:    24.07.2022                                    */
/*==============================================================*/

/*==============================================================*/
/* Table: db_version                                            */
/*==============================================================*/

create table db_version
(
    ver_number varchar(30) not null,
    ver_date   timestamp   not null
);

comment
on table db_version is 'Версия объектов БД';

comment
on column db_version.ver_number is 'Номер версии';

comment
on column db_version.ver_date is 'Дата применения скрипта';

----------------------------------------------------------------
insert into db_version (ver_number, ver_date)
values ('0.0.0', current_timestamp);
----------------------------------------------------------------

/*
   Создание таблицы users
 */
create table users
(
    id          bigserial
        constraint users_pk
            primary key,
    email       varchar(50)  not null,
    password    varchar(100) not null,
    last_name   varchar(50)  not null,
    first_name  varchar(50)  not null,
    middle_name varchar(50)  not null,
    phone       varchar(12)  not null,
    create_date date         not null,
    active      boolean      not null
);

comment
    on table users is 'Таблица пользователей';

comment
    on column users.id is 'Идентификатор пользователей';

comment
    on column users.email is 'Электронная почта пользователя(логин)';

comment
    on column users.password is 'Пароль пользователя';

comment
    on column users.last_name is 'Фамилия пользователя';

comment
    on column users.first_name is 'Имя пользователя';

comment
    on column users.middle_name is 'Отчество пользователя';

comment
    on column users.phone is 'Контактный телефон';

comment
    on column users.create_date is 'Дата создания записи';

comment
    on column users.active is 'Признак активной записи';

create unique index users_email_uindex
    on users (email);

/*
    Создание таблицы users_roles
 */
create table user_role
(
    user_id bigint not null,
    roles char(20) not null,

    primary key (user_id)

);

comment
on table user_role is 'Связующая таблица для пользователей и ролей';

comment
on column user_role.user_id is 'ИД пользователя';

comment
on column user_role.roles is 'Роли';


--------------------------------------------------------------------------------

update db_version
set ver_number = '1.0.0',
    ver_date   = current_timestamp;

-- VACUUM (FULL, VERBOSE, ANALYZE);
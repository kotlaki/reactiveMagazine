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

CREATE TABLE IF NOT EXISTS users
(
    id          bigserial   NOT NULL
        constraint users_pk primary key,
    email       VARCHAR(50) NOT NULL,
    password    varchar(80)    NOT NULL,
    last_name   VARCHAR(50) NOT NULL,
    first_name  VARCHAR(50) NOT NULL,
    middle_name varchar(50) not null,
    phone       VARCHAR(15) NOT NULL,
    active      boolean              default true,
    create_date timestamp   not null default current_timestamp,
    roles       varchar(50) not null
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

comment
    on column users.roles is 'Роль';

create unique index users_email_uindex
    on users (email);

--------------------------------------------------------------------------------

update db_version
set ver_number = '1.0.0',
    ver_date   = current_timestamp;

-- VACUUM (FULL, VERBOSE, ANALYZE);
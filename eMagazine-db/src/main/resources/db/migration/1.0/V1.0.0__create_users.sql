/*==============================================================*/
/* Project name:  eMagazine                                     */
/* DBMS name:     PostgreSQL 14.4                               */
/* Created on:    24.07.2022                                    */
/*==============================================================*/

/*==============================================================*/
/* Table: db_version                                            */
/*==============================================================*/

create table db_version (
                            ver_number           varchar(30)          not null,
                            ver_date             timestamp            not null
);

comment on table db_version is 'Версия объектов БД';

comment on column db_version.ver_number is 'Номер версии';

comment on column db_version.ver_date is 'Дата применения скрипта';

----------------------------------------------------------------
insert into db_version (ver_number, ver_date) values ('0.0.0', current_timestamp);
----------------------------------------------------------------

/*
   Создание объектов БД и начальное заполнение
 */
create table users
(
    id          bigserial
        constraint users_pk
            primary key,
    login       varchar(20) not null,
    password    varchar(20) not null,
    last_name   varchar(30) not null,
    first_name  varchar(20) not null,
    middle_name varchar(20) not null,
    email       varchar(20) not null,
    phone       varchar(12) not null
);

comment on table users is 'Таблица пользователей';

comment on column users.id is 'Идентификатор пользователей';

comment on column users.login is 'Логин пользователя';

comment on column users.password is 'Пароль пользователя';

comment on column users.last_name is 'Фамилия пользователя';

comment on column users.first_name is 'Имя пользователя';

comment on column users.middle_name is 'Отчество пользователя';

comment on column users.email is 'Электронная почта пользователя';

comment on column users.phone is 'Контактный телефон';

create unique index users_email_uindex
    on users (email);

create unique index users_login_uindex
    on users (login);

create unique index users_phone_uindex
    on users (phone);

--------------------------------------------------------------------------------

update db_version set ver_number = '1.0.0', ver_date = current_timestamp;

-- VACUUM (FULL, VERBOSE, ANALYZE);
/*==============================================================*/
/* Project name:  eMagazine                                     */
/* DBMS name:     PostgreSQL 14.4                               */
/* Created on:    24.07.2022                                    */
/*==============================================================*/

/*==============================================================*/
/* Table: db_version                                            */
/*==============================================================*/

CREATE TABLE IF NOT EXISTS categories (
  id	                bigserial NOT NULL constraint categories_pk primary key,
  title                 VARCHAR(255) NOT NULL,
  description           VARCHAR(5000)
);

comment on table categories is 'Таблица категорий товаров';

comment on column categories.id is 'ИД категории';

comment on column categories.title is 'Наименование категории';

comment on column categories.description is 'Описание категории';


--------------------------------------------------------------------------------

update db_version
set ver_number = '1.0.2',
    ver_date   = current_timestamp;

-- VACUUM (FULL, VERBOSE, ANALYZE);
/*==============================================================*/
/* Project name:  eMagazine                                     */
/* DBMS name:     PostgreSQL 14.4                               */
/* Created on:    24.07.2022                                    */
/*==============================================================*/

/*==============================================================*/
/* Table: db_version                                            */
/*==============================================================*/

CREATE TABLE IF NOT EXISTS products (
  id	                bigserial NOT NULL constraint products_pk primary key,
  category_id           bigint NOT NULL,
  vendor_code           VARCHAR(8) NOT NULL,
  title                 VARCHAR(255) NOT NULL,
  short_description     VARCHAR(1000) NOT NULL,
  full_description      VARCHAR(5000) NOT NULL,
  price                 DECIMAL(8,2) NOT NULL,
  create_at             TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  update_at             TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

  CONSTRAINT FK_CATEGORY_ID FOREIGN KEY (category_id)
  REFERENCES categories (id)
);

CREATE TABLE IF NOT EXISTS products_images (
  id                    bigserial NOT NULL constraint products_images_pk primary key,
  product_id            bigint NOT NULL,
  path                  VARCHAR(250) NOT NULL,

  CONSTRAINT FK_PRODUCT_ID_IMG FOREIGN KEY (product_id)
  REFERENCES products (id)
);

--------------------------------------------------------------------------------

update db_version
set ver_number = '1.0.3',
    ver_date   = current_timestamp;

-- VACUUM (FULL, VERBOSE, ANALYZE);
/*==============================================================*/
/* Project name:  eMagazine                                     */
/* DBMS name:     PostgreSQL 14.4                               */
/* Created on:    24.07.2022                                    */
/*==============================================================*/

/*==============================================================*/
/* Table: db_version                                            */
/*==============================================================*/

CREATE TABLE IF NOT EXISTS orders_statuses (
  id                    bigserial NOT NULL constraint orders_statuses_pk primary key,
  title                 VARCHAR(50) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS delivery_addresses (
  id	                bigserial NOT NULL constraint delivery_addresses_pk primary key,
  user_id               bigint NOT NULL,
  address               VARCHAR(500) NOT NULL,
  CONSTRAINT FK_USER_ID_DEL_ADR FOREIGN KEY (user_id)
  REFERENCES users (id)
);

CREATE TABLE IF NOT EXISTS orders (
  id	                bigserial NOT NULL constraint orders_pk primary key,
  user_id               bigint NOT NULL,
  price                 DECIMAL(8,2) NOT NULL,
  delivery_price        DECIMAL(8,2) NOT NULL,
  delivery_address_id   bigint NOT NULL,
  phone_number          VARCHAR(20) NOT NULL,
  status                VARCHAR(12) NOT NULL,
  delivery_date         TIMESTAMP NOT NULL,
  create_at             TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  update_at             TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT FK_USER_ID FOREIGN KEY (user_id)
  REFERENCES users (id),
  CONSTRAINT FK_DELIVERY_ADDRESS_ID FOREIGN KEY (delivery_address_id)
  REFERENCES delivery_addresses (id)
);

CREATE TABLE IF NOT EXISTS orders_item (
  id	                bigserial NOT NULL constraint orders_item_pk primary key,
  product_id            bigint NOT NULL,
  order_id              bigint NOT NULL,
  quantity              INT NOT NULL,
  item_price            DECIMAL(8,2) NOT NULL,
  total_price           DECIMAL(8,2) NOT NULL,
  CONSTRAINT FK_ORDER_ID FOREIGN KEY (order_id)
  REFERENCES orders (id),
  CONSTRAINT FK_PRODUCT_ID_ORD_IT FOREIGN KEY (product_id)
  REFERENCES products (id)
);
--------------------------------------------------------------------------------

update db_version
set ver_number = '1.0.4',
    ver_date   = current_timestamp;

-- VACUUM (FULL, VERBOSE, ANALYZE);
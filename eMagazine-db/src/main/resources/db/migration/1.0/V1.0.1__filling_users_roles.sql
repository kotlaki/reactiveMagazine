/*==============================================================*/
/* Project name:  eMagazine                                     */
/* DBMS name:     PostgreSQL 14.4                               */
/* Created on:    24.07.2022                                    */
/*==============================================================*/

/*==============================================================*/
/* Table: db_version                                            */
/*==============================================================*/

INSERT INTO users (email, password, last_name, first_name, middle_name, create_date, phone, active)
VALUES
    (
     'admin@gmail.com',
     '$2a$08$iGvUFt.Id3VgJxTg7Tphwe5Xk08Sw/FUDQzVHuqZ8Oga0jlxMMW5C',
     'Курганов',
     'Роман',
     'Васильевич',
     '2022-07-26',
     '+79881111111',
     true
     );

INSERT INTO user_role (user_id, roles)
VALUES
    (1, 'ROLE_ADMIN');

--------------------------------------------------------------------------------

update db_version
set ver_number = '1.0.1',
    ver_date   = current_timestamp;

-- VACUUM (FULL, VERBOSE, ANALYZE);
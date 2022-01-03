create schema if not exists bruno_eurder;

set search_path to bruno_eurder;

create table ADDRESS
(
    ID integer,
    STREET_NAME text,
    STREET_NUMBER text,
    POSTAL_CODE text,
    CITY_NAME text,
    COUNTRY text,
    constraint PK_ADDRESS primary key (id)
);
create sequence address_seq start with 1 increment by 1;

create table USERS
(
    ID integer,
    FIRST_NAME text,
    LAST_NAME text,
    EMAIL text,
    FK_ADDRESS_ID integer,
    PHONE_NUMBER text,
    constraint FK_USERS_ADDRESS foreign key(FK_ADDRESS_ID) references ADDRESS (ID),
    constraint PK_USERS primary key (ID)
);
create sequence users_seq start with 1 increment by 1;

-- POPULATE TABLE ADDRESS
insert into ADDRESS(id, street_name, street_number, postal_code, city_name, country)
values (nextval('address_seq'),'Rue de Merino','178','36895','Malaga','Spain');
insert into ADDRESS(id, street_name, street_number, postal_code, city_name, country)
values (nextval('address_seq'),'Cure driveway','100','SL4785','London','UK');

-- POPULATE TABLE USERS
insert into USERS(id, first_name, last_name, email, fk_address_id, phone_number)
values (nextval('users_seq'),'Robert', 'Smith', 'robersmith@thecure.com',(select ID from ADDRESS where COUNTRY='UK'),'0044123');
insert into USERS(id, first_name, last_name, email, fk_address_id, phone_number)
values (nextval('users_seq'),'Don', 'Quichotte', 'don@spagna.com',(select ID from ADDRESS where COUNTRY='Spain'),'0034968574');


-- EXECUTE THE CODE BELOW TO DROP ALL TABLES
drop table USERS;
drop table ADDRESS;
drop sequence users_seq;
drop sequence address_seq;


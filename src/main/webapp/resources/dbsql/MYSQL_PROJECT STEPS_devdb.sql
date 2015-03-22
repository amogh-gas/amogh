drop database if exists devdb;  
create database devdb;
GRANT ALL PRIVILEGES ON *.* TO devdb@localhost IDENTIFIED BY 'devdb' WITH GRANT OPTION;

USE devdb;
select database();

drop table if exists MENU_DETAILS;
  
create table MENU_DETAILS (  
MENU_PK int AUTO_INCREMENT primary key,  
MENU_DESC varchar(255) not null,  
PARENT_MENU_ID varchar(255) not null,
MENU_URL varchar(255) not null    
);

drop table if exists CUSTOMER;

create table CUSTOMER  (
   CUST_ID              INT  AUTO_INCREMENT,
   CUST_NAME            varchar(100)                       not null,
   ADDR                 varchar(200)                       not null,
   AREA                 varchar(50)                       not null,
   STATE                varchar(20)                        not null,
   EMAIL                varchar(50),
   PHONE                varchar(20),
   PRI_MOBILE           varchar(20),
   SEC_MOBILE           varchar(20),
   CONTACT_PERSON1      varchar(30),
   CONTACT_PERSON2      varchar(30),
   TIN_NUM              varchar(20),
   CST_NUM              varchar(20),
   PAN_NUM              varchar(20),
   ECC_NUM              varchar(20),
   HOLDING_ADVICE       varchar(1),
   CREDIT_DAYS          INT,
   MAX_CYLINDER         INT                         not null,
   MIN_CYLINDER         INT                         not null,
   SECOND               varchar(1),
   constraint PK_CUST primary key (CUST_ID));

drop table if exists PRODUCT;

create table PRODUCT  (
   PROD_ID              INT    AUTO_INCREMENT ,
   PROD_NAME            VARCHAR(100)                       not null,
   PROD_TYP            VARCHAR(20)                        not null,
   PORDUCT_DESC         VARCHAR(200)                       not null,
   SHORT_DESC           VARCHAR(10)                        not null,
   UNIT                 VARCHAR(5)                         not null,
   UNDER                VARCHAR(10),
   TARIFF_CODE          VARCHAR(10),
constraint PK_PROD primary key (PROD_ID)
   );

drop table if exists RATE_MATSER;

create table RATE_MASTER  (
   RATE_ID              INT    AUTO_INCREMENT,
   CUST_ID              INT                         not null,
   PROD_ID              INT                         not null,
   RATE_PER_NO          DECIMAL(9,2),
   RATE_PER_LTR         DECIMAL(9,2),
   RATE_PER_CUB_MTR     DECIMAL(9,2),
   RATE_PER_KG          DECIMAL(9,2),
   EXCISE_RATE          DECIMAL(9,2),
   CESS_EXCISE          DECIMAL(9,2),
   EDU_CESS             DECIMAL(9,2),
   FRIEGHT              DECIMAL(9,2),
   LOADING_CHRGS        DECIMAL(9,2),
   UNLOADING_CHRGS      DECIMAL(9,2),
   WITHOUT_EXCISE       VARCHAR(3),
   SRVC_TAX_FLAG        VARCHAR(3),
   SRVC_TAX             DECIMAL(9,2),
   SUPPLEMENTRY_INVOIC  VARCHAR(3),
   VAT                  DECIMAL(9,2),
   CST_WITH_CFORM       DECIMAL(9,2),
   CST_WITHOUT_CFORM    DECIMAL(9,2),
constraint PK_RATE_MASTER primary key (RATE_ID)   
);

drop table if exists SUPPLIER;

create table SUPPLIER  (
   SUPPLIER_ID              INT  AUTO_INCREMENT,
   SUPPLIER_NAME            varchar(100)                       not null,
   ADDR                 varchar(200)                       not null,
   AREA                 varchar(50)                       not null,
   STATE                varchar(20)                        not null,
   EMAIL                varchar(50),
   PHONE                varchar(20),
   PRI_MOBILE           varchar(20),
   SEC_MOBILE           varchar(20),
   CONTACT_PERSON1      varchar(30),
   CONTACT_PERSON2      varchar(30),
   TIN_NUM              varchar(20),
   CST_NUM              varchar(20),
   PAN_NUM              varchar(20),
   ECC_NUM              varchar(20),
   HOLDING_ADVICE       varchar(1),
   CREDIT_DAYS          INT,
   MAX_CYLINDER         INT                         not null,
   MIN_CYLINDER         INT                         not null,
   SECOND               varchar(1),
   constraint PK_SUPPLIER primary key (SUPPLIER_ID)
);


Insert into MENU_DETAILS (MENU_PK,MENU_DESC,PARENT_MENU_ID,MENU_URL) values (1,'Master','-1','./customerMain');
Insert into MENU_DETAILS (MENU_PK,MENU_DESC,PARENT_MENU_ID,MENU_URL) values (2,'Sales','-1','./salesMain');
Insert into MENU_DETAILS (MENU_PK,MENU_DESC,PARENT_MENU_ID,MENU_URL) values (3,'Purchases','-1','./purchaseMain');
Insert into MENU_DETAILS (MENU_PK,MENU_DESC,PARENT_MENU_ID,MENU_URL) values (4,'Report','-1','./reportMain');
Insert into MENU_DETAILS (MENU_PK,MENU_DESC,PARENT_MENU_ID,MENU_URL) values (5,'Menu Maintainance','-1','./menu');

Insert into MENU_DETAILS (MENU_PK,MENU_DESC,PARENT_MENU_ID,MENU_URL) values (101,'Customer Mastar','1','./customer');
Insert into MENU_DETAILS (MENU_PK,MENU_DESC,PARENT_MENU_ID,MENU_URL) values (102,'Product Mastar','1','./product');
Insert into MENU_DETAILS (MENU_PK,MENU_DESC,PARENT_MENU_ID,MENU_URL) values (103,'Rate Mastar','1','./rate');
Insert into MENU_DETAILS (MENU_PK,MENU_DESC,PARENT_MENU_ID,MENU_URL) values (104,'Supplier Mastar','1','./supplier');




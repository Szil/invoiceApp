create table currency (
  currency_id               integer auto_increment not null,
  iso_code                  varchar(255),
  name                      varchar(255),
  symbol                    varchar(255),
  constraint uq_currency_iso_code unique (iso_code),
  constraint uq_currency_symbol unique (symbol),
  constraint pk_currency primary key (currency_id))
;

create table invoice (
  invoice_id                integer auto_increment not null,
  orgId                     integer,
  partnerId                 integer,
  currency_currency_id      integer,
  fullfil_date              date,
  issue_date                date,
  due_date                  date,
  number_of_copies          integer,
  gross_total               integer,
  constraint pk_invoice primary key (invoice_id))
;

create table organisation (
  org_id                    integer auto_increment not null,
  name                      varchar(255),
  bank_account              varchar(255),
  address                   varchar(255),
  tax_id                    varchar(255),
  phone_number              varchar(255),
  email                     varchar(255),
  constraint pk_organisation primary key (org_id))
;

create table partner (
  partner_id                integer auto_increment not null,
  name                      varchar(255),
  bank_account              varchar(255),
  address                   varchar(255),
  tax_id                    varchar(255),
  phone_number              varchar(255),
  email                     varchar(255),
  constraint pk_partner primary key (partner_id))
;

create table product (
  prod_id                   integer auto_increment not null,
  sku                       varchar(255),
  prod_name                 varchar(255),
  unit_of_measure           varchar(255),
  unit_price                double,
  tax_percent               double,
  currency_currency_id      integer,
  constraint pk_product primary key (prod_id))
;

create table products (
  invoice_id_invoice_id     integer,
  quantity                  integer)
;

create table i_user (
  email                     varchar(255) not null,
  name                      varchar(255),
  password                  varchar(255),
  u_role                    varchar(1),
  constraint ck_i_user_u_role check (u_role in ('S','K','A')),
  constraint pk_i_user primary key (email))
;

alter table invoice add constraint fk_invoice_issuer_1 foreign key (orgId) references organisation (org_id) on delete restrict on update restrict;
create index ix_invoice_issuer_1 on invoice (orgId);
alter table invoice add constraint fk_invoice_partner_2 foreign key (partnerId) references partner (partner_id) on delete restrict on update restrict;
create index ix_invoice_partner_2 on invoice (partnerId);
alter table invoice add constraint fk_invoice_currency_3 foreign key (currency_currency_id) references currency (currency_id) on delete restrict on update restrict;
create index ix_invoice_currency_3 on invoice (currency_currency_id);
alter table product add constraint fk_product_currency_4 foreign key (currency_currency_id) references currency (currency_id) on delete restrict on update restrict;
create index ix_product_currency_4 on product (currency_currency_id);
alter table products add constraint fk_products_invoiceId_5 foreign key (invoice_id_invoice_id) references invoice (invoice_id) on delete restrict on update restrict;
create index ix_products_invoiceId_5 on products (invoice_id_invoice_id);



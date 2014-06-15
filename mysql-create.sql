create table i_user (
  email                     varchar(255) not null,
  name                      varchar(40),
  password                  varchar(255) not null,
  constraint pk_i_user primary key (email))
;




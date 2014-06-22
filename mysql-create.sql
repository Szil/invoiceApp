create table i_user (
  email                     varchar(255) not null,
  name                      varchar(255),
  password                  varchar(255),
  u_role                    varchar(1),
  constraint ck_i_user_u_role check (u_role in ('S','K','A')),
  constraint pk_i_user primary key (email))
;




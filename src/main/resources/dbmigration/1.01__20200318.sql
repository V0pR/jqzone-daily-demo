-- apply changes
create table session (
  id                            varchar(255) not null,
  account_id                    varchar(255),
  expired_date                  datetime(6),
  constraint pk_session primary key (id)
);

create table user (
  id                            bigint auto_increment not null,
  remark                        varchar(255),
  name                          varchar(255),
  nick                          varchar(255),
  avt_url                       varchar(255),
  account                       varchar(255),
  password                      varchar(255),
  phone_number                  varchar(255),
  email                         varchar(255),
  status                        integer,
  version                       bigint not null,
  when_created                  datetime(6) not null,
  when_modified                 datetime(6) not null,
  who_created                   varchar(255) not null,
  who_modified                  varchar(255) not null,
  deleted                       tinyint(1) default 0 not null,
  constraint uq_user_phone_number unique (phone_number),
  constraint pk_user primary key (id)
);


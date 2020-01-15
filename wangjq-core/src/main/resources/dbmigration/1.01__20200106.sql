-- apply changes
create table wj_user (
  id                            bigint auto_increment not null,
  user_name                     varchar(255),
  real_name                     varchar(255),
  phone_number                  varchar(255),
  account                       varchar(255),
  salt                          varchar(255),
  password                      varchar(255),
  version                       bigint not null,
  when_created                  datetime(6) not null,
  when_modified                 datetime(6) not null,
  who_created                   varchar(255) not null,
  who_modified                  varchar(255) not null,
  deleted                       tinyint(1) default 0 not null,
  constraint uq_wj_user_account_phone_number unique (account,phone_number),
  constraint pk_wj_user primary key (id)
);


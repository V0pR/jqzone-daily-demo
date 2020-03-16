-- apply changes
create table brand (
  id                            bigint auto_increment not null,
  remark                        varchar(255),
  name                          varchar(255),
  code                          varchar(255),
  version                       bigint not null,
  when_created                  datetime(6) not null,
  when_modified                 datetime(6) not null,
  who_created                   varchar(255) not null,
  who_modified                  varchar(255) not null,
  deleted                       tinyint(1) default 0 not null,
  constraint pk_brand primary key (id)
);

create table category (
  id                            bigint auto_increment not null,
  remark                        varchar(255),
  code                          varchar(255),
  name                          varchar(255),
  version                       bigint not null,
  when_created                  datetime(6) not null,
  when_modified                 datetime(6) not null,
  who_created                   varchar(255) not null,
  who_modified                  varchar(255) not null,
  deleted                       tinyint(1) default 0 not null,
  constraint pk_category primary key (id)
);

create table coffee (
  id                            bigint auto_increment not null,
  remark                        varchar(255),
  order_no                      varchar(255),
  name                          varchar(255),
  price                         decimal(38),
  cost                          decimal(38),
  status                        integer,
  version                       bigint not null,
  when_created                  datetime(6) not null,
  when_modified                 datetime(6) not null,
  who_created                   varchar(255) not null,
  who_modified                  varchar(255) not null,
  deleted                       tinyint(1) default 0 not null,
  constraint pk_coffee primary key (id)
);

create table coffee_order (
  id                            bigint auto_increment not null,
  remark                        varchar(255),
  user_id                       bigint,
  coffee_id                     bigint,
  order_no                      varchar(255),
  status                        integer,
  create_time                   datetime(6),
  done_time                     datetime(6),
  cancel_time                   datetime(6),
  cancel_reason                 varchar(255),
  order_amount                  decimal(38),
  version                       bigint not null,
  when_created                  datetime(6) not null,
  when_modified                 datetime(6) not null,
  who_created                   varchar(255) not null,
  who_modified                  varchar(255) not null,
  deleted                       tinyint(1) default 0 not null,
  constraint pk_coffee_order primary key (id)
);

create table user (
  id                            bigint auto_increment not null,
  remark                        varchar(255),
  name                          varchar(255),
  nick                          varchar(255),
  avt_url                       varchar(255),
  account                       varchar(255),
  phone_no                      varchar(255),
  email                         varchar(255),
  status                        integer,
  has_vip                       tinyint(1) default 0 not null,
  version                       bigint not null,
  when_created                  datetime(6) not null,
  when_modified                 datetime(6) not null,
  who_created                   varchar(255) not null,
  who_modified                  varchar(255) not null,
  deleted                       tinyint(1) default 0 not null,
  constraint pk_user primary key (id)
);

create index ix_coffee_order_user_id on coffee_order (user_id);
alter table coffee_order add constraint fk_coffee_order_user_id foreign key (user_id) references user (id) on delete restrict on update restrict;

create index ix_coffee_order_coffee_id on coffee_order (coffee_id);
alter table coffee_order add constraint fk_coffee_order_coffee_id foreign key (coffee_id) references coffee (id) on delete restrict on update restrict;


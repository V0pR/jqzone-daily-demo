-- apply changes
create table user_feed_back (
  id                            bigint auto_increment not null,
  remark                        varchar(255),
  uid                           varchar(255),
  title                         varchar(255),
  content                       varchar(255),
  tall                          varchar(255),
  version                       bigint not null,
  when_created                  datetime(6) not null,
  when_modified                 datetime(6) not null,
  who_created                   varchar(255) not null,
  who_modified                  varchar(255) not null,
  deleted                       tinyint(1) default 0 not null,
  constraint pk_user_feed_back primary key (id)
);

create table version_control (
  id                            bigint auto_increment not null,
  remark                        varchar(255),
  device                        varchar(255),
  version_code                  varchar(255),
  switch_tag                    varchar(255),
  url                           varchar(255),
  content                       varchar(255),
  version_number                varchar(255),
  version                       bigint not null,
  when_created                  datetime(6) not null,
  when_modified                 datetime(6) not null,
  who_created                   varchar(255) not null,
  who_modified                  varchar(255) not null,
  deleted                       tinyint(1) default 0 not null,
  constraint pk_version_control primary key (id)
);


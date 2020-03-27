-- apply changes
create table role (
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
  constraint pk_role primary key (id)
);

create table user_role_ref (
  id                            bigint auto_increment not null,
  user_id                       bigint not null,
  role_id                       bigint not null,
  version                       bigint not null,
  when_created                  datetime(6) not null,
  when_modified                 datetime(6) not null,
  who_created                   varchar(255) not null,
  who_modified                  varchar(255) not null,
  constraint pk_user_role_ref primary key (id)
);

alter table user add column password varchar(255);

create index ix_user_role_ref_user_id on user_role_ref (user_id);
alter table user_role_ref add constraint fk_user_role_ref_user_id foreign key (user_id) references user (id) on delete restrict on update restrict;

create index ix_user_role_ref_role_id on user_role_ref (role_id);
alter table user_role_ref add constraint fk_user_role_ref_role_id foreign key (role_id) references role (id) on delete restrict on update restrict;


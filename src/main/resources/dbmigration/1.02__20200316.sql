-- apply changes
alter table coffee add column category_id bigint;
alter table coffee add column brand_id bigint;

create index ix_coffee_category_id on coffee (category_id);
alter table coffee add constraint fk_coffee_category_id foreign key (category_id) references category (id) on delete restrict on update restrict;

create index ix_coffee_brand_id on coffee (brand_id);
alter table coffee add constraint fk_coffee_brand_id foreign key (brand_id) references brand (id) on delete restrict on update restrict;


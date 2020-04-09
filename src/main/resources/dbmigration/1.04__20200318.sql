-- apply changes
alter table user_role_ref add constraint uq_user_role_ref_user_id_role_id unique  (user_id,role_id);

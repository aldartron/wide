-- TODO: Перенести в механизм миграции, когда появится (flyway/liquibase)
create database wide;
create user widecore with encrypted password 'widecore';
grant all privileges on database wide to widecore;
revoke all privileges on database wide from widecore;
drop role widecore;
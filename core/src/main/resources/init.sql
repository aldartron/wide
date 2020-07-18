-- TODO: Перенести в механизм миграции, когда появится (flyway/liquibase)
create database wide;
create person widecore with encrypted password 'widecore';
grant all privileges on database wide to widecore;

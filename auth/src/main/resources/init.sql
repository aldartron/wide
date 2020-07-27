-- TODO: Так же Перенести в механизм миграции, когда появится (flyway/liquibase)
create user wideauth with encrypted password 'wideauth';
grant all privileges on database wide to wideauth;

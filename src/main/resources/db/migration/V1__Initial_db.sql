create table student (
                         id bigserial primary key,
                         name varchar(225),
                         surname varchar(225),
                         date_of_birth date,
                         phone_number integer,
                         email varchar(225),
                         address varchar(225),
                         course integer,
                         group_name varchar(225)
)
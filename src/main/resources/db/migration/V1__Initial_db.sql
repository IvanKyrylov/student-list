create table student (
                         id bigserial primary key,
                         name varchar(255),
                         surname varchar(255),
                         date_of_birth date,
                         phone_number varchar(255),
                         email varchar(255),
                         address varchar(255),
                         course integer,
                         group_name varchar(255)
)
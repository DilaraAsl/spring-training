
drop table if exists employees;  -- if the table exists drop it first then create

create table EMPLOYEES(
                          id bigint not null,
                          name varchar(255),
                          primary key (id)
);
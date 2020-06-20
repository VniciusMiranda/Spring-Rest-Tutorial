
CREATE TABLE client(
    client_id bigint not null auto_increment,
    name varchar(60) not null,
    email_address varchar(255) not null,
    phone_number varchar(20) not null,

    primary key (client_id)
);

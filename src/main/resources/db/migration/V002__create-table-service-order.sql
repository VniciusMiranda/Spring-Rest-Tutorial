create table service_order (

    id bigint not null auto_increment,
    client_id bigint not null,
    description text not null,
    price decimal(10,2),
    status varchar(20) not null,
    opening_date datetime not null,
    finishing_date datetime not null,

    primary key (id)
);


alter table service_order add constraint fk_service_order_client
foreign key (client_id) references client (client_id)
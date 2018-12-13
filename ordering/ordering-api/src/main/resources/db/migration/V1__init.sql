CREATE TABLE OMS_ORDER (
	id BIGINT GENERATED BY DEFAULT AS IDENTITY,
	description varchar(255) not null
);

create sequence oms_order_sequence start with 1 increment by 1;
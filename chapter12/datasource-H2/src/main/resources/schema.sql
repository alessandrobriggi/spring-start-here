CREATE TABLE IF NOT EXISTS purchase (
	id int auto_increment primary key,
	product varchar(50) not null,
	price double not null
);
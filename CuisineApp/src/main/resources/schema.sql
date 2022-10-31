create table if not exists Cuisine_order(
	id identity,
    delivery_Name varchar(50) not null,
    delivery_Street varchar(50) not null,
    delivery_City varchar(50) not null,
    delivery_State varchar(50) not null,
    delivery_Zip varchar(10) not null,
    cc_number varchar(16) not null,
    cc_expiration varchar(5) not null,
    cc_cvv varchar(3) not null,
    placed_at timestamp not null
);
create table if not exists Cuisine(
	id identity,
    "name" varchar(50) not null,
    cuisine_order bigint not null,
    cuisine_order_key bigint not null,
    created_at timestamp not null
);
create table if not exists Ingredient_ref(
	ingredient varchar(4) not null,
    cuisine bigint not null,
    cuisine_key bigint not null
);
create table if not exists Ingredient(
	id varchar(4) not null,
    name varchar(25) not null,
    type varchar(25) not null
); 
alter table Cuisine 
	add foreign key(cuisine_order) 
    references Cuisine_order(id);
alter table Ingredient_ref 
	add foreign key(ingredient) 
    references Ingredient(id);
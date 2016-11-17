# hadoop-hbase-finskul

The sequence iq way
sudo docker run -it -h bonsai-phoenix hadoop/phoenix:2.7.1


create 'orders','client','product'
put 'orders', 'joe_2013-01-13', 'client:name', 'Joe'
put 'orders', 'joe_2013-01-13', 'client:address', 'Hillroad 1, SF'
put 'orders', 'joe_2013-01-13', 'product:title', 'iPhone 5'
put 'orders', 'joe_2013-01-13', 'product:delivery', '2013-01-13'

put 'orders', 'jane_2013-02-05', 'client:name', 'Jane'
put 'orders', 'jane_2013-02-05', 'client:address', 'Sunset Drive 42, NY'
put 'orders', 'jane_2013-02-05', 'product:title', 'Samsung S4'
put 'orders', 'jane_2013-02-05', 'product:delivery', '2013-05-02'

--Creating a new table
 CREATE TABLE product(id VARCHAR NOT NULL PRIMARY KEY, name VARCHAR);
 UPSERT INTO PRODUCT VALUES('1234','LEDTV');
 select * from product;

--Mapping an existing table
 CREATE VIEW "orders" (name_date VARCHAR PRIMARY KEY, "client"."address" VARCHAR, "client"."name" VARCHAR, "product"."delivery" VARCHAR ,"product"."title" VARCHAR) ;


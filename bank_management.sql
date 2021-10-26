
----USER TABLE------------
create table b_user(id int(25) primary key auto_increment,fname varchar(25),mname varchar(25),lname varchar(25),email varchar(100),dob
date,mobile int (100),gender varchar(25),role varchar(25));


alter table b_user add column(loginId varchar(20) unique,password varchar(20));


insert into b_user(fname,mname,lname,email,dob,mobile,gender,role)values('Mukesh','B','Bhange','bhange@gmail.com','1997-04-03',9898,'MALE','admin','admin@123');

--------------------------


-----ACCOUNT TABLE--------

create table b_account(acc_no int(100) primary key auto_increment,acc_type varchar(50),balance int(100),user_id int(20), constraint account_foreign_key foreign key(user_id) references b_user(id) on delete cascade);

alter table b_account add column(opening_date date);
---------------------------

-----TRASNSACTION TABLE----

 create table b_transactions(id int(20) primary key auto_increment,fromBank int(100),amount int(100),tobank int(100),sent_date date,status varchar(20),user_id int(20),constraint trans_constraint foreign key(user_id) references b_user(id) on delete cascade);
 
alter table b_transactions add column (description varchar(25));

---------------------------




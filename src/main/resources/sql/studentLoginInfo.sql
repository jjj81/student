

drop table if exists studentLoginInfo;

create table studentLoginInfo(
studentId varchar(50) primary key,
passWord varchar(500) not null,
className varchar(30) not null,
studentName varchar(30) 
);

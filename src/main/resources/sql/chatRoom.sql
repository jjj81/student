
drop table if exists chatRoom;

create table chatRoom(
userId varchar(30) not null,
lineText varchar(200) not null,
createAt timestamp not null default current_timestamp,
clazzId int
);

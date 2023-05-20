

drop table if exists studentDoExerciseInfo;

create table studentDoExerciseInfo(
studentId varchar(20) not null,
doExerciseWebSiteUrl varchar(50) not null,
doExerciseWebSiteAccount varchar(50) not null,
solveExerciseNumber int not null,
doExerciseStartTime date not  null,
doExerciseEndTime date not null,
doExercisePhoto1 mediumtext ,
doExercisePhoto2 mediumtext ,
doExercisePhoto3 mediumtext ,
doExercisePhoto4 mediumtext ,
doExercisePhoto5 mediumtext ,
isTure int default 0,
primary key(doExerciseWebSiteUrl,doExerciseWebSiteAccount)
);

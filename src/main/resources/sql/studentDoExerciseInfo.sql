

drop table if exists studentDoExerciseInfo;

create table studentDoExerciseInfo(
studentId varchar(20) not null,
doExerciseWebSiteUrl varchar(50) not null,
doExerciseWebSiteAccount varchar(50) not null,
solveExerciseNumber int not null,
doExerciseStartTime date not  null,
doExerciseEndTime date not null,
doExercisePhoto1 blob ,
doExercisePhoto2 blob ,
doExercisePhoto3 blob ,
primary key(doExerciseWebSiteUrl,doExerciseWebSiteAccount)
);

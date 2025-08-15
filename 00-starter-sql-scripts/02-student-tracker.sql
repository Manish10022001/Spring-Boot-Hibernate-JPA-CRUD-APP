create database if not exists `student_tracker`;
use student_tracker;
drop table if exists `student`;

-- 
-- table structure for table student
--

create table `student`(
	`id` int primary key not null auto_increment,
    `first_name` varchar(45) default null,
	`last_name` varchar(45) default null,
	`email` varchar(45) default null
)

engine = InnoDB auto_increment=1 default charset=latin1;
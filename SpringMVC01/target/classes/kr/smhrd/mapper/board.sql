create table board(
	num int not null auto_increment, -- 자동 증가
	title varchar(100) not null,
	content varchar(2000) not null,
	writer varchar(100) not null,
	indate datetime default now(), -- now() --> sysdate
	count int default 0,
	primary key(num)
);

-- insert
insert into board(title,content,writer)
values('스프링게시판','스프링게시판','관리자');
insert into board(title,content,writer)
values('스프링게시판','스프링게시판','정교훈');
insert into board(title,content,writer)
values('스프링게시판','스프링게시판','신형만');

select * from board;
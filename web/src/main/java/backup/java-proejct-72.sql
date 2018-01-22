
/* 게시글 첨부 파일명을 저장할 테이블을 정의한다.*/
create table ex_book (
  no int not null,
  bookname varchar(255) not null,
  company varchar(255) not null,
  bookdate varchar(255) not null,
  price int not null,
  expln varchar(255) not null
);

alter table ex_book
    add constraint primary key (no);

alter table ex_book
  modify column no int not null auto_increment;


insert into ex_book(bookname,company,bookdate,price,expln) values('aaa','aaa','2017-02-20',500,'aaa')

alter table ex_book
    add filename varchar(255)
  








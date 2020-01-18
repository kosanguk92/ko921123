--=================================
--관리자계정
--=================================

--web계정 생성

create user web identified by web
default tablespace users;

grant connect, resource to web;

--=================================
--web계정
--=================================

--member 테이블 생성

create table member(
    memberid varchar2(15),
    password varchar2(300) not null,
    mebername varchar2(30) not null,
    memberrole char(1) default 'U' not null,
    gender char(1),
    birthday date,
    email varchar2(100),
    phone char(11) not null,
    hobby varchar2(50),
    enrolldate date default sysdate,
    constraint pk_member_id primary key(memberid),
    constraint ck_member_gender check(gender in ('M','F')),
    constraint ck_member_role check(memberrole in ('U','A'))
);

--일반사용자 추가
insert into member
values('qwerty','1234','큐티','U','M',to_date('20000909'),'qwerty@naver.com','01012340909','서울시 강남구',
'운동,등산,독서',default);


--관리자계정 추가
insert into member
values('admin','큐티','U','M',to_date('20000909'),'qwerty@naver.com','01012340909','서울시 강남구',
'운동,등산,독서',default);



drop table member;


create table member (
    memberid varchar2(15),
    password varchar2(300) not null,
    membername varchar2(30) not null,
    memberrole char(1) default 'U' not null,
    gender char(1),
    birthday date,
    email varchar2(100),
    phone char(11) not null,
    address varchar2(150),
    hobby varchar2(50),
    enrolldate date default sysdate,
    constraint pk_member_id primary key (memberid),
    constraint ck_member_gender check(gender in ('M','F')),
    constraint ck_member_role check(memberrole in ('U','A'))
);

--일반사용자 추가
insert into member
values('ganadol7','1234','이지준','U','M',to_date('20000909'),'ganadol7@gmail.com','01027133279','서울시 강남구','운동,등산,독서,게임',default);

insert into member
values('jjune3279','1234','라따두이','U','F',to_date('19971121'),'jjune3279@gmail.com','01027133845','경기도 남양주','운동,등산',default);

--관리자계정 추가
insert into member
values('admin','1234','관리자','A','M',to_date('19830213'),'admin@gmail.com','01024413279','서울시 가낙구','독서,게임',default);

commit;



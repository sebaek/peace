create table users (
id varchar(255) primary key,
password varchar(255) not null,
nickName varchar(255) not null,
email varchar(255)
);
select * from users;
desc users;
drop table users;

drop table items2;
desc items2;
desc items;
create table items2 (
item_id int auto_increment primary key,
title varchar(255) not null,
body varchar(3000) not null,
user_id varchar(255) not null,
inserted datetime default now(),
foreign key (user_id) references users (id)
);
update  items set user_id='seoul' where item_id>0;
update items set user_id='korea' where item_id=13;
alter table items add column user_id varchar(255) references users(id);
alter table items add foreign key (user_id) references users(id);
select @@autocommit;
commit;
select * from items order by item_id desc;
insert into items (title, body)values('title3제목3','body3제목3의 본문3');

select item_id, title, body, inserted, user_id from items order by item_id desc
limit 0, 10;
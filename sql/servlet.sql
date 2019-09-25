create database servlet;
use servlet;

select stu_id stuId,stu_no stuNo,stu_name stuName,stu_sex stuSex,
       stu_age stuAge,stu_phone stuPhone,stu_idcard stuIdCard,
       stu_email stuEmail,stu_addr stuAddr,stu_grade stuGrade,
       stu_class stuClass,stu_img stuImg,stu_pwd stuPwd,auth_id authId   from student;

select * from project p inner join student s on p.pro_person = s.stu_id where p.pro_person = 4;

select pro_id proId,pro_name proName,stu_name proPerson,pro_state proState,pro_date proDate
from project pro inner join student stu on pro.pro_person = stu.stu_id
where pro.pro_person = 4 limit 0,9;
select pro_id proId,pro_name proName,stu_name proPerson,pro_state proState,pro_date proDate
from project pro inner join student stu on pro.pro_person = stu.stu_id limit 0,9;
select count(pro_person) from project;


select pro_id proId,pro_name proName,stu_name proPerson,pro_state proState,pro_date proDate
       from project pro inner join student stu on pro.pro_person = stu.stu_id
    where pro.pro_person = 5;




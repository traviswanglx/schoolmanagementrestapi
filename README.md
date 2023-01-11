# schoolmanagementrestapi
This program uses spring boot 2 to creating the rest api and mysql as the database.

**Mysql setup**

create database schoolmanagement;

use schoolmanagement;

CREATE TABLE teacher (
    id int NOT NULL AUTO_INCREMENT,
    email varchar(50) NOT NULL,
	name varchar(50) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE student (
    id int NOT NULL AUTO_INCREMENT,
    email varchar(50) NOT NULL,
	name varchar(50) NOT NULL,
	PRIMARY KEY (id)
);


CREATE TABLE student_teacher(
	student_id int,
	teacher_id int
);

**Add teacher**
![image](https://user-images.githubusercontent.com/88640243/211831730-75a0e49e-13a6-414d-9321-31f621fa27a7.png)

**Add student**
![image](https://user-images.githubusercontent.com/88640243/211831966-b17b9ec4-1f8f-41f3-97ce-fd2a74534925.png)

![image](https://user-images.githubusercontent.com/88640243/211832070-1404cdb1-16d4-4fee-ae55-da9aca2a7628.png)

![image](https://user-images.githubusercontent.com/88640243/211832164-33de55af-8b34-4138-9b02-8ad78be7a407.png)

**Db data**
![image](https://user-images.githubusercontent.com/88640243/211832772-a5a89538-4a08-4e7e-bcba-313a2e690a62.png)

![image](https://user-images.githubusercontent.com/88640243/211832866-a7025429-baee-4f27-ada0-89b24b0119a1.png)

**Register student to teacher**

**testing with 2 students**
![image](https://user-images.githubusercontent.com/88640243/211833572-3d8542db-d03c-48f0-8a9a-efbfc64ac9b0.png)

![image](https://user-images.githubusercontent.com/88640243/211833297-c5ac211e-3e65-4b7a-9861-29e6d3b27565.png)

**testing with 1 student**
![image](https://user-images.githubusercontent.com/88640243/211833781-a47394d0-ec0c-4a40-b9a3-e7ef93743827.png)

![image](https://user-images.githubusercontent.com/88640243/211833947-a36bd23b-c487-4b9c-a44c-6096ac6c40e2.png)

**Listing the students that is registered to a teacher**
![image](https://user-images.githubusercontent.com/88640243/211834237-56933b9d-4cae-4014-b8ad-95b0cd17547f.png)

**Suspend a student**
![image](https://user-images.githubusercontent.com/88640243/211834374-fc612fa4-0077-4759-9cd8-282007bed536.png)

![image](https://user-images.githubusercontent.com/88640243/211834436-39be25a7-b181-4db0-92a7-c12333bb302d.png)

**Links for all the api**
localhost:8080/schoolmanagement/api/teachers
localhost:8080/schoolmanagement/api/students
localhost:8080/schoolmanagement/api/register
localhost:8080/schoolmanagement/api/commonstudents?teacher=teachermary%40gmail.com
localhost:8080/schoolmanagement/api/suspend



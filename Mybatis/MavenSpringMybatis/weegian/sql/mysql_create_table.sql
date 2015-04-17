﻿/* Formatted on 2010/9/24 21:34:56 (QP5 v5.114.809.3010) */
/* 建立数据库 */
CREATE DATABASE STUDENT_MANAGER;
USE STUDENT_MANAGER;



/***** 建立student表 *****/
DROP TABLE STUDENT_TBL;
CREATE TABLE `STUDENT_TBL` (
	`STUDENT_ID` INT(8) NOT NULL AUTO_INCREMENT,
	`STUDENT_NAME` VARCHAR(10) NOT NULL,
	`STUDENT_SEX` VARCHAR(10) NULL DEFAULT NULL,
	`STUDENT_BIRTHDAY` DATE NULL DEFAULT NULL,
	`CLASS_ID` VARCHAR(255) NULL DEFAULT NULL,
	PRIMARY KEY (`STUDENT_ID`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=19;

/* 删除一列和增加一列的sql写法*/
ALTER TABLE STUDENT_TBL ADD PHOTO_ID VARCHAR(100);
ALTER TABLE STUDENT_TBL DROP COLUMN PHOTO_ID;


/***** 建立班级表 *****/
DROP TABLE CLASS_TBL;
CREATE TABLE `class_tbl` (
	`CLASS_ID` INT(8) NOT NULL AUTO_INCREMENT,
	`CLASS_NAME` VARCHAR(10) NOT NULL ,
	`CLASS_YEAR` DATE NULL DEFAULT NULL,
	`TEACHER_ID` VARCHAR(100) NULL DEFAULT NULL ,
	PRIMARY KEY (`CLASS_ID`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB;


/***** 建立教师表  *****/
DROP TABLE TEACHER_TBL;
CREATE TABLE TEACHER_TBL
(
   TEACHER_ID         INT(8) NOT NULL AUTO_INCREMENT,
   TEACHER_NAME       VARCHAR(10) NOT NULL,
   TEACHER_SEX        VARCHAR(10),
   TEACHER_BIRTHDAY   DATE,
   TEACHER_PHOTO      BLOB,
   WORK_DATE          DATE,
   PROFESSIONAL       VARCHAR(10),
   STUDENT_ID 		  INT(10) NULL DEFAULT NULL,
   PRIMARY KEY (`TEACHER_ID`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB;
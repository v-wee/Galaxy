
/*插入班级数据*/

INSERT INTO CLASS_TBL( CLASS_NAME, CLASS_YEAR)
VALUES ( '计算机及应用', '2010-09-01');

INSERT INTO CLASS_TBL( CLASS_NAME, CLASS_YEAR)
VALUES ( '计算机及应用', '2007-09-01');

INSERT INTO CLASS_TBL( CLASS_NAME, CLASS_YEAR)
VALUES ( '表演系', '1998-09-01');

INSERT INTO CLASS_TBL(, CLASS_NAME, CLASS_YEAR)
VALUES ( '电影系', '1985-09-01');

INSERT INTO CLASS_TBL( CLASS_NAME, CLASS_YEAR)
VALUES ( '土木工程', '2005-09-01');




/*插入学生数据*/
DELETE FROM STUDENT_TBL;
INSERT INTO STUDENT_TBL(STUDENT_NAME,
                        STUDENT_SEX,
                        STUDENT_BIRTHDAY,
                        CLASS_ID
                        )
VALUES (
          '李秀丽',
          1,
          '1986-04-03',
          (SELECT CT.CLASS_ID
             FROM CLASS_TBL CT
            WHERE CT.CLASS_NAME = '计算机及应用'
                  AND CT.CLASS_YEAR = '2007-09-01')
          );


INSERT INTO STUDENT_TBL(
                        STUDENT_NAME,
                        STUDENT_SEX,
                        STUDENT_BIRTHDAY,
                        CLASS_ID
                        )
VALUES (
        '沈玉颖',
        '0',
        '1985-02-26',
        (SELECT CT.CLASS_ID
           FROM CLASS_TBL CT
          WHERE CT.CLASS_NAME = '土木工程')
        );

INSERT INTO STUDENT_TBL(
                        STUDENT_NAME,
                        STUDENT_SEX,
                        STUDENT_BIRTHDAY,
                        CLASS_ID
                        )
VALUES (
        '蔡依林',
        '0',
        '1980-08-01',
        (SELECT CT.CLASS_ID
           FROM CLASS_TBL CT
          WHERE CT.CLASS_NAME = '表演系')
        );



SELECT * FROM CLASS_TBL;
DELETE FROM CLASS_TBL;


/* 插入教师 */

SELECT * FROM TEACHER_TBL;

DELETE FROM TEACHER_TBL;

INSERT INTO TEACHER_TBL(
                        TEACHER_NAME,
                        TEACHER_SEX,
                        TEACHER_BIRTHDAY,
                        WORK_DATE,
                        PROFESSIONAL)
VALUES (
        '谭浩强',
        '男',
        '1934-08-28',
        '1958-09-01',
        '教授');

INSERT INTO TEACHER_TBL(
                        TEACHER_NAME,
                        TEACHER_SEX,
                        TEACHER_BIRTHDAY,
                        WORK_DATE,
                        PROFESSIONAL)
VALUES (
        '立成丹',
        '女',
        '1975-05-08',
        '1990-03-01',
        '高级教师');


INSERT INTO TEACHER_TBL(
                        TEACHER_NAME,
                        TEACHER_SEX,
                        TEACHER_BIRTHDAY,
                        WORK_DATE,
                        PROFESSIONAL)
VALUES (
        '张艺谋',
        '男',
        '1951-11-14',
        '1973-09-01',
        '博士');


INSERT INTO TEACHER_TBL(
                        TEACHER_NAME,
                        TEACHER_SEX,
                        TEACHER_BIRTHDAY,
                        WORK_DATE,
                        PROFESSIONAL)
VALUES (
        '刘德华',
        '男',
        '1961-09-02',
        '1985-09-01',
        '');

INSERT INTO TEACHER_TBL(
                        TEACHER_NAME,
                        TEACHER_SEX,
                        TEACHER_BIRTHDAY,
                        WORK_DATE,
                        PROFESSIONAL)
VALUES (
        '孔德丽',
        '女',
        '1978-01-08',
        '1990-03-01',
        '博士');
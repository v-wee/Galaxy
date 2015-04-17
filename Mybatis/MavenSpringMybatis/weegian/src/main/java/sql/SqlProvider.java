package sql;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

import java.util.Date;
import java.util.Map;

import foo.Student;

public class SqlProvider {

	private static final String TABLE_NAME = "student_tbl";

	public String insertLogicSql(Map<String, Object> parameters) {

		/**
		 * 从mapper接口传过来的多个形参都可以用map.get()方法获得，map的key为借口处用@Param定义的,然后造型为实际的类型
		 * 而在Mybatis里使用方法则为#{key.property}，例如#{entity.id}则为key为entity的Object<Student>的id属性。
		 */
		Student e = (Student) parameters.get("entity");

		BEGIN();
		INSERT_INTO(TABLE_NAME);
		
		/**
		 * 关于sql语句需要的逻辑判断可以添加到此处 比如学生如果姓魏，则将名字加上大人,班级号设为xxx
		 */
		String name = e.getStudentName();
		if (name.startsWith("魏")){
			VALUES("student_name", "\"" + name + "大人" + "\"");
			VALUES("class_id","'777'");
		}
		else
			VALUES("student_name",	"#{entity.studentName}");

		VALUES("student_sex", "#{entity.studentSex,javaType=string,jdbcType=VARCHAR}");
		VALUES("student_birthday", "curdate()");

		return SQL();
	}
	
	public String updateSql(Map<String, Object> parameters) {

		Student e = (Student) parameters.get("entity");

		BEGIN();
		UPDATE(TABLE_NAME);
		SET("student_name = #{entity.studentName}");
		if(e.getStudentSex()!=null)
			SET("student_sex = #{entity.studentSex}");
		if(e.getStudentBirthday()!=null)
			SET("student_birthday = #{entity.studentBirthday}");
        WHERE("student_id = #{entity.studentID}");  
		return SQL();
	}
}

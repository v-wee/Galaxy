package foo;

import java.util.List;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

import sql.SqlProvider;

/**
 * 示例的对应关系为：一个专业可以有多个学生，一个学生可以有多个老师
 * 
 * 从学生查专业可以印发M+1问题(多方引起)
 * 从学生查老师可以引发N+1问题(一方引起)
 * 
 * @author Administrator
 *
 */
public interface StudentMapper {

	@Insert("insert into student_tbl(student_name,student_sex,student_birthday,class_id) values(#{studentName}, #{studentSex}, #{studentBirthday}, #{studentClazz.clazzId})")
//	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "studentID", before = true, resultType = int.class)
	public int insertStudent(Student entity);

	@InsertProvider(type = SqlProvider.class, method = "insertLogicSql")
	public int insertLogicStudent(@Param(value = "entity") Student entity);

	@Select("select * from student_tbl where student_id=#{whatever}")
	@Results(value = {
			@Result(id = true, property = "studentID", column = "STUDENT_ID", javaType = int.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "studentName", column = "STUDENT_NAME", javaType = String.class, jdbcType = JdbcType.VARCHAR) })
	public Student getStudent(String studentID);

	@Select("select * from student_tbl")
	@Results(value = {
			@Result(id = true, property = "studentID", column = "STUDENT_ID"),
			@Result(property = "studentName", column = "STUDENT_NAME"),
			@Result(property = "studentSex", column = "STUDENT_SEX"),
			@Result(property = "studentBirthday", column = "STUDENT_BIRTHDAY") })
	public List<Student> getStudentAll();

	@UpdateProvider(type = SqlProvider.class, method = "updateSql")
	public void updateStudent(@Param(value = "entity") Student entity);

	@Delete("delete from student_tbl where STUDENT_ID = #{param1}")
	public void deleteStudent(@Param(value = "id") int id);
	
	/**
	 * 使用@one，@many标签，Mybatis可以指定select自动抓取赋值。
	 * 使用注释里的方法可以避免N+1问题，对于集合类也可以智能赋值
	 */
//	@Select("select * from student_tbl st  join class_tbl tt on st.class_id = tt.class_id where student_id = #{studentID}")
	@Select("select * from student_tbl st   where student_id = #{studentID}")
	@Results(value = {
			@Result(id = true, property = "studentID", column = "STUDENT_ID"),
			@Result(property = "studentName", column = "STUDENT_NAME"),
			@Result(property = "studentSex", column = "STUDENT_SEX"),
			@Result(property = "studentBirthday", column = "STUDENT_BIRTHDAY"),
//			@Result(property = "studentClazz.clazzID", column = "CLASS_id"),
//			@Result(property = "studentClazz.clazzName", column = "class_name"),
//			@Result(property = "studentClazz.clazzYear", column = "class_year"),
			@Result(property="studentClazz", column="class_id", javaType=Clazz.class, one=@One(select="selectClazz")),
			@Result(property="teachers", column="student_id", javaType=List.class, many=@Many(select="selectTeacherList")),
			})
	public Student getStudentAndClassAndTeachers(int studentID);
	
	@Select("select * from class_tbl where class_id=#{whatever}")
	@Results(value = {
			@Result(id = true, property = "clazzID", column = "CLASS_ID"),
			@Result(property = "clazzName", column = "CLASS_NAME") ,
			@Result(property = "clazzYear", column = "CLASS_YEAR") })
	public Clazz selectClazz(int clazzID);
	
	@Select("select * from teacher_tbl where student_id = #{id}")
	@Results(value = {
			@Result(id = true, property = "teacherID", column = "TEACHER_ID"),
			@Result(property = "teacherName", column = "TEACHER_NAME") ,
			@Result(property = "professional", column = "professional") })
	public List<Teacher> selectTeacherList(int studentID);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
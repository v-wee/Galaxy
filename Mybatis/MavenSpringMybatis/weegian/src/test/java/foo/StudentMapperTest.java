package foo;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.liming.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:testContext.xml")
@TransactionConfiguration(defaultRollback = false)  
public class StudentMapperTest {


	@Autowired
	private StudentMapper studentMapper;
	@Autowired
	private SqlSessionFactory factory;

	@Before
	public void before() {
		System.out.println("---------------BEFORE-----------------");
	}


//	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={RuntimeException.class},noRollbackFor={Exception.class})
	@Test
	@Transactional(propagation=Propagation.REQUIRES_NEW,rollbackFor={BussException.class})
	public void testTransactional() throws Throwable{
			testInsert();
			throw new RuntimeException("wee");
	}
	
	@Test
	public void testInsert() {
		Student entity = new Student();
		entity.setStudentName("小花");
		entity.setStudentSex("male");
		entity.setStudentBirthday(DateUtil.parse("2010-05-28"));
		int k = this.studentMapper.insertStudent(entity);
		System.out.println("影响行数为:  " + k);

	}

	@Test
	public void testInsertLogic() {
		Student entity = new Student();
		entity.setStudentName("魏蜀吴");
		entity.setStudentSex("male");
		int k = this.studentMapper.insertLogicStudent(entity);
		System.out.println(k);
	}

	@Test
	public void testGetStudent() {
		Student entity = studentMapper.getStudent("20");
		System.out.println("学生Name: " + entity.getStudentName());
	}

	@Test
	public void testGetStudentAll() {
		List<Student> list = studentMapper.getStudentAll();
		for (Student student : list) {
			System.out.println("学生Name: " + student.getStudentName() + "     "
					+ "学生birthday: " + student.getStudentBirthday());
		}
	}

	@Test
	public void testDeleteStudent() {
		studentMapper.deleteStudent(20);
	}

	@Test
	public void testUpdateStudent() {
		Student entity = new Student();
		entity.setStudentID(22);
		entity.setStudentName("杨乃武");
		entity.setStudentSex("人妖");
		studentMapper.updateStudent(entity);
	}

	@Test
	public void testGetStudentAndClassAndTeachers() {
		Student s = studentMapper.getStudentAndClassAndTeachers(25);
		System.out.println(s.getStudentName());
		System.out.println("#"+s.getStudentClazz().getClazzName());
		for (Teacher t : s.getTeachers()) {
			System.out.println("-----" + t.getTeacherName());
		}
	}

	@Test
	public void testSelectClazz() {
		System.out.println("Clazz Name: "
				+ studentMapper.selectClazz(5).getClazzName());
	}

	@Test
	public void testSelectTeacherList() {
		List<Teacher> list = studentMapper.selectTeacherList(25);
		for (Teacher t : list) {
			System.out.println(t.getTeacherName() + "       "
					+ t.getProfessional());

		}
	}
	
	@After
	public void after() {
		System.out.println("---------------AFTER-----------------");
	}
}

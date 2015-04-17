package cn.bj;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.ws.rs.core.Response;

public class StudentServiceImpl implements IStudentService {
	public Student getStudent(long id, String name) {
		Student s = new Student();
		s.setId(id);
		s.setName(name+"--student");
		try {
			s.setBirthday(new SimpleDateFormat("yyyy-MM-dd")
					.parse("1983-04-26"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return s;
	}


	public UserResponse getStudent(String name) {
		Student s = new Student();
		s.setId(1);
		s.setName(name+"--UserP");
		try {
			s.setBirthday(new SimpleDateFormat("yyyy-MM-dd")
					.parse("1983-04-26"));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return new UserResponse("ok", s);
	}
}

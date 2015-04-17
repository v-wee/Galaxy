package foo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Student implements Serializable {  
	  
    private static final long serialVersionUID = 3096154202413606831L;  
//    private ClassEntity classEntity;  

      
    private int studentID;  
    private String studentName;  
    private String studentSex;  
    private Date studentBirthday;
    private Clazz studentClazz;
    private List<Teacher> teachers;
    
    


	public List<Teacher> getTeachers() {
		return teachers;
	}


	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}


	public Clazz getStudentClazz() {
		return studentClazz;
	}


	public void setStudentClazz(Clazz studentClazz) {
		this.studentClazz = studentClazz;
	}


	public Date getStudentBirthday() {  
        return studentBirthday;  
    }  

  
    public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public String getStudentName() {  
        return studentName;  
    }  
  
    public String getStudentSex() {  
        return studentSex;  
    }  
  
//    public void setClassEntity(ClassEntity classEntity) {  
//        this.classEntity = classEntity;  
//    }  
  
    public void setStudentBirthday(Date studentBirthday) {  
        this.studentBirthday = studentBirthday;  
    }  
  

  
    public void setStudentName(String studentName) {  
        this.studentName = studentName;  
    }  
  
    public void setStudentSex(String studentSex) {  
        this.studentSex = studentSex;  
    }  
}  
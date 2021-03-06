package cn.bj;

import javax.xml.bind.annotation.XmlAccessType;  
import javax.xml.bind.annotation.XmlAccessorType;  
import javax.xml.bind.annotation.XmlRootElement;  
import java.util.Date;  
  
@XmlRootElement(name = "Student")  
@XmlAccessorType(XmlAccessType.FIELD)  
public class Student  
{  
    private long id;  
    private String name;  
    private Date birthday;  
  
    public long getId()  
    {  
        return id;  
    }  
  
    public void setId(long id)  
    {  
        this.id = id;  
    }  
  
    public String getName()  
    {  
        return name;  
    }  
  
    public void setName(String name)  
    {  
        this.name = name;  
    }  
  
  
    public Date getBirthday()  
    {  
        return birthday;  
    }  
  
    public void setBirthday(Date birthday)  
    {  
        this.birthday = birthday;  
    }  
}  
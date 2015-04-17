package cn.bj;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "Response")  
@XmlAccessorType(XmlAccessType.FIELD)  
public class UserResponse  
{  
    private String status;  
  
    private Student data;  
  
    public UserResponse()  
    {  
    }  
  
    public UserResponse(String status, Student data)  
    {  
        this.status = status;  
        this.data = data;  
    }  
  
    public String getStatus()  
    {  
        return status;  
    }  
  
    public void setStatus(String status)  
    {  
        this.status = status;  
    }  
  
    public Object getData()  
    {  
        return data;  
    }  
  
    public void setData(Student data)  
    {  
        this.data = data;  
    }  
}  
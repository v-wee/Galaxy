package cn.bj;

import javax.ws.rs.Path;
/**
 * 部署使用jaxrs:server，增加REST服务,支持HTTP数据绑定，xml json格式
 * @author Administrator
 *
 */
public class Client {
	public static void main(String[] args) {
		String url = "http://localhost:8080/CXF/webservice/student/student/3/info2.json?name=abcss "
				+ "http://localhost:8080/CXF/webservice/student/student/3/info2.xml?name=abcss ";
		
		url = "http://localhost:8080/CXF/webservice/student/student/3/info?name=abcss&_type=xml "
			+ "http://localhost:8080/CXF/webservice/student/student/3/info?name=abcss&_type=json ";
		//第一个student是bean.xml里配置的address="/student"，
		//第二个student是Interface里配置的@Path(value = "/student/{id}")
	}
}

package cn.lz;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface IHelloWorld {
	// @WebParam给参数命名，提高可代码可读性。此项可选
	public String sayHi(@WebParam(name = "text") String text);
}
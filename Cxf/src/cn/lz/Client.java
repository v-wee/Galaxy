package cn.lz;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

public class Client {   
	  
	private Client(){};   
	  
	public static void main(String[] args){   
	    //创建WebService客户端代理工厂   
	    JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();   
	    //注册WebService接口   
	    factory.setServiceClass(IHelloWorld.class);   
	    //设置WebService地址   
	    factory.setAddress("http://localhost:9000/HelloWorld");        
	    IHelloWorld iHelloWorld = (IHelloWorld)factory.create();   
	    System.out.println("invoke webservice");   
	    System.out.println("message context is:"+iHelloWorld.sayHi("Josen"));   
	    System.exit(0);   
	}   
	   }   
package cn.lz;

import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

/**
 * 使用main方法建立server端
 * @author Administrator
 *
 */
public class Server {

	private Server() {
		IHelloWorld helloWorld = new HelloWorldImpl();
		// 创建WebService服务工厂
		JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
		// 注册WebService接口
		factory.setServiceClass(IHelloWorld.class);
		// 发布接口
		factory.setAddress("http://localhost:9000/HelloWorld");
		factory.setServiceBean(helloWorld);
		// 创建WebService
		factory.create();
	};

	public static void main(String[] args) throws InterruptedException {
		// 启动服务端
		new Server();
		System.out.println("Server ready");
		// 休眠一分钟，便于测试
		Thread.sleep(1000 * 60 * 2);
		System.out.println("Server exit");
		System.exit(0);
		
		String url= "http://localhost:9000/HelloWorld?wsdl";
	}
}
package cn.hk;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
/**
 * 部署spring server端
 * @author Administrator
 *
 */
public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {  
        JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();  
        factoryBean.setServiceClass(IReaderService.class);  
        factoryBean.setAddress("http://localhost:8080/readerService");  
          
        IReaderService readerService = (IReaderService)factoryBean.create();  
        Reader reader = readerService.getReader("shun","123");  
        System.out.println("Reader:"+reader);
        
        String url = "http://localhost:8080/CXF/webservice/readerService2?wsdl";
    }  
}

package cn.hk;

import javax.xml.ws.Endpoint;


public class Server {

	public static void main(String[] args) {  
        System.out.println("Server is starting...");  
        ReaderService readerService = new ReaderService();  
        Endpoint.publish("http://localhost:8080/readerService",readerService);  
        System.out.println("Server is started...");  
    }  
}

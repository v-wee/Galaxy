package cn.hk;



import java.util.ArrayList;
import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
@WebService(endpointInterface="cn.hk.IReaderService",serviceName="readerService3")  
public class ReaderServiceJson implements IReaderService{  
	@POST
    public Reader getReader(@WebParam(name="name") String name,@WebParam(name="password") String password) {  
        return new Reader(name,password);  
    }  
      
    public List<Reader> getReaders(){  
        List<Reader> readerList = new ArrayList<Reader>();  
        readerList.add(new Reader("shun1","123"));  
        readerList.add(new Reader("shun2","123"));  
        return readerList;  
    }  
    
    @GET  
    @Path(value = "/info2")  
     List<Reader> getStudent(@QueryParam("name") String name){
        List<Reader> readerList = new ArrayList<Reader>();  
        readerList.add(new Reader("shun1","123"));  
        readerList.add(new Reader("shun2","123"));  
        return readerList;  
    }
}  
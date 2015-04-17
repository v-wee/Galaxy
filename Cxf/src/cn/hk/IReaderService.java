package cn.hk;


import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@WebService  
public interface IReaderService {


    public Reader getReader(@WebParam(name="name") String name,@WebParam(name="password") String password);
    public List<Reader> getReaders();  
}  
package cn.bj;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

@Path(value = "/student/{id}")
public interface IStudentService {
	@GET
	@Path(value = "/info")
	Student getStudent(@PathParam("id") long id, @QueryParam("name") String name);

	@GET
	@Path(value = "/info2")
	UserResponse getStudent(@QueryParam("name") String name);
}

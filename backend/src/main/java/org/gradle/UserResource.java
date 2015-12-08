package org.gradle;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/user")
public class UserResource {
	//private static Map<Integer, User> DATA = new ConcurrentHashMap<>();
    //private static AtomicInteger ID_COUNTER = new AtomicInteger();
	 @PUT
	 public User insert(User user){
		 
		 SqlH2 data = new SqlH2();
		 data.initializeConnections();
		 data.createNewTable();
		 data.insertRow(user);
		 data.Retrieve(user);
		 data.closeConnections();
		 return user;
	 }
	 
	
}

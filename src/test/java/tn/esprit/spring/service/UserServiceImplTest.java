
package tn.esprit.spring.service;

 
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.IUserService;
import tn.esprit.spring.services.UserServiceImpl;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
 class UserServiceImplTest {
	private static final Logger l = LogManager.getLogger(UserServiceImpl.class);
	

		@Autowired
		IUserService us; 
	
		@Test
		@Order(1)
		 void testRetrieveAllUsers() {
			List<User> listUsers = us.retrieveAllUsers(); 
			// if there are 7 users in DB : 
			Assertions.assertEquals(5, listUsers.size());
		
			
		}
		
		
		@Test
		@Order(2)
		 void testAddUser() throws ParseException {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date d = dateFormat.parse("2015-03-23");
			User u = new User("AYMEN", "NEGRA22", d, Role.INGENIEUR); 
			User userAdded = us.addUser(u); 
			Assertions.assertEquals(u.getLastName(), userAdded.getLastName());
		}
	 
		@Test
		@Order(3)
		 void testModifyUser() throws ParseException   {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date d = dateFormat.parse("2015-03-23");
			User u = new User(2L, "Mayssa11111", "Mayssa", d, Role.INGENIEUR); 
			User userUpdated  = us.updateUser(u); 
			Assertions.assertEquals(u.getLastName(), userUpdated.getLastName());
		}
	
		@Test
		@Order(4)
		 void testRetrieveUser() {
			User userRetrieved = us.retrieveUser("2"); 
			Assertions.assertEquals(2L, userRetrieved.getId());
		}
		
		@Test
		@Order(5)
		 void testDeleteUser() {
		
			us.deleteUser("19");
			Assertions.assertNull(us.retrieveUser("13"));
	
		}
		
		// 5 tests unitaires  
 
}






package learn.contoller;

import java.util.List;

import learn.entity.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestMVC {
	@Autowired
	private HibernateTemplate ht;
	
	@RequestMapping("/show")
	public List<Users> show(){
		Users u = new Users();
		u.setAge(30);
		return (List<Users>)  ht.findByExample(u, 3, 10);
	}
}

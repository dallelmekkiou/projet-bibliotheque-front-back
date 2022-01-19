package com.example.demo.web;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.UserRepository;
import com.example.demo.entities.User;

@RestController
public class UserController {

	@Autowired
	private UserRepository uRepository;
	
	//Get un user
    @RequestMapping(value="/getUser/{id}", method= RequestMethod.GET)  
	public User getUser(@PathVariable Long id){
	        return uRepository.findById(id).orElse(null);  
	    }
    
	//Get les Users
    @RequestMapping(value="/getUsers", method= RequestMethod.GET)  
	public List<User> getUsers(){
	        return uRepository.findAll();  
	    }
    
    //Add
    @RequestMapping(value="/addUser", method=RequestMethod.POST)
	public User addUser(@RequestBody User u) {
    	return uRepository.save(u);	
	}

	//Edit
	@RequestMapping(value="/editUser/{id}", method=RequestMethod.PUT)
	public User editUser(@PathVariable Long id, @RequestBody User u) {
		u.setId(id);
		return uRepository.save(u);
	}
	
	//Edit un seul attribut
	@RequestMapping(value="/patchUser/{id}",method=RequestMethod.PATCH)
	public User patchUser(@PathVariable Long id, @RequestBody Map<String, Object> changes) {
        User u = uRepository.findById(id).get();

		changes.forEach(
                (change, value) -> {
                    switch (change){
                        case "username": u.setUsername ((String) value); break;
                        case "password": u.setPassword((String) value); break;
                       
                    }
                });
		
		return uRepository.save(u);	
	}
	
	//Delete
	@RequestMapping(value="/deleteUser/{id}", method=RequestMethod.DELETE)
	public boolean deleteUser(@PathVariable Long id) {
		uRepository.deleteById(id);
		return true;
	}
	
	


}

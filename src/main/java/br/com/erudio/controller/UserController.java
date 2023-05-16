package br.com.erudio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

//import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.model.User;
import br.com.erudio.services.UserService;


@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;
	

	/* @RequestMapping(value = "/{id}",
			method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Person findById(@PathVariable(value = "id") Long id) throws Exception{

		return service.findById(id);
	}
	*/
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> findAll(){

		return service.findAll();
	}


	@GetMapping(value = "/{id}",
		produces = MediaType.APPLICATION_JSON_VALUE)	
	public User findById(@PathVariable(value = "id") Long id) throws Exception{

		return service.findById(id);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
	produces = MediaType.APPLICATION_JSON_VALUE)
	public User create(@RequestBody User person){

		return service.create(person);
}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
	produces = MediaType.APPLICATION_JSON_VALUE)
	public User update(@RequestBody User person){

		return service.update(person);
	}

/* 	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable (value = "id")Long id){
		service.delete(id);
	}
*/
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable (value = "id")Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
}

}

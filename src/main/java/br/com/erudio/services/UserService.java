package br.com.erudio.services;

import java.util.List;
import br.com.erudio.exceptions.ResourceNotFoundException;
import br.com.erudio.model.User;
import br.com.erudio.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    UserRepository repository;

    public List<User> findAll(){
 
        return repository.findAll();
    }
    public User findById(Long id){
       

        return repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
    }


    public User create(User person){
        return repository.save(person);
    }
     

    public User update(User user){
        var entity = repository.findById(user.getRegistration())
            .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        
            entity.setFullName(user.getFullName());
            entity.setRegistration(user.getRegistration());
            entity.setEmail(user.getEmail());
            entity.setGender(user.getGender());
        
        return repository.save(user);
    }

    public void delete(Long id){

        var entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
            repository.delete(entity);
    }
     

}

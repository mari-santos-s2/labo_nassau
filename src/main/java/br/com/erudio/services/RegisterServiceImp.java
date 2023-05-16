package br.com.erudio.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.erudio.model.Register;
import br.com.erudio.repositories.RegisterRepository;


public class RegisterServiceImp implements RegisterService {
    
    @Autowired
    private RegisterRepository registerRepository;
    
    @Override
    public Register cadastrar(Register register) {
        return registerRepository.save(register);
    }
    
    @Override
    public Optional<Register> buscarPorEmail(String email) {
        return registerRepository.findByEmail(email);
    }
    
    @Override
    public Optional<Register> buscarPorEmailESenha(String email, String password) {
        Optional<Register> register = registerRepository.findByEmail(email);
        if (register.isPresent() && register.get().getPassword().equals(password)) {
            return register;
        }

        
        return Optional.empty();
    }

    @Override
    public Object getPassword() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPassword'");
    }

}

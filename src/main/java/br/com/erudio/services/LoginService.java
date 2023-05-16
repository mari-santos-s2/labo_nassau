package br.com.erudio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.model.Login;
import br.com.erudio.repositories.LoginRepository;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    public Login save(Login login) {
        return loginRepository.save(login);
    }

    public boolean isValidUser(String email, String password) {
        Login login = loginRepository.findByEmail(email);
        if (login != null && login.getPassword().equals(password)) {
            return true;
        }
        return false;
    }
}

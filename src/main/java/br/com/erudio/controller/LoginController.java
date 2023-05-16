package br.com.erudio.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.erudio.model.Login;
import br.com.erudio.model.Register;
import br.com.erudio.services.RegisterService;
import jakarta.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    private RegisterService registerService; 

    
    @GetMapping("/")
    public String login(Model model) {
        model.addAttribute("loginForm", new Login());
        return "login";
    }
    
    @PostMapping("/login")
    public String realizarLogin(@ModelAttribute("loginForm") @Valid Login login, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "login";
        }
        
        Optional<Register> register = registerService.buscarPorEmailESenha(login.getEmail(), login.getPassword());
        if (register.isPresent()) {
            // login realizado com sucesso
            return "redirect:/pagina-restrita";
        } else {
            // redireciona para a página de cadastro
            model.addAttribute("cadastroForm", new Register());
            return "cadastro";
        }
    }
    
    @PostMapping("/cadastro")
    public String realizarRegister(@ModelAttribute("cadastroForm") @Valid RegisterService cadastroForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "cadastro";
        }
        
        Register register = cadastroForm.cadastrar((Register) registerService);
        registerService.cadastrar(register);
        return "redirect:/login";
       // RegisterService cadastro = cadastroForm.toRegister();
       // registerService.registerr(cadastro);
     //   return "redirect:/login";
    }   
 }

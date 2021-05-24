package cseiu.abet.controller;


import cseiu.abet.model.Account;
import cseiu.abet.model.Instructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/app")
public class LoginController {

    @GetMapping("/login")
    public String showLoginPage(Model model){
        Account account = new Account();
        model.addAttribute("account", account);
        return "login.html";

    }
    @RequestMapping(value ="/checkLogin" , method = RequestMethod.POST)
    public String checkLogin(@ModelAttribute("account") Account account, Model model){
        return "greeting.html";
    }



}

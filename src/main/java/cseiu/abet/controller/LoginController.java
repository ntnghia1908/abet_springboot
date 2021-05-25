package cseiu.abet.controller;


import cseiu.abet.model.Account;
import cseiu.abet.services.AccountService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
@RequestMapping("/app")
public class LoginController {
    private final AccountService accountService;

    public LoginController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/login")
    public String showLoginPage(Model model) {
        Account account = new Account();
        model.addAttribute("account", account);
        return "login.html";

    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {

        if (principal != null) {
            Account loginedAccount = (Account) ((Authentication) principal).getPrincipal();

            String userInfo = loginedAccount.toString();

            model.addAttribute("userInfo", userInfo);

            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);
        }

        return "403Page";
    }

    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        return "logoutSuccessfulPage";
    }

//    @RequestMapping(value ="/checkLogin" , method = RequestMethod.POST)
//    public String checkLogin(@ModelAttribute("account") Account account){
//        Account checkLogin = accountService.checkLogin(account.getUser_name(), account.getPassword());
//        if (checkLogin == null){
//            return "redirect:/app/login";
//        }
//        else{
//            return "redirect:/admin/dashboard";
//        }
//     }


}

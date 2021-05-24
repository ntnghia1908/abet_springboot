package cseiu.abet.services;

import cseiu.abet.model.Account;
import cseiu.abet.repo.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

//    @Bean
//    public DaoAuthenticationProvider authProvider() {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(userDetailsService);
//        authProvider.setPasswordEncoder(encoder());
//        return authProvider;
//    }

    public Account addAccount(Account account) {
//        account.setPassword(passwordEncoder.encode(account.getPassword()));
        return accountRepository.save(account);
    }

    public Account updateAccount(Account account) {
        return accountRepository.save(account);
    }

    public void deleteAccount(int accountId){
        accountRepository.deleteById(accountId);
    }

    public Account checkLogin (String user_name, String password) {
//        String encryptedPass = passwordEncoder.encode(password);
//        System.out.println(password);
//        System.out.println(encryptedPass);
        return accountRepository.checkAccount(user_name, password);
    }

}

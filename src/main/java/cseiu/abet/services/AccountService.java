package cseiu.abet.services;

import cseiu.abet.model.Account;
import cseiu.abet.repo.AccountRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    public Account addAccount(Account account){
        return accountRepository.save(account);
    }
    public Account updateAccount(Account account){
        return accountRepository.save(account);
    }
    public void deleteAccount(int accountId){
        accountRepository.deleteById(accountId);
    }
}

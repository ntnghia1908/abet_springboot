package cseiu.abet.repo;

import cseiu.abet.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AccountRepository extends JpaRepository<Account, Integer> {

    @Query(
            value ="select * from account where user_name = :user_name and password = :password",
            nativeQuery = true
    )
    Account checkAccount(@Param("user_name") String user_name, @Param("password") String password);
    
}

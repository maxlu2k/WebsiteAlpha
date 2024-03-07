package com.app.alpha.Repository;

import com.app.alpha.Model.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountsRepository extends JpaRepository<Accounts,String> {

}

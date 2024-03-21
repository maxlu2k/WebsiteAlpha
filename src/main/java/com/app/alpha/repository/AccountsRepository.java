package com.app.alpha.repository;

import com.app.alpha.model.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountsRepository extends JpaRepository<Accounts,String> {

}

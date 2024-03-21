package com.app.alpha.service;

import com.app.alpha.model.Accounts;

import java.util.List;

public interface AccountService {
    Accounts create(Accounts account);
    public List<Accounts> getAll();
    public  Accounts getByUsername(String id);

    public List<Accounts> listAdmin();
}

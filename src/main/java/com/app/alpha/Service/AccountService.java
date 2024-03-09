package com.app.alpha.Service;

import com.app.alpha.Model.Accounts;

import java.util.List;

public interface AccountService {
    Accounts create(Accounts account);
    public List<Accounts> getAll();
    public  Accounts getByUsername(String id);

    public List<Accounts> listAdmin();
}

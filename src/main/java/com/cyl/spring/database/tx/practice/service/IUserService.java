package com.cyl.spring.database.tx.practice.service;

import com.cyl.spring.database.tx.practice.model.UserModel;

public interface IUserService {
    public void save(UserModel userModel);

    public int countAll();
}

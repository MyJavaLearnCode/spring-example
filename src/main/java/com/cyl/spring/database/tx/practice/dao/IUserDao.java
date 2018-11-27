package com.cyl.spring.database.tx.practice.dao;


import com.cyl.spring.database.tx.practice.model.UserModel;

public interface IUserDao {
    public void save(UserModel userModel);

    public int countAll();
}

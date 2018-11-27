package com.cyl.spring.database.jdbc.example;

public interface IUserDao {
    public void save(UserModel userModel);

    public int countAll();
}

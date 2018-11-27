package com.cyl.spring.database.tx.practice.dao;


import com.cyl.spring.database.tx.practice.model.AddressModel;

public interface IAddressDao {
    public void save(AddressModel userModel);

    public int countAll();
}

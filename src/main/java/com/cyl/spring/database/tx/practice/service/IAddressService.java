package com.cyl.spring.database.tx.practice.service;

import com.cyl.spring.database.tx.practice.model.AddressModel;

public interface IAddressService {
    public void save(AddressModel addressModel);

    public int countAll();
}

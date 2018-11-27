package com.cyl.spring.database.tx.txbyconfig;

import com.cyl.spring.database.tx.practice.dao.IAddressDao;
import com.cyl.spring.database.tx.practice.model.AddressModel;
import com.cyl.spring.database.tx.practice.service.IAddressService;

public class ConfigAddressServiceImpl implements IAddressService {
    private IAddressDao addressDao;

    public IAddressDao getAddressDao() {
        return addressDao;
    }

    public void setAddressDao(IAddressDao addressDao) {
        this.addressDao = addressDao;
    }

    @Override
    public void save(AddressModel addressModel) {
        addressDao.save(addressModel);
    }

    @Override
    public int countAll() {
        return addressDao.countAll();
    }
}

package com.cyl.spring.database.tx.txbyconfig;

import com.cyl.spring.database.tx.practice.dao.IUserDao;
import com.cyl.spring.database.tx.practice.model.UserModel;
import com.cyl.spring.database.tx.practice.service.IAddressService;
import com.cyl.spring.database.tx.practice.service.IUserService;

public class ConfigUserServiceImpl implements IUserService {
    private IUserDao userDao;
    private IAddressService addressService;

    public IUserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    public IAddressService getAddressService() {
        return addressService;
    }

    public void setAddressService(IAddressService addressService) {
        this.addressService = addressService;
    }

    @Override
    public void save(UserModel userModel) {
        userDao.save(userModel);
        userModel.getAddressModel().setUserId(userModel.getId());
        addressService.save(userModel.getAddressModel());

    }

    @Override
    public int countAll() {
        return userDao.countAll();
    }
}

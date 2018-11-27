package com.cyl.spring.database.tx.practice.service.impl;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import com.cyl.spring.database.tx.practice.dao.IUserDao;
import com.cyl.spring.database.tx.practice.model.UserModel;
import com.cyl.spring.database.tx.practice.service.IAddressService;
import com.cyl.spring.database.tx.practice.service.IUserService;
import com.cyl.spring.database.tx.practice.utils.TransactionTemplateUtils;

public class UserServiceImpl implements IUserService {
    private IUserDao userDao;
    private IAddressService addressService;
    private PlatformTransactionManager txManager;

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    public void setAddressService(IAddressService addressService) {
        this.addressService = addressService;
    }

    public void setTxManager(PlatformTransactionManager txManager) {
        this.txManager = txManager;
    }

    @Override
    public void save(UserModel userModel) {
        TransactionTemplate transactionTemplate = TransactionTemplateUtils.getDefaultTransactionTemplate(txManager);
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                userDao.save(userModel);
                userModel.getAddressModel().setUserId(userModel.getId());
                try {
                    addressService.save(userModel.getAddressModel());
                } catch (RuntimeException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public int countAll() {
        return userDao.countAll();
    }
}

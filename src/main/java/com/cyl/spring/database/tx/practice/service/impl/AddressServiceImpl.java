package com.cyl.spring.database.tx.practice.service.impl;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import com.cyl.spring.database.tx.practice.dao.IAddressDao;
import com.cyl.spring.database.tx.practice.model.AddressModel;
import com.cyl.spring.database.tx.practice.service.IAddressService;
import com.cyl.spring.database.tx.practice.utils.TransactionTemplateUtils;

public class AddressServiceImpl implements IAddressService {
    private IAddressDao addressDao;
    private PlatformTransactionManager txManager;

    public IAddressDao getAddressDao() {
        return addressDao;
    }

    public void setAddressDao(IAddressDao addressDao) {
        this.addressDao = addressDao;
    }

    public PlatformTransactionManager getTxManager() {
        return txManager;
    }

    public void setTxManager(PlatformTransactionManager txManager) {
        this.txManager = txManager;
    }

    @Override
    public void save(AddressModel addressModel) {
        TransactionTemplate transactionTemplate = TransactionTemplateUtils.getDefaultTransactionTemplate(txManager);
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                addressDao.save(addressModel);
//                throw new RuntimeException();
            }
        });
    }

    @Override
    public int countAll() {
        return addressDao.countAll();
    }
}

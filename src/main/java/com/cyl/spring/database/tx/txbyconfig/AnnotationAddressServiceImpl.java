package com.cyl.spring.database.tx.txbyconfig;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.cyl.spring.database.tx.practice.dao.IAddressDao;
import com.cyl.spring.database.tx.practice.model.AddressModel;
import com.cyl.spring.database.tx.practice.service.IAddressService;

public class AnnotationAddressServiceImpl implements IAddressService {
    private IAddressDao addressDao;

    public IAddressDao getAddressDao() {
        return addressDao;
    }

    public void setAddressDao(IAddressDao addressDao) {
        this.addressDao = addressDao;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED)
    public void save(AddressModel addressModel) {
        addressDao.save(addressModel);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED,readOnly = true)
    public int countAll() {
        return addressDao.countAll();
    }
}

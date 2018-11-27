package com.cyl.spring.database.tx.practice.utils;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;

public class TransactionTemplateUtils {
    public static TransactionTemplate getDefaultTransactionTemplate(PlatformTransactionManager txManager) {
//        return getDefaultTransactionTemplate(txManager, TransactionDefinition.PROPAGATION_REQUIRED, TransactionDefinition.ISOLATION_READ_COMMITTED);
        //定义传播行为
        return getDefaultTransactionTemplate(txManager, TransactionDefinition.PROPAGATION_REQUIRES_NEW, TransactionDefinition.ISOLATION_READ_COMMITTED);
    }

    private static TransactionTemplate getDefaultTransactionTemplate(PlatformTransactionManager txManager, int propagationBehavior, int isolationLevel) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(txManager);
        transactionTemplate.setPropagationBehavior(propagationBehavior);
        transactionTemplate.setIsolationLevel(isolationLevel);
        return transactionTemplate;
    }
}

package org.bank.repository.impl;

import org.bank.base.repository.BaseRepositoryImpl;
import org.bank.entity.Transaction;
import org.bank.repository.TransactionRepository;

public class TransactionRepositoryImpl extends BaseRepositoryImpl<Long, Transaction>
implements TransactionRepository {
    public TransactionRepositoryImpl(Class<Transaction> entityClass) {
        super(entityClass);
    }
}

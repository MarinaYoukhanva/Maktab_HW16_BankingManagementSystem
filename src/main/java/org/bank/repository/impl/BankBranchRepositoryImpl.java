package org.bank.repository.impl;

import org.bank.base.repository.BaseRepositoryImpl;
import org.bank.entity.BankBranch;
import org.bank.repository.BankBranchRepository;

public class BankBranchRepositoryImpl extends BaseRepositoryImpl<Long, BankBranch>
implements BankBranchRepository {
    public BankBranchRepositoryImpl(Class<BankBranch> entityClass) {
        super(entityClass);
    }
}

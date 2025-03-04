package org.bank.service.impl;

import org.bank.base.service.BaseServiceImpl;
import org.bank.entity.BankBranch;
import org.bank.repository.BankBranchRepository;
import org.bank.service.BankBranchService;

public class BankBranchServiceImpl extends BaseServiceImpl<Long, BankBranch, BankBranchRepository>
        implements BankBranchService {
    public BankBranchServiceImpl(BankBranchRepository repository) {
        super(repository);
    }

    @Override
    public void updateColumns(BankBranch entity, BankBranch foundEntity) {

    }
}


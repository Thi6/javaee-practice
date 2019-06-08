package com.qa.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.qa.domain.Account;

@Transactional(TxType.SUPPORTS)
public class AccountRepoDB implements AccountRepo{

	@PersistenceContext(unitName = "myPU")
	EntityManager manager;

	@Transactional(TxType.REQUIRED)
	public Account create(Account account) {
		manager.persist(account);
		return account;
	}
}

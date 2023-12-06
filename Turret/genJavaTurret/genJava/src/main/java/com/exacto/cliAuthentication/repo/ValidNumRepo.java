package com.exacto.cliAuthentication.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.exacto.cliAuthentication.entity.ValidContactInfo;


@Repository
public interface ValidNumRepo extends JpaRepository<ValidContactInfo, Long> {

	// Optional<ValidContactInfo> findByID(Long id);
	// Optional<ValidContactInfo> findByTxnID(String txn_id);
	
}

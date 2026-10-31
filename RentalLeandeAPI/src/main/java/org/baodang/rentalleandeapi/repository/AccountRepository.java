package org.baodang.rentalleandeapi.repository;

import org.baodang.rentalleandeapi.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,Long> {
    Optional<Account> findByEmailAndPasswordHash(String email,String passwordHash);
}

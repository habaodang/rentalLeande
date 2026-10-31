package org.baodang.rentalleandeapi.repository;

import org.baodang.rentalleandeapi.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
}

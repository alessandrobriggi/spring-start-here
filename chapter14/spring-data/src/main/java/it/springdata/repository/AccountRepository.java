package it.springdata.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.springdata.dao.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
	
	@Query("SELECT * FROM account WHERE name = :name")
	List<Account> findByName(String name);
	
	@Modifying
	@Query("UPDATE account SET amount = :newAmount WHERE id = :id")
	void changeAmount(long id, BigDecimal newAmount);

}

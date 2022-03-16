package it.transactions.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import it.transactions.model.Account;

@Repository
public class AccountRepository {
	
	private final JdbcTemplate template;
	
	public AccountRepository(JdbcTemplate template) {
		this.template = template;
	}
	
	public List<Account> findAll() {
		return template.query("SELECT * FROM account;", new AccountRowMapper());
	}
	
	public Account findById(long id) {
		String sql = "SELECT * FROM account WHERE id=?;";
		return template.queryForObject(sql, new AccountRowMapper(), id);
	}
	
	public void changeAmountById(BigDecimal newAmount, long id) {
		String sql = "UPDATE account SET amount=? WHERE id=?;";
		template.update(sql, newAmount, id);
	}

}

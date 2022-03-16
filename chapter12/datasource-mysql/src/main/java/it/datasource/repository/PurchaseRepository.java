package it.datasource.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import it.datasource.model.Purchase;

@Repository
public class PurchaseRepository {
	
	private final JdbcTemplate jdbcTemplate;
	
	public PurchaseRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void storePurchase(Purchase purchase) {
		String sql = "INSERT INTO purchase VALUES (NULL, ?, ?);";
		jdbcTemplate.update(sql, purchase.getProduct(), purchase.getPrice());
	}
	
	public List<Purchase> findAll() {
		String sql = "SELECT * FROM purchase;";
		
		RowMapper<Purchase> rowMapper = (rs, rowNumber) -> {
			Purchase rowObject = new Purchase();
			rowObject.setId(rs.getInt("id"));
			rowObject.setProduct(rs.getString("product"));
			rowObject.setPrice(rs.getBigDecimal("price"));
			return rowObject;
		};
		
		return jdbcTemplate.query(sql, rowMapper);
	}

}

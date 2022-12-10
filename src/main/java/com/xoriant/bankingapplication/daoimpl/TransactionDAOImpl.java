package com.xoriant.bankingapplication.daoimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.xoriant.bankingapplication.dao.BaseDAO;
import com.xoriant.bankingapplication.dao.TransactionDAO;
import com.xoriant.bankingapplication.model.Transaction;
import com.xoriant.bankingapplication.rm.TransactionRowMapper;

@Repository
public class TransactionDAOImpl extends BaseDAO implements TransactionDAO {

	@Override
	public void save(Transaction transaction) {
		String sql="insert into transaction(dateOfTransaction,fromAccount,toAcount,amount,currentBalance,"
				+ "transactionStatus) values(:dateOfTransaction,:fromAccount,:toAcount,:amount,:currentBalance,"
				+ ":transactionStatus)";
		Map m = new HashMap();
		m.put("dateOfTransaction", transaction.getDateOfTransaction());
		m.put("fromAccount", transaction.getFromAccount());
		m.put("toAcount", transaction.getToAcount());
		m.put("amount", transaction.getAmount());
		m.put("currentBalance", transaction.getCurrentBalance());
		m.put("transactionStatus", transaction.getTransactionStatus().name());
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource parameterSource = new MapSqlParameterSource(m);
		getNamedParameterJdbcTemplate().update(sql, parameterSource, keyHolder);
		transaction.setTransactionId(keyHolder.getKey().intValue());
		
	}

	@Override
	public void update(Transaction transaction) {
		String sql="update transaction set dateOfTransaction=:dateOfTransaction,"
				+ "fromAccount=:fromAccount,"
				+ "toAcount=:toAcount,"
				+ "amount=:amount,"
				+ "currentBalance=:currentBalance,"
				+ "transactionStatus=:transactionStatus where transactionId=:transactionId";
		Map m = new HashMap();
		m.put("dateOfTransaction", transaction.getDateOfTransaction());
		m.put("fromAccount", transaction.getFromAccount());
		m.put("toAcount", transaction.getToAcount());
		m.put("amount", transaction.getAmount());
		m.put("currentBalance", transaction.getCurrentBalance());
		m.put("transactionStatus", transaction.getTransactionStatus().name());
		m.put("transactionId", transaction.getTransactionId());
		
		getNamedParameterJdbcTemplate().update(sql, m);
	}

	@Override
	public void delete(Transaction transaction) {
		this.delete(transaction.getTransactionId());
		
	}

	@Override
	public void delete(Integer transactionId) {
		String sql="delete from transaction where transactionId=?";
		getJdbcTemplate().update(sql,transactionId);
		
	}

	@Override
	public Transaction findById(Integer transactionId) {
		String sql="select transactionId,dateOfTransaction,fromAccount,toAcount,amount,currentBalance,"
				+ "transactionStatus from transaction where transactionId=?";
		Transaction transaction = getJdbcTemplate().queryForObject(sql, new TransactionRowMapper(),transactionId);
		return transaction;
	}

	@Override
	public List<Transaction> findAll() {
		String sql="select transactionId,dateOfTransaction,fromAccount,toAcount,amount,currentBalance,"
				+ "transactionStatus from transaction";
		List<Transaction> transactions = getJdbcTemplate().query(sql, new TransactionRowMapper());
		return transactions;
	}

	@Override
	public List<Transaction> findByProperty(String propertName, Object propertyValue) {
		String sql="select transactionId,dateOfTransaction,fromAccount,toAcount,amount,currentBalance,"
				+ "transactionStatus from transaction where "+propertName+ " =?";
		
		List<Transaction> transactions = getJdbcTemplate().query(sql, new TransactionRowMapper(),propertyValue);
		return transactions;
	}

}

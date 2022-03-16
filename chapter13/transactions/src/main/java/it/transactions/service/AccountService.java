package it.transactions.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.transactions.model.Account;
import it.transactions.repository.AccountRepository;

@Service
public class AccountService {

	private final AccountRepository repository;
	
	public AccountService(AccountRepository repository) {
		this.repository = repository;
	}
	
	public List<Account> findAll() {
		return repository.findAll();
	}
	
	@Transactional
	public void transferMoney(long idSender, long idReceiver, BigDecimal amount) {
		Account sender = repository.findById(idSender);
		Account receiver = repository.findById(idReceiver);
		
		BigDecimal newSenderAmount = sender.getAmount().subtract(amount);
		BigDecimal newReceiverAmount = receiver.getAmount().add(amount);
		
		repository.changeAmountById(newSenderAmount, idSender);
		
//		throw new RuntimeException();
		
		repository.changeAmountById(newReceiverAmount, idReceiver);
	}
	
}

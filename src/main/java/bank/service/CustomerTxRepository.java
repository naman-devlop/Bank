package bank.service;

import java.util.List;

import bank.model.CustomerTransaction;
import org.springframework.data.repository.CrudRepository;
/**
 * 
 * @author GUR57557
 *
 */

public interface CustomerTxRepository extends CrudRepository<CustomerTransaction, Long> {
	//public CustomerTransaction findByAccount(String account);
	public List<CustomerTransaction> findByAccount(String account);
	public String deleteByAccount(String account);
}

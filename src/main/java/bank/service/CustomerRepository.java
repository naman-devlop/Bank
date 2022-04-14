/**
 * 
 */
package bank.service;

import org.springframework.data.repository.CrudRepository;

import bank.model.Customer;

/**
 * @author GUR57557
 *
 *
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {
	public Customer findByAccount(String account);
	public String deleteByAccount(String account);

}

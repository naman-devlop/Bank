package bank.service;

import org.springframework.data.repository.CrudRepository;

import bank.model.CustomerAddress;

public interface CustomerAddressRepository extends CrudRepository<CustomerAddress, Long> {
	public CustomerAddress findByCustomerAccount(String account);
	public String deleteByCustomerAccount(String account);

}

/**
 * 
 */
package bank.service;

import java.util.List;

import bank.model.Customer;
import bank.model.CustomerAddressDto;
import bank.model.CustomerDto;
import bank.model.CustomerTransaction;
import bank.model.CustomerTransactionDto;

/**
 * @author GUR57557
 *
 */
public interface CustomerService {
	public  String save(List<CustomerDto> customerDtoList);
	public CustomerDto findbyCustomerAccount(String account, CustomerDto customerDto);
	public Boolean deleteByCustomerAccount(String account);
	public List<CustomerDto> getAllCustomer();
	public String customerTransaction(String account, CustomerTransactionDto customerTxDto);
	public String addCustomerAddress(CustomerAddressDto customerAddDto);
	public Double checkBalance(String account);
}

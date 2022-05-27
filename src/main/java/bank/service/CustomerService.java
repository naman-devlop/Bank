/**
 * 
 */
package bank.service;

import java.util.List;

import bank.exception.BankException;
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
	public String saveCustomerFromJsp(String account,String name, String ifsc);
	public List<CustomerTransactionDto> getAllTransactionByAccount(String account) throws BankException;
	public String saveCustomerTransaction(String account, String ifsc, String amount, String tx_type, String customerId);
	
	
}

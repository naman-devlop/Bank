/**
 * 
 */
package bank.serviceimpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bank.exception.BankException;
import bank.model.Customer;
import bank.model.CustomerAddress;
import bank.model.CustomerAddressDto;
import bank.model.CustomerDto;
import bank.model.CustomerTransaction;
import bank.model.CustomerTransactionDto;
import bank.service.CustomerAddressRepository;
import bank.service.CustomerRepository;
import bank.service.CustomerService;
import bank.service.CustomerTxRepository;

/**
 * @author GUR57557
 *
 */
@Service
@Transactional
public class CustomerSerivceImpl implements CustomerService {
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	CustomerTxRepository cusTxRepository;
	@Autowired
	CustomerAddressRepository customerAddRepository;

	// @Autowired Customer customer;
	public String save(List<CustomerDto> customerDtoList) {

		for (CustomerDto c : customerDtoList) {

			if (!checkCustomerExist(c.getAccount())) {

				Customer customer = new Customer();
				customer.setAccount(c.getAccount());
				customer.setIfcCode(c.getIfcCode());
				customer.setName(c.getName());
				customerRepository.save(customer);

			} else {
				Customer customer = customerRepository.findByAccount(c.getAccount());
				customer.setAccount(c.getAccount());
				customer.setIfcCode(c.getIfcCode());
				customer.setName(c.getName());
				customerRepository.save(customer);
			}
		}
		return "SUCCESS";
	}

	public Boolean deleteByCustomerAccount(String account) {

		String customer = null;
		customer = customerRepository.deleteByAccount(account);

		if (Integer.parseInt(customer) == 0) {
			return Boolean.FALSE;
		}
		deleteCustomerTxByAccount(account);
		customerAddRepository.deleteByCustomerAccount(account);
		return Boolean.TRUE;
	}

	public List<CustomerDto> getAllCustomer() {
		List<CustomerDto> customerDtoList = new ArrayList<CustomerDto>();
		Iterable<Customer> customerList = customerRepository.findAll();
		Iterator<Customer> itr = customerList.iterator();
		while (itr.hasNext()) {
			Customer customer = itr.next();
			CustomerDto customerDto = new CustomerDto();
			customerDto.setAccount(customer.getAccount());
			customerDto.setIfcCode(customer.getIfcCode());
			customerDto.setName(customer.getName());
			customerDto.setId(customer.getId());
			customerDtoList.add(customerDto);

		}
		return customerDtoList;
	}

	public CustomerDto findbyCustomerAccount(String account, CustomerDto customerDto) {
		Customer customer = customerRepository.findByAccount(account);
		if (customer != null) {
			customerDto.setAccount(customer.getAccount());
			customerDto.setIfcCode(customer.getIfcCode());
			customerDto.setName(customer.getName());
			customerDto.setId(customer.getId());
			return customerDto;
		}
		return customerDto;
	}

	private Boolean checkCustomerExist(String account) {
		Customer customer = customerRepository.findByAccount(account);
		if (customer == null) {
			return Boolean.FALSE;
		}
		return Boolean.TRUE;

	}

	public String customerTransaction(String account, CustomerTransactionDto customerTxDto) {

		Customer customer = customerRepository.findByAccount(account);

		Double currentBalance = calculateCurrentAmount(account);
		if (customer != null && customer.getAccount().equalsIgnoreCase(account)) {
			CustomerTransaction customerTx = new CustomerTransaction();
			LocalDateTime ldt = LocalDateTime.now();
			DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			String date_tx = ldt.format(format);
			customerTx.setTx_date(date_tx);
			customerTx.setAccount(account);
			customerTx.setId(customer.getId());
			if (customerTxDto.getTransactionType().equalsIgnoreCase("CR")) {
				customerTx.setCreditAmount(customerTxDto.getCreditAmount());
				customerTx.setCurrentBalance(currentBalance + customerTxDto.getCreditAmount());
				customerTx.setTransactionType("CR");

			}
			if (customerTxDto.getTransactionType().equalsIgnoreCase("DB")
					&& currentBalance >= customerTxDto.getDebitAmount()) {
				customerTx.setDebitAmount(customerTxDto.getDebitAmount());
				customerTx.setTransactionType(customerTxDto.getTransactionType());
				customerTx.setCurrentBalance(currentBalance - customerTxDto.getDebitAmount());
			}
			cusTxRepository.save(customerTx);
			return "SUCCESS";
		}
		return null;
	}

	public String addCustomerAddress(CustomerAddressDto customerAddDto) {
		CustomerAddress customerAdd = customerAddRepository.findByCustomerAccount(customerAddDto.getCustomerAccount());
		if (customerAddDto != null && customerAdd != null) {
			customerAdd.setCurrentLocation(customerAddDto.getCurrentLocation());
			customerAdd.setPermanentLocation(customerAddDto.getPermanentLocation());
			customerAdd.setCustomerAccount(customerAddDto.getCustomerAccount());
			customerAdd.setEmail(customerAddDto.getEmail());
			customerAdd.setMobileNumber(customerAddDto.getMobileNumber());
			customerAddRepository.save(customerAdd);
			return "Updated";
		}
		if (customerAddDto != null && customerAdd == null) {
			CustomerAddress customerAddNew = new CustomerAddress();
			customerAddNew.setCurrentLocation(customerAddDto.getCurrentLocation());
			customerAddNew.setPermanentLocation(customerAddDto.getPermanentLocation());
			customerAddNew.setCustomerAccount(customerAddDto.getCustomerAccount());
			customerAddNew.setEmail(customerAddDto.getEmail());
			customerAddNew.setMobileNumber(customerAddDto.getMobileNumber());
			customerAddRepository.save(customerAddNew);
			return "Saved";
		}
		return null;
	}

	/**
	 * method to calculate the current balance
	 * 
	 * @param account
	 * @return
	 */
	private Double calculateCurrentAmount(String account) {
		List<Double> balanceList = new ArrayList<Double>();
		double currentBalance = 0;
		double balance = 0;
		List<CustomerTransaction> customerTxList = cusTxRepository.findByAccount(account);
		if (!customerTxList.isEmpty()) {
			for (CustomerTransaction c : customerTxList) {
				balance = c.getCreditAmount() - c.getDebitAmount();
				balanceList.add(balance);
			}
			for (Double b : balanceList) {
				currentBalance = currentBalance + b;
			}
			return currentBalance;
		}
		return currentBalance;

	}

	private String deleteCustomerTxByAccount(String account) {
		String result = null;
		List<CustomerTransaction> customerTxList = cusTxRepository.findByAccount(account);
		if (!customerTxList.isEmpty()) {
			for (CustomerTransaction c : customerTxList) {
				cusTxRepository.deleteByAccount(c.getAccount());
			}
			return result;
		}
		return result;

	}

	public Double checkBalance(String account) {
		Double currentBalance = calculateCurrentAmount(account);

		return currentBalance;
	}

	public String saveCustomerFromJsp(String account, String name, String ifsc) {
		Customer customer = customerRepository.findByAccount(account);
		if (customer != null && customer.getAccount().equalsIgnoreCase(account)) {
			customer.setAccount(account);
			customer.setIfcCode(ifsc);
			customer.setName(name);
			customerRepository.save(customer);
		} else {
			customer = new Customer();
			customer.setAccount(account);
			customer.setIfcCode(ifsc);
			customer.setName(name);
			customerRepository.save(customer);
		}

		return "SUCESS";
	}

	public List<CustomerTransactionDto> getAllTransactionByAccount(String account) throws BankException {
		List<CustomerTransactionDto> customerTxDtoList = new ArrayList<CustomerTransactionDto>();
		List<CustomerTransaction> customerTxList = cusTxRepository.findByAccount(account);
		if(!customerTxList.isEmpty()) {
			for (CustomerTransaction c : customerTxList) {
				CustomerTransactionDto customerTxDto = new CustomerTransactionDto();
				customerTxDto.setAccount(c.getAccount());
				customerTxDto.setCreditAmount(c.getCreditAmount());
				customerTxDto.setCurrentBalance(c.getCurrentBalance());
				customerTxDto.setDebitAmount(c.getDebitAmount());
				customerTxDto.setTransactionDate(c.getTx_date());
				customerTxDto.setTransactionType(c.getTransactionType());
				customerTxDtoList.add(customerTxDto);

			}
			return customerTxDtoList;			
		}
		else {
			throw new BankException("Account is wrong or empty");
		}

	}

	public String saveCustomerTransaction(String account, String ifsc, String amount, String tx_type,
			String customerId) {
		Double customerAmount = Double.parseDouble(amount);
		Long id = Long.parseLong(customerId);
		Double currentBalance = calculateCurrentAmount(account);
		CustomerTransaction customerTx = new CustomerTransaction();
		customerTx.setAccount(account);
		customerTx.setId(id);
		LocalDateTime ldt = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String date_tx = ldt.format(format);
		customerTx.setTx_date(date_tx);
		if (tx_type.equalsIgnoreCase("CR")) {
			customerTx.setCreditAmount(customerAmount);
			customerTx.setCurrentBalance(currentBalance + customerAmount);
			customerTx.setTransactionType("CR");
			cusTxRepository.save(customerTx);
			return "SUCCESS";
		}
		if (tx_type.equalsIgnoreCase("DB") && currentBalance < customerAmount) {
			return "Sorry You have not sufficient amount in your account";
		}
		if (tx_type.equalsIgnoreCase("DB") && currentBalance > customerAmount) {
			customerTx.setDebitAmount(customerAmount);
			customerTx.setTransactionType("DB");
			customerTx.setCurrentBalance(currentBalance - customerAmount);
			cusTxRepository.save(customerTx);
			return "SUCCESS";
		}
		return "Something went wring , please try again later";
	}

	public String saveCustomerAddressFromJSP(String account, String email, String mobile, String currentAddress,
			String permanentAddress) {
			CustomerAddress customeradd = customerAddRepository.findByCustomerAccount(account);
			if(customeradd != null) {
				customeradd.setCurrentLocation(currentAddress);
				customeradd.setPermanentLocation(permanentAddress);
				customeradd.setCustomerAccount(account);
				customeradd.setEmail(email);
				customeradd.setMobileNumber(mobile);
				customerAddRepository.save(customeradd);
				return "Updated";
			}
			else {
				CustomerAddress customeraddess = new CustomerAddress();
				customeraddess.setCurrentLocation(currentAddress);
				customeraddess.setPermanentLocation(permanentAddress);
				customeraddess.setCustomerAccount(account);
				customeraddess.setEmail(email);
				customeraddess.setMobileNumber(mobile);
				customerAddRepository.save(customeraddess);
				return "Saved SUccessfully";
			}
	}

	public CustomerAddressDto findAddressByAccount(String account) {
		CustomerAddress customerAdd = customerAddRepository.findByCustomerAccount(account);
		if(customerAdd != null) {
			CustomerAddressDto customerAddDto = new CustomerAddressDto();
			customerAddDto.setCurrentLocation(customerAdd.getCurrentLocation());
			customerAddDto.setCustomerAccount(customerAdd.getCustomerAccount());
			customerAddDto.setEmail(customerAdd.getEmail());
			customerAddDto.setMobileNumber(customerAdd.getMobileNumber());
			customerAddDto.setPermanentLocation(customerAdd.getPermanentLocation());
			return customerAddDto;
			
		}
		return null;
	}

}

/**
 * 
 */
package bank.controler;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import bank.bean.CustomerAddressBean;
import bank.bean.CustomerBean;
import bank.bean.CustomerInfo;
import bank.bean.CustomerList;
import bank.bean.CustomerTransactionBean;
import bank.constant.BankConstants;
import bank.model.CustomerAddressDto;
import bank.model.CustomerAddressResponse;
import bank.model.CustomerDto;
import bank.model.CustomerResponse;
import bank.model.CustomerTransactionDto;
import bank.model.CustomerTransactionResponse;
import bank.service.CustomerService;
import bank.service.CustomerTxRepository;

/**
 * @author GUR57557
 *
 */
@RestController
public class CutomerControler {
	@Autowired
	CustomerService customerSerivce;

	/**
	 * method to add/update the customer data
	 * 
	 * @param customerBean
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@PostMapping(value = BankConstants.ADD_CUSTOMER, produces = { BankConstants.APPLICATION_JSON })
	public ResponseEntity<JSONObject> AddCustomer(@RequestBody CustomerBean customerBean) {
		String result = "FAIL";

		JSONObject resObj = new JSONObject();
		List<CustomerResponse> customerResponseList = new ArrayList<CustomerResponse>();
		List<CustomerDto> customerDtoList = mapRequestToCustomer(customerBean);

		if (!customerDtoList.isEmpty()) {
			result = customerSerivce.save(customerDtoList);
			for (CustomerDto c : customerDtoList) {
				CustomerResponse customerResponse = new CustomerResponse();
				customerResponse.setCode("200");
				customerResponse.setMessage("SUCCESS");
				customerResponse.setId(c.getName());
				customerResponseList.add(customerResponse);
			}
			resObj.put("Response", customerResponseList);
			return new ResponseEntity<JSONObject>(resObj, HttpStatus.OK);
		}
		return new ResponseEntity<JSONObject>(resObj, HttpStatus.BAD_REQUEST);
	}

	/**
	 * delete method
	 * 
	 * @param account
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@DeleteMapping(value = BankConstants.DELETE_CUSTOMER, produces = { BankConstants.APPLICATION_JSON })
	public ResponseEntity<JSONObject> deleteCustomer(@PathVariable("account") String account) {

		JSONObject resObj = new JSONObject();
		CustomerResponse customerResponse = new CustomerResponse();
		Boolean deleteFlag = Boolean.FALSE;
		deleteFlag = customerSerivce.deleteByCustomerAccount(account);
		if (deleteFlag) {
			customerResponse.setCode("200");
			customerResponse.setId(account);
			customerResponse.setMessage("SUCCESS");
			resObj.put("Response", customerResponse);
			return new ResponseEntity<JSONObject>(resObj, HttpStatus.OK);
		} else {

			customerResponse.setCode("121");
			customerResponse.setId(account);
			customerResponse.setMessage("Something Went Wrong");
			resObj.put("Response", customerResponse);

			return new ResponseEntity<JSONObject>(resObj, HttpStatus.OK);

		}

	}

	@SuppressWarnings("unchecked")
	@PostMapping(value = BankConstants.GET_CUSTOMER, produces = { BankConstants.APPLICATION_JSON })
	public ResponseEntity<JSONObject> getAllCustomer() {
		List<CustomerDto> customerDtoList = customerSerivce.getAllCustomer();
		JSONObject resObj = new JSONObject();
		resObj.put("Response", customerDtoList);
		return new ResponseEntity<JSONObject>(resObj, HttpStatus.OK);
	}

	/**
	 * method for customer transaction
	 * 
	 * @param customerBean
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@PostMapping(value = BankConstants.CUSTOMER_TRANSACTION, produces = { BankConstants.APPLICATION_JSON })
	public ResponseEntity<JSONObject> creditAmount(@RequestBody CustomerBean customerBean) {
		String result = null;
		JSONObject resObj = new JSONObject();
		// CustomerTransactionResponse customerTxResp = new
		// CustomerTransactionResponse();
		List<CustomerTransactionResponse> customerTxResList = new ArrayList<CustomerTransactionResponse>();
		List<CustomerTransactionDto> customerTxDtoList = mapRequestTOcustomeCustomerTransaction(customerBean);
		if (!customerTxDtoList.isEmpty()) {
			for (CustomerTransactionDto ctx : customerTxDtoList) {
				result = customerSerivce.customerTransaction(ctx.getAccount(), ctx);
				if (result != null && ctx.getTransactionType().equalsIgnoreCase("CR")) {
					CustomerTransactionResponse txResponse = new CustomerTransactionResponse();
					txResponse.setAccount(ctx.getAccount());
					txResponse.setMessage("SUCCESS");
					txResponse.setCode("200");
					txResponse.setTransactionType("Credited Amount");
					txResponse.setBalance(String.valueOf(ctx.getCreditAmount()));
					customerTxResList.add(txResponse);
				}
				if (result != null && ctx.getTransactionType().equalsIgnoreCase("DB")) {
					CustomerTransactionResponse txResponse = new CustomerTransactionResponse();
					txResponse.setAccount(ctx.getAccount());
					txResponse.setMessage("SUCCESS");
					txResponse.setCode("200");
					txResponse.setTransactionType("Debited Amount");
					txResponse.setBalance(String.valueOf(ctx.getDebitAmount()));
					customerTxResList.add(txResponse);
				}
				if (result == null) {

					CustomerTransactionResponse txResponse = new CustomerTransactionResponse();
					txResponse.setAccount(ctx.getAccount());
					txResponse.setMessage("Account not exist");
					txResponse.setCode("231");
					customerTxResList.add(txResponse);
				}
			}
			resObj.put("Transaction", customerTxResList);
			return new ResponseEntity<JSONObject>(resObj, HttpStatus.OK);
		}

		return new ResponseEntity<JSONObject>(resObj, HttpStatus.OK);
	}

	@SuppressWarnings("unchecked")
	@PostMapping(value = BankConstants.UPDATE_CUSTOMER_ADDRESS, produces = { BankConstants.APPLICATION_JSON })
	public ResponseEntity<JSONObject> addUpdateCustomerAddress(@RequestBody CustomerBean customerBean) {
		List<CustomerAddressDto> customerAddressDtos = mapRequestToCustomerAddress(customerBean);
		String result = null;
		JSONObject jsonObject = new JSONObject();
		List<CustomerAddressResponse> responseList = new ArrayList<CustomerAddressResponse>();
		for (CustomerAddressDto customerAddDto : customerAddressDtos) {
			result = customerSerivce.addCustomerAddress(customerAddDto);

			CustomerAddressResponse response = new CustomerAddressResponse();
			if (result != null) {
				response.setAction(result);
				response.setCode("200");
				response.setCustomerAccount(customerAddDto.getCustomerAccount());
				response.setMessage("SUCCESS");
				responseList.add(response);
			} else {
				response.setAction(result);
				response.setCode("112");
				response.setCustomerAccount(customerAddDto.getCustomerAccount());
				response.setMessage("FAIL");
				responseList.add(response);

			}
		}
		jsonObject.put("Response", responseList);
		return new ResponseEntity<JSONObject>(jsonObject, HttpStatus.OK);

	}

	@SuppressWarnings("unchecked")
	@GetMapping(value = BankConstants.CHECK_BALANCE, produces = { BankConstants.APPLICATION_JSON })
	public ResponseEntity<JSONObject> checkBalance(@PathVariable("account") String account) {
		JSONObject jsonObject = new JSONObject();
		Double currentBalance = null;
		currentBalance = customerSerivce.checkBalance(account);
		CustomerTransactionResponse customerResponse = new CustomerTransactionResponse();
		customerResponse.setTransactionType("Check Account Balance");
		customerResponse.setCode("200");
		customerResponse.setMessage("SUCCESS");
		customerResponse.setAccount(account);
		customerResponse.setCurrentBalance(String.valueOf(currentBalance));
		jsonObject.put("CurrentBalance", customerResponse);

		return new ResponseEntity<JSONObject>(jsonObject, HttpStatus.OK);

	}
/**
 * method to open the home page
 * @return
 */
	@GetMapping(value = BankConstants.HOME_PAGE)
	public ModelAndView homePage() {
		ModelAndView mv = new ModelAndView("home");
		return mv;
	}

	@GetMapping(value = BankConstants.TRANSACTION_PAGE)
	public ModelAndView transactionPage() {
		ModelAndView mv = new ModelAndView("transaction");
		return mv;
	}

	@GetMapping(value = BankConstants.CUSTOMER_PAGE)
	public ModelAndView customerPage() {
		ModelAndView mv = new ModelAndView("customer");
		List<CustomerDto> customerDtoList = customerSerivce.getAllCustomer();
		mv.addObject("customers", customerDtoList);
		return mv;
	}

	/* addCustomerFromJsp */
	@PostMapping(value = BankConstants.ADD_CUSTOMER_FROM_WEBPAGE, produces = { BankConstants.APPLICATION_JSON })
	public ModelAndView addCustomer(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("customer");
		customerSerivce.saveCustomerFromJsp(request.getParameter("account"), request.getParameter("name"),
				request.getParameter("ifsc"));
		return mv;
	}

	@DeleteMapping(value = BankConstants.DELETE_CUSTOMER_FROM_WEBPAGE)
	public ModelAndView deleteCustomerFromJsp(HttpServletRequest request, @PathVariable("account") String account) {
		ModelAndView mv = new ModelAndView("customer");
		customerSerivce.deleteByCustomerAccount(account);
		return mv;

	}

	@GetMapping(value = BankConstants.SEARCH_CUSTOMER)
	public ModelAndView searchCustomer(HttpServletRequest request, @PathVariable("account") String account) {
		CustomerDto customerDto = new CustomerDto();
		ModelAndView mv = new ModelAndView("transaction");
		List<CustomerTransactionDto> customerTxDtos = customerSerivce.getAllTransactionByAccount(account);
		CustomerDto customer = customerSerivce.findbyCustomerAccount(account, customerDto);
		Double currentBalance = customerSerivce.checkBalance(account);
		mv.addObject("customer", customer);
		mv.addObject("currentBalance", currentBalance);
		mv.addObject("transactionInfo", customerTxDtos);
		return mv;
	}

	@PostMapping(value = BankConstants.SAVE_CUSTOMER_TX_WEBPAGE)
	public String saveCustomerTransaction(HttpServletRequest request) {
		String result = null;
		String account = request.getParameter("customerAccount");
		String ifsc = request.getParameter("customerIFSC");
		String tx_type = request.getParameter("txType");
		String amount = request.getParameter("amount");
		String customerId = request.getParameter("customerId");
		result = customerSerivce.saveCustomerTransaction(account, ifsc, amount, tx_type, customerId);
		return result;
	}

	private List<CustomerAddressDto> mapRequestToCustomerAddress(CustomerBean customerBean) {
		List<CustomerAddressDto> customerAddressDtos = new ArrayList<CustomerAddressDto>();
		CustomerList customerList = customerBean.getCustomerList();
		List<CustomerInfo> customerInfo = customerList.getCustomerInfo();
		for (CustomerInfo c : customerInfo) {
			CustomerAddressBean customerAddressBean = c.getCustomerAddressBean();
			CustomerAddressDto customeraddressDto = new CustomerAddressDto();
			customeraddressDto.setCurrentLocation(customerAddressBean.getCurrentLocation());
			customeraddressDto.setCustomerAccount(customerAddressBean.getCustomer_account());
			customeraddressDto.setEmail(customerAddressBean.getEmail());
			customeraddressDto.setMobileNumber(customerAddressBean.getMobileNumber());
			customeraddressDto.setPermanentLocation(customerAddressBean.getPermanentLocation());
			customerAddressDtos.add(customeraddressDto);
		}
		return customerAddressDtos;
	}

	private List<CustomerTransactionDto> mapRequestTOcustomeCustomerTransaction(CustomerBean customerBean) {
		List<CustomerTransactionDto> customerTraDtos = new ArrayList<CustomerTransactionDto>();
		CustomerList customerList = customerBean.getCustomerList();
		List<CustomerInfo> customerInfo = customerList.getCustomerInfo();
		for (CustomerInfo c : customerInfo) {
			CustomerTransactionDto customerTx = new CustomerTransactionDto();
			CustomerTransactionBean customerTransaction = c.getCustomerTransaction();
			if (customerTransaction.getTransactionAmount() != null
					&& customerTransaction.getTransactionType().equalsIgnoreCase("CR")) {
				customerTx.setAccount(c.getAccount());
				customerTx.setTransactionType("CR");
				customerTx.setCreditAmount(Double.parseDouble(customerTransaction.getTransactionAmount()));

				customerTraDtos.add(customerTx);

			}
			if (customerTransaction.getTransactionAmount() != null
					&& customerTransaction.getTransactionType().equalsIgnoreCase("DB")) {
				customerTx.setAccount(c.getAccount());
				customerTx.setTransactionType("DB");
				customerTx.setDebitAmount(Double.parseDouble(customerTransaction.getTransactionAmount()));
				customerTraDtos.add(customerTx);
			}
		}
		return customerTraDtos;

	}

	private List<CustomerDto> mapRequestToCustomer(CustomerBean customerBean) {
		List<CustomerDto> customerDtoList = new ArrayList<CustomerDto>();
		CustomerList customerList = customerBean.getCustomerList();
		List<CustomerInfo> customerInfo = customerList.getCustomerInfo();

		for (CustomerInfo c : customerInfo) {
			CustomerDto customerDto = new CustomerDto();
			CustomerDto customers = customerSerivce.findbyCustomerAccount(c.getAccount(), customerDto);
			if (customers.getAccount() == null) {

				customerDto.setName(c.getName());
				customerDto.setAccount(c.getAccount());
				customerDto.setIfcCode(c.getIfcCode());
         
				customerDtoList.add(customerDto);

			} else {
				customerDto.setAccount(customers.getAccount());
				customerDto.setIfcCode(c.getIfcCode());
				customerDto.setName(c.getName());
				customerDtoList.add(customerDto);
			}

		}
		return customerDtoList;
	}
}

/**
 * 
 */
package bank.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author GUR57557
 *
 */
public class CustomerInfo {
	@JsonProperty("name")
	private String name;

	@JsonProperty("account")
	private String account;

	@JsonProperty("ifcCode")
	private String ifcCode;

	@JsonProperty("customerTransaction")
	private CustomerTransactionBean customerTransaction;

	@JsonProperty("customerAddress")
	private CustomerAddressBean customerAddressBean;
	
	
	/**
	 * @return the customerAddressBean
	 */
	public CustomerAddressBean getCustomerAddressBean() {
		return customerAddressBean;
	}

	/**
	 * @param customerAddressBean the customerAddressBean to set
	 */
	public void setCustomerAddressBean(CustomerAddressBean customerAddressBean) {
		this.customerAddressBean = customerAddressBean;
	}

	/**
	 * @return the customerTransaction
	 */
	public CustomerTransactionBean getCustomerTransaction() {
		return customerTransaction;
	}

	/**
	 * @param customerTransaction the customerTransaction to set
	 */
	public void setCustomerTransaction(CustomerTransactionBean customerTransaction) {
		this.customerTransaction = customerTransaction;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the account
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(String account) {
		this.account = account;
	}

	/**
	 * @return the ifcCode
	 */
	public String getIfcCode() {
		return ifcCode;
	}

	/**
	 * @param ifcCode the ifcCode to set
	 */
	public void setIfcCode(String ifcCode) {
		this.ifcCode = ifcCode;
	}

	@Override
	public String toString() {
		return "CustomerInfo [name=" + name + ", account=" + account + ", ifcCode=" + ifcCode + ", customerTransaction="
				+ customerTransaction + ", customerAddressBean=" + customerAddressBean + "]";
	}

	

}

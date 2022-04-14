/**
 * 
 */
package bank.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author GUR57557
 *
 */
public class CustomerBean {
	@JsonProperty("customerList")
	private CustomerList customerList;

	/**
	 * @return the customerList
	 */
	public CustomerList getCustomerList() {
		return customerList;
	}

	/**
	 * @param customerList the customerList to set
	 */
	public void setCustomerList(CustomerList customerList) {
		this.customerList = customerList;
	}

	@Override
	public String toString() {
		return "CustomerBean [customerList=" + customerList + "]";
	}

}

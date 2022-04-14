/**
 * 
 */
package bank.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author GUR57557
 *
 */
public class CustomerList {
	@JsonProperty("customerInfo")
	private List<CustomerInfo> customerInfo;

	/**
	 * @return the customerInfo
	 */
	public List<CustomerInfo> getCustomerInfo() {
		return customerInfo;
	}

	/**
	 * @param customerInfo the customerInfo to set
	 */
	public void setCustomerInfo(List<CustomerInfo> customerInfo) {
		this.customerInfo = customerInfo;
	}

	@Override
	public String toString() {
		return "CustomerList [customerInfo=" + customerInfo + "]";
	}



}

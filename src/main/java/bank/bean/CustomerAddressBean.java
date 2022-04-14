package bank.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerAddressBean {
	@JsonProperty("customerAccount")
	private String customer_account;

	@JsonProperty("email")
	private String email;
	
	@JsonProperty("mobileNumber")
	private String mobileNumber;
	
	@JsonProperty("currentLocation")
	private String currentLocation;
	
	@JsonProperty("permanentLocation")
	private String permanentLocation;

	/**
	 * @return the customer_account
	 */
	public String getCustomer_account() {
		return customer_account;
	}

	/**
	 * @param customer_account the customer_account to set
	 */
	public void setCustomer_account(String customer_account) {
		this.customer_account = customer_account;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the mobileNumber
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * @param mobileNumber the mobileNumber to set
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	/**
	 * @return the currentLocation
	 */
	public String getCurrentLocation() {
		return currentLocation;
	}

	/**
	 * @param currentLocation the currentLocation to set
	 */
	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}

	/**
	 * @return the permanentLocation
	 */
	public String getPermanentLocation() {
		return permanentLocation;
	}

	/**
	 * @param permanentLocation the permanentLocation to set
	 */
	public void setPermanentLocation(String permanentLocation) {
		this.permanentLocation = permanentLocation;
	}

	@Override
	public String toString() {
		return "CustomerAddressBean [customer_account=" + customer_account + ", email=" + email + ", mobileNumber="
				+ mobileNumber + ", currentLocation=" + currentLocation + ", permanentLocation=" + permanentLocation
				+ "]";
	}
	
	

}

package bank.model;

public class CustomerAddressDto {
	private String customerAccount;
	private String currentLocation;
	private String permanentLocation;
	private String email;
	private String mobileNumber;
	/**
	 * @return the customerAccount
	 */
	public String getCustomerAccount() {
		return customerAccount;
	}
	/**
	 * @param customerAccount the customerAccount to set
	 */
	public void setCustomerAccount(String customerAccount) {
		this.customerAccount = customerAccount;
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
	@Override
	public String toString() {
		return "CustomerAddressDto [customerAccount=" + customerAccount + ", currentLocation=" + currentLocation
				+ ", permanentLocation=" + permanentLocation + ", email=" + email + ", mobileNumber=" + mobileNumber
				+ "]";
	}
	
}

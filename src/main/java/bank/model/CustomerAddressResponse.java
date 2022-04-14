package bank.model;

public class CustomerAddressResponse {
	private String 	customerAccount;
	private String message;
	private String code;
	private String action;
	
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
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}
	/**
	 * @param action the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}
	@Override
	public String toString() {
		return "CustomerAddressResponse [customerAccount=" + customerAccount + ", message=" + message + ", code=" + code
				+ ", action=" + action + "]";
	}
	
	

}

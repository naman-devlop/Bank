/**
 * 
 */
package bank.model;

/**
 * @author GUR57557
 *
 */
public class CustomerTransactionResponse {
	private String code;
	private String message;
	private String account;
	private String balance;
	private String transactionType;
	private String currentBalance;
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
	 * @return the balance
	 */
	public String getBalance() {
		return balance;
	}
	/**
	 * @param balance the balance to set
	 */
	public void setBalance(String balance) {
		this.balance = balance;
	}
	/**
	 * @return the transactionType
	 */
	public String getTransactionType() {
		return transactionType;
	}
	/**
	 * @param transactionType the transactionType to set
	 */
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	/**
	 * @return the currentBalance
	 */
	public String getCurrentBalance() {
		return currentBalance;
	}
	/**
	 * @param currentBalance the currentBalance to set
	 */
	public void setCurrentBalance(String currentBalance) {
		this.currentBalance = currentBalance;
	}
	@Override
	public String toString() {
		return "CustomerTransactionResponse [code=" + code + ", message=" + message + ", account=" + account
				+ ", balance=" + balance + ", transactionType=" + transactionType + ", currentBalance=" + currentBalance
				+ "]";
	}
	
}

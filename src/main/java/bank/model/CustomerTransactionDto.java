/**
 * 
 */
package bank.model;

/**
 * @author GUR57557
 *
 */
public class CustomerTransactionDto {
	private String account;
	private double creditAmount;
	private double debitAmount;
	private String transactionType;
	private double currentBalance;
	private String transactionDate;
	
	
	/**
	 * @return the transactionDate
	 */
	public String getTransactionDate() {
		return transactionDate;
	}
	/**
	 * @param transactionDate the transactionDate to set
	 */
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
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
	 * @return the creditAmount
	 */
	public double getCreditAmount() {
		return creditAmount;
	}
	/**
	 * @param creditAmount the creditAmount to set
	 */
	public void setCreditAmount(double creditAmount) {
		this.creditAmount = creditAmount;
	}
	/**
	 * @return the debitAmount
	 */
	public double getDebitAmount() {
		return debitAmount;
	}
	/**
	 * @param debitAmount the debitAmount to set
	 */
	public void setDebitAmount(double debitAmount) {
		this.debitAmount = debitAmount;
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
	public double getCurrentBalance() {
		return currentBalance;
	}
	/**
	 * @param currentBalance the currentBalance to set
	 */
	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}
	@Override
	public String toString() {
		return "CustomerTransactionDto [account=" + account + ", creditAmount=" + creditAmount + ", debitAmount="
				+ debitAmount + ", transactionType=" + transactionType + ", currentBalance=" + currentBalance
				+ ", transactionDate=" + transactionDate + "]";
	}
	
	
	
}

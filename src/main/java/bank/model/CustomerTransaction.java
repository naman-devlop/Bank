/**
 * 
 */
package bank.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author GUR57557
 *
 */
@Entity
@Table(name = "customertransaction")
public class CustomerTransaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long tx_id;
	@Column(name = "id")
	private long id;
	@Column(name = "account")
	private String account;
	@Column(name = "credit_amount")
	private double creditAmount;
	@Column(name = "debit_amount")
	private double debitAmount;
	@Column(name = "transaction_type")
	private String transactionType;
	@Column(name = "current_balance")
	private double currentBalance;
	@Column(name = "tx_date")
	private String tx_date;
	
	
	/**
	 * @return the tx_date
	 */
	public String getTx_date() {
		return tx_date;
	}
	/**
	 * @param tx_date the tx_date to set
	 */
	public void setTx_date(String tx_date) {
		this.tx_date = tx_date;
	}
	/**
	 * @return the tx_id
	 */
	public long getTx_id() {
		return tx_id;
	}
	/**
	 * @param tx_id the tx_id to set
	 */
	public void setTx_id(long tx_id) {
		this.tx_id = tx_id;
	}
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
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
		return "CustomerTransaction [tx_id=" + tx_id + ", id=" + id + ", account=" + account + ", creditAmount="
				+ creditAmount + ", debitAmount=" + debitAmount + ", transactionType=" + transactionType
				+ ", currentBalance=" + currentBalance + ", tx_date=" + tx_date + "]";
	}
	

}

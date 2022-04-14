package bank.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerTransactionBean {
	@JsonProperty("transactionType")
	private String transactionType;
	@JsonProperty("transactionAmount")
	private String transactionAmount;
	@JsonProperty("transactionDate")
	private String transactionDate;

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
	 * @return the transactionAmount
	 */
	public String getTransactionAmount() {
		return transactionAmount;
	}

	/**
	 * @param transactionAmount the transactionAmount to set
	 */
	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

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

	@Override
	public String toString() {
		return "CustomerTransactionBean [transactionType=" + transactionType + ", transactionAmount="
				+ transactionAmount + ", transactionDate=" + transactionDate + "]";
	}

}

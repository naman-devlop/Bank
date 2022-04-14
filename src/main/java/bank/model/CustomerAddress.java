/**
 * 
 */
package bank.model;

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
@Table(name = "customer_address")
public class CustomerAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "customer_account")
	private String customerAccount;
	
	@Column(name = "current_location")
	private String currentLocation;
		
	@Column(name = "permanent_location")
	private String permanentLocation;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "mobile_number")
	private String mobileNumber;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

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
		return "CustomerAddress [id=" + id + ", customerAccount=" + customerAccount + ", currentLocation="
				+ currentLocation + ", permanentLocation=" + permanentLocation + ", email=" + email + ", mobileNumber="
				+ mobileNumber + "]";
	}
	
	

}

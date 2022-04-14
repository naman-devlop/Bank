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
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "name")
	private String name;
	@Column(name = "account")
	private String account;
	@Column(name = "ifc_code")
	private String ifcCode;

	public Customer() {

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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @return the ifcCode
	 */
	public String getIfcCode() {
		return ifcCode;
	}

	/**
	 * @param ifcCode the ifcCode to set
	 */
	public void setIfcCode(String ifcCode) {
		this.ifcCode = ifcCode;
	}

	public Customer(long id, String name, String account, String ifcCode) {
		this.id = id;
		this.name = name;
		this.account = account;
		this.ifcCode = ifcCode;
	}

}

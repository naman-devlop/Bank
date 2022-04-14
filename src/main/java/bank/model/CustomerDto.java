/**
 * 
 */
package bank.model;

/**
 * @author GUR57557
 *
 */
public class CustomerDto {
	private String name;
	private String account;
	private String ifcCode;
	
	@Override
	public String toString() {
		return "CustomerDto [name=" + name + ", account=" + account + ", ifcCode=" + ifcCode + "]";
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
	
	
	
}

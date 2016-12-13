package cKtom;

/**
 * @author Administrator
 *
 */
public abstract class Employee {

	private String firstName;
	private String lastName;
	private String socialSecurityNumber;

	public Employee(String firstName, String lastName,
			String socialSecurityNumber) {

		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setSocialSecurityNumber(socialSecurityNumber);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName
				+ ", socialSecurityNumber=" + socialSecurityNumber + "]";
	}
	
	
	public abstract  double earnings();

	
}

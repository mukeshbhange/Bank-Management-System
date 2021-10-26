package entity;

public class Address {
	
	private String landmark;
	private String street;
	private String city;
	private String state;
	private String pinCode;
	
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	
	@Override
	public String toString() {
		return "Address [landmark=" + landmark + ", street=" + street + ", city=" + city + ", state=" + state
				+ ", pinCode=" + pinCode + "]";
	}
}

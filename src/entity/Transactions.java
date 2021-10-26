package entity;

public class Transactions {
	
	private int fromAccount;
	private int toAccount;
	private double trans_ammount;
	private String description;
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(int fromAccount) {
		this.fromAccount = fromAccount;
	}
	public long getToAccount() {
		return toAccount;
	}
	public void setToAccount(int toAccount) {
		this.toAccount = toAccount;
	}
	public double getTrans_ammount() {
		return trans_ammount;
	}
	public void setTrans_ammount(double trans_ammount) {
		this.trans_ammount = trans_ammount;
	}
}

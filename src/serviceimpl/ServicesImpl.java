package serviceimpl;

import dao.Dao;
import entity.User;
import services.IServices;
import utility.UtilScanner;

public class ServicesImpl implements IServices{
	
	private Dao dao;
	
	public ServicesImpl() {
		this.dao = new Dao();
	}
	
	
	//Customer methods
	
	@Override
	public void addUser(User user) {
		dao.addUser(user);
	}

	@Override
	public void editProfile(User user) {
		dao.editProfile(user);
	}

	@Override
	public void displayProfile() {
		String fname = UtilScanner.getString("First name");
		String mname = UtilScanner.getString("Middle name");
		String lname = UtilScanner.getString("last name");

		dao.displayProfile(fname,mname,lname);
	}


	@Override
	public void sendMoney(double amount, long bankAccountNo) {
		dao.sendMoney(amount, bankAccountNo);
	}

	public int checkCredentials(String loginId, String user_pass) {
		int correct = dao.checkCredentials(loginId,user_pass);
		return correct;
	}


   //Admin Methods
	
	@Override
	public void deleteUser() {
		int user_id  = getUser();
		dao.deleteUser(user_id);
	}



	@Override
	public int getUser() {
		String fname = UtilScanner.getString("First name");
		String mname = UtilScanner.getString("Middle name");
		String lname = UtilScanner.getString("last name");
		int user = dao.getUser(fname,mname,lname);
		if(user != 0) {
			return user;
		}else {
			return 0;
		}
	}

	@Override
	public void displayAllUsers() {
		dao.displayAllUsers();
		
	}

	public void editUser() {
		String fname = UtilScanner.getString("First name");
		String mname = UtilScanner.getString("Middle name");
		String lname = UtilScanner.getString("last name");
		
		int user = dao.getUser(fname,mname,lname);
		if(user != 0) {
			dao.editUser(user);
		}else {
			System.out.println("This user is not present");
		}
		
	}

	public void displayAllTransactions() {
		dao.displayAllTransactions();
	}

	public void displayTransaction() {		
		String fname = UtilScanner.getString("First name");
		String mname = UtilScanner.getString("Middle name");
		String lname = UtilScanner.getString("last name");
		
		int user_id = dao.getUser(fname,mname,lname);
		if(user_id != 0) {
			dao.displayTransactions(user_id);
		}else {
			System.out.println("This user is not present");
		}
		
	}


	@Override
	public void withdra(double amount) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deposit(double amount) {
		// TODO Auto-generated method stub
		
	}
}

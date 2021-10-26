package services;

import entity.User;

public interface IDao {
	
	
	void addUser(User user);
	void deleteUser(int user_id);
	int getUser(String firstname,String middlename,String lastNamename);
	void displayAllUsers();
	
	void editProfile(User user);
	void displayProfile(String Firstname,String Middlename,String LastNamename);
	void withdraw(double amount);
	void deposit(double amount);
	void sendMoney(double amount,long bankAccountNo);
}

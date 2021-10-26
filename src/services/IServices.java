package services;

import entity.User;

public interface IServices {
	
	
	
	void addUser(User user);
	void deleteUser();
	void displayAllUsers();
	int getUser();
	void editProfile(User user);
	void displayProfile();
	void withdra(double amount);
	void deposit(double amount);
	void sendMoney(double amount,long bankAccountNo);
	
}

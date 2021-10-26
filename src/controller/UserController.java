package controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import entity.Address;
import entity.User;
import serviceimpl.ServicesImpl;
import utility.UtilScanner;

public class UserController {
	
	ServicesImpl userServices = new ServicesImpl();

	
	public void logIn() {
		String user_id = UtilScanner.getString("UserID");
		String user_pass = UtilScanner.getString("Password");
		int check = userServices.checkCredentials(user_id,user_pass);
		System.out.println(check);
		if(check != 0) {
			if(user_id.equals("admin")) {
				managerMenu();			
			}else {
				customerMenu();
			}
		}else {
			System.out.println("Enter Correct Credentials");
		}
	}
	

	
	private void customerMenu() {
		boolean exit = true;
		while(exit) {
			System.out.println("..Make Your Choice..");
			int choice = UtilScanner.getInt("\n1.Add Money to Account\n2.Take Money From Account "
					+ "\n3.Send Money to Another Account \n4.Edit Profile \n5.Diplay Profile \n6.EXIT");
			switch(choice) {
				case 1:
					System.out.println("Add Money to Account");
					break;
				case 2:
					System.out.println("Remove Money from Account");
					break;
				case 3:
					System.out.println("Send Money to Another Account");
					break;
				case 4:
					System.out.println("Edit profile");
					break;
				case 5:
					System.out.println("display profile");
					break;
				case 6:
					exit = false;
					break;
				default:
					System.out.println("Enter Correct Choice");
			}
		}		
	}



	private void managerMenu() {
		ServicesImpl userServices = new ServicesImpl();
		boolean exit = true;
		while(exit) {
			System.out.println("..Enter Your Choice..");
			int choice = UtilScanner.getInt("\n1.Add User\n2.Delete User"
					+ "\n3.profile for particular cutomer \n4.Edit User \n5.Display All Transactions \n6."
					+ "See transactions \n7.Search user\n8.EXIT");
			switch(choice) {
				case 1:
					signUpCustomer();
					break;
				case 2:
					userServices.deleteUser();
					break;
				case 3:
					userServices.displayProfile();
					break;
				case 4:
					userServices.editUser();
					break;
				case 5:
					userServices.displayAllTransactions();
				case 6:
					userServices.displayTransaction();
					break;
				case 7:
					userServices.getUser();
					break;
				case 8:
					exit = false;
					break;
				default:
					System.out.println("Enter Correct Choice");
			}
		}		
		
	}



	public void signUpCustomer() {
		User user = new User();
		Address address = new Address();
		user.setId(UtilScanner.getInt("Id"));
		user.setFirstName(UtilScanner.getString("First Name"));
		user.setMiddleName(UtilScanner.getString("Middle Name"));
		user.setLastName(UtilScanner.getString("Middle Name"));
		user.setEmail(UtilScanner.getString("Email"));
		
		
		
		String sDate = UtilScanner.getString("Enter dob: ex: 2004/01/23");
		try {
			Date date= (Date) new SimpleDateFormat("yyyy/MM/dd").parse(sDate);
			user.setDob(date);
		} catch (ParseException e) {
			System.out.println("Enter correct Format");
			e.printStackTrace();
		}
		
		
		user.setMobile(UtilScanner.getInt("Mobile"));
		user.setGender(UtilScanner.getString("Gender"));
		
		address.setLandmark(UtilScanner.getString("Landmark"));
		address.setStreet(UtilScanner.getString("street"));
		address.setCity(UtilScanner.getString("city"));
		address.setState(UtilScanner.getString("state"));
		address.setPinCode(UtilScanner.getString("Pincode"));
		user.setAddress(address);
		
		user.setLoginId(UtilScanner.getString("Login Id"));
		user.setPassword(UtilScanner.getString("password"));
		
		userServices.addUser(user);
	}

}

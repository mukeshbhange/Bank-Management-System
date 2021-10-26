package Application;

import controller.UserController;
import utility.UtilScanner;

public class Application {

	public static void main(String[] args) {
		optionMenu();
	}

	private static void optionMenu() {
		UserController userController = new UserController();
		boolean exit = true;
		while(exit) {
			System.out.println("..Make Your Choice..");
			int choice = UtilScanner.getInt("\n1.LOGIN\n2.SIGN UP\n3.EXIT");
			switch(choice) {
				case 1:
					userController.logIn();
					break;
				case 2:
					userController.signUpCustomer();
					break;
				case 3:
					exit = true;
					break;
				default:
					System.out.println("Enter Correct Choice");
			}
		}
	}

}

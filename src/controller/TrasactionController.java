package controller;

import entity.Transactions;
import serviceimpl.ServicesImpl;
import utility.UtilScanner;

public class TrasactionController {
	
	public void sendMoney() {
		Transactions transaction = new Transactions();
		ServicesImpl service = new ServicesImpl();
		int toAccount = UtilScanner.getInt("To Acccount");
		int ammount = UtilScanner.getInt("Amount");
		
		transaction.setToAccount(toAccount);
		transaction.setTrans_ammount(ammount);
		service.sendMoney(ammount, toAccount);
	}
}

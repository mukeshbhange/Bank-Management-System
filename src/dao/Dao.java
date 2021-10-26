package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import entity.Address;
import entity.User;
import services.IDao;
import utility.DBConnection;

public class Dao implements IDao{
	
	private DBConnection conn;
	
	public Dao() {
		this.conn = new DBConnection();
	}
	
	
	@Override
	public void addUser(User user) {
		
		try {
			Connection connection = conn.getConnection();
			Address address = user.getAddress();

			String sql = "INSERT INTO b_user(id,fname,mname,lname,email,dob,mobile,gender,"
					+ "role,loginId,password)values(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1,user.getId());
			statement.setString(2,user.getFirstName());
			statement.setString(3,user.getMiddleName());
			statement.setString(4,user.getLastName());
			statement.setString(5, user.getEmail());
			statement.setDate(6,new Date(user.getDob().getTime()));
			statement.setInt(7,user.getMobile());
			statement.setString(8,user.getGender());
			statement.setString(9,"customer");
			statement.setString(10,user.getLoginId());
			statement.setString(11,user.getPassword());

			String addSql = "INSERT INTO b_address(landmark,street,city,state,pincode,user_"
					+ "id)values(?,?,?,?,?,?)";
			PreparedStatement addStatement = connection.prepareStatement(addSql);

			addStatement.setString(1,address.getLandmark());
			addStatement.setString(2,address.getStreet());
			addStatement.setString(3,address.getCity());
			addStatement.setString(4,address.getState());
			addStatement.setString(5,address.getPinCode());
			addStatement.setInt(6, user.getId());
			
			
			
			
			String accSql = "INSERT INTO b_account(acc_type,balance,user_id,opening_date)values(?,?,?,?)";
			PreparedStatement accStatement = connection.prepareStatement(accSql);
						
			accStatement.setString(1,"Saving");
			accStatement.setInt(2, 0);
			accStatement.setInt(3,user.getId());			
			accStatement.setDate(4, Date.valueOf(LocalDate.now()));
			
			int rowsInserted = statement.executeUpdate();
			int rowInsertedInAdress = addStatement.executeUpdate();
			int rowInsertedAccount = accStatement.executeUpdate();
			
			if (rowsInserted > 0 && rowInsertedInAdress >0 && rowInsertedAccount > 0) {
				System.out.println("A new user was inserted successfully!");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void editProfile(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayProfile(String fname,String mname,String lname) {
		try {
			Connection connection = conn.getConnection();
			String sql = "select * from b_user u inner join b_address a on u.id = a.user_id "
					+ "inner join b_account ac on u.id where u.fname=?"
					+ " and u.mname=? and  u.lname=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, fname);
			statement.setString(2,mname);
			statement.setString(3,lname);


			ResultSet res = statement.executeQuery();

			if(res != null) {
				while(res.next()) {
					System.out.println("Name : "+ res.getString("fname")+" "+res.getString("mname")+" "+res.getString("lname")+
							"\t\tEmail : "+ res.getString("email")+"\nDate of birth: "+res.getString("dob")+"\ttMobile: "+
							res.getString("mobile")+"\nGender : "+res.getString("gender")+"\t\t\tRole : "
							+res.getString("role")+"\n\nAddress :\n"+res.getString("landmark")+"\n"+
							res.getString("street")+"\n"+res.getString("city")+"\n"+res.getString("state")
							+"\n"+res.getString("pincode"));
					System.out.println("\n\n.......Account Info.... :\n Account No: "+res.getString("acc_no")+"\nAccount Type: "+
							res.getString("acc_type")+"\n Balance : "+res.getString("balance")+"\nOpening date: "+
							res.getString("opening_date"));
					System.out.println("\n");
				}
			}else {
				System.out.println("No profile");
			}
		} catch (SQLException e) {
			System.out.println("Wrong check Credwntials Query");
		}		
	}

	@Override
	public void sendMoney(double amount, long bankAccountNo) {
		// TODO Auto-generated method stub
		
	}

	public int checkCredentials(String loginId, String user_pass) {
		try {
			Connection connection = conn.getConnection();
			String sql = "select exists ( select * from b_user where loginId = ? AND password= ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, loginId);
			statement.setString(2,user_pass);

			ResultSet res = statement.executeQuery();
			if(res.next()) {
				int result = res.getInt(1);
				return result;
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return 0;
	}


	@Override
	public void deleteUser(int user_id) {
		
	}
	
	@Override
	public int getUser(String firstname,String middlename,String lastNamename) {
		int user_id = 10;
		return user_id;
		
	}


	@Override
	public void displayAllUsers() {
		// TODO Auto-generated method stub
		
	}


	public void editUser(int user_id) {
		// TODO Auto-generated method stub
		
	}


	public void displayAllTransactions() {
		// TODO Auto-generated method stub
		
	}


	public void displayTransactions(int user_id) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void withdraw(double amount) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deposit(double amount) {
		// TODO Auto-generated method stub
		
	}
}

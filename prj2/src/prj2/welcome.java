package prj2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Font;

public class welcome {
	Connection con = null;
	ResultSet rs = null;
	Statement stmt = null;

	private JFrame frame;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					welcome window = new welcome();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public welcome() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(51, 204, 204));
		frame.setTitle("Welcome to Jamaica Palace");
		frame.setBounds(100, 100, 450, 361);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPassword = new JLabel("password:");
		lblPassword.setBounds(104, 82, 106, 14);
		frame.getContentPane().add(lblPassword);
		
		JButton btnNewButton_1 = new JButton("Administrator");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
		        
		        try{
		        	Class.forName("com.mysql.jdbc.Driver");
					String connectionUrl = "jdbc:mysql://localhost:3306/prj1";
					String connectionUser = "root";
					String connectionPassword = "test1234";
					Connection con= DriverManager.getConnection(connectionUrl, connectionUser,connectionPassword);
		        	
		        	String query= "Select * from  adm where  password=?";
			        PreparedStatement stmt =con.prepareStatement(query);
			        stmt.setString(1,password.getText());
			        
			        ResultSet rs= stmt.executeQuery();
			        int count=0;
			        while(rs.next()){
			        	count=count+1;
			        }
			        if(count==1)
			        {
			        	JOptionPane.showMessageDialog(null," password is correct");
			        	frame.dispose();
			        	admin adm=new admin();
						adm.setVisible(true);
			        	
			        	
			        }
			        else if(count>1)
			        {
			        	JOptionPane.showMessageDialog(null, "Duplicate password");
			        }
			        else{
			        	JOptionPane.showMessageDialog(null, "password is not correct try again");
			        }
			        rs.close();
			        stmt.close();
		        }
			   catch(Exception e){
				JOptionPane.showMessageDialog(null,e);
				}
			}
		});
		btnNewButton_1.setBounds(60, 132, 122, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnOfficer = new JButton("Officer");
		btnOfficer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
		        
		        try{
		        	Class.forName("com.mysql.jdbc.Driver");
					String connectionUrl = "jdbc:mysql://localhost:3306/prj1";
					String connectionUser = "root";
					String connectionPassword = "test1234";
					Connection con= DriverManager.getConnection(connectionUrl, connectionUser,connectionPassword);
		        	
		        	String query= "Select * from  ofc where  password=?";
			        PreparedStatement stmt =con.prepareStatement(query);
			        stmt.setString(1,password.getText());
			        
			        ResultSet rs= stmt.executeQuery();
			        int count=0;
			        while(rs.next()){
			        	count=count+1;
			        }
			        if(count==1)
			        {
			        	JOptionPane.showMessageDialog(null," password is correct");
			        	frame.dispose();
			        	officer off=new officer();
						off.setVisible(true);
			        	
			        }
			        else if(count>1)
			        {
			        	JOptionPane.showMessageDialog(null, "Duplicate password");
			        }
			        else{
			        	JOptionPane.showMessageDialog(null, "password is not correct try again");
			        }
			        rs.close();
			        stmt.close();
		        }
			   catch(Exception e){
				JOptionPane.showMessageDialog(null,e);
				}
			}
		});
		btnOfficer.setBounds(212, 132, 128, 23);
		frame.getContentPane().add(btnOfficer);
		
		JButton btnNewButton = new JButton("Make a booking");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				customers cust=new customers();
				cust.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 259, 414, 52);
		frame.getContentPane().add(btnNewButton);
		
		password = new JPasswordField();
		password.setBounds(220, 79, 99, 20);
		frame.getContentPane().add(password);
		
		JLabel lblWhoAreYou = new JLabel("Who are you...?");
		lblWhoAreYou.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblWhoAreYou.setBounds(117, 11, 223, 37);
		frame.getContentPane().add(lblWhoAreYou);
		
		JLabel lblNewLabel = new JLabel("Do you want a reservation?");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(69, 182, 329, 52);
		frame.getContentPane().add(lblNewLabel);
	}
}

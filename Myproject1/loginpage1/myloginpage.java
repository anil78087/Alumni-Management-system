package loginpage1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextField;

import myproject1.database2;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class myloginpage {

	private JFrame frame;
	private JTextField user;
	private JPasswordField pass1;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					myloginpage window = new myloginpage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public myloginpage() {
		initialize();
	}


	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(0, 255, 255));
		frame.setForeground(Color.CYAN);
		frame.getContentPane().setForeground(Color.CYAN);
		frame.setBounds(450, 150, 636, 415);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 255, 255));
		panel.setBorder(new LineBorder(new Color(0, 51, 255), 6));
		panel.setBounds(0, 0, 620, 376);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBackground(new Color(51, 255, 255));
		panel_1.setBounds(195, 249, 394, 78);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton exitbtn = new JButton("EXIT");
		exitbtn.setBorder(null);
		exitbtn.setBounds(263, 14, 121, 53);
		panel_1.add(exitbtn);
		exitbtn.setIcon(new ImageIcon(myloginpage.class.getResource("/myproject1/exit12.png")));
		exitbtn.setForeground(new Color(255, 255, 255));
		exitbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit","STUDENT DATABASE",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION)
				{
				System.exit(0);
				}
			}
		});
		exitbtn.setBackground(new Color(51, 255, 255));
		exitbtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton lgbtn = new JButton("Login");
		lgbtn.setBounds(44, 16, 119, 46);
		panel_1.add(lgbtn);
		lgbtn.setBorder(null);
		lgbtn.setIcon(new ImageIcon(myloginpage.class.getResource("/loginpage1/login123.png")));
		lgbtn.setForeground(new Color(255, 255, 255));
		lgbtn.setBackground(new Color(51, 255, 255));
		lgbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try
				{
					DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","12345678");
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select * from loginpage1");
					String u;
					String p;
					String ptxt=pass1.getText();
					String utxt=user.getText();
					boolean flag1=true;
					while(rs.next())
					{
						u=rs.getString(1);
						p=rs.getString(2);
						if(u.equals(utxt)&&p.equals(ptxt))
						{
							database2.main(null);
							
							flag1=false;
							
						}
					}
					if(flag1==true)
					{
						JOptionPane.showMessageDialog(null, "Username and password is wrong!");
					}
					
					
				}
			
				catch(SQLException e1)
				{
				JOptionPane.showMessageDialog(null, e1);
					e1.printStackTrace();
				}
				
				
				
				
				
				
				

			}
		});
		lgbtn.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		pass1 = new JPasswordField();
		pass1.setBounds(393, 165, 170, 29);
		panel.add(pass1);
		pass1.setBorder(new LineBorder(new Color(0, 0, 255), 2));
		pass1.setFont(new Font("Tahoma", Font.BOLD, 16));
		char a='*';
		pass1.setEchoChar(a);
		
		user = new JTextField();
		user.setBounds(393, 103, 170, 29);
		panel.add(user);
		user.setBorder(new LineBorder(new Color(0, 0, 255), 2));
		user.setColumns(10);
		user.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel pass = new JLabel("Password");
		pass.setBounds(241, 146, 142, 56);
		panel.add(pass);
		pass.setFont(new Font("Tahoma", Font.BOLD, 22));
		
		JLabel usr = new JLabel("Username");
		usr.setBounds(241, 84, 150, 56);
		panel.add(usr);
		usr.setFont(new Font("Tahoma", Font.BOLD, 22));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 51, 153));
		panel_2.setBounds(10, 11, 600, 62);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Alumni Management Login");
		lblNewLabel.setBackground(new Color(0, 102, 204));
		lblNewLabel.setBounds(128, 0, 434, 62);
		panel_2.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(myloginpage.class.getResource("/myproject1/alumni12.png")));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(myloginpage.class.getResource("/loginpage1/Admin1.png")));
		lblNewLabel_1.setBounds(32, 114, 152, 127);
		panel.add(lblNewLabel_1);
		//ImageIcon icon=new ImageIcon(this.getClass().getResource("/lpuimg.jpeg"));
	}
}

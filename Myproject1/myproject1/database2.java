package myproject1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import loginpage1.myloginpage;
import viewdata1.viewdata;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JDesktopPane;

public class database2 {

	private JFrame frame;
	private JTextField nm;
	private JTextField fnmm;
	private JTextField clgname;
	private JTextField clgcode1;
	private JTextField stdrl;
	private JTextField regno;
	private JTextField city1;
	private JTable table;
	DefaultTableModel model=new DefaultTableModel();
	private JTextField uroll;
	private JTextField clas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					database2 window = new database2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public database2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setBounds(180, 0, 950, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBorder(new LineBorder(Color.BLUE, 10));
		panel.setBounds(16, 59, 566, 273);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(23, 30, 100, 25);
		panel.add(lblNewLabel);
		
		JLabel lblFathersName = new JLabel("Father's  Name");
		lblFathersName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFathersName.setBounds(23, 90, 111, 25);
		panel.add(lblFathersName);
		
		JLabel lblCollegeName = new JLabel("College Name");
		lblCollegeName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCollegeName.setBounds(23, 158, 100, 25);
		panel.add(lblCollegeName);
		
		JLabel lblCollegeCode = new JLabel("College Code");
		lblCollegeCode.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCollegeCode.setBounds(23, 228, 100, 25);
		panel.add(lblCollegeCode);
		
		JLabel lblStudentRoll = new JLabel("Class");
		lblStudentRoll.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStudentRoll.setBounds(292, 30, 100, 25);
		panel.add(lblStudentRoll);
		
		JLabel lblStudentRoll_1 = new JLabel("Student Roll");
		lblStudentRoll_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStudentRoll_1.setBounds(292, 90, 100, 25);
		panel.add(lblStudentRoll_1);
		
		JLabel lblStuUniversityRoll = new JLabel("Registration No");
		lblStuUniversityRoll.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStuUniversityRoll.setBounds(292, 158, 131, 25);
		panel.add(lblStuUniversityRoll);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCity.setBounds(303, 228, 100, 25);
		panel.add(lblCity);
		
		nm = new JTextField();
		nm.setBorder(new LineBorder(new Color(0, 0, 255), 2));
		nm.setFont(new Font("Tahoma", Font.BOLD, 11));
		nm.setBounds(144, 32, 126, 25);
		panel.add(nm);
		nm.setColumns(10);
		
		fnmm = new JTextField();
		fnmm.setBorder(new LineBorder(new Color(0, 0, 255), 2));
		fnmm.setFont(new Font("Tahoma", Font.BOLD, 11));
		fnmm.setColumns(10);
		fnmm.setBounds(144, 92, 126, 25);
		panel.add(fnmm);
		
		clgname = new JTextField();
		clgname.setBorder(new LineBorder(new Color(0, 0, 255), 2));
		clgname.setFont(new Font("Tahoma", Font.BOLD, 11));
		clgname.setColumns(10);
		clgname.setBounds(144, 158, 126, 25);
		panel.add(clgname);
		clgcode1 = new JTextField();
		clgcode1.setBorder(new LineBorder(new Color(0, 0, 255), 2));
		clgcode1.setFont(new Font("Tahoma", Font.BOLD, 11));
		clgcode1.setColumns(10);
		clgcode1.setBounds(144, 228, 126, 25);
		panel.add(clgcode1);
		stdrl = new JTextField();
		stdrl.setBorder(new LineBorder(new Color(0, 0, 255), 2));
		stdrl.setFont(new Font("Tahoma", Font.BOLD, 11));
		stdrl.setColumns(10);
		stdrl.setBounds(413, 92, 126, 25);
		panel.add(stdrl);
		regno = new JTextField();
		regno.setBorder(new LineBorder(new Color(0, 0, 255), 2));
		regno.setFont(new Font("Tahoma", Font.BOLD, 11));
		regno.setColumns(10);
		regno.setBounds(413, 160, 126, 25);
		panel.add(regno);
		city1 = new JTextField();
		city1.setBorder(new LineBorder(new Color(0, 0, 255), 2));
		city1.setFont(new Font("Tahoma", Font.BOLD, 11));
		city1.setColumns(10);
		city1.setBounds(413, 230, 126, 25);
		panel.add(city1);
		
		JList list = new JList();
		list.setBounds(465, 45, -63, -13);
		panel.add(list);
		
		clas = new JTextField();
		clas.setBorder(new LineBorder(new Color(0, 0, 255), 2));
		clas.setFont(new Font("Tahoma", Font.BOLD, 11));
		clas.setColumns(10);
		clas.setBounds(413, 32, 126, 25);
		panel.add(clas);
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.BLUE, 10));
		panel_1.setBackground(Color.CYAN);
		panel_1.setBounds(592, 59, 332, 273);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(311, 27, -271, 275);
		panel_1.add(textArea);
		
		JTextArea textArea1 = new JTextArea();
		textArea1.setFont(new Font("Arial", Font.BOLD, 12));
		textArea1.setBounds(10, 11, 312, 251);
		panel_1.add(textArea1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 255), 10));
		panel_2.setBackground(Color.CYAN);
		panel_2.setBounds(16, 374, 908, 247);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 888, 225);
		panel_2.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		table.setFont(new Font("Tahoma", Font.BOLD, 12));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"s_name", "f_name", "college_name", "college_code", "Class", "Student_Roll", "su_Roll", "City"
			}
		));
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(79);
		table.getColumnModel().getColumn(1).setPreferredWidth(80);
		table.getColumnModel().getColumn(4).setPreferredWidth(54);
		table.getColumnModel().getColumn(6).setPreferredWidth(99);
		table.getColumnModel().getColumn(7).setPreferredWidth(83);
		scrollPane.setColumnHeaderView(table);
		
		JLabel lblStudentDatabase = new JLabel("Alumni Management System");
		lblStudentDatabase.setIcon(new ImageIcon(database2.class.getResource("/myproject1/alumni12.png")));
		lblStudentDatabase.setFont(new Font("Tahoma", Font.BOLD, 29));
		lblStudentDatabase.setBounds(262, 3, 484, 51);
		frame.getContentPane().add(lblStudentDatabase);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.CYAN);
		panel_4.setBounds(816, 11, 108, 43);
		frame.getContentPane().add(panel_4);
		
		JButton btnNewButton_3 = new JButton("login");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				myloginpage.main(null);
				
			}
		});
		panel_4.add(btnNewButton_3);
		btnNewButton_3.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnNewButton_3.setBorderPainted(false);
		btnNewButton_3.setForeground(Color.BLACK);
		btnNewButton_3.setBackground(new Color(0, 255, 255));
		btnNewButton_3.setBorder(null);
		btnNewButton_3.setIcon(new ImageIcon(database2.class.getResource("/myproject1/login3.png")));
		
		uroll = new JTextField();
		uroll.setBackground(new Color(0, 255, 255));
		uroll.setFont(new Font("Tahoma", Font.BOLD, 18));
		uroll.setBounds(113, 24, 56, 34);
		frame.getContentPane().add(uroll);
		uroll.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Search");
		lblNewLabel_1.setIcon(new ImageIcon(database2.class.getResource("/myproject1/search.png")));
		lblNewLabel_1.setBounds(16, 25, 97, 34);
		frame.getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setBackground(new Color(153, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(51, 255, 255));
		panel_3.setBounds(16, 625, 908, 86);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JButton insertBtn = new JButton("Insert");
		insertBtn.setIcon(new ImageIcon(database2.class.getResource("/myproject1/insert12.png")));
		insertBtn.setBorder(null);
		insertBtn.setBounds(0, 14, 136, 45);
		panel_3.add(insertBtn);
		insertBtn.setForeground(new Color(0, 0, 0));
		insertBtn.setBackground(new Color(51, 255, 255));
		insertBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(nm.getText().equals("")||fnmm.getText().equals("")||clgname.getText().equals("")||clgcode1.getText().equals("")||clas.getText().equals("")||stdrl.getText().equals("")||regno.getText().equals("")||city1.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "please enter all information");
				}
				else
				{
					boolean flg=false;
					
					try
					{
						DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
						Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","12345678");
						Statement st=con.createStatement();
						ResultSet rs=st.executeQuery("select s_name,f_name,college_name,college_code,class,student_Roll,su_Roll,city from project1");
					
						Object[] columnData = new Object[8];
						while(rs.next())
						{
						columnData[0] =rs.getString("s_name");
						columnData[1]= rs.getString("f_name");
						columnData[2]= rs.getString("college_name");
						columnData[3]= rs.getString("college_code");
						columnData[4]= rs.getString("class");
						columnData[5]= rs.getString("student_Roll");
						columnData[6]= rs.getString("su_Roll");
						columnData[7]= rs.getString("city");
						
						//model.addRow(columnData);
						
						String srl=rs.getString("student_Roll");
						
						if(stdrl.getText().equals(srl))
						{
							JOptionPane.showMessageDialog(null, "Roll No should not be unique");
							flg=true;
						}
						
						if(flg==false)
						{
							st.executeUpdate("insert into Project2(s_name,f_name,college_name,college_code,class,student_Roll,su_Roll,city) values('"+nm.getText()+"','"+fnmm.getText()+"','"+clgname.getText()+"','"+clgcode1.getText()+"','"+clas.getText()+"','"+stdrl.getText()+"','"+regno.getText()+"','"+city1.getText()+"')");
							JOptionPane.showMessageDialog(null, "Data Inserted");
						}
						
					}
					}
				
					catch(SQLException e)
					{
					JOptionPane.showMessageDialog(null, e);
						e.printStackTrace();
					}
					
					
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.addRow(new Object[] {
							nm.getText(),fnmm.getText(),clgname.getText(),clgcode1.getText(),clas.getText(),stdrl.getText(),regno.getText(),city1.getText()
					});
					
					
					
					
					nm.setText(null);
					fnmm.setText(null);
					clgname.setText(null);
					clgcode1.setText(null);
					clas.setText(null);
					stdrl.setText(null);
					regno.setText(null);
					city1.setText(null);
					
				
				}
					
				
				
				
				
				
				
				
				
				
			}
				
		});
		insertBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton updateBtn = new JButton("Update");
		updateBtn.setIcon(new ImageIcon(database2.class.getResource("/myproject1/update12.png")));
		updateBtn.setBorder(null);
		updateBtn.setBounds(168, 15, 128, 43);
		panel_3.add(updateBtn);
		updateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(uroll.getText().equals(""))
						{
							JOptionPane.showMessageDialog(null, "Please Enter Roll to Update Data");
						}
				else if(nm.getText().equals("")||fnmm.getText().equals("")||clgname.getText().equals("")||clgcode1.getText().equals("")||clas.getText().equals("")||stdrl.getText().equals("")||regno.getText().equals("")||city1.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "please enter all information");
				}
				else
				{
					
					try
					{
						DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
						Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","12345678");
						Statement st=con.createStatement();
//						int myrl=Integer.parseInt(stdrl.getText());
//						int urld=Integer.parseInt(regno.getText());
						String qry="update project2 set s_name='"+nm.getText()+"',f_name='"+fnmm.getText()+"',college_name='"+clgname.getText()+"',college_code='"+clgcode1.getText()+"',student_Roll='"+stdrl.getText()+"',su_Roll='"+regno.getText()+"',city='"+city1.getText()+"' where student_Roll='"+stdrl.getText()+"'";
						PreparedStatement pstmt=con.prepareStatement(qry);
						pstmt.execute();
						JOptionPane.showMessageDialog(null, "Data Upadated");
						
					}
				
					catch(SQLException e2)
					{
					JOptionPane.showMessageDialog(null, e2);
						e2.printStackTrace();
					}
				
				}
					
				
				
			}
			
		});
		updateBtn.setForeground(new Color(0, 0, 255));
		updateBtn.setBackground(new Color(51, 255, 255));
		updateBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton searchBtn = new JButton("Search");
		searchBtn.setIcon(new ImageIcon(database2.class.getResource("/myproject1/search.png")));
		searchBtn.setBorder(null);
		searchBtn.setBounds(323, 15, 123, 43);
		panel_3.add(searchBtn);
		searchBtn.setForeground(new Color(102, 0, 255));
		searchBtn.setBackground(new Color(51, 255, 255));
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String rl = null;
				if(uroll.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "please enter roll to find");
				}
				
								
				else
				{
					
					try
					{
						DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
						Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","12345678");
						String qry2="select * from project2 where student_Roll='"+uroll.getText()+"'";
						Statement st=con.createStatement();
						ResultSet rs=st.executeQuery(qry2);
//						String rl = null;
						boolean flg=false;
						while(rs.next())
						{
							String s =rs.getString("s_name");
							String f= rs.getString("f_name");
							String cnm= rs.getString("college_name");
							String cd= rs.getString("college_code");
							String cls= rs.getString("class");
							 rl= rs.getString("student_Roll");
							String url= rs.getString("su_Roll");
							String cty= rs.getString("city");
							
							
							textArea1.setText("");
							textArea1.append("                                    student database \n" + ""
									+ "----------------------------------------------------------------------------------\n" + ""
									+ "Student Name:-" + s
									+ "\nFather's Name:-" + f
									+ "\nCollege Name:-" + cnm
									+ "\nCollege Code:-" + cd
									+ "\nClass:-" + cls
									+ "\nStudent Roll:-" + rl
									+ "\nSty University Roll:-" + url
									+ "\nCity:-" + cty);
							
							nm.setText(s);
							fnmm.setText(f);
							clgname.setText(cnm);
							clgcode1.setText(cd);
							clas.setText(cls);
							stdrl.setText(rl);
							regno.setText(url);
							city1.setText(cty);
							
							String rl2=uroll.getText();
							
							
							if(rl.equals(rl2))
							{
								JOptionPane.showMessageDialog(null, "Data Found");	
								
								flg=true;
							}	
							
							
	
							
						}
						if(flg==false)
						{
							JOptionPane.showMessageDialog(null, "This data is not present in your database");
						}
					}
					
					
				
					catch(SQLException e2)
					{
					JOptionPane.showMessageDialog(null, e2);
						e2.printStackTrace();
					}

				}
				
				
				
				
			}
		});
		searchBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton viewBtn = new JButton("ViewAllData");
		viewBtn.setIcon(new ImageIcon(database2.class.getResource("/myproject1/view12.png")));
		viewBtn.setBorder(null);
		viewBtn.setBounds(478, 15, 136, 43);
		panel_3.add(viewBtn);
		viewBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				viewdata.main(null);
				frame.setVisible(false);
			
				
			}
		});
		viewBtn.setForeground(new Color(51, 0, 0));
		viewBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		viewBtn.setBackground(new Color(51, 255, 255));
		
		JButton deleteBtn = new JButton("Delete");
		deleteBtn.setBorder(null);
		deleteBtn.setBounds(630, 15, 128, 43);
		panel_3.add(deleteBtn);
		deleteBtn.setIcon(new ImageIcon(database2.class.getResource("/myproject1/delete2.png")));
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(uroll.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please Enter Roll to Delete");
				}
				else
				{
					try
					{
						DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
						Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","12345678");
						Statement st=con.createStatement();
						String qry1="delete from project2 where student_Roll='"+uroll.getText()+"'";
						PreparedStatement pstmt=con.prepareStatement(qry1);
						pstmt.execute();
						JOptionPane.showMessageDialog(null, "Data Deleted");
						
					}
				
					catch(SQLException e2)
					{
					JOptionPane.showMessageDialog(null, e2);
						e2.printStackTrace();
					}
			
				}
					}
		});
		deleteBtn.setForeground(new Color(204, 0, 0));
		deleteBtn.setBackground(new Color(51, 255, 255));
		deleteBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton exitBtn = new JButton("Exit");
		exitBtn.setIcon(new ImageIcon(database2.class.getResource("/myproject1/exit12.png")));
		exitBtn.setBorder(null);
		exitBtn.setBounds(785, 15, 123, 43);
		panel_3.add(exitBtn);
		exitBtn.setForeground(new Color(153, 0, 0));
		exitBtn.setBackground(new Color(51, 255, 255));
		exitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
					if(JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit","Alumni System",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION)
					{
			
					
					System.exit(0);
					}
				
				
				
			}
		});
		exitBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		
	
	}
}

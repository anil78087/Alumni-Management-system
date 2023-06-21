package viewdata1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

import loginpage1.myloginpage;
import myproject1.database2;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class viewdata{

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewdata window = new viewdata();
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
	public viewdata() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(0, 255, 255));
		frame.setBounds(100, 100, 883, 488);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 69, 847, 353);
		table.setForeground(new Color(0, 0, 0));
		table.setFont(new Font("Tahoma", Font.BOLD, 12));
		table.setBorder(new LineBorder(new Color(0, 0, 255), 2));
		table.setBackground(new Color(224, 255, 255));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"StudentName", "FatherName", "collegeName", "collegeCode", "Class", "Roll", "Registraton", "City"
			}
		));
		frame.getContentPane().add(table);
		
		JButton btnNewButton = new JButton("View Data");
		btnNewButton.setIcon(new ImageIcon(viewdata.class.getResource("/viewdata1/view12.png")));
		btnNewButton.setBounds(383, 420, 156, 29);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setForeground(new Color(255, 250, 250));
		btnNewButton.setBackground(new Color(0, 0, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","12345678");
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select s_name,f_name,college_name,college_code,class,student_Roll,su_Roll,city from project2");
				
					Object[] columnData = new Object[8];
					while(rs.next())
					{
					String s =rs.getString("s_name");
					String f= rs.getString("f_name");
					String cnm= rs.getString("college_name");
					String cd= rs.getString("college_code");
					String cls= rs.getString("class");
					String rl= rs.getString("student_Roll");
					String url= rs.getString("su_Roll");
					String cty= rs.getString("city");
					String tbdata[]= {s,f,cnm,cd,cls,rl,url,cty};
					DefaultTableModel dft=(DefaultTableModel)table.getModel();
					dft.addRow(tbdata);
					//model.addRow(columnData);
					
					
					
					
					
				}
				}
			
				catch(SQLException e1)
				{
				JOptionPane.showMessageDialog(null, e1);
					e1.printStackTrace();
				}
				
				
				
			

				
			}
		});
		
		
		frame.getContentPane().add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 42, 847, 29);
		panel.setForeground(new Color(255, 250, 250));
		panel.setBackground(new Color(0, 0, 128));
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("StudentName");
		lblNewLabel.setForeground(new Color(255, 250, 250));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(0, 5, 109, 24);
		panel.add(lblNewLabel);
		
		JLabel lblFathername = new JLabel("FatherName");
		lblFathername.setBackground(new Color(240, 255, 255));
		lblFathername.setForeground(new Color(255, 250, 250));
		lblFathername.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFathername.setBounds(107, 5, 128, 25);
		panel.add(lblFathername);
		
		JLabel lblFathername_1 = new JLabel("CollegeName");
		lblFathername_1.setForeground(new Color(255, 250, 250));
		lblFathername_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFathername_1.setBounds(205, 5, 128, 25);
		panel.add(lblFathername_1);
		
		JLabel lblFathername_2 = new JLabel("CollegeCode");
		lblFathername_2.setForeground(new Color(255, 250, 250));
		lblFathername_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFathername_2.setBounds(317, 5, 128, 25);
		panel.add(lblFathername_2);
		
		JLabel lblFathername_3 = new JLabel("Class");
		lblFathername_3.setForeground(new Color(255, 250, 250));
		lblFathername_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFathername_3.setBounds(420, 5, 128, 25);
		panel.add(lblFathername_3);
		
		JLabel lblFathername_4 = new JLabel("Registration");
		lblFathername_4.setForeground(new Color(255, 250, 250));
		lblFathername_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFathername_4.setBounds(622, 5, 128, 25);
		panel.add(lblFathername_4);
		
		JLabel lblFathername_5 = new JLabel("Roll");
		lblFathername_5.setForeground(new Color(255, 250, 250));
		lblFathername_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFathername_5.setBounds(522, 5, 128, 25);
		panel.add(lblFathername_5);
		
		JLabel lblFathername_7 = new JLabel("City");
		lblFathername_7.setForeground(new Color(255, 250, 250));
		lblFathername_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFathername_7.setBounds(734, 5, 128, 25);
		panel.add(lblFathername_7);
		
		JLabel lblFathername_6 = new JLabel("FatherName");
		lblFathername_6.setBounds(729, 102, 128, 25);
		lblFathername_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		frame.getContentPane().add(lblFathername_6);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 0, 847, 36);
		panel_1.setBorder(null);
		panel_1.setBackground(new Color(51, 255, 255));
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Alumni Management System");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setIcon(new ImageIcon(viewdata.class.getResource("/viewdata1/alumni12.png")));
		lblNewLabel_1.setBounds(309, 0, 302, 43);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.CYAN);
		panel_2.setBounds(10, 2, 141, 41);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnHomePage = new JButton("Home");
		btnHomePage.setBounds(0, 0, 85, 41);
		panel_2.add(btnHomePage);
		btnHomePage.setBorder(null);
		btnHomePage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				database2.main(null);
				frame.setVisible(false);
			}
		});
		btnHomePage.setIcon(new ImageIcon(viewdata.class.getResource("/viewdata1/home1.png")));
		btnHomePage.setForeground(new Color(0, 0, 0));
		btnHomePage.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnHomePage.setBackground(new Color(51, 255, 255));
		
		JButton btnNewButton_1 = new JButton("Print Data");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBackground(new Color(51, 255, 255));
		btnNewButton_1.setIcon(new ImageIcon(viewdata.class.getResource("/viewdata1/pt.png")));
		btnNewButton_1.setBounds(727, 0, 110, 36);
		panel_1.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MessageFormat header=new MessageFormat("Student Data");
				MessageFormat footer=new MessageFormat("Data generated by anil");
				try
				{
					table.print(JTable.PrintMode.FIT_WIDTH,header,footer);
				}
				catch (Exception es) {
					es.printStackTrace();
				}
			}
		});
		
	
	}
}

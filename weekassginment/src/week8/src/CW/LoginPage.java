package CW;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField text_username;
	private JTextField text_password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 564, 547);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("COVID Contact Tracing");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(185, 43, 342, 71);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Login Form");
		lblNewLabel_1.setBounds(249, 124, 136, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setBounds(143, 193, 110, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Password");
		lblNewLabel_2_1.setBounds(143, 240, 110, 13);
		contentPane.add(lblNewLabel_2_1);
		
		text_username = new JTextField();
		text_username.setBounds(249, 190, 136, 19);
		contentPane.add(text_username);
		text_username.setColumns(10);
		
		text_password = new JTextField();
		text_password.setColumns(10);
		text_password.setBounds(249, 237, 136, 19);
		contentPane.add(text_password);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = text_username.getText();
				String password_v = text_password.getText();
				if (username.isEmpty()){
					JOptionPane.showMessageDialog(contentPane,"Username is required!");
				}
				else if (password_v.isEmpty()){
					JOptionPane.showMessageDialog(contentPane,"Password field is left blank!");
				}
				else{
					String userName = text_username.getText();
					String password = text_password.getText();

					boolean validate = false;
					try {
						validate = checkLogin(userName, password);
					} catch (IOException ex) {
						ex.printStackTrace();
					}
					if (validate){
						JOptionPane.showMessageDialog(contentPane,"Welcome Here!");
						dispose();

					}
					else {
						JOptionPane.showMessageDialog(contentPane,"Login Failed");
					}
				}
			}
		});
		btnNewButton.setBounds(249, 308, 136, 21);
		contentPane.add(btnNewButton);
		
		JButton btnRegistration = new JButton("Registration");
		btnRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Register().setVisible(true);
			}
		});
		btnRegistration.setBounds(145, 373, 240, 33);
		contentPane.add(btnRegistration);
	}
	public boolean validateStaff(String typedPassword, String savedPassword){
		return typedPassword.equals(savedPassword);
	}

	public boolean checkLogin(String userName, String password) throws IOException {
		FileHand fh = new FileHand();
		boolean validStaff = false;

		String[] data = fh.ReadOrFetch(Constants.staffFile,userName,0 );
		if (data != null){
			validStaff = validateStaff(password, data[5]);
		}
		return validStaff;
	}

}

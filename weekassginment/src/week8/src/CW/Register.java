package CW;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField text_uname;
	private JTextField text_fname;
	private JTextField text_lname;
	private JTextField text_email;
	private JTextField text_phone;
	private JTextField text_passwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 764, 562);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("REGISTRATION FORM");
		lblNewLabel.setBounds(247, 39, 205, 66);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("USERNAME");
		lblNewLabel_1.setBounds(129, 135, 109, 13);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("FIRSTNAME");
		lblNewLabel_1_1.setBounds(129, 195, 109, 13);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("LASTNAME");
		lblNewLabel_1_2.setBounds(129, 240, 109, 13);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("EMAIL");
		lblNewLabel_1_3.setBounds(129, 287, 109, 13);
		contentPane.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_4 = new JLabel("PHONE");
		lblNewLabel_1_4.setBounds(129, 328, 109, 13);
		contentPane.add(lblNewLabel_1_4);

		JLabel lblNewLabel_1_5 = new JLabel("PASSWORD");
		lblNewLabel_1_5.setBounds(129, 374, 109, 13);
		contentPane.add(lblNewLabel_1_5);

		text_uname = new JTextField();
		text_uname.setBounds(314, 132, 165, 19);
		contentPane.add(text_uname);
		text_uname.setColumns(10);

		text_fname = new JTextField();
		text_fname.setColumns(10);
		text_fname.setBounds(314, 192, 165, 19);
		contentPane.add(text_fname);

		text_lname = new JTextField();
		text_lname.setColumns(10);
		text_lname.setBounds(314, 237, 165, 19);
		contentPane.add(text_lname);

		text_email = new JTextField();
		text_email.setColumns(10);
		text_email.setBounds(314, 284, 165, 19);
		contentPane.add(text_email);

		text_phone = new JTextField();
		text_phone.setColumns(10);
		text_phone.setBounds(314, 325, 165, 19);
		contentPane.add(text_phone);

		text_passwd = new JPasswordField();
		text_passwd.setColumns(10);
		text_passwd.setBounds(314, 371, 165, 19);
		contentPane.add(text_passwd);

		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = text_uname.getText();
				String firstname = text_fname.getText();
				String lastname = text_lname.getText();
				String email = text_email.getText();
				String phone = text_phone.getText();
				String passwd = text_passwd.getText();

				if (username.isEmpty()) {
					JOptionPane.showMessageDialog(contentPane, "Username is required.");
				}
				else if (firstname.isEmpty()) {
					JOptionPane.showMessageDialog(contentPane, "First name is required.");
				} else if (lastname.isEmpty()) {
					JOptionPane.showMessageDialog(contentPane, "Last name is required.");
				} else if (email.isEmpty()) {
					JOptionPane.showMessageDialog(contentPane, "Email is required.");
				} else if (phone.isEmpty()) {
					JOptionPane.showMessageDialog(contentPane, "Phone is required.");
				} else if (passwd.isEmpty()) {
					JOptionPane.showMessageDialog(contentPane, "Password is required.");
				} else {
					RegistrationFilehandler rfh = new RegistrationFilehandler();
					String[] staffDetail = { username, firstname, lastname, email, phone, passwd };
					String message = rfh.staffRegistration(staffDetail);
					if (message.startsWith("Success")) {
						JOptionPane.showMessageDialog(contentPane, "New Staff is registered Successfully!");
						new LoginPage().setVisible(true);
						dispose();
					}

				}

			}
		});
		btnNewButton.setBounds(314, 421, 165, 21);
		contentPane.add(btnNewButton);

		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new LoginPage().setVisible(true);
			}
		});
		btnLogin.setBounds(129, 421, 165, 21);
		contentPane.add(btnLogin);
	}

}

class RegistrationFilehandler {
	public String staffRegistration(String[] staffDetails) {
		FileHand fhl = new FileHand();
		return fhl.CreateOrAdd(Constants.staffFile, staffDetails);
	}
}

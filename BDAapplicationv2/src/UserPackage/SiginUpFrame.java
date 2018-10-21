package UserPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import ComunPackage.Data;
import ComunPackage.DataUser;
import ComunPackage.TypeData;
import javax.swing.border.LineBorder;



public class SiginUpFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel lblConfirmPassword;
	private JLabel warningLabel;
	@SuppressWarnings("unused")
	private ObjectOutputStream out;

	/**
	 * Create the frame.
	 */
	public SiginUpFrame(ObjectOutputStream out) {
		this.out=out;

		setTitle("BDAapplication");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 789, 478);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.text);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel label_3 = new JLabel("");
		label_3.setBounds(685, 0, 76, 20);
		label_3.setIcon(new ImageIcon(SiginUpFrame.class.getResource("/Image/logominsize.PNG")));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(new Color(255, 153, 0));
		label_3.setFont(new Font("Lucida Calligraphy", Font.ITALIC, 13));
		panel.add(label_3);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(366, 21, 385, 397);
		panel_1.setBorder(new LineBorder(SystemColor.text, 1, true));
		panel.add(panel_1);
		panel_1.setLayout(null);


		lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setBounds(10, 252, 115, 24);
		panel_1.add(lblConfirmPassword);
		lblConfirmPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConfirmPassword.setFont(new Font("Cambria", Font.PLAIN, 14));
		lblConfirmPassword.setVisible(false);

		textField_3 = new JTextField();
		textField_3.setVisible(false);
		textField_3.setBounds(143, 251, 174, 28);
		panel_1.add(textField_3);
		textField_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {

					if(!textField.getText().isEmpty() && !textField_1.getText().isEmpty() 
							&& !textField_2.getText().isEmpty() && !textField_3.getText().isEmpty()) {

						if(textField_2.getText().equals(textField_3.getText())) {

							String [] options = { "Confirm", "Cancel" };

							int choice=JOptionPane.showOptionDialog(null, "Are you sure you want to create the account?", "Warning",
									JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);

							if(choice==0) {
								try {
									out.flush();
									out.writeObject(new Data(TypeData.REQUEST_SIGN,new DataUser(textField.getText(), textField_2.getText().hashCode(), 
											textField_1.getText(), textField_4.getText())));
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}		
							}

						}	
						else
							JOptionPane.showMessageDialog(null,"The passwords do not match!");

					}
					else
						JOptionPane.showMessageDialog(null, "Please complete all the fields!");
				}
			}
		});
		textField_3.setHorizontalAlignment(SwingConstants.LEFT);
		textField_3.setFont(new Font("Arial", Font.ITALIC, 13));
		textField_3.setColumns(20);

		textField_2 = new JTextField();
		textField_2.setBounds(143, 212, 174, 28);
		panel_1.add(textField_2);


		warningLabel = new JLabel("");
		warningLabel.setFont(new Font("Tahoma", Font.ITALIC, 11));
		warningLabel.setForeground(new Color(255, 0, 0));
		warningLabel.setBounds(143, 241, 232, 14);
		panel_1.add(warningLabel);

		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if(textField_2.getText().length()>=7) {
					textField_3.setVisible(true);
					lblConfirmPassword.setVisible(true);
					warningLabel.setText("");

				}

				if(textField_2.getText().length()<7) {
					warningLabel.setText("Password must have at least 8 characters");
					textField_3.setText("");
					textField_3.setVisible(false);
					lblConfirmPassword.setVisible(false);
				}


				if(e.getKeyCode()==KeyEvent.VK_ENTER) {

					if(!textField.getText().isEmpty() && !textField_1.getText().isEmpty() 
							&& !textField_2.getText().isEmpty() && !textField_3.getText().isEmpty()) {

						if(textField_2.getText().equals(textField_3.getText())) {

							String [] options = { "Confirm", "Cancel" };

							int choice=JOptionPane.showOptionDialog(null, "Are you sure you want to create the account?", "Warning",
									JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);

							if(choice==0) {
								try {
									out.flush();
									out.writeObject(new Data(TypeData.REQUEST_SIGN,new DataUser(textField.getText(), textField_2.getText().hashCode(), 
											textField_1.getText(), textField_4.getText())));
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}		
							}

						}	
						else
							JOptionPane.showMessageDialog(null,"The passwords do not match!");

					}
					else
						JOptionPane.showMessageDialog(null, "Please complete all the fields!");
				}
			}
		});
		textField_2.setHorizontalAlignment(SwingConstants.LEFT);
		textField_2.setFont(new Font("Arial", Font.ITALIC, 13));
		textField_2.setColumns(20);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(66, 216, 59, 24);
		panel_1.add(lblPassword);
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setFont(new Font("Cambria", Font.PLAIN, 14));



		JLabel label_1 = new JLabel("Username");
		label_1.setBounds(60, 177, 65, 24);
		panel_1.add(label_1);
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Cambria", Font.PLAIN, 14));

		textField = new JTextField();
		textField.setBounds(143, 173, 232, 28);
		panel_1.add(textField);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {

					if(!textField.getText().isEmpty() && !textField_1.getText().isEmpty() 
							&& !textField_2.getText().isEmpty() && !textField_3.getText().isEmpty()) {

						if(textField_2.getText().equals(textField_3.getText())) {

							String [] options = { "Confirm", "Cancel" };

							int choice=JOptionPane.showOptionDialog(null, "Are you sure you want to create the account?", "Warning",
									JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);

							if(choice==0) {
								try {
									out.flush();
									out.writeObject(new Data(TypeData.REQUEST_SIGN,new DataUser(textField.getText(), textField_2.getText().hashCode(), 
											textField_1.getText(), textField_4.getText())));
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}		
							}

						}	
						else
							JOptionPane.showMessageDialog(null,"The passwords do not match!");

					}
					else
						JOptionPane.showMessageDialog(null, "Please complete all the fields!");
				}
			}
		});
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setFont(new Font("Arial", Font.PLAIN, 13));
		textField.setColumns(20);

		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("Cambria", Font.PLAIN, 14));
		lblEmail.setBounds(83, 138, 42, 24);
		panel_1.add(lblEmail);

		textField_4 = new JTextField();
		textField_4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {

					if(!textField.getText().isEmpty() && !textField_1.getText().isEmpty() 
							&& !textField_2.getText().isEmpty() && !textField_3.getText().isEmpty()) {

						if(textField_2.getText().equals(textField_3.getText())) {

							String [] options = { "Confirm", "Cancel" };

							int choice=JOptionPane.showOptionDialog(null, "Are you sure you want to create the account?", "Warning",
									JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);

							if(choice==0) {
								try {
									out.flush();
									out.writeObject(new Data(TypeData.REQUEST_SIGN,new DataUser(textField.getText(), textField_2.getText().hashCode(), 
											textField_1.getText(), textField_4.getText())));
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}		
							}

						}	
						else
							JOptionPane.showMessageDialog(null,"The passwords do not match!");

					}
					else
						JOptionPane.showMessageDialog(null, "Please complete all the fields!");
				}
			}
		});
		textField_4.setHorizontalAlignment(SwingConstants.LEFT);
		textField_4.setFont(new Font("Arial", Font.PLAIN, 13));
		textField_4.setColumns(20);
		textField_4.setBounds(143, 134, 232, 28);
		panel_1.add(textField_4);

		textField_1 = new JTextField();
		textField_1.setBounds(143, 95, 232, 28);
		panel_1.add(textField_1);
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()==KeyEvent.VK_ENTER) {
					if(!textField.getText().isEmpty() && !textField_1.getText().isEmpty() 
							&& !textField_2.getText().isEmpty() && !textField_3.getText().isEmpty()) {

						if(textField_2.getText().equals(textField_3.getText())) {

							String [] options = { "Confirm", "Cancel" };

							int choice=JOptionPane.showOptionDialog(null, "Are you sure you want to create the account?", "Warning",
									JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);

							if(choice==0) {
								try {
									out.flush();
									out.writeObject(new Data(TypeData.REQUEST_SIGN,new DataUser(textField.getText(), textField_2.getText().hashCode(), 
											textField_1.getText(), textField_4.getText())));
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}		
							}

						}	
						else
							JOptionPane.showMessageDialog(null,"The passwords do not match!");

					}
					else
						JOptionPane.showMessageDialog(null, "Please complete all the fields!");
				}
			}
		});
		textField_1.setHorizontalAlignment(SwingConstants.LEFT);
		textField_1.setFont(new Font("Arial", Font.PLAIN, 13));
		textField_1.setColumns(20);

		JLabel lblFullName = new JLabel("Full Name");
		lblFullName.setBounds(60, 99, 65, 24);
		panel_1.add(lblFullName);
		lblFullName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFullName.setFont(new Font("Cambria", Font.PLAIN, 14));

		JButton btnBack = new JButton("Cancel");
		btnBack.setBounds(205, 305, 115, 37);
		panel_1.add(btnBack);
		btnBack.setIcon(new ImageIcon(SiginUpFrame.class.getResource("/Image/error.png")));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Client.logFrame.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JButton btnSiginUp = new JButton("Sigin Up");
		btnSiginUp.setBounds(73, 305, 115, 37);
		panel_1.add(btnSiginUp);
		btnSiginUp.setIcon(new ImageIcon(SiginUpFrame.class.getResource("/Image/checked.png")));
		btnSiginUp.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if(!textField.getText().isEmpty() && !textField_1.getText().isEmpty() 
						&& !textField_2.getText().isEmpty() && !textField_3.getText().isEmpty()) {

					if(textField_2.getText().equals(textField_3.getText())) {

						String [] options = { "Confirm", "Cancel" };

						int choice=JOptionPane.showOptionDialog(null, "Are you sure you want to create the account?", "Warning",
								JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);

						if(choice==0) {
							try {
								out.flush();
								out.writeObject(new Data(TypeData.REQUEST_SIGN,new DataUser(textField.getText(), textField_2.getText().hashCode(), 
										textField_1.getText(), textField_4.getText())));
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}		
						}

					}	
					else
						JOptionPane.showMessageDialog(null,"The passwords do not match!");

				}
				else
					JOptionPane.showMessageDialog(null, "Please complete all the fields!");
			}
		});
		btnSiginUp.setFont(new Font("Tahoma", Font.PLAIN, 12));



		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 21, 346, 397);
		panel_2.setBackground(Color.WHITE);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblSignupWindow = new JLabel("Register");
		lblSignupWindow.setIcon(new ImageIcon(SiginUpFrame.class.getResource("/Image/add-user (1).png")));
		lblSignupWindow.setBounds(26, 79, 289, 219);
		panel_2.add(lblSignupWindow);
		lblSignupWindow.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignupWindow.setForeground(SystemColor.activeCaption);
		lblSignupWindow.setFont(new Font("Mongolian Baiti", Font.BOLD, 36));
	}

	public void hide() {
		textField_3.setVisible(false);
		lblConfirmPassword.setVisible(false);
		warningLabel.setText("");
	}

	//raise methods
	public void raiseTf() {
		textField.setText("");
	}
	public void raiseTf1() {
		textField_1.setText("");
	}
	public void raiseTf2() {
		textField_2.setText("");
	}
	public void raiseTf3() {
		textField_3.setText("");
	}
	public void raiseTf4() {
		textField_4.setText("");
	}
}

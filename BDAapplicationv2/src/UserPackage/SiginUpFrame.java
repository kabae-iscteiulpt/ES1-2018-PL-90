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
	@SuppressWarnings("unused")
	private ObjectOutputStream out;
	

	
	/**
	 * Create the frame.
	 */
	public SiginUpFrame(ObjectOutputStream out) {
		this.out=out;
		
		setTitle("BDAapplication");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 787, 478);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(SystemColor.text);
		contentPane.add(panel, BorderLayout.CENTER);

		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("C:\\Users\\User\\ES1-2018-PL-90\\images\\logominsize.PNG"));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(new Color(255, 153, 0));
		label_3.setFont(new Font("Lucida Calligraphy", Font.ITALIC, 13));
		label_3.setBounds(685, 0, 76, 20);
		panel.add(label_3);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(366, 21, 385, 397);
		panel.add(panel_1);
		panel_1.setLayout(null);

		textField_3 = new JTextField();
		textField_3.setBounds(115, 224, 174, 28);
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
		textField_2.setBounds(115, 185, 174, 28);
		panel_1.add(textField_2);

		textField_2.addKeyListener(new KeyAdapter() {
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
		textField_2.setHorizontalAlignment(SwingConstants.LEFT);
		textField_2.setFont(new Font("Arial", Font.ITALIC, 13));
		textField_2.setColumns(20);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(46, 187, 59, 24);
		panel_1.add(lblPassword);
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setFont(new Font("Calibri", Font.PLAIN, 14));

		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setBounds(0, 226, 105, 24);
		panel_1.add(lblConfirmPassword);
		lblConfirmPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConfirmPassword.setFont(new Font("Calibri", Font.PLAIN, 14));

		JLabel label_1 = new JLabel("Username");
		label_1.setBounds(40, 148, 65, 24);
		panel_1.add(label_1);
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Calibri", Font.PLAIN, 14));

		textField = new JTextField();
		textField.setBounds(115, 146, 242, 28);
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
		lblEmail.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblEmail.setBounds(63, 109, 42, 24);
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
									out.writeObject(new Data(TypeData.REQUEST_SIGN,new DataUser(textField.getText(), 
											textField_2.getText().hashCode(), 
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
		textField_4.setBounds(115, 107, 242, 28);
		panel_1.add(textField_4);

		textField_1 = new JTextField();
		textField_1.setBounds(115, 68, 242, 28);
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
		lblFullName.setBounds(40, 70, 65, 24);
		panel_1.add(lblFullName);
		lblFullName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFullName.setFont(new Font("Calibri", Font.PLAIN, 14));

		JButton btnBack = new JButton("Cancel");
		btnBack.setBounds(205, 288, 115, 37);
		panel_1.add(btnBack);
		btnBack.setIcon(new ImageIcon("C:\\Users\\User\\ES1-2018-PL-90\\images\\error.png"));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Client.logFrame.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JButton btnSiginUp = new JButton("Sigin Up");
		btnSiginUp.setBounds(73, 288, 115, 37);
		panel_1.add(btnSiginUp);
		btnSiginUp.setIcon(new ImageIcon("C:\\Users\\User\\ES1-2018-PL-90\\images\\checked.png"));
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
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 21, 346, 397);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblSignupWindow = new JLabel("Register");
		lblSignupWindow.setIcon(new ImageIcon("C:\\Users\\User\\ES1-2018-PL-90\\images\\add-user (1).png"));
		lblSignupWindow.setBounds(26, 79, 289, 219);
		panel_2.add(lblSignupWindow);
		lblSignupWindow.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignupWindow.setForeground(SystemColor.activeCaption);
		lblSignupWindow.setFont(new Font("Mongolian Baiti", Font.BOLD, 36));
	}

}

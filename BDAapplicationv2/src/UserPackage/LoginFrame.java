package UserPackage;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;

import ComunPackage.Data;
import ComunPackage.DataUser;
import ComunPackage.TypeData;


public class LoginFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9221336562521229333L;

	public JTextField usernameField;
	public JPasswordField passwordField;
	@SuppressWarnings("unused")
	private ObjectOutputStream out;


	/**
	 * Create the frame.
	 * @param out 
	 */
	public LoginFrame(ObjectOutputStream out) {
		this.out=out;

		setTitle("BDAapplication");
		setResizable(false);
		setBounds(100, 100, 789, 478);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(SystemColor.textHighlightText);
		getContentPane().add(panel, BorderLayout.CENTER);

		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("C:\\Users\\User\\ES1-2018-PL-90\\images\\logo3.PNG"));
		label_2.setBounds(10, 163, 214, 78);
		panel.add(label_2);

		JLabel label_3 = new JLabel("Bom dia Academia");
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setForeground(new Color(255, 153, 0));
		label_3.setFont(new Font("Monotype Corsiva", Font.ITALIC, 24));
		label_3.setBackground(SystemColor.activeCaption);
		label_3.setBounds(138, 241, 159, 24);
		panel.add(label_3);

		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon("C:\\Users\\User\\ES1-2018-PL-90\\images\\isctelogo.PNG"));
		label_4.setBounds(0, 0, 159, 37);
		panel.add(label_4);

		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon("C:\\Users\\User\\ES1-2018-PL-90\\images\\logominsize.PNG"));
		label_5.setBounds(696, 0, 77, 22);
		panel.add(label_5);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new CompoundBorder());
		panel_1.setBounds(320, 23, 442, 404);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel label_1 = new JLabel("Username");
		label_1.setBounds(56, 133, 89, 28);
		panel_1.add(label_1);
		label_1.setForeground(SystemColor.infoText);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));

		JLabel label = new JLabel("Password");
		label.setBounds(56, 188, 89, 22);
		panel_1.add(label);
		label.setForeground(SystemColor.infoText);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));

		usernameField = new JTextField();
		usernameField.setBounds(157, 135, 244, 28);
		panel_1.add(usernameField);
		usernameField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					char[] v=passwordField.getPassword();
					String pwd=String.copyValueOf(v);

					if(!pwd.isEmpty() && !usernameField.getText().isEmpty()) {
						try {
							out.flush();
							out.writeObject(new Data(TypeData.REQUEST_LOG,new DataUser(usernameField.getText(),pwd.hashCode(), null,null)));
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					else
						JOptionPane.showMessageDialog(null,"Please complete all the fields!");
				}
			}
		});
		usernameField.setHorizontalAlignment(SwingConstants.LEFT);
		usernameField.setFont(new Font("Arial", Font.ITALIC, 12));
		usernameField.setColumns(20);

		passwordField = new JPasswordField();
		passwordField.setBounds(155, 183, 244, 28);
		panel_1.add(passwordField);
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()==KeyEvent.VK_ENTER) {
					char[] v=passwordField.getPassword();
					String pwd=String.copyValueOf(v);

					if(!pwd.isEmpty() && !usernameField.getText().isEmpty()) {
						try {
							out.flush();
							out.writeObject(new Data(TypeData.REQUEST_LOG,new DataUser(usernameField.getText(),pwd.hashCode(), null,null)));
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else
						JOptionPane.showMessageDialog(null,"Please complete all the fields!");	
				}
			}
		});
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JButton button = new JButton("Login");
		button.setBounds(204, 228, 112, 37);
		panel_1.add(button);


		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				char[] v=passwordField.getPassword();
				String pwd=String.copyValueOf(v);

				if(!pwd.isEmpty() && !usernameField.getText().isEmpty()) {
					try {
						out.flush();
						out.writeObject(new Data(TypeData.REQUEST_LOG,new DataUser(usernameField.getText(),pwd.hashCode(), null,null)));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else
					JOptionPane.showMessageDialog(null,"Please complete all the fields!");

			}
		});

		button.setInheritsPopupMenu(true);
		button.setIcon(new ImageIcon("C:\\Users\\User\\ES1-2018-PL-90\\images\\lock (1).png"));
		button.setHorizontalAlignment(SwingConstants.LEFT);
		button.setFont(new Font("Arial", Font.BOLD, 13));
		button.setBackground(UIManager.getColor("Button.background"));

		JLabel lblIfYouDo = new JLabel("If you do not have an account click on the button below");
		lblIfYouDo.setBounds(0, 297, 450, 14);
		panel_1.add(lblIfYouDo);
		lblIfYouDo.setForeground(SystemColor.infoText);
		lblIfYouDo.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		lblIfYouDo.setHorizontalAlignment(SwingConstants.CENTER);

		JButton btncreateAccount = new JButton("Create Account");
		btncreateAccount.setBounds(158, 322, 159, 37);
		panel_1.add(btncreateAccount);
		btncreateAccount.setForeground(SystemColor.textText);
		btncreateAccount.setIcon(new ImageIcon("C:\\Users\\User\\ES1-2018-PL-90\\images\\create account2.png"));
		btncreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Thread(new Runnable() {
					@Override
					public void run() {
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									setVisible(false);
									Client.siginUpFrame.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});						
					}
				}).start();

			}
		});
		btncreateAccount.setInheritsPopupMenu(true);
		btncreateAccount.setFont(new Font("Arial", Font.BOLD, 13));
		btncreateAccount.setBackground(UIManager.getColor("Button.background"));

		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setForeground(new Color(0, 102, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 62, 450, 28);
		panel_1.add(lblNewLabel);

	}

}

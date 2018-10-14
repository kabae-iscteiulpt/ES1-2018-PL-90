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
import ComunPackage.Data;
import ComunPackage.DataUser;
import ComunPackage.TypeData;

import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.DropMode;


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
		panel.setBackground(SystemColor.textHighlightText);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel label_4 = new JLabel("");
		label_4.setBounds(0, 0, 159, 37);
		label_4.setIcon(new ImageIcon("C:\\Users\\User\\ES1-2018-PL-90\\images\\isctelogo.PNG"));
		panel.add(label_4);

		JLabel label_5 = new JLabel("");
		label_5.setBounds(706, 0, 77, 22);
		label_5.setIcon(new ImageIcon("C:\\Users\\User\\ES1-2018-PL-90\\images\\logominsize.PNG"));
		panel.add(label_5);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(318, 33, 442, 369);
		panel_1.setBorder(new LineBorder(new Color(255, 255, 255), 8, true));
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel label_1 = new JLabel("Username");
		label_1.setBounds(56, 95, 89, 28);
		panel_1.add(label_1);
		label_1.setForeground(SystemColor.infoText);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Cambria", Font.ITALIC, 14));

		JLabel label = new JLabel("Password");
		label.setBounds(56, 150, 89, 22);
		panel_1.add(label);
		label.setForeground(SystemColor.infoText);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Cambria", Font.ITALIC, 14));

		usernameField = new JTextField();
		usernameField.setBounds(157, 97, 244, 28);
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
		passwordField.setBounds(155, 145, 244, 28);
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
		button.setBounds(165, 192, 112, 37);
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
		lblIfYouDo.setBounds(0, 259, 442, 14);
		panel_1.add(lblIfYouDo);
		lblIfYouDo.setForeground(SystemColor.infoText);
		lblIfYouDo.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		lblIfYouDo.setHorizontalAlignment(SwingConstants.CENTER);

		JButton btncreateAccount = new JButton("Create Account");
		btncreateAccount.setBounds(158, 284, 159, 37);
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
									Client.siginUpFrame.raiseTf();
									Client.siginUpFrame.hide();
									Client.siginUpFrame.raiseTf1();
									Client.siginUpFrame.raiseTf2();
									Client.siginUpFrame.raiseTf3();
									Client.siginUpFrame.raiseTf4();
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
		lblNewLabel.setBounds(0, 42, 442, 28);
		panel_1.add(lblNewLabel);

		JLabel labelLogo = new JLabel("");
		labelLogo.setBounds(13, 137, 209, 102);
		labelLogo.setIcon(new ImageIcon("C:\\Users\\User\\ES1-2018-PL-90\\images\\LogoSystem.PNG"));
		panel.add(labelLogo);

		JLabel label_3 = new JLabel("Bom dia Academia");
		label_3.setBounds(143, 244, 165, 24);
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setForeground(new Color(0, 153, 255));
		label_3.setFont(new Font("Monotype Corsiva", Font.ITALIC, 24));
		label_3.setBackground(SystemColor.activeCaption);
		panel.add(label_3);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 427, 783, 22);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JLabel animationLabel = new JLabel("Welcome to BDA System, Enjoy");
		animationLabel.setBounds(0, 0, 185, 22);
		panel_2.add(animationLabel);
		animationLabel.setForeground(new Color(0, 128, 128));
		animationLabel.setFont(new Font("Tahoma", Font.ITALIC, 13));


		new Thread(new Runnable() {

			@Override
			public void run() {
				int x=animationLabel.getLocation().x-animationLabel.getWidth();
				int y=animationLabel.getLocation().y;

				while(true) {
					x++;
					if(x>getWidth()){
						x=0-animationLabel.getWidth();
					}
					animationLabel.setLocation(x,y);

					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}


			}
		}).start();

	}
}

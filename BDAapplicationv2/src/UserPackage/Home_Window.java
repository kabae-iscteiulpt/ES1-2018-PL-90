package UserPackage;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Home_Window extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	@SuppressWarnings("unused")
	private ObjectOutputStream out;
	@SuppressWarnings("unused")
	private ObjectInputStream in;
	private JLabel lblNome;
	private JLabel lblNewLabel;
	

	/**
	 * Create the frame.
	 * @param out 
	 * @param in 
	 */
	public Home_Window(ObjectInputStream in, ObjectOutputStream out) {
		this.in=in;
		this.out=out;
		
		setTitle("BDAapplication");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 824, 445);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Home_Window.class.getResource("/Image/logominsize.PNG")));
		label.setBounds(713, 11, 75, 26);
		panel.add(label);
		
		JButton btnLogOf = new JButton("Logout");
		btnLogOf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Client.logFrame.passwordField.setText("");
				Client.logFrame.usernameField.setText("");
				Client.logFrame.setVisible(true);
			}
		});
		btnLogOf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogOf.setIcon(new ImageIcon(Home_Window.class.getResource("/Image/logout.png")));
		btnLogOf.setBounds(20, 342, 114, 43);
		panel.add(btnLogOf);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(Home_Window.class.getResource("/Image/tools.png")));
		button.setBounds(728, 342, 60, 43);
		panel.add(button);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 405, 320);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("");
		mntmNewMenuItem.setBounds(10, 117, 101, 192);
		panel_1.add(mntmNewMenuItem);
		mntmNewMenuItem.setHorizontalAlignment(SwingConstants.RIGHT);
		mntmNewMenuItem.setLayout(new GridLayout(3, 1));
		mntmNewMenuItem.add(new JButton("E-mail"));
		mntmNewMenuItem.add(new JButton("Facebook"));
		mntmNewMenuItem.add(new JButton("Twiter"));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(84, 11, 217, 83);
		panel_1.add(panel_2);
		panel_2.setForeground(new Color(51, 204, 51));
		panel_2.setLayout(null);
		
		lblNewLabel = new JLabel("Email");
		lblNewLabel.setBounds(0, 46, 217, 24);
		panel_2.add(lblNewLabel);
		
		lblNome = new JLabel("Username");
		lblNome.setBounds(0, 11, 217, 24);
		panel_2.add(lblNome);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel label_1 = new JLabel("");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setIcon(new ImageIcon(Home_Window.class.getResource("/Image/man-user.png")));
		label_1.setBounds(10, 11, 64, 83);
		panel_1.add(label_1);
	}
	
	public void setUserNameAndMail(String name, String email) {
		lblNome.setText(name);
		lblNewLabel.setText(email);
	}
}

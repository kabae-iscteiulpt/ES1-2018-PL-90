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
	private ObjectOutputStream out;
	private ObjectInputStream in;
	

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
		label.setIcon(new ImageIcon("C:\\Users\\User\\ES1-2018-PL-90\\images\\logominsize.PNG"));
		label.setBounds(713, 11, 75, 26);
		panel.add(label);
		
		JButton btnLogOf = new JButton("Logout");
		btnLogOf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Client.logFrame.setVisible(true);
				
			}
		});
		btnLogOf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogOf.setIcon(new ImageIcon("C:\\Users\\User\\ES1-2018-PL-90\\images\\logout.png"));
		btnLogOf.setBounds(10, 342, 124, 43);
		panel.add(btnLogOf);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon("C:\\Users\\User\\ES1-2018-PL-90\\images\\tools.png"));
		button.setBounds(728, 342, 60, 43);
		panel.add(button);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 124, 320);
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
		
		JLabel label_1 = new JLabel("");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setIcon(new ImageIcon("C:\\Users\\User\\ES1-2018-PL-90\\images\\user.png"));
		label_1.setBounds(10, 11, 101, 48);
		panel_1.add(label_1);
		
		JLabel lblNome = new JLabel("Name User");
		lblNome.setBounds(30, 56, 65, 14);
		panel_1.add(lblNome);
		
		JLabel lblNewLabel = new JLabel("E-mail User");
		lblNewLabel.setBounds(30, 82, 65, 14);
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setForeground(new Color(51, 204, 51));
		panel_2.setBounds(10, 11, 104, 95);
		panel_1.add(panel_2);
	}
}

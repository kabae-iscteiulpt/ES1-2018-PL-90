package version2;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;

public class Twitter extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9013544845906235859L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public Twitter() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Twitter.class.getResource("/Image/twitter.png")));
		setTitle("Twitter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 533, 362);
		getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("Retweet");
		btnNewButton.setIcon(new ImageIcon(Twitter.class.getResource("/Image/retweet-arrows-symbol.png")));
		btnNewButton.setBounds(175, 289, 321, 23);
		getContentPane().add(btnNewButton);

		textField = new JTextField();
		textField.setBounds(175, 59, 321, 20);
		getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(Twitter.class.getResource("/Image/back-arrow.png")));
		btnNewButton_1.setBounds(25, 59, 66, 23);
		getContentPane().add(btnNewButton_1);

		JLabel lblBomDiaAcademia = new JLabel("Bom dia Academia");
		lblBomDiaAcademia.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblBomDiaAcademia.setHorizontalAlignment(SwingConstants.CENTER);
		lblBomDiaAcademia.setBounds(25, 11, 482, 23);
		getContentPane().add(lblBomDiaAcademia);

		DefaultListModel<String> model = new DefaultListModel<String>();

		JList<String> list = new JList<String>();
		list.setBounds(25, 120, 135, 197);
		getContentPane().add(list);
		list.setModel(model);
		JLabel lblNewLabel = new JLabel("Tweet from: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(178, 37, 98, 14);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Tweet: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(175, 91, 117, 14);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("List of Tweets:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(25, 93, 82, 14);
		getContentPane().add(lblNewLabel_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(175, 120, 321, 164);
		getContentPane().add(scrollPane);

		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Twitter frame = new Twitter();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

package version2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;

public class GmailFrame extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private final JTextArea textArea = new JTextArea();
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GmailFrame frame = new GmailFrame();
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
	public GmailFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 671, 490);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(90, 75, 492, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(90, 106, 492, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblTo = new JLabel("To:");
		lblTo.setBounds(57, 78, 46, 14);
		getContentPane().add(lblTo);
		
		JLabel lblSubject = new JLabel("Subject:");
		lblSubject.setBounds(34, 109, 46, 14);
		getContentPane().add(lblSubject);
		
		JLabel lblContent = new JLabel("Content:");
		lblContent.setBounds(34, 182, 69, 25);
		getContentPane().add(lblContent);
		
		JButton btnSend = new JButton("Send");
		btnSend.setIcon(new ImageIcon("C:\\Users\\gsantos\\Downloads\\send-button.png"));
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSend.setBounds(90, 41, 107, 23);
		getContentPane().add(btnSend);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(90, 188, 492, 193);
		getContentPane().add(scrollPane);
		scrollPane.setViewportView(textArea);
		
		textField_2 = new JTextField();
		textField_2.setBounds(90, 137, 492, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblCc = new JLabel("Cc:");
		lblCc.setBounds(57, 140, 46, 14);
		getContentPane().add(lblCc);


	}
}

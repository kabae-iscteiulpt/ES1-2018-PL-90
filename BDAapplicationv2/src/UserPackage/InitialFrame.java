package UserPackage;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;


public class InitialFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -501092200125980243L;
	private JProgressBar barra;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JPanel jPanel1;
	private JLabel label_1;
	private JLabel label_2;
	private JPanel panel_1;


	/**
	 * Create the frame.
	 * @param out 
	 */
	public InitialFrame() {
		initComponents();
		animation();
	}


	private void animation() {

		new Thread (){
			public void run(){
				for(int i=0; i<101; i++){
					try {
						sleep(55);
						barra.setValue(i);

					} catch (InterruptedException ex) {
						Logger.getLogger(InitialFrame.class.getName()).log(Level.SEVERE, null, ex);
					}
				}
				dispose();

				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Client.logFrame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});

			}
		}.start();

	}
	private void initComponents() {
		jPanel1 = new JPanel();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		getContentPane().setLayout(null);

		jPanel1.setBackground(SystemColor.text);
		jPanel1.setBorder(new LineBorder(SystemColor.activeCaption, 1, true));
		jPanel1.setLayout(null);


		getContentPane().add(jPanel1);
		jPanel1.setBounds(0, 0, 560, 248);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(153, 180, 209), 1, true));
		panel.setBounds(0, 0, 560, 248);
		jPanel1.add(panel);
		panel.setLayout(null);

		label_1 = new JLabel("Bom dia Academia");
		label_1.setBounds(143, 118, 159, 24);
		panel.add(label_1);
		label_1.setBackground(UIManager.getColor("activeCaption"));
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setForeground(new Color(0, 153, 255));
		label_1.setFont(new Font("Monotype Corsiva", Font.ITALIC, 24));
		barra = new javax.swing.JProgressBar();
		barra.setBounds(13, 170, 537, 24);
		panel.add(barra);
		barra.setFont(new Font("Tahoma", Font.ITALIC, 11));

		barra.setBackground(new Color(230, 230, 250));
		barra.setForeground(new Color(0, 100, 0));
		barra.setMaximumSize(new java.awt.Dimension(32767, 20));
		barra.setMinimumSize(new java.awt.Dimension(10, 20));

		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(SystemColor.controlLtHighlight, 1, true));
		panel_1.setBackground(SystemColor.controlLtHighlight);
		panel_1.setBounds(10, 11, 303, 148);
		panel.add(panel_1);
		panel_1.setLayout(null);

		label_2 = new JLabel("");
		label_2.setBounds(10, 11, 209, 102);
		panel_1.add(label_2);
		label_2.setIcon(new ImageIcon(InitialFrame.class.getResource("/Image/LogoSystem.PNG")));
		jLabel3 = new javax.swing.JLabel();
		jLabel3.setBounds(10, 213, 150, 24);
		panel.add(jLabel3);
		jLabel3.setIcon(new ImageIcon(InitialFrame.class.getResource("/Image/copyright-symbol.png")));

		jLabel3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11)); // NOI18N
		jLabel3.setText("CopyRight@2018");
		jLabel4 = new javax.swing.JLabel();
		jLabel4.setBounds(480, 215, 70, 19);
		panel.add(jLabel4);

		jLabel4.setFont(new Font("Tahoma", Font.ITALIC, 13)); // NOI18N
		jLabel4.setText("Version 1.0");

		setSize(new Dimension(562, 248));
		setLocationRelativeTo(null);
		setVisible(true);
	}
}

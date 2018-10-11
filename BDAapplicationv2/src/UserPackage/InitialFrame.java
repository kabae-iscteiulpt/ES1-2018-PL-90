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
import javax.swing.border.CompoundBorder;


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
		barra = new javax.swing.JProgressBar();
		barra.setFont(new Font("Tahoma", Font.ITALIC, 11));
		jLabel3 = new javax.swing.JLabel();
		jLabel3.setIcon(new ImageIcon("C:\\Users\\User\\ES1-2018-PL-90\\images\\copyright-symbol.png"));
		jLabel4 = new javax.swing.JLabel();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		getContentPane().setLayout(null);

		jPanel1.setBackground(SystemColor.text);
		jPanel1.setBorder(new CompoundBorder());
		jPanel1.setLayout(null);

		barra.setBackground(new Color(230, 230, 250));
		barra.setForeground(new Color(0, 100, 0));
		barra.setMaximumSize(new java.awt.Dimension(32767, 20));
		barra.setMinimumSize(new java.awt.Dimension(10, 20));
		jPanel1.add(barra);
		barra.setBounds(10, 134, 537, 24);

		jLabel3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11)); // NOI18N
		jLabel3.setText("CopyRight@2018");
		jPanel1.add(jLabel3);
		jLabel3.setBounds(10, 195, 150, 24);

		jLabel4.setFont(new Font("Tahoma", Font.ITALIC, 13)); // NOI18N
		jLabel4.setText("Version 1.0");
		jPanel1.add(jLabel4);
		jLabel4.setBounds(477, 197, 70, 19);


		getContentPane().add(jPanel1);
		jPanel1.setBounds(0, 0, 560, 230);

		label_1 = new JLabel("Bom dia Academia");
		label_1.setBackground(UIManager.getColor("activeCaption"));
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setForeground(new Color(255, 153, 0));
		label_1.setFont(new Font("Monotype Corsiva", Font.ITALIC, 24));
		label_1.setBounds(141, 89, 204, 24);
		jPanel1.add(label_1);

		label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("C:\\Users\\User\\ES1-2018-PL-90\\images\\logo3.PNG"));
		label_2.setBounds(13, 11, 249, 78);
		jPanel1.add(label_2);

		setSize(new Dimension(562, 230));
		setLocationRelativeTo(null);
		setVisible(true);
	}


}

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PersContactEditor extends JFrame {

	private JPanel contentPane;
	private JTable tblPers;
	private JTextField tfFirstNamePers;
	private JTextField tfLastNamePers;
	private JTextField tfEmailPers;
	private JTextField tfPhonePers;
	private JTextField tfAdressLine1Pers;
	private JTextField tfAdressLine2Pers;
	private JTextField tfPostcodePers;
	private JTextField tfCountryPers;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersContactEditor frame = new PersContactEditor();
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
	public PersContactEditor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 896, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane spGridPers = new JScrollPane();
		DbConn d=new  DbConn();
		JButton btnRefreshPers = new JButton("Refresh");
		btnRefreshPers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tblPers.setModel (DbUtils.resultSetToTableModel(d.getAllPersonal()));
			}
		});
		btnRefreshPers.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		tfFirstNamePers = new JTextField();
		tfFirstNamePers.setColumns(10);
		
		tfLastNamePers = new JTextField();
		tfLastNamePers.setColumns(10);
		
		tfEmailPers = new JTextField();
		tfEmailPers.setColumns(10);
		
		tfPhonePers = new JTextField();
		tfPhonePers.setColumns(10);
		
		tfAdressLine1Pers = new JTextField();
		tfAdressLine1Pers.setColumns(10);
		
		tfAdressLine2Pers = new JTextField();
		tfAdressLine2Pers.setColumns(10);
		
		tfPostcodePers = new JTextField();
		tfPostcodePers.setColumns(10);
		
		tfCountryPers = new JTextField();
		tfCountryPers.setColumns(10);
		
		JLabel lblFirstNamePers = new JLabel("First Name");
		
		JLabel lblLastNamePers = new JLabel("Last Name");
		
		JLabel lblEmailPers = new JLabel("Email");
		
		JLabel lblPhonePers = new JLabel("Phone number");
		
		JLabel lblAdressLine1Pers = new JLabel("Adress Line 1");
		
		JLabel lblAdressLine2Pers = new JLabel("Adress Line 2");
		
		JLabel lblPostcodePers = new JLabel("Postcode");
		
		JLabel lblCountryPers = new JLabel("Country");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblFirstNamePers, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
								.addComponent(lblLastNamePers, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblEmailPers, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblPhonePers, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(tfPhonePers, Alignment.LEADING)
									.addComponent(tfEmailPers, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE))
								.addComponent(tfFirstNamePers, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(tfLastNamePers, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(58)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblAdressLine2Pers, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
								.addComponent(lblAdressLine1Pers, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblPostcodePers, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblCountryPers, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(tfPostcodePers, GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
								.addComponent(tfAdressLine2Pers, GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
								.addComponent(tfAdressLine1Pers, GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
								.addComponent(tfCountryPers, GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE))
							.addGap(195))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnRefreshPers, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
							.addGap(29))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(spGridPers, GroupLayout.DEFAULT_SIZE, 858, Short.MAX_VALUE)
							.addContainerGap())))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(tfAdressLine1Pers, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAdressLine1Pers))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(tfAdressLine2Pers, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAdressLine2Pers))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(tfPostcodePers, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPostcodePers))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(tfCountryPers, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCountryPers)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(tfFirstNamePers, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblFirstNamePers))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(tfLastNamePers, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblLastNamePers))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(tfEmailPers, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEmailPers))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(tfPhonePers, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPhonePers))))
					.addGap(76)
					.addComponent(btnRefreshPers)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(spGridPers, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		tblPers = new JTable();
		spGridPers.setViewportView(tblPers);
		contentPane.setLayout(gl_contentPane);
	}
}

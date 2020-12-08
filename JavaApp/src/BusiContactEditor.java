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
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BusiContactEditor extends JFrame {

	private JPanel contentPane;
	private JTable tblBusi;
	private JTextField tfFirstNameBusi;
	private JTextField tfLastNameBusi;
	private JTextField tfEmailBusi;
	private JTextField tfPhoneBusi;
	private JTextField tfCompanyBusi;
	private JTextField tfAddressLine1Busi;
	private JTextField tfAddressLine2Busi;
	private JTextField tfPostcodeBusi;
	private JTextField tfCountryBusi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BusiContactEditor frame = new BusiContactEditor();
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
	public BusiContactEditor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 895, 552);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane spGridBusi = new JScrollPane();
		spGridBusi.setBounds(10, 271, 861, 233);
		contentPane.add(spGridBusi);
		
		tblBusi = new JTable();
		spGridBusi.setViewportView(tblBusi);
		
		DbConn d=new  DbConn();
		JButton btnRefreshBusi = new JButton("Refresh");
		btnRefreshBusi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tblBusi.setModel (DbUtils.resultSetToTableModel(d.getAllBusiness()));
			}
		});
		btnRefreshBusi.setBounds(724, 229, 98, 31);
		contentPane.add(btnRefreshBusi);
		
		tfFirstNameBusi = new JTextField();
		tfFirstNameBusi.setBounds(112, 11, 96, 20);
		contentPane.add(tfFirstNameBusi);
		tfFirstNameBusi.setColumns(10);
		
		tfLastNameBusi = new JTextField();
		tfLastNameBusi.setBounds(112, 42, 96, 20);
		contentPane.add(tfLastNameBusi);
		tfLastNameBusi.setColumns(10);
		
		tfEmailBusi = new JTextField();
		tfEmailBusi.setBounds(112, 104, 199, 20);
		contentPane.add(tfEmailBusi);
		tfEmailBusi.setColumns(10);
		
		tfPhoneBusi = new JTextField();
		tfPhoneBusi.setBounds(112, 135, 199, 20);
		contentPane.add(tfPhoneBusi);
		tfPhoneBusi.setColumns(10);
		
		tfCompanyBusi = new JTextField();
		tfCompanyBusi.setBounds(463, 135, 199, 20);
		contentPane.add(tfCompanyBusi);
		tfCompanyBusi.setColumns(10);
		
		tfAddressLine1Busi = new JTextField();
		tfAddressLine1Busi.setBounds(463, 11, 199, 20);
		contentPane.add(tfAddressLine1Busi);
		tfAddressLine1Busi.setColumns(10);
		
		tfAddressLine2Busi = new JTextField();
		tfAddressLine2Busi.setBounds(463, 42, 199, 20);
		contentPane.add(tfAddressLine2Busi);
		tfAddressLine2Busi.setColumns(10);
		
		tfPostcodeBusi = new JTextField();
		tfPostcodeBusi.setBounds(463, 73, 199, 20);
		contentPane.add(tfPostcodeBusi);
		tfPostcodeBusi.setColumns(10);
		
		tfCountryBusi = new JTextField();
		tfCountryBusi.setBounds(463, 104, 199, 20);
		contentPane.add(tfCountryBusi);
		tfCountryBusi.setColumns(10);
		
		JLabel lbFristNameBusi = new JLabel("Frist Name");
		lbFristNameBusi.setBounds(10, 14, 71, 14);
		contentPane.add(lbFristNameBusi);
		
		JLabel lbLastNameBusi = new JLabel("Last Name");
		lbLastNameBusi.setBounds(10, 45, 71, 14);
		contentPane.add(lbLastNameBusi);
		
		JLabel lblEmailBusi = new JLabel("Email");
		lblEmailBusi.setBounds(10, 107, 71, 14);
		contentPane.add(lblEmailBusi);
		
		JLabel lblPhoneBusi = new JLabel("Business Phone num.");
		lblPhoneBusi.setBounds(10, 138, 110, 14);
		contentPane.add(lblPhoneBusi);
		
		JLabel lblAddressLine1Busi = new JLabel("Address Line 1");
		lblAddressLine1Busi.setBounds(376, 14, 77, 14);
		contentPane.add(lblAddressLine1Busi);
		
		JLabel lblAddressLine2Busi = new JLabel("Address Line 2");
		lblAddressLine2Busi.setBounds(376, 45, 77, 14);
		contentPane.add(lblAddressLine2Busi);
		
		JLabel lblPostcodeBusi = new JLabel("Postcode");
		lblPostcodeBusi.setBounds(376, 76, 77, 14);
		contentPane.add(lblPostcodeBusi);
		
		JLabel lblCountryBusi = new JLabel("Country");
		lblCountryBusi.setBounds(376, 107, 77, 14);
		contentPane.add(lblCountryBusi);
		
		JLabel lblCompanyBusi = new JLabel("Company");
		lblCompanyBusi.setBounds(376, 138, 77, 14);
		contentPane.add(lblCompanyBusi);
	}
}

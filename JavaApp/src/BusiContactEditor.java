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
	private JTextField tfAddressLine1Busi;
	private JTextField tfAddressLine2Busi;
	private JTextField tfPostcodeBusi;
	private JTextField tfCountryBusi;
	private JButton btnUpdateSelBusi;
	private JButton btnSaveSelBusi;
	private JButton btnDeleteSelBusi;
	private JButton btnAddNewBusi;
	private JButton btnSaveNewBusi;
	private JTextField tfCompanyBusi;
	private JLabel lblCompanyBusi;

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
		setBounds(100, 100, 1008, 561);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane spGridBusi = new JScrollPane();
		spGridBusi.setBounds(10, 271, 984, 242);
		contentPane.add(spGridBusi);
		/*
		 * on click populates the text fields with the data from selected tblBusi row
		 */
		tblBusi = new JTable();
		tblBusi.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				tfFirstNameBusi.setText(tblBusi.getValueAt(tblBusi.getSelectedRow(),1).toString());
				tfLastNameBusi.setText(tblBusi.getValueAt(tblBusi.getSelectedRow(),2).toString());
				tfEmailBusi.setText(tblBusi.getValueAt(tblBusi.getSelectedRow(),3).toString());
				tfAddressLine1Busi.setText(tblBusi.getValueAt(tblBusi.getSelectedRow(),5).toString());
				tfAddressLine2Busi.setText(tblBusi.getValueAt(tblBusi.getSelectedRow(),6).toString());
				tfPostcodeBusi.setText(tblBusi.getValueAt(tblBusi.getSelectedRow(),7).toString());
				tfCountryBusi.setText(tblBusi.getValueAt(tblBusi.getSelectedRow(),8).toString());
				tfCompanyBusi.setText(tblBusi.getValueAt(tblBusi.getSelectedRow(),9).toString());
				tfPhoneBusi.setText(tblBusi.getValueAt(tblBusi.getSelectedRow(),10).toString());
			}
		});
		spGridBusi.setViewportView(tblBusi);
		/*
		 * on click populates/updates the tblBusi with data retrieved from the database using the method getAllBusiness
		 */
		DbConn d=new  DbConn();
		JButton btnRefreshBusi = new JButton("Refresh");
		btnRefreshBusi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tblBusi.setModel (DbUtils.resultSetToTableModel(d.getAllBusiness()));
			}
		});
		btnRefreshBusi.setBounds(800, 229, 98, 31);
		contentPane.add(btnRefreshBusi);
		
		tfFirstNameBusi = new JTextField();
		tfFirstNameBusi.setEnabled(false);
		tfFirstNameBusi.setBounds(147, 11, 96, 20);
		contentPane.add(tfFirstNameBusi);
		tfFirstNameBusi.setColumns(10);
		
		tfLastNameBusi = new JTextField();
		tfLastNameBusi.setEnabled(false);
		tfLastNameBusi.setBounds(147, 42, 96, 20);
		contentPane.add(tfLastNameBusi);
		tfLastNameBusi.setColumns(10);
		
		tfEmailBusi = new JTextField();
		tfEmailBusi.setEnabled(false);
		tfEmailBusi.setBounds(147, 104, 199, 20);
		contentPane.add(tfEmailBusi);
		tfEmailBusi.setColumns(10);
		
		tfPhoneBusi = new JTextField();
		tfPhoneBusi.setEnabled(false);
		tfPhoneBusi.setBounds(147, 135, 199, 20);
		contentPane.add(tfPhoneBusi);
		tfPhoneBusi.setColumns(10);
		
		tfAddressLine1Busi = new JTextField();
		tfAddressLine1Busi.setEnabled(false);
		tfAddressLine1Busi.setBounds(463, 11, 199, 20);
		contentPane.add(tfAddressLine1Busi);
		tfAddressLine1Busi.setColumns(10);
		
		tfAddressLine2Busi = new JTextField();
		tfAddressLine2Busi.setEnabled(false);
		tfAddressLine2Busi.setBounds(463, 42, 199, 20);
		contentPane.add(tfAddressLine2Busi);
		tfAddressLine2Busi.setColumns(10);
		
		tfPostcodeBusi = new JTextField();
		tfPostcodeBusi.setEnabled(false);
		tfPostcodeBusi.setBounds(463, 73, 199, 20);
		contentPane.add(tfPostcodeBusi);
		tfPostcodeBusi.setColumns(10);
		
		tfCountryBusi = new JTextField();
		tfCountryBusi.setEnabled(false);
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
		lblPhoneBusi.setBounds(10, 138, 127, 14);
		contentPane.add(lblPhoneBusi);
		
		JLabel lblAddressLine1Busi = new JLabel("Address Line 1");
		lblAddressLine1Busi.setBounds(356, 14, 97, 14);
		contentPane.add(lblAddressLine1Busi);
		
		JLabel lblAddressLine2Busi = new JLabel("Address Line 2");
		lblAddressLine2Busi.setBounds(356, 45, 97, 14);
		contentPane.add(lblAddressLine2Busi);
		
		JLabel lblPostcodeBusi = new JLabel("Postcode");
		lblPostcodeBusi.setBounds(356, 76, 97, 14);
		contentPane.add(lblPostcodeBusi);
		
		JLabel lblCountryBusi = new JLabel("Country");
		lblCountryBusi.setBounds(356, 107, 97, 14);
		contentPane.add(lblCountryBusi);
		/*
		 * on click toggles all the required buttons and text fields used to update selected business contact
		 * populates/updates the tblBusi with data retrieved from the database
		 */
		btnUpdateSelBusi = new JButton("Update Selected");
		btnUpdateSelBusi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnSaveNewBusi.setEnabled(false);
				btnAddNewBusi.setEnabled(false);
				btnDeleteSelBusi.setEnabled(false);
				btnSaveSelBusi.setEnabled(true);
				btnUpdateSelBusi.setEnabled(false);
				tfFirstNameBusi.setEnabled(true);
				tfLastNameBusi.setEnabled(true);
				tfEmailBusi.setEnabled(true);
				tfPhoneBusi.setEnabled(true);
				tfAddressLine1Busi.setEnabled(true);
				tfAddressLine2Busi.setEnabled(true);
				tfPostcodeBusi.setEnabled(true);
				tfCountryBusi.setEnabled(true);
				tfCompanyBusi.setEnabled(true);
				
				tblBusi.setModel (DbUtils.resultSetToTableModel(d.getAllBusiness()));
			}
		});
		btnUpdateSelBusi.setBounds(699, 10, 135, 23);
		contentPane.add(btnUpdateSelBusi);
		/*
		 * on click toggles all the required buttons and text fields used to save selected business contact
		 */
		btnSaveSelBusi = new JButton("Save Selected");
		btnSaveSelBusi.setEnabled(false);
		btnSaveSelBusi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String id=tblBusi.getValueAt(tblBusi.getSelectedRow(), 0).toString();
				String first_name=tfFirstNameBusi.getText();
				String last_name=tfLastNameBusi.getText();
				String email=tfEmailBusi.getText();
				String business_phone_number=tfPhoneBusi.getText();
				String address_line_1=tfAddressLine1Busi.getText();
				String address_line_2=tfAddressLine2Busi.getText();
				String postcode=tfPostcodeBusi.getText();
				String country=tfCountryBusi.getText();
				String company=tfCompanyBusi.getText();
				
				d.UpdateBusiness(id,first_name,last_name,email,address_line_1,address_line_2,postcode,country,company,business_phone_number);
				
				btnSaveNewBusi.setEnabled(false);
				btnAddNewBusi.setEnabled(true);
				btnDeleteSelBusi.setEnabled(true);
				btnSaveSelBusi.setEnabled(false);
				btnUpdateSelBusi.setEnabled(true);
				tfFirstNameBusi.setEnabled(false);
				tfLastNameBusi.setEnabled(false);
				tfEmailBusi.setEnabled(false);
				tfPhoneBusi.setEnabled(false);
				tfAddressLine1Busi.setEnabled(false);
				tfAddressLine2Busi.setEnabled(false);
				tfPostcodeBusi.setEnabled(false);
				tfCountryBusi.setEnabled(false);
				tfCompanyBusi.setEnabled(false);
				
				tblBusi.setModel (DbUtils.resultSetToTableModel(d.getAllBusiness()));
			}
		});
		btnSaveSelBusi.setBounds(699, 41, 135, 23);
		contentPane.add(btnSaveSelBusi);
		/*
		 * on click deletes selected business contact from the database
		 */
		btnDeleteSelBusi = new JButton("Delete Selected");
		btnDeleteSelBusi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String id=tblBusi.getValueAt(tblBusi.getSelectedRow(), 0).toString();	
				d.DeleteBusiness(id);
				tblBusi.setModel (DbUtils.resultSetToTableModel(d.getAllBusiness()));
			}
		});
		btnDeleteSelBusi.setBounds(699, 72, 135, 23);
		contentPane.add(btnDeleteSelBusi);
		/*
		 * on click toggles all the required buttons and text fields used to add new business contact
		 */
		btnAddNewBusi = new JButton("Add New");
		btnAddNewBusi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnSaveNewBusi.setEnabled(true);
				btnAddNewBusi.setEnabled(false);
				btnDeleteSelBusi.setEnabled(false);
				btnSaveSelBusi.setEnabled(false);
				btnUpdateSelBusi.setEnabled(false);
				tfFirstNameBusi.setEnabled(true);
				tfLastNameBusi.setEnabled(true);
				tfEmailBusi.setEnabled(true);
				tfPhoneBusi.setEnabled(true);
				tfAddressLine1Busi.setEnabled(true);
				tfAddressLine2Busi.setEnabled(true);
				tfPostcodeBusi.setEnabled(true);
				tfCountryBusi.setEnabled(true);
				tfCompanyBusi.setEnabled(true);
				tblBusi.setModel (DbUtils.resultSetToTableModel(d.getAllBusiness()));
			}
		});
		btnAddNewBusi.setBounds(877, 10, 107, 23);
		contentPane.add(btnAddNewBusi);
		/*
		 * on click toggles all the required buttons and text fields used to save new business contact
		 * saves contacts in the database
		 * reloads the data in the tblBusi
		 */
		btnSaveNewBusi = new JButton("Save New");
		btnSaveNewBusi.setEnabled(false);
		btnSaveNewBusi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnSaveNewBusi.setEnabled(false);
				btnAddNewBusi.setEnabled(true);
				btnDeleteSelBusi.setEnabled(true);
				btnSaveSelBusi.setEnabled(false);
				btnUpdateSelBusi.setEnabled(true);
				tfFirstNameBusi.setEnabled(false);
				tfLastNameBusi.setEnabled(false);
				tfEmailBusi.setEnabled(false);
				tfPhoneBusi.setEnabled(false);
				tfAddressLine1Busi.setEnabled(false);
				tfAddressLine2Busi.setEnabled(false);
				tfPostcodeBusi.setEnabled(false);
				tfCountryBusi.setEnabled(false);
				tfCompanyBusi.setEnabled(false);
				
				String first_name=tfFirstNameBusi.getText();
				String last_name=tfLastNameBusi.getText();
				String email=tfEmailBusi.getText();
				String business_phone_number=tfPhoneBusi.getText();
				String address_line_1=tfAddressLine1Busi.getText();
				String address_line_2=tfAddressLine2Busi.getText();
				String postcode=tfPostcodeBusi.getText();
				String country=tfCountryBusi.getText();
				String company=tfCompanyBusi.getText();
				
				d.InsertBusiness(first_name, last_name, email, address_line_1, address_line_2, postcode, country, company, business_phone_number);
				tblBusi.setModel (DbUtils.resultSetToTableModel(d.getAllBusiness()));
			
			}
		});
		btnSaveNewBusi.setBounds(877, 41, 107, 23);
		contentPane.add(btnSaveNewBusi);
		
		tfCompanyBusi = new JTextField();
		tfCompanyBusi.setEnabled(false);
		tfCompanyBusi.setBounds(463, 135, 199, 20);
		contentPane.add(tfCompanyBusi);
		tfCompanyBusi.setColumns(10);
		
		lblCompanyBusi = new JLabel("Company");
		lblCompanyBusi.setBounds(356, 138, 97, 14);
		contentPane.add(lblCompanyBusi);
	}
}

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
		/*
		 * on click populates/updates the tblPers with data retrieved from the database using the method getAllPersonal
		 */
		JButton btnRefreshPers = new JButton("Refresh");
		btnRefreshPers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tblPers.setModel (DbUtils.resultSetToTableModel(d.getAllPersonal()));
			}
		});
		btnRefreshPers.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		tfFirstNamePers = new JTextField();
		tfFirstNamePers.setEnabled(false);
		tfFirstNamePers.setColumns(10);
		
		tfLastNamePers = new JTextField();
		tfLastNamePers.setEnabled(false);
		tfLastNamePers.setColumns(10);
		
		tfEmailPers = new JTextField();
		tfEmailPers.setEnabled(false);
		tfEmailPers.setColumns(10);
		
		tfPhonePers = new JTextField();
		tfPhonePers.setEnabled(false);
		tfPhonePers.setColumns(10);
		
		tfAdressLine1Pers = new JTextField();
		tfAdressLine1Pers.setEnabled(false);
		tfAdressLine1Pers.setColumns(10);
		
		tfAdressLine2Pers = new JTextField();
		tfAdressLine2Pers.setEnabled(false);
		tfAdressLine2Pers.setColumns(10);
		
		tfPostcodePers = new JTextField();
		tfPostcodePers.setEnabled(false);
		tfPostcodePers.setColumns(10);
		
		tfCountryPers = new JTextField();
		tfCountryPers.setEnabled(false);
		tfCountryPers.setColumns(10);
		
		JLabel lblFirstNamePers = new JLabel("First Name");
		
		JLabel lblLastNamePers = new JLabel("Last Name");
		
		JLabel lblEmailPers = new JLabel("Email");
		
		JLabel lblPhonePers = new JLabel("Phone number");
		
		JLabel lblAdressLine1Pers = new JLabel("Adress Line 1");
		
		JLabel lblAdressLine2Pers = new JLabel("Adress Line 2");
		
		JLabel lblPostcodePers = new JLabel("Postcode");
		
		JLabel lblCountryPers = new JLabel("Country");

		JButton btnSaveSelPers = new JButton("Save Selected");

		btnSaveSelPers.setEnabled(false);
		
		JButton btnDeleteSelPers = new JButton("Delete Selected");

		
		JButton btnAddNewPers = new JButton("Add New");

		
		JButton btnSaveNewPers = new JButton("Save New");
		
		btnSaveNewPers.setEnabled(false);
		
		JButton btnUpdateSelPers = new JButton("Update Selelected");

		

		/*
		 * on click populates the text fields with the data from selected tblPers row 
		 */
		tblPers = new JTable();
		tblPers.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				tfFirstNamePers.setText(tblPers.getValueAt(tblPers.getSelectedRow(),1).toString());
				tfLastNamePers.setText(tblPers.getValueAt(tblPers.getSelectedRow(),2).toString());
				tfEmailPers.setText(tblPers.getValueAt(tblPers.getSelectedRow(),3).toString());
				tfPhonePers.setText(tblPers.getValueAt(tblPers.getSelectedRow(),4).toString());
				tfAdressLine1Pers.setText(tblPers.getValueAt(tblPers.getSelectedRow(),5).toString());
				tfAdressLine2Pers.setText(tblPers.getValueAt(tblPers.getSelectedRow(),6).toString());
				tfPostcodePers.setText(tblPers.getValueAt(tblPers.getSelectedRow(),7).toString());
				tfCountryPers.setText(tblPers.getValueAt(tblPers.getSelectedRow(),8).toString());
			}
		});
		spGridPers.setViewportView(tblPers);
		
		/*
		 * on click deletes selected business contact from the database
		 */
		btnDeleteSelPers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			String id=tblPers.getValueAt(tblPers.getSelectedRow(), 0).toString();	
			d.DeletePersonal(id);
			tblPers.setModel (DbUtils.resultSetToTableModel(d.getAllPersonal()));
			}
		});
		
		/*
		 * on click toggles all the required buttons and text fields used to save new personal contact
		 * saves contacts in the database
		 * reloads the data in the tblPers
		 */
		btnSaveNewPers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnSaveNewPers.setEnabled(false);
				btnAddNewPers.setEnabled(true);
				btnDeleteSelPers.setEnabled(true);
				btnSaveSelPers.setEnabled(false);
				btnUpdateSelPers.setEnabled(true);
				tfFirstNamePers.setEnabled(false);
				tfLastNamePers.setEnabled(false);
				tfEmailPers.setEnabled(false);
				tfPhonePers.setEnabled(false);
				tfAdressLine1Pers.setEnabled(false);
				tfAdressLine2Pers.setEnabled(false);
				tfPostcodePers.setEnabled(false);
				tfCountryPers.setEnabled(false);
				
				String first_name=tfFirstNamePers.getText();
				String last_name=tfLastNamePers.getText();
				String email=tfEmailPers.getText();
				String phone_number=tfPhonePers.getText();
				String address_line_1=tfAdressLine1Pers.getText();
				String address_line_2=tfAdressLine2Pers.getText();
				String postcode=tfPostcodePers.getText();
				String country=tfCountryPers.getText();
				
				d.InsertPersonal(first_name,last_name,email,phone_number,address_line_1,address_line_2,postcode,country);
				tblPers.setModel (DbUtils.resultSetToTableModel(d.getAllPersonal()));
				
			}
		});
		
		/*
		 * on click toggles all the required buttons and text fields used to add new personal contact
		 */
		btnAddNewPers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnSaveNewPers.setEnabled(true);
				btnAddNewPers.setEnabled(false);
				btnDeleteSelPers.setEnabled(false);
				btnSaveSelPers.setEnabled(false);
				btnUpdateSelPers.setEnabled(false);
				tfFirstNamePers.setEnabled(true);
				tfLastNamePers.setEnabled(true);
				tfEmailPers.setEnabled(true);
				tfPhonePers.setEnabled(true);
				tfAdressLine1Pers.setEnabled(true);
				tfAdressLine2Pers.setEnabled(true);
				tfPostcodePers.setEnabled(true);
				tfCountryPers.setEnabled(true);
				
				tblPers.setModel (DbUtils.resultSetToTableModel(d.getAllPersonal()));
				
				
			}
		});
		
		/*
		 * on click toggles all the required buttons and text fields used to update selected personal contact
		 */
		btnUpdateSelPers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnSaveNewPers.setEnabled(false);
				btnAddNewPers.setEnabled(false);
				btnDeleteSelPers.setEnabled(false);
				btnSaveSelPers.setEnabled(true);
				btnUpdateSelPers.setEnabled(false);
				tfFirstNamePers.setEnabled(true);
				tfLastNamePers.setEnabled(true);
				tfEmailPers.setEnabled(true);
				tfPhonePers.setEnabled(true);
				tfAdressLine1Pers.setEnabled(true);
				tfAdressLine2Pers.setEnabled(true);
				tfPostcodePers.setEnabled(true);
				tfCountryPers.setEnabled(true);
				
				tblPers.setModel (DbUtils.resultSetToTableModel(d.getAllPersonal()));
				
			}
		});
		/*
		 * on click toggles all the required buttons and text fields used to save selected personal contact
		 * saves the updated contacts in the database
		 * reloads the data in the tblPers
		 */
		btnSaveSelPers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String id=tblPers.getValueAt(tblPers.getSelectedRow(), 0).toString();
				String first_name=tfFirstNamePers.getText();
				String last_name=tfLastNamePers.getText();
				String email=tfEmailPers.getText();
				String phone_number=tfPhonePers.getText();
				String address_line_1=tfAdressLine1Pers.getText();
				String address_line_2=tfAdressLine2Pers.getText();
				String postcode=tfPostcodePers.getText();
				String country=tfCountryPers.getText();
				d.UpdatePersonal(id,first_name,last_name,email,phone_number,address_line_1,address_line_2,postcode,country);
				btnSaveNewPers.setEnabled(false);
				btnAddNewPers.setEnabled(true);
				btnDeleteSelPers.setEnabled(true);
				btnSaveSelPers.setEnabled(false);
				btnUpdateSelPers.setEnabled(true);
				tfFirstNamePers.setEnabled(false);
				tfLastNamePers.setEnabled(false);
				tfEmailPers.setEnabled(false);
				tfPhonePers.setEnabled(false);
				tfAdressLine1Pers.setEnabled(false);
				tfAdressLine2Pers.setEnabled(false);
				tfPostcodePers.setEnabled(false);
				tfCountryPers.setEnabled(false);
				
				tblPers.setModel (DbUtils.resultSetToTableModel(d.getAllPersonal()));
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addComponent(lblFirstNamePers, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(tfFirstNamePers, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(123)
							.addComponent(lblAdressLine1Pers, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(tfAdressLine1Pers, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
							.addGap(43)
							.addComponent(btnUpdateSelPers, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnAddNewPers, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblLastNamePers, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEmailPers, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
							.addGap(4)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(tfLastNamePers, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(tfEmailPers, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE))
							.addGap(58)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblAdressLine2Pers, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPostcodePers, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(tfAdressLine2Pers, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
								.addComponent(tfPostcodePers, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE))
							.addGap(43)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnSaveSelPers, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnSaveNewPers, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addComponent(btnDeleteSelPers, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addComponent(lblPhonePers, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(tfPhonePers, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
							.addGap(58)
							.addComponent(lblCountryPers, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(tfCountryPers, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(586)
							.addComponent(btnRefreshPers, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addComponent(spGridPers, GroupLayout.PREFERRED_SIZE, 862, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblFirstNamePers))
						.addComponent(tfFirstNamePers, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addComponent(lblAdressLine1Pers))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(tfAdressLine1Pers, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnUpdateSelPers)
							.addComponent(btnAddNewPers)))
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(12)
							.addComponent(lblLastNamePers)
							.addGap(24)
							.addComponent(lblEmailPers))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(9)
							.addComponent(tfLastNamePers, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(tfEmailPers, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(15)
							.addComponent(lblAdressLine2Pers)
							.addGap(21)
							.addComponent(lblPostcodePers))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(12)
							.addComponent(tfAdressLine2Pers, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(15)
							.addComponent(tfPostcodePers, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnSaveSelPers)
								.addComponent(btnSaveNewPers))
							.addGap(6)
							.addComponent(btnDeleteSelPers)))
					.addGap(15)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(9)
							.addComponent(lblPhonePers))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(tfPhonePers, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addComponent(lblCountryPers))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(tfCountryPers, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
					.addComponent(btnRefreshPers)
					.addGap(11)
					.addComponent(spGridPers, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}

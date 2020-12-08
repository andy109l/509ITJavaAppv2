import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JavaContactManager {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JavaContactManager window = new JavaContactManager();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JavaContactManager() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 618, 385);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnPersConctats = new JButton("Personal Contacts");
		btnPersConctats.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PersContactEditor windp=new PersContactEditor ();
				frame.dispose();
				windp.setVisible(true);
			}
		});
		btnPersConctats.setFont(new Font("Arial", Font.PLAIN, 12));
		btnPersConctats.setBounds(101, 159, 140, 41);
		frame.getContentPane().add(btnPersConctats);
		
		JButton btnNewButton_1 = new JButton("Business Contacts");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BusiContactEditor windb=new BusiContactEditor ();
				frame.dispose();
				windb.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNewButton_1.setBounds(336, 159, 140, 41);
		frame.getContentPane().add(btnNewButton_1);
	}
}

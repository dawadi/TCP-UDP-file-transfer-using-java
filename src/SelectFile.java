/**
 * TCP select file
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class SelectFile extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblInsertPort;
	private JButton btnSend;
	private JFileChooser file= new JFileChooser();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectFile frame = new SelectFile();
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
	public SelectFile() {
		validate();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(148, 53, 134, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblIp = new JLabel("Insert IP");
		lblIp.setBounds(79, 59, 74, 16);
		contentPane.add(lblIp);
		
		textField_1 = new JTextField();
		textField_1.setBounds(148, 85, 134, 28);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		lblInsertPort = new JLabel("Insert Port");
		lblInsertPort.setBounds(79, 91, 74, 16);
		
		
	
		contentPane.add(lblInsertPort);
		
		
		JLabel lblSelectFileTo = new JLabel("Select File To Send (TCP)");
		lblSelectFileTo.setBounds(92, 6, 190, 16);
		contentPane.add(lblSelectFileTo);
		
		final JButton btnOpen = new JButton("Open");
		btnOpen.setBounds(148, 125, 117, 29);
		
		
		btnOpen.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				file.showOpenDialog(btnOpen);
				
			}
			
		});
		
		
		contentPane.add(btnOpen);
		
		btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				File selectedFile = file.getSelectedFile();
				clientAction x= new clientAction();
				try {
					x.clientRequest(textField.getText(),textField_1.getText(),selectedFile);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		btnSend.setBounds(312, 229, 117, 29);
		contentPane.add(btnSend);
	}
}

/**
 *@author feisalsalim 
 *SID:824317549
 **/
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JButton;

public class GuiApplication extends JFrame {

	/**This application creates a bak file for a file using tcp or udp protocols
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JRadioButton rb1;
	public JRadioButton rdbtnSavefileUdp;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiApplication frame = new GuiApplication();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Creates the frame.
	 */
	public GuiApplication() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		rb1= new JRadioButton("saveFile TCP");
		rb1.setBounds(141, 136, 141, 23);
		
		contentPane.add(rb1);
		
		JLabel lblFeisalSalim = new JLabel("Feisal Salim");
		lblFeisalSalim.setBounds(17, 50, 99, 16);
		contentPane.add(lblFeisalSalim);
		
		JLabel lblSid = new JLabel("SID:824317549");
		lblSid.setBounds(17, 71, 99, 16);
		contentPane.add(lblSid);
		
		rdbtnSavefileUdp = new JRadioButton("saveFile UDP");
		rdbtnSavefileUdp.setBounds(141, 169, 141, 23);
		contentPane.add(rdbtnSavefileUdp);
		ButtonGroup grp = new ButtonGroup();
		grp.add(rdbtnSavefileUdp);
		grp.add(rb1);
		
		JButton btnSelect = new JButton("select");
		btnSelect.setBounds(294, 228, 117, 29);
		contentPane.add(btnSelect);
		
		btnSelect.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(rb1.isSelected()){
					SelectFile select = new SelectFile();//tcp selectfile implementation
					select.setVisible(true);
				}else{
					
					selectFileUDP select = new selectFileUDP();//udp selectfile implementation
					select.setVisible(true);
					
				}
				
			}
			
		});
	}
}

package Project;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFileChooser;

public class FileChooser extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public void fileChoose() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileChooser frame = new FileChooser();
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
	public FileChooser() {
		setBackground(new Color(135, 206, 250));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 426, 201);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnChooseAFile = new JButton("Choose a file");
		btnChooseAFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				  	JButton open =new JButton();
			 		JFileChooser fc = new JFileChooser();
			 		fc.setCurrentDirectory(new java.io.File("C:/Users/Shishir/Desktop"));
			 		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			 		if(fc.showOpenDialog(open)==JFileChooser.APPROVE_OPTION){
			 			//
			 		}
			 		System.out.println("You choose: "+fc.getSelectedFile().getAbsolutePath());
					
				}catch (Exception e){System.out.print(e);}
			}
		});
		btnChooseAFile.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnChooseAFile.setBounds(99, 29, 190, 32);
		contentPane.add(btnChooseAFile);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnGoBack.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnGoBack.setBounds(99, 92, 190, 32);
		contentPane.add(btnGoBack);
	}
}

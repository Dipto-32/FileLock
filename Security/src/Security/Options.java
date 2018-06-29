package Project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.math.*;
import java.util.*;
import java.security.*;
import java.io.*;

import javax.swing.JButton;
import javax.swing.JFileChooser;

public class Options extends JFrame {
	secret secretkey=new secret();
	JFileChooser fc = new JFileChooser();
	String spath;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	 public String getPathname() {
	        return spath;
	    }
	    public void setPathname(String spath) {
	        this.spath = this.fc.getSelectedFile().getAbsolutePath();
	    }
	
	
	public void chooseOption() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Options frame = new Options();
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
	public Options() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 293);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnElgamal = new JButton("ElGamal Encryption");
		btnElgamal.setBounds(147, 30, 153, 36);
		btnElgamal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					
				  	secretkey.secretkey_generate();
				  	
					
				}catch(Exception e){System.out.print(e);}
				
			}
		});
		contentPane.setLayout(null);
		btnElgamal.setFont(new Font("Times New Roman", Font.BOLD, 16));
		contentPane.add(btnElgamal);
		
		JButton btnRsa = new JButton("RSA Encryption");
		btnRsa.setBounds(147, 102, 153, 36);
		btnRsa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnRsa.setFont(new Font("Times New Roman", Font.BOLD, 16));
		contentPane.add(btnRsa);
		
		JButton btnCaeserCipher = new JButton("Caeser Cipher Encr");
		btnCaeserCipher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCaeserCipher.setBounds(147, 176, 153, 36);
		btnCaeserCipher.setFont(new Font("Times New Roman", Font.BOLD, 12));
		contentPane.add(btnCaeserCipher);
		
		JButton btnElgamalDecryption = new JButton("ElGamal Decryption");
		btnElgamalDecryption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnElgamalDecryption.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnElgamalDecryption.setBounds(337, 30, 153, 36);
		contentPane.add(btnElgamalDecryption);
		
		JButton btnRsaDecryption = new JButton("RSA Decryption");
		btnRsaDecryption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnRsaDecryption.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnRsaDecryption.setBounds(337, 102, 153, 36);
		contentPane.add(btnRsaDecryption);
		
		JButton btnCaeserCipherDecrypt = new JButton("Caeser Cipher Decrypt");
		btnCaeserCipherDecrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCaeserCipherDecrypt.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnCaeserCipherDecrypt.setBounds(322, 176, 168, 36);
		contentPane.add(btnCaeserCipherDecrypt);
		
		JButton btnChooseFile = new JButton("Choose File");
		btnChooseFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				  	JButton open =new JButton();
			 		
			 		fc.setCurrentDirectory(new java.io.File("C:/Users/Shishir/Desktop"));
			 		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			 		if(fc.showOpenDialog(open)==JFileChooser.APPROVE_OPTION){
			 			//
			 		}
			 		System.out.println("You choose: "+fc.getSelectedFile().getAbsolutePath());
			 		spath = fc.getSelectedFile().getAbsolutePath();
			 		//System.out.println(spath);
			 		
			 		//secret s1=new secret();
			 		//s1.elgamal_encryption(secretkey);
			 		//s2.rsa_encrypt(fc);
			 		//s3.caeser_encrypt(fc);

			 		
			 		
					
				}catch (Exception e){System.out.print(e);}
				
			}
		});
		btnChooseFile.setBounds(10, 109, 109, 46);
		contentPane.add(btnChooseFile);
	}
}

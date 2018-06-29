package Project;
import java.math.*;
import java.util.*;
import java.security.*;
import java.io.*;
import java.awt.BorderLayout;
import java.math.*;
import java.util.*;
import java.security.*;
import java.io.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFileChooser;
import javax.swing.JTextField;


public class secret extends JFrame {

	private JPanel contentPane;
	private JTextField secretkey;
	String s1;

	
	
	/**
	 * Launch the application.
	 */
	
	public void secretkey_generate() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					secret frame = new secret();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
			
		
  

	public void elgamal_encryption(BigInteger secret_key) {
		
		BigInteger p, alpha, b;
        Random sc = new SecureRandom();
		System.out.println("secretKey = " + secret_key);
        p = BigInteger.probablePrime(512, sc);
        alpha = new BigInteger("3");
        b = alpha.modPow(secret_key, p);
      //  System.out.println("p = " + p);
      //  System.out.println("b = " + alpha);
      //  System.out.println("c = " + b);
        
     // Encryption
        
        Options o1=new Options();
    //    JFileChooser f=o1.fc;
      //  System.out.println(f.getSelectedFile().getAbsolutePath());
       final String path=o1.getPathname();
        System.out.println("Random access "+path);
       
        
       
        try{
        	
        	RandomAccessFile f2 = new RandomAccessFile(path, "r");
            byte [] plaintext = new byte[(int)f2.length()];
            f2.read(plaintext);
        
       
        BigInteger X = new BigInteger(plaintext);
        System.out.println("plaintext = " + X);
        
       
        BigInteger k = new BigInteger(64, sc);
        BigInteger y1 = alpha.modPow(k, p);
        BigInteger y2 = X.multiply(b.modPow(k, p)).mod(p);
        
        
      
               
        System.out.println("k = " + k);
        System.out.println("y2 = " + y2);
        System.out.println("alpha^k mod p = " + y1);
        }catch (Exception e){System.out.print("error det");}
		
	}

	/**
	 * Create the frame.
	 */
	public secret() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 399, 149);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterASecret = new JLabel("Enter a secret key");
		lblEnterASecret.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblEnterASecret.setBounds(10, 11, 189, 21);
		contentPane.add(lblEnterASecret);
		
		JButton btnOkay = new JButton("Encrypt");
		btnOkay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				//	System.out.print(secretkey.getText().toString());
			    BigInteger enc_key = BigInteger.valueOf(0);
				enc_key = enc_key.add(BigInteger.valueOf(Long.parseUnsignedLong(secretkey.getText().toString())));
				//BigInteger enc_key=secretkey.getText().toString();
					
				//System.out.print(enc_key);
				dispose();
				elgamal_encryption(enc_key);
				
				
				
				
				
				
			    }catch (Exception e){System.out.print(e);}
				
			}
		});
		btnOkay.setBounds(254, 62, 89, 23);
		contentPane.add(btnOkay);
		
		secretkey = new JTextField();
		s1=secretkey.getText().toString(); 
		secretkey.setBounds(170, 13, 154, 20);
		contentPane.add(secretkey);
		secretkey.setColumns(10);
	}
}

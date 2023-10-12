package javafullcourse;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class MyFrame extends JFrame implements ActionListener{

	JButton button=new JButton();
	JButton button1=new JButton();
	MyFrame(){
	 
		//JFrame schermo=new JFrame();
		this.setVisible(true);
		this.setLayout( new BorderLayout());
		this.setSize(1500,1500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel=new JPanel();
		JPanel panel1=new JPanel();
		panel.setBounds(0,0,300,300);
		panel.setPreferredSize(new Dimension(200,200));
		panel.setBackground(Color.red);
		panel1.setBounds(0,0,50,100);
		panel1.setBackground(Color.green);
		JLabel label=new JLabel();
		label.setText("RAINY");
		label.setBackground(Color.CYAN);
		ImageIcon image=new ImageIcon("pokemon.png");
		Border border=  BorderFactory.createLineBorder(Color.blue,5);
		label.setBorder(border);
		label.setOpaque(true);
		label.setIcon(image);
		panel1.add(label);
		
		
		
		this.add(panel,BorderLayout.SOUTH);
		this.add(panel1);
		
		button.setPreferredSize(new Dimension(100,100));
		button.setText("START");
		button1.setText("STOP");
		button.addActionListener(this);
		button1.addActionListener(this);
		panel.add(button);
		button1.setPreferredSize(new Dimension(100,100));
		panel.add(button1);
		
		
		
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		File file1=new File("rainy.wav");
		
		try {
			AudioInputStream audio= AudioSystem.getAudioInputStream(file1);
		
		Clip clip = AudioSystem.getClip();
		
	
		while(e.getSource()!=button1) {
			if(e.getSource()==button) {
				System.out.print("funziona");
				
				
				clip.start();
			
			}
			if(e.getSource()==button1) {
				System.out.print("stop");
				clip.stop();
					
			}
		}
			
		
		} catch (LineUnavailableException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedAudioFileException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}

}

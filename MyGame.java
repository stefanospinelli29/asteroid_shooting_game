package javafullcourse;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class MyGame extends JFrame implements KeyListener, ActionListener  {
	
	JLabel razzo;
	JLabel startg = new JLabel();
	JLabel meteorite;
	JLabel meteorite1=new JLabel();
	JLabel meteorite2=new JLabel();
	JLabel meteorite3=new JLabel();
	JLabel meteorite4=new JLabel();
	JLabel meteorite5=new JLabel();
	JLabel meteorite6=new JLabel();
	JLabel colpo=new JLabel();
	JOptionPane over=new JOptionPane();
	JLabel powerUp=new JLabel();
	int punteggio=0;
	boolean pUy=false;
	boolean puntup=true;
	boolean powup=true;
	JLabel text=new JLabel();
	boolean mt1=false;
	int speed=3;
	int rspeed=5;
	ImageIcon image;
	ImageIcon image1;
	ImageIcon image2;
	ImageIcon image3;
	ImageIcon image4;
	ImageIcon image5;
	ImageIcon image6;
	ImageIcon image0;
	ImageIcon missile;
	ImageIcon pspeed;
	Timer timer= new Timer(30, this);
	 AudioInputStream audio1;
	 Clip clip;
	 AudioInputStream audio2;
	 Clip clip1;
	
	boolean sparo=false;
	MyGame() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		 File file1=new File("esplosione.wav");
		     audio1= AudioSystem.getAudioInputStream(file1);
		     clip=AudioSystem.getClip();
		    clip.open( audio1);
		    File file2=new File("powerup.wav");
		     audio2= AudioSystem.getAudioInputStream(file2);
		     clip1=AudioSystem.getClip();
		    clip1.open( audio2);
		   
		  //  clip.start();
		    
		this.setSize(900,1200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setTitle("ASTEROIDS");
		image=new ImageIcon("navicellagiusta.jpg");
		image1=new ImageIcon("meteoriteg.jpg");
		image2=new ImageIcon("met2g.jpg");
		image3=new ImageIcon("met3g.jpg");
		image4=new ImageIcon("met4g.jpg");
		image5=new ImageIcon("met5g.jpg");
		image6=new ImageIcon("met6g.png");
		image0=new ImageIcon("met0g.jpg");
		missile=new ImageIcon("missile2g.jpg");
		pspeed=new ImageIcon("speedg.jpg");
		startg.setText("schiaccia un tasto per iniziare");
		startg.setBounds(250, 300, 400,30);
		startg.setBackground(Color.black);
		
		startg.setFont(new Font("Times New Roman", Font.PLAIN, 30 ));
		startg.setForeground(Color.white);
		startg.setOpaque(true);
		
		
		
		this.getContentPane().setBackground(Color.black);;
		razzo= new JLabel();
		meteorite=new JLabel();
		razzo.setBounds(350,700,100,100);
		razzo.setBackground(Color.red);
		razzo.setOpaque(true);
		meteorite.setBounds(150,-100,100,100);
		meteorite.setBackground(Color.gray);
		meteorite.setOpaque(true);
		razzo.setIcon(image);
		text.setText("Punteggio:"+punteggio);
		text.setBounds(0,0,100,20);
		text.setBackground(Color.white);
		text.setOpaque(true);
		meteorite.setIcon(image1);
		meteorite1.setIcon(image0);
		meteorite2.setIcon(image2);
		meteorite3.setIcon(image3);
		meteorite4.setIcon(image4);
		meteorite5.setIcon(image5);
		meteorite6.setIcon(image6);
		colpo.setIcon(missile);
		powerUp.setIcon(pspeed);
		
		meteorite1.setBackground(Color.gray);
		meteorite1.setOpaque(true);
		meteorite1.setBounds(350,-100,120,100);
		meteorite2.setBackground(Color.gray);
		meteorite2.setOpaque(true);
		meteorite2.setBounds(450,-100,120,100);
		meteorite3.setBackground(Color.gray);
		meteorite3.setOpaque(true);
		meteorite3.setBounds(550,-100,120,100);
		meteorite4.setBackground(Color.gray);
		meteorite4.setOpaque(true);
		meteorite4.setBounds(650,-100,120,100);
		meteorite5.setBackground(Color.gray);
		meteorite5.setOpaque(true);
		meteorite5.setBounds(650,-100,120,100);
		meteorite6.setBackground(Color.gray);
		meteorite6.setOpaque(true);
		meteorite6.setBounds(750,-100,120,100);
		//meteorite1.setLocation((int) (600*Math.random()), -100);
		powerUp.setBackground(Color.green);
		powerUp.setOpaque(true);
		powerUp.setBounds(450,-100,100,70);
		
		this.add(text);
		this.add(razzo);
		this.add(meteorite);
		this.add(meteorite1);
		this.add(meteorite2);
		this.add(meteorite3);
		this.add(meteorite4);
		this.add(meteorite5);
		this.add(meteorite6);
		this.add(powerUp);
		this.add(startg);
		this.addKeyListener(this);
		
		
		this.setVisible(true);
		if(razzo.getX()==meteorite.getX()&&razzo.getY()==meteorite.getY()) {
			System.out.print("collisione");
		}
		
		
		
	}

	@Override
	
	public void keyTyped(KeyEvent e) {
		
		switch(e.getKeyChar()) {
		case 'a':
			razzo.setLocation(razzo.getX()-rspeed, razzo.getY());
			
			
			break;
		case 's':
			razzo.setLocation(razzo.getX(), razzo.getY()+rspeed);
			
			break;
		case 'w':
			razzo.setLocation(razzo.getX(), razzo.getY()-rspeed);
			
			break;
		case 'd':
			razzo.setLocation(razzo.getX()+rspeed, razzo.getY());
			
			break;
		case'l':
			if(!sparo) {
			sparo=true;
			
			colpo.setBounds(razzo.getX()+35,razzo.getY(), 30, 70);
			colpo.setBackground(Color.orange);
			colpo.setOpaque(true);
			this.add(colpo);
			}
			
			break;
			
			
		}
		timer.start();
		startg.setLocation(-100, -100);
		this.remove(startg);
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void Collisione(JLabel razzo,JLabel meteorite) {
		if((colpo.getX()>=meteorite.getX()&&colpo.getX()<=meteorite.getX()+100)&&(colpo.getY()>=meteorite.getY()&&colpo.getY()<=meteorite.getY()+100)||(colpo.getX()+30>=meteorite.getX()&&colpo.getX()+30<=meteorite.getX()+100)&&(colpo.getY()>=meteorite.getY()&&colpo.getY()<=meteorite.getY()+100)) {
			System.out.print("collisione");
			punteggio+=30;
			this.remove(colpo);
			//this.remove(meteorite);
			colpo.setLocation(-7000, -10);
			this.remove(colpo);
			meteorite.setLocation((int) (600*Math.random()), -100);
			
			clip.setMicrosecondPosition(0);
			clip.start();
			
			
		}
	}
	public void GameOver(JLabel razzo,JLabel meteorite) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		if((razzo.getX()>=meteorite.getX()&&razzo.getX()<=meteorite.getX()+100)&&(razzo.getY()>=meteorite.getY()&&razzo.getY()<=meteorite.getY()+100)||(razzo.getX()+100>=meteorite.getX()&&razzo.getX()+100<=meteorite.getX()+100)&&(razzo.getY()>=meteorite.getY()&&razzo.getY()<=meteorite.getY()+100)||(razzo.getX()+50>=meteorite.getX()&&razzo.getX()+50<=meteorite.getX()+100)&&(razzo.getY()>=meteorite.getY()&&razzo.getY()<=meteorite.getY()+100)||(razzo.getX()>=meteorite.getX()&&razzo.getX()<=meteorite.getX()+100)&&(razzo.getY()+100>=meteorite.getY()&&razzo.getY()+100<=meteorite.getY()+100)||(razzo.getX()+100>=meteorite.getX()&&razzo.getX()+100<=meteorite.getX()+100)&&(razzo.getY()+100>=meteorite.getY()&&razzo.getY()+100<=meteorite.getY()+100)) {
			System.out.print("GAME OVER");
			
			over.setBounds(0,0,400,400);
			over.showMessageDialog(null, "             GAME OVER \n       il tuo punteggio è "+ punteggio);
			this.add(over);
			if(over.showConfirmDialog(null,"vuoi rigiocare?")==0) {
				this.dispose();
				meteorite.setLocation(-100,-100);
				razzo.setLocation(-100,-600);
				colpo.setLocation(-300,-600);
				this.remove(meteorite);
				this.remove(razzo);
				clip.close();
				clip1.close();
				
				new MyGame();}
			else {
			
			over.setBackground(Color.black);
			over.setOpaque(true);
			meteorite.setLocation(-100,-100);
			razzo.setLocation(-100,-600);
			colpo.setLocation(-300,-600);
			this.remove(meteorite);
			this.remove(razzo);
			
			System.exit(0);
			}
		}	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		meteorite.setLocation(meteorite.getX(),meteorite.getY()+speed);
		if(punteggio>=180) {
			meteorite1.setLocation(meteorite1.getX(),meteorite1.getY()+speed);
		}
		if(punteggio>=360) {
			meteorite2.setLocation(meteorite2.getX(),meteorite2.getY()+speed);
		}
		if(punteggio>=540) {
			meteorite3.setLocation(meteorite3.getX(),meteorite3.getY()+speed);
		}
		if(punteggio>=720) {
			meteorite4.setLocation(meteorite4.getX(),meteorite4.getY()+speed);
		}
		if(punteggio>=900) {
			meteorite5.setLocation(meteorite5.getX(),meteorite5.getY()+speed);
		}
		if(punteggio>=1080) {
			meteorite6.setLocation(meteorite6.getX(),meteorite6.getY()+speed);
		}
		if(razzo.getX()==meteorite.getX()&&razzo.getY()==meteorite.getY()) {
			System.out.print("collisione");
		}
		if(sparo) {
			colpo.setLocation(colpo.getX(),colpo.getY()-rspeed-3);
		}
		
		Collisione(razzo,meteorite);
		Collisione(razzo,meteorite1);
		Collisione(razzo,meteorite2);
		Collisione(razzo,meteorite3);
		Collisione(razzo,meteorite4);
		Collisione(razzo,meteorite5);
		Collisione(razzo,meteorite5);
		Collisione(razzo,meteorite6);
		
		if(punteggio%210==0&&punteggio!=0&&puntup) {
			speed+=2;
			puntup=false;
		}
		
		if(punteggio%210!=0)
			puntup=true;
		
		if(punteggio%510==0&&punteggio!=0&&powup) {
			pUy=true;
			powup=false;
		}
		
		if(punteggio%510!=0)
			powup=true;
		
		
		
		if((razzo.getX()>=powerUp.getX()&&razzo.getX()<=powerUp.getX()+100)&&(razzo.getY()>=powerUp.getY()&&razzo.getY()<=powerUp.getY()+100)||(razzo.getX()+100>=powerUp.getX()&&razzo.getX()+100<=powerUp.getX()+100)&&(razzo.getY()>=powerUp.getY()&&razzo.getY()<=powerUp.getY()+100)||(razzo.getX()+50>=powerUp.getX()&&razzo.getX()+50<=powerUp.getX()+100)&&(razzo.getY()>=powerUp.getY()&&razzo.getY()<=powerUp.getY()+100)||(razzo.getX()>=powerUp.getX()&&razzo.getX()<=powerUp.getX()+100)&&(razzo.getY()+100>=powerUp.getY()&&razzo.getY()+100<=powerUp.getY()+100)||(razzo.getX()+100>=powerUp.getX()&&razzo.getX()+100<=powerUp.getX()+100)&&(razzo.getY()+100>=powerUp.getY()&&razzo.getY()+100<=powerUp.getY()+100)) {
			System.out.print("pow");
			rspeed+=3;
			//this.remove(razzo);
			//this.remove(powerUp);
			//razzo.setLocation(-7000, -10);
			//this.remove(razzo);
			powerUp.setLocation((int) (750*Math.random()), -100);
			pUy=false;
			clip1.setMicrosecondPosition(0);
			clip1.start();
			
		}
		if(pUy) {
			powerUp.setLocation(powerUp.getX(),powerUp.getY()+5);
		}
		try {
			GameOver(razzo,meteorite);
			GameOver(razzo,meteorite1);
			GameOver(razzo,meteorite2);
			GameOver(razzo,meteorite3);
			GameOver(razzo,meteorite4);
			GameOver(razzo,meteorite5);
			GameOver(razzo,meteorite6);
		} catch (UnsupportedAudioFileException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (LineUnavailableException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		if(colpo.getY()<=5) {
			sparo=false;
			colpo.setLocation(-7000, -10);
			//this.remove(colpo);
		}
		if(meteorite.getY()>=800) {
			meteorite.setLocation((int) (750*Math.random()), -100);
		}
		if(meteorite1.getY()>=800) {
			meteorite1.setLocation((int) (750*Math.random()), -100);
		}
		if(meteorite2.getY()>=800) {
			meteorite2.setLocation((int) (750*Math.random()), -100);
		}
		
		
		if(meteorite3.getY()>=800) {
			meteorite3.setLocation((int) (750*Math.random()), -100);
		}
		if(meteorite4.getY()>=800) {
			meteorite4.setLocation((int) (750*Math.random()), -100);
		}if(meteorite5.getY()>=800) {
			meteorite5.setLocation((int) (750*Math.random()), -100);
		}
		if(meteorite6.getY()>=800) {
			meteorite6.setLocation((int) (750*Math.random()), -100);
		}
		if(powerUp.getY()>=800) {
			powerUp.setLocation((int) (750*Math.random()), -100);
			pUy=false;
		}
		text.setText("Punteggio:"+punteggio);
	}
	
}

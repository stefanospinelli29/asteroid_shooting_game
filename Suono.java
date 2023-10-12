package javafullcourse;

import javax.sound.sampled.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.io.IOException;

import java.util.Scanner;

class Suono{
 public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
    Scanner tastiera=new Scanner(System.in);
    File file1=new File("esplosione.wav");
    AudioInputStream audio1= AudioSystem.getAudioInputStream(file1);
    File file2=new File("esplosione.wav");
    AudioInputStream audio2= AudioSystem.getAudioInputStream(file2);
    Clip clip=AudioSystem.getClip();
    String s="";
    String nome="";
    nome=tastiera.next();
    if(nome.equals("pioggia"))
    clip.open(audio2);
    else
    clip.open( audio1);
    
    System.out.println("test");
    while(!s.equals("q")){
      s=tastiera.next();
      switch(s){
         case "p":
      clip.start();
      break;
      case "r":
      clip.setMicrosecondPosition(0);
      break;
      case "s":
      clip.stop();
      break;
      case "q":
      clip.close();
      break;
      default:
      System.out.println("input non valido");
      }
    }
   System.out.println("ciao");

 }
}
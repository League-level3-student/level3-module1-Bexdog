package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


//Copyright The League of Amazing Programmers, 2015

public class _06_IPodShuffle implements ActionListener{
	public _06_IPodShuffle() {
		// 1. Use the Song class the play the demo.mp3 file.
				
				
		/**
		 * 2. Congratulations on completing the sound check! * Now we want to make an
		 * iPod Shuffle that plays random music. * Create an ArrayList of Songs and a
		 * "Surprise Me!" button that will play a random song when it is clicked. * If
		 * you're really dumb, you can stop all the songs, before playing a new one on
		 * subsequent button clicks.
		 */
		
	}
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton play = new JButton();
	Song song;
	int randy;
	ArrayList <Song> songs = new ArrayList <Song>();
	
	 void run() {
		panel.add(play);
		frame.add(panel);
		play.addActionListener(this);
		play.setText("Surprise Me!");
		frame.pack();
		frame.setVisible(true);
		song = new Song("roar.mp3");
		songs.add(song);
		song = new Song("creepy.mp3");
		songs.add(song);
		song = new Song("monster.mp3");
		songs.add(song);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		randy = new Random().nextInt(songs.size());
		for(int i = 0;i<songs.size();i++) {
			songs.get(i).stop();
		}
		songs.get(randy).play();	
	}
}
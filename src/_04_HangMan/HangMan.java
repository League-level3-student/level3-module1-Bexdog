package _04_HangMan;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan implements KeyListener {
	static JFrame frame = new JFrame();
	static JPanel panel = new JPanel();
	static JLabel label = new JLabel();
	static Stack<String> words = new <String>Stack();
	static String lastWord = "";
	static boolean finished = true;
	static int word;
	int lives = 5;

	public static void main(String[] args) {
		HangMan man = new HangMan();
		man.run();
		String Input = JOptionPane.showInputDialog("How many words do you want to guess?");
		int input = Integer.parseInt(Input);
		word = input;
		for (int i = 0; i < input; i++) {
			if (finished) {
				man.newWord();
				System.out.println(lastWord);

			}
			finished = false;
		}
	}

	void newWord() {
		word--;
		if(word>=0) {
			words.clear();
			words.push(Utilities.readRandomLineFromFile("dictionary.txt"));
			lastWord = words.pop();
			for (int z = 0; z < lastWord.length(); z++) {
				label.setText(label.getText() + "_");
			}
			frame.pack();
		}
	}

	void run() {
		frame.addKeyListener(this);
		frame.add(panel);
		panel.add(label);
		label.setPreferredSize(new Dimension(200, 100));
		frame.setVisible(true);
		frame.pack();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		for (int i = 0; i < label.getText().length(); i++) {
			if (lastWord.charAt(i) == e.getKeyChar()) {
				String s = label.getText();
				System.out.println(e.getKeyChar());
				label.setText(s.substring(0, i) + lastWord.charAt(i) + s.substring(i + 1, s.length()));
				frame.pack();
				System.out.println(lives);
			} else if(i==label.getText().length()){
				lives--;
				if(lives==0) {
					JOptionPane.showMessageDialog(null, "You Lose");
				}
			}
			if (!label.getText().contains("_")) {
				finished = true;
			}
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}

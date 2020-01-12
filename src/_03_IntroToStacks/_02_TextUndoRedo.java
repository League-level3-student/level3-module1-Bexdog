package _03_IntroToStacks;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener {
	/*
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look
	 * like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character
	 * is erased from the JLabel. Save that deleted character onto a Stack of
	 * Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed,
	 * the top Character is popped off the Stack and added back to the JLabel.
	 * 
	 */
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	Stack deleted = new Stack();
	String change;

	void run() {
		panel.add(label);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.addKeyListener(this);
		panel.setPreferredSize(new Dimension(250, 50));
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == 37&&deleted.size()>0) {
			label.setText(label.getText() + deleted.pop());
		} 
		else if ((e.getKeyCode() == KeyEvent.VK_BACK_SPACE) && (label.getText().length() > 0)) {
			change = label.getText();
			change = change.substring(0, change.length() - 1);
//			System.out.println(label.getText().length() - 1);
//			System.out.println(label.getText().charAt(label.getText().length() - 1));
			deleted.add(label.getText().charAt(label.getText().length() - 1));
			label.setText(change);
			frame.pack();
		} else if(e.getKeyCode()!=KeyEvent.VK_SHIFT&&e.getKeyCode() != 37){
			label.setText(label.getText() + e.getKeyChar());
			frame.pack();
		}
//		System.out.println(label.getText());
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}
}

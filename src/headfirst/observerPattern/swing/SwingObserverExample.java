package headfirst.observerPattern.swing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingObserverExample {

	JFrame frame;
	
	/*public static void main(String[] args) {
		System.out.println("Hi, I am here!!!");
		new SwingObserverExample().go();
	}*/

	public void go() {
		frame = new JFrame();
		JButton button = new JButton("Hola!!!, I am newbi");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ghanta, You are a pro!");				
			}
		});
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Good that you know it.");
			}
		});
		frame.getContentPane().add(BorderLayout.CENTER, button);
	}
}

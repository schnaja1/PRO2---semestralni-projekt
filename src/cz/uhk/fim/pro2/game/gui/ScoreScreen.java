package cz.uhk.fim.pro2.game.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ScoreScreen extends Screen{

	public ScoreScreen(MainFrame mainFrame) {
		super(mainFrame);
		
		JButton jButtonBack = new JButton("Back");
		

		jButtonBack.setBounds(20, 20, 80, 80);
		
		jButtonBack.addActionListener(new ActionListener(){
			@Override
            public void actionPerformed(ActionEvent e) {
				//System.out.println("??");
				mainFrame.setScreen(new HomeScreen(mainFrame));
            }
		});
		
		add(jButtonBack);
	}
	

}

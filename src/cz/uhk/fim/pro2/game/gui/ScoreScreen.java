package cz.uhk.fim.pro2.game.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import cz.uhk.fim.pro2.game.ScoreManager;

public class ScoreScreen extends Screen{

	public ScoreScreen(MainFrame mainFrame) {
		super(mainFrame);
		
		for(int i=0;i<ScoreManager.size();i++){
			int score = ScoreManager.get(i);
			ScoreItem scoreItem = new ScoreItem(i+1, score);
			scoreItem.setBounds(40,200+i*50,400,50);
			add(scoreItem);
		}
		
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

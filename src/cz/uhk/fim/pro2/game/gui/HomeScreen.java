package cz.uhk.fim.pro2.game.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class HomeScreen extends Screen{

	public HomeScreen(MainFrame mainFrame) {
		super(mainFrame);
		JButton jButtonPlay = new JButton("PLAY");
		JButton jButtonScore = new JButton("SCORE");
		JButton jButtonSound = new JButton("Pssst");
		
		add(jButtonPlay);
		add(jButtonScore);
		add(jButtonSound);
		
		jButtonPlay.addActionListener(new ActionListener(){
			@Override
            public void actionPerformed(ActionEvent e) {
				//System.out.println("??");
				mainFrame.setScreen(new GameScreen(mainFrame));
            }
		});
		jButtonScore.addActionListener(new ActionListener(){
			@Override
            public void actionPerformed(ActionEvent e) {
				//System.out.println("??");
				mainFrame.setScreen(new ScoreScreen(mainFrame));
            }
		});
	}

}

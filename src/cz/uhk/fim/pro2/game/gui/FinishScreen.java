package cz.uhk.fim.pro2.game.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import cz.uhk.fim.pro2.game.ScoreManager;
import cz.uhk.fim.pro2.game.model.World;

public class FinishScreen extends Screen{

	public FinishScreen(MainFrame mainFrame, World world) {
		super(mainFrame);
		
		int score = world.getBird().getScore();
		String name = world.getBird().getName(); 
		
		JLabel scoreJLabel = new JLabel("Your score was " + score + "!");
		
		scoreJLabel.setFont(new Font("Arial", Font.BOLD, 20));
		scoreJLabel.setBounds(150, 100, 300, 100);
		
		JButton newGameJButton = new JButton("New Game");
		JButton homeJButton = new JButton("Home Screen");
		
		newGameJButton.setBounds(140, 300, 200, 50);
		homeJButton.setBounds(140, 400, 200, 50);
	
	//	ScoreManager.putScore(score);
		ScoreManager.addScore(score);
		
		newGameJButton.addActionListener(new ActionListener(){
			@Override
            public void actionPerformed(ActionEvent e) {
				mainFrame.setScreen(new GameScreen(mainFrame));
            }
		});
		homeJButton.addActionListener(new ActionListener(){
			@Override
            public void actionPerformed(ActionEvent e) {
				mainFrame.setScreen(new HomeScreen(mainFrame));
            }
		});
		
		add(scoreJLabel);
		add(newGameJButton);
		add(homeJButton);
	}

}

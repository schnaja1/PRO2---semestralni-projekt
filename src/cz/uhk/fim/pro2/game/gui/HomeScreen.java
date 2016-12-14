package cz.uhk.fim.pro2.game.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class HomeScreen extends Screen{

	public HomeScreen(MainFrame mainFrame) {
		super(mainFrame);
		JButton jButtonPlay = new JButton("PLAY");
		JButton jButtonScore = new JButton("SCORE");
		JButton jButtonSound = new JButton("SOUND");
		
		jButtonPlay.setBounds(100, 400, 280, 50);
		jButtonScore.setBounds(100, 460, 280, 50);
		jButtonSound.setBounds(100, 520, 280, 50);
		
		JLabel jLabel = new JLabel("Epileptic Bird");
		
		jLabel.setFont(new Font("Ärial",Font.BOLD,40));
		jLabel.setBounds(100,10,300,100);
		
		add(jLabel);
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

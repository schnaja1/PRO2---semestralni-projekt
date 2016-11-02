package cz.uhk.fim.pro2.game.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class GameScreen extends Screen {

	public GameScreen(MainFrame mainFrame) {
		super(mainFrame);
		JButton jButtonBack = new JButton("Back");
		JButton jButtonPause = new JButton("Pause");
		add(jButtonBack);
		add(jButtonPause);	
		jButtonBack.setBounds(20, 20, 80, 80);
		jButtonPause.setBounds(380,20,80,80);
		
		jButtonBack.addActionListener(new ActionListener(){
			@Override
            public void actionPerformed(ActionEvent e) {
				//System.out.println("??");
				mainFrame.setScreen(new HomeScreen(mainFrame));
            }
		});
	}

}

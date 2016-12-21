package cz.uhk.fim.pro2.game.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;

import cz.uhk.fim.pro2.game.ScoreDetail;
import cz.uhk.fim.pro2.game.ScoreManager;

public class ScoreScreen extends Screen{

	public ScoreScreen(MainFrame mainFrame) {
		super(mainFrame);
		List<ScoreDetail> scoreList;
	
		scoreList=ScoreManager.getAll();
		scoreList=ScoreManager.sortList(scoreList);
		for(int i=0;i<scoreList.size();i++){
			int score = scoreList.get(i).getScore();
			String name = scoreList.get(i).getName();
			String date = scoreList.get(i).getDate();
			ScoreItem scoreItem = new ScoreItem(i+1, score, name, date);
			scoreItem.setBounds(40,200+i*40,400,20);	
			add(scoreItem);
		}
		  
		JButton jButtonBack = new JButton("Back");
		

		jButtonBack.setBounds(20, 20, 80, 80);
		
		jButtonBack.addActionListener(new ActionListener(){
			@Override
            public void actionPerformed(ActionEvent e) {
				mainFrame.setScreen(new HomeScreen(mainFrame));
            }
		});
		
		add(jButtonBack);
	}
	

}

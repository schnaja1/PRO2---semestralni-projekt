package cz.uhk.fim.pro2.game.gui;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScoreItem extends JPanel {

	JLabel jLabelIndex, jLabelScore, jLabelName, jLabelDate;
	
	public ScoreItem(int index, int score, String name, String date){
		setLayout(null);
		Font font = new Font("Arial", Font.BOLD, 20);
		jLabelIndex = new JLabel(index + ".");
		jLabelIndex.setFont(font);
		jLabelIndex.setBounds(0, 0, 150, 20);
		add(jLabelIndex);
		
		jLabelName = new JLabel(name);
		jLabelName.setFont(font);
		jLabelName.setBounds(25, 0, 150, 20);
		add(jLabelName);
		 
		jLabelScore = new JLabel (String.valueOf(score));
		jLabelScore.setFont(font);
		jLabelScore.setBounds(150, 0, 150, 20);
		add(jLabelScore);
		
		jLabelDate = new JLabel(date);
		jLabelDate.setFont(font);
		jLabelDate.setBounds(175, 0, 305, 20);
		add(jLabelDate);
	}

}

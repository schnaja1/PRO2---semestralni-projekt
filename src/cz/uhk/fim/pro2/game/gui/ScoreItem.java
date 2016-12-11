package cz.uhk.fim.pro2.game.gui;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScoreItem extends JPanel {

	JLabel jLabelIndex, jLabelScore;
	
	public ScoreItem(int index, int score){
		setLayout(null);
		Font font = new Font("Arial", Font.BOLD, 40);
		jLabelIndex = new JLabel(index + ".");
		jLabelIndex.setFont(font);
		jLabelIndex.setBounds(0, 0, 150, 50);
		
		
		jLabelScore = new JLabel (String.valueOf(score));
		jLabelScore.setFont(font);
		jLabelScore.setBounds(0, 100, 150, 50);
		
		
	}

}

package cz.uhk.fim.pro2.game;

import java.util.Date;

public class ScoreDetail {
	
	String name;
	int score;
	String date;

	public ScoreDetail(String name, int score){
		this.name=name;
		this.score=score;
		this.date=new Date().toLocaleString();
	}
	 
	public ScoreDetail(String name, int score, String date){
		this.name=name;
		this.score=score;
		this.date=date;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}
	
	public String getDate(){
		return date;
	}
	
}

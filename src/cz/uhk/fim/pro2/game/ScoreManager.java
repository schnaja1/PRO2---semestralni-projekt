package cz.uhk.fim.pro2.game;

import java.util.ArrayList;
import java.util.List;

public class ScoreManager {
	
	/*
	 * Definice tøídy
	 */
	
	private List<Integer> scoreList;
	
	

	private ScoreManager(){
		this.scoreList = new ArrayList<>();
	}
	
	private void addScore(int score){
		scoreList.add(score);
	}
	
	private  List<Integer> getScoreList() {
		return scoreList;
	}
	
	/*
	 * Singleton 
	 */
	
	private static ScoreManager instance;
	
	public static ScoreManager getInstance(){
		if(instance == null)
			instance = new ScoreManager();
		return instance;
	}
	
	
	/*
	 * Verejne metody
	 */
	public static  List<Integer> getList() {
		return getInstance().getScoreList();
	}
	
	public static void putScore(int score){
		getInstance().addScore(score);
	}
	
	public static int get(int i){
		return getInstance().getScoreList().get(i);
	}
	
	public static int size(){
		return getInstance().getScoreList().size();
	}
}

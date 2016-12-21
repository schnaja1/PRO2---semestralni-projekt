package cz.uhk.fim.pro2.game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ScoreManager {
	public ScoreManager(){
		
	}
	/*
	public static List<Integer> sortList(List<Integer> list){
		for(int i = 0; i < list.size(); i++){
			int max = i;
			for(int j = i+1; j < list.size();j++){
				if(list.get(j) > list.get(max))
					max = j;
			}
			int a = list.get(i);
			list.set(i, list.get(max));
			list.set(max,a);
		}		
		return list;
		
	}
	
	public static void addScore(int currentScore){
		try {
			List<Integer> scoreList = getAll();
			scoreList.add(currentScore);
			scoreList = sortList(scoreList);
			
			
			FileWriter fileWriter = new FileWriter(Game.SCORE_FILE);
			int max = scoreList.size();
			if (scoreList.size()>10)
				max = 10;
				
			for(int i = 0; i < max; i++){
				int score = scoreList.get(i);
				fileWriter.append(String.valueOf(score));
				fileWriter.append(";");
				fileWriter.append(new Date().toGMTString());
				fileWriter.append("\n");
				fileWriter.flush();
			}
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static List<Integer> getAll(){
		List<Integer> scoreList = new ArrayList();
		try {
			FileReader fileReader = new FileReader(Game.SCORE_FILE);
			
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			String line;
			while((line = bufferedReader.readLine())!=null){
				String[] values = line.split(";");
				scoreList.add(Integer.valueOf(values[0]));
			}
		} catch (Exception e) {
			System.out.println("Chyba naèítání souboru");
		}
		
		return scoreList;
	}*/
	
	public static List<ScoreDetail> sortList(List<ScoreDetail> list){	
		for(int i = 0; i < list.size(); i++){
			int max = i;
			for(int j = i+1; j < list.size();j++){
				if(list.get(j).getScore() > list.get(max).getScore())
					max = j;
			}
			ScoreDetail a = list.get(i);
			list.set(i, list.get(max));
			list.set(max,a);
		}		
		return list;
		
	}
	
	public static void addScore(String name, int currentScore){
		try {
			List<ScoreDetail> scoreList = getAll();
			scoreList.add(new ScoreDetail(name, currentScore));
			scoreList = sortList(scoreList);
			
			if(name==null)
				return;
			
			FileWriter fileWriter = new FileWriter(Game.SCORE_FILE);
			int max = scoreList.size();
			if (scoreList.size()>10)
				max = 10;
				
			for(int i = 0; i < max; i++){
				fileWriter.append(scoreList.get(i).getName());
				fileWriter.append(";");
				fileWriter.append(String.valueOf(scoreList.get(i).getScore()));
				fileWriter.append(";");
				fileWriter.append(scoreList.get(i).getDate());
				fileWriter.append("\n");
				fileWriter.flush();
			}
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static List<ScoreDetail> getAll(){
		List<ScoreDetail> scoreList = new ArrayList<ScoreDetail>();
		try {
			FileReader fileReader = new FileReader(Game.SCORE_FILE);
			
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			String line;
			while((line = bufferedReader.readLine())!=null){
				String[] values = line.split(";");
				scoreList.add(new ScoreDetail(values[0],Integer.valueOf(values[1]), values[2]));
			}
		} catch (Exception e) {
			System.out.println("Chyba naèítání souboru");
		}
		
		return scoreList;
	}
}

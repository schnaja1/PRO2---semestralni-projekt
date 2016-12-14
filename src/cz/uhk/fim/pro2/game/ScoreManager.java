package cz.uhk.fim.pro2.game;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ScoreManager {
	public ScoreManager(){
		
	}
	
	public static void addScore(int score){
		try {
			FileWriter fileWriter = new FileWriter(Game.SCORE_FILE);
			
			fileWriter.append(String.valueOf(score));
			fileWriter.append(";");
			fileWriter.append(new Date().toGMTString());
			fileWriter.append("\n");
			System.out.println("Píšu");
			fileWriter.flush();
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
			// TODO Auto-generated catch block
			System.out.println("Chyba naèítání souboru");
		}
		
		return scoreList;
	}
}

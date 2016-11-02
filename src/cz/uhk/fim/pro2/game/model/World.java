package cz.uhk.fim.pro2.game.model;

import java.util.ArrayList;
import java.util.List;

public class World {
	private Bird bird;
	private List<Tube> tubes;
	private List<Heart> hearts;
	
	public Bird getBird(){
		return this.bird;
	}
	
	public World(Bird bird){
		this.bird=bird;
		tubes = new ArrayList<>();
		hearts = new ArrayList<>();
	}
	
	public void addTube(Tube tube){
		tubes.add(tube);
	}
	
	public void addHeart(Heart heart){
		hearts.add(heart);
	}
	
	public String toString(){
		return "Bird:" + bird.getName() + " on position: " + bird.getPositionX() + ":" + bird.getPositionY() + 
			"\nThere are " + tubes.size() + " tubes and " + hearts.size() + " hearts in the world.";
	}
}

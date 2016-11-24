package cz.uhk.fim.pro2.game.model;

import java.util.ArrayList;
import java.util.List;

import cz.uhk.fim.pro2.game.interfaces.WorldListener;

public class World {
	public static final int SPEED = 100;
	private Bird bird;
	private List<Tube> tubes;
	private List<Heart> hearts;
	private WorldListener worldListener;
	
	public Bird getBird(){
		return this.bird;
	}

	public void update(float deltaTime){
		bird.update(deltaTime);
		
		if(bird.isOutOf()){
			worldListener.outOf();
		}
		
		for(Heart heart: hearts){
			heart.update(deltaTime);			
			if(bird.collideWith(heart))
				worldListener.catchHeart(heart);
		}
		for(Tube tube: tubes){
			tube.update(deltaTime);
			if(bird.collideWith(tube)){
				worldListener.crashTube(tube);
				tube.setState(true);
			}
			
			else{
				if(bird.getPositionX()>tube.getMinX() && bird.getPositionX() < tube.getMaxX()){
					if(!tube.wasCounted()){
						bird.addPoint();
						tube.setState(true);
						System.out.println(bird.getScore());
					}
				}	
			}
		}
	}
	
	public World(Bird bird, WorldListener worldListener){
		this.bird=bird;
		tubes = new ArrayList<>();
		hearts = new ArrayList<>();
		this.worldListener=worldListener;
	}
	
	public void addTube(Tube tube){
		tubes.add(tube);
	}
	
	public void addHeart(Heart heart){
		hearts.add(heart);
	}

	
	public List<Heart> getHearts(){
		return hearts;
	}

	public List<Tube> getTubes() {
		return tubes;
	}
	
	public String toString(){
		return "Bird:" + bird.getName() + " on position: " + bird.getPositionX() + ":" + bird.getPositionY() + 
			"\nThere are " + tubes.size() + " tubes and " + hearts.size() + " hearts in the world.";
	}
}

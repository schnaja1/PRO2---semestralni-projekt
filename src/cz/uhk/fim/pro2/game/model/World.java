package cz.uhk.fim.pro2.game.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import cz.uhk.fim.pro2.game.gui.MainFrame;
import cz.uhk.fim.pro2.game.interfaces.WorldListener;

public class World {
	public static final int SPEED = 100;
	private static final int SPACE_BETWEEN_TUBES = 250;
	private static final int SPACE_BETWEEN_HEARTS = 600;
	
	private Bird bird;
	private List<Tube> tubes;
	private List<Heart> hearts;
	private WorldListener worldListener;
	private boolean generated;
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
	
	public void generateRandom(){
		addTube(new Tube((int)(100+SPACE_BETWEEN_TUBES), 450, Color.green));
		for (int i=1; i<3; i++){
			addTube(new Tube(100+SPACE_BETWEEN_TUBES+ SPACE_BETWEEN_TUBES*i, Tube.getRandomHeight(), Color.green));
		}
		generated=true;
	//	addTube(new Tube(SPACE_BETWEEN_TUBES, Tube.getRandomHeight(), Color.green));
		addHeart(new Heart(SPACE_BETWEEN_HEARTS, Heart.getRandomHeight()));
	}
	
	public void regenerate(){
		for(Tube tube:tubes){
			if(tube.getPositionX()<-100){
				tube.setPositionX(tube.getPositionX() + tubes.size() * SPACE_BETWEEN_TUBES);
				//tube.setPositionX(800);
				tube.setHeight((int)Tube.getRandomHeight());
				tube.setState(false);
			}
		}
		for(Heart heart: hearts){
			if(heart.getPositionX()< -100){
				heart.setPositionX(800);
				heart.setPositionY(heart.getRandomHeight());
			}
		}
	}
	
	public void paintBackGround(Graphics g){
		g.setColor(Color.cyan);
		g.fillRect(0, 0, MainFrame.WIDTH, MainFrame.HEIGHT);
	}
	
	public void paintGround(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(0, 750, 480, 50);
		
		g.setColor(Color.ORANGE);
		g.fillRect(0, 0, MainFrame.WIDTH, 50);
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

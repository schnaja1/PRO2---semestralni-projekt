package cz.uhk.fim.pro2.game.model;

public class Bird {
	private String name;
	private int positionX, positionY;
	private int speed;
	private int lives;
	

	public Bird(String name, int positionX, int positionY){
		this.name=name;
		this.positionX=positionX;
		this.positionY=positionY;
		lives=3;
		speed=0;
	}
	
	
	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

	public String getName(){
		return name;
	}
	
	public int getPositionX(){
		return positionX;
	}
	
	public void setPositionX(int positionX){
		this.positionX=positionX;
	}
	
	public void goUp(){
		
	}
	
	public void catchHeart(){
		
	}
	
	public void die(){
		
	}
	
	public void addLive(){
		
	}
	
	public void removeLive(){
		
	}

}

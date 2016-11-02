package cz.uhk.fim.pro2.game.model;

public class Bird {
	private String name;
	private float positionX, positionY;
	private float speed;
	private int lives;
	

	public Bird(String name, float positionX, float positionY){
		this.name=name;
		this.positionX=positionX;
		this.positionY=positionY;
		lives=3;
		speed=0;
	}
	
	
	public float getPositionY() {
		return positionY;
	}

	public void setPositionY(float positionY) {
		this.positionY = positionY;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
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
	
	public float getPositionX(){
		return positionX;
	}
	
	public void setPositionX(float positionX){
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

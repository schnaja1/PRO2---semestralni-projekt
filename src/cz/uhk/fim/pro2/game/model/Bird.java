package cz.uhk.fim.pro2.game.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import cz.uhk.fim.pro2.game.gui.MainFrame;

public class Bird {
	
	public static final int DEFAULT_SCORE = 0;
	public static final int DEFAULT_LIVES = 3;
	
	private static final int GRAVITY = 300;
	private static final int JUMP = 400;
	
	private String name;
	private int positionX, positionY;
	private int speed;
	private int lives;
	private int score;
	

	public Bird(String name, int positionX, int positionY){
		this.name=name;
		this.positionX=positionX;
		this.positionY=positionY;
		setLives(DEFAULT_LIVES);
		setSpeed(0);
		setScore(DEFAULT_SCORE);
	}
	
	public boolean isAlive(){
		return (lives>0);
	}
	
	public void goUp(){
		speed+=JUMP;
	}
	
	public void catchHeart(){
		lives++;
	}
	
	public void die(){
		
	}
	
	public void removeLive(){
		lives--;
	}
	
	public void addPoint(){
		score++;
	}
	
	public void paint(Graphics g){
		g.setColor(Color.YELLOW);
		Rectangle rectangle = getRectangle();
		g.fillRect(
			(int) rectangle.getX(),
			(int)rectangle.getY(),
			(int) rectangle.getHeight(),
			(int) rectangle.getWidth());
	}
	public Rectangle getRectangle(){
		return new Rectangle((int) positionX - 25,(int) positionY - 25,50, 50);
	}
	
	public void update(float deltaTime){
		positionY -=speed * deltaTime;
		positionY += GRAVITY * deltaTime;
		speed-=speed*deltaTime;
	}
	
	public boolean collideWith(Tube tube){
		Rectangle rectangle = getRectangle();
		return rectangle.intersects(tube.getBottomRectangle()) || rectangle.intersects(tube.getTopRectangle());
	}
	public boolean collideWith(Heart heart){;
		return getRectangle().intersects(heart.getRectangle());
	}
	
	public boolean isOutOf(){
		return this.getPositionY()<0 || this.getPositionY()>MainFrame.HEIGHT; 
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

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	}

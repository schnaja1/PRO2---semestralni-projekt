package cz.uhk.fim.pro2.game.gui;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import cz.uhk.fim.pro2.game.model.Bird;
import cz.uhk.fim.pro2.game.model.Heart;
import cz.uhk.fim.pro2.game.model.Tube;
import cz.uhk.fim.pro2.game.model.World;

public class GameCanvas extends Canvas{
	private World world;
	private BufferedImage imgBird, imgHeart, imgTube, imgBricks ,imgBackGround, imgGround;
	
	public GameCanvas(World world){
		this.world=world;
		
		try {
			imgBird = ImageIO.read(new File("assets/bird.png"));
			imgHeart = ImageIO.read(new File("assets/heart.png"));
			imgTube = ImageIO.read(new File("assets/tube.png"));
			imgBricks=ImageIO.read(new File("assets/top.png"));
			imgBackGround=ImageIO.read(new File("assets/background.png"));
			imgGround=ImageIO.read(new File("assets/bottom.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if(imgBackGround==null)
			world.paintBackGround(g);
		else
			g.drawImage(imgBackGround,0,0, MainFrame.WIDTH,MainFrame.HEIGHT,null);
		
		List<Tube> tubes = world.getTubes();
		for(Tube tube : tubes){
			tube.paint(g,imgTube);
		}
		
		List<Heart> hearts = world.getHearts();
		for(Heart heart : hearts)
			heart.paint(g,imgHeart);
		
//	world.paintGround(g);	
		if((imgBricks==null)||(imgGround==null))
			world.paintGround(g);
		else{
			g.drawImage(imgBricks,0,0,MainFrame.WIDTH,50,null);
			g.drawImage(imgGround,0,720,MainFrame.WIDTH,80,null);
		}
		Bird bird = world.getBird();
		bird.paint(g,imgBird);
	}
	
}

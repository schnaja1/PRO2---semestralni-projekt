package cz.uhk.fim.pro2.game.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.Timer;

import cz.uhk.fim.pro2.game.interfaces.WorldListener;
import cz.uhk.fim.pro2.game.model.Bird;
import cz.uhk.fim.pro2.game.model.Heart;
import cz.uhk.fim.pro2.game.model.Tube;
import cz.uhk.fim.pro2.game.model.World;

public class GameScreen extends Screen implements WorldListener {
	private long lastTimeMillis;
	private Timer timer;
	private Bird bird;
	
	private JLabel jLabelScore, jLabelLives, jLabelGameOver;

	public GameScreen(MainFrame mainFrame) {
		super(mainFrame);


		JButton back = new JButton("Back");
		JButton pause = new JButton("Pause");
		
		back.setLocation(10, 10);
		back.setSize(80, 30);
		pause.setLocation(90, 10);
		pause.setSize(80, 30);
		
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				timer.stop();
				mainFrame.setScreen(new HomeScreen(mainFrame));
			}
		});
		
		pause.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(timer.isRunning())
					timer.stop();
				else{
					lastTimeMillis = System.currentTimeMillis();
					timer.restart();		
				}
			}
		});
		
		jLabelLives = new JLabel("Lives: " + Bird.DEFAULT_LIVES);
		jLabelScore = new JLabel("Score: " + Bird.DEFAULT_SCORE);
		
		jLabelGameOver = new JLabel("Game Over");
		
		jLabelGameOver.setBounds(20,300,300,200);
		jLabelLives.setBounds(10, 50, 50, 30);
		jLabelScore.setBounds(10, 80, 50, 30);
		
		add(back);
		add(pause);
		add(jLabelLives);
		add(jLabelScore);
		
		
		
		bird = new Bird("Flappik",240,400);
		World world = new World(bird, this);
		world.addTube(new Tube(400, 400));
		world.addTube(new Tube(600, 300));
		world.addTube(new Tube(800, 500));

		
		world.addHeart(new Heart(500,350));
		System.out.println(world.toString());
		
		GameCanvas gameCanvas = new GameCanvas(world);
		add(gameCanvas);
		gameCanvas.setBounds(0,0,MainFrame.WIDTH,MainFrame.HEIGHT);
		gameCanvas.addMouseListener(new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);
				bird.goUp();
			}
			
		});
			add(gameCanvas);
			timer = new Timer(20, new ActionListener(){
				
				@Override
				public void actionPerformed(ActionEvent e) {
					long currentTimeMillis = System.currentTimeMillis();
					
					float deltaTime = (currentTimeMillis - lastTimeMillis) / 1000f;
					world.update(deltaTime);
					jLabelScore.setText("Score: " + bird.getScore());
					jLabelLives.setText("Lives: " + bird.getLives());
					
					if(bird.isAlive()){
						timer.stop();
				//		add(jLabelGameOver);
					}
					
					gameCanvas.repaint();
					
					lastTimeMillis = currentTimeMillis;
				}
			});
			
			lastTimeMillis = System.currentTimeMillis();
			timer.start();
	}

	@Override
	public void crashTube(Tube tube) {
		bird.removeLive();
		bird.setScore(bird.getScore()-1);
		bird.setPositionY((int)tube.getCenter());
		
	}

	@Override
	public void catchHeart(Heart heart) {
		bird.catchHeart();
		heart.setPositionY(-50);
	}

	@Override
	public void outOf() {
		if(bird.getPositionY()>MainFrame.HEIGHT){
			bird.setPositionY(0);
		}
		if(bird.getPositionY()<0){
			bird.setPositionY(MainFrame.HEIGHT);
		}
		
	}

}

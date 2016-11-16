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
		
		
		add(back);
		add(pause);
		
		Bird bird = new Bird("Flappik",240,400);
		World world = new World(bird, this);
		world.addTube(new Tube(400, 400));
		world.addTube(new Tube(600, 300));
		world.addTube(new Tube(800, 500));

		
		world.addHeart(new Heart(500,450));
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
	
					
					gameCanvas.repaint();
					
					lastTimeMillis = currentTimeMillis;
				}
			});
			
			lastTimeMillis = System.currentTimeMillis();
			timer.start();
			
		//	System.out.println(world);
	}

	@Override
	public void crashTube(Tube tube) {
		System.out.println("bum");
		
	}

	@Override
	public void catchHeart(Heart heart) {
		System.out.println("mnham");
		
	}

	@Override
	public void outOf() {
		System.out.println("papa");
		
	}

}

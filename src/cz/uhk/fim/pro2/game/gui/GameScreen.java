package cz.uhk.fim.pro2.game.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.sun.prism.paint.Color;

import cz.uhk.fim.pro2.game.model.Bird;
import cz.uhk.fim.pro2.game.model.Heart;
import cz.uhk.fim.pro2.game.model.Tube;
import cz.uhk.fim.pro2.game.model.World;

public class GameScreen extends Screen {

	public GameScreen(MainFrame mainFrame) {
		super(mainFrame);
		JButton jButtonBack = new JButton("Back");
		JButton jButtonPause = new JButton("Pause");
		add(jButtonBack);
		add(jButtonPause);	
		jButtonBack.setBounds(20, 20, 80, 80);
		jButtonPause.setBounds(380,20,80,80);
		
		jButtonBack.addActionListener(new ActionListener(){
			@Override
            public void actionPerformed(ActionEvent e) {
				//System.out.println("??");
				mainFrame.setScreen(new HomeScreen(mainFrame));
           }
			
		});
		
		Bird bird = new Bird("Flappik",240,400);
		World world = new World(bird);
		world.addTube(new Tube(400,400, Color.GREEN));
		world.addTube(new Tube(600,300, Color.GREEN));
		world.addTube(new Tube(800,500, Color.GREEN));
		
		world.addHeart(new Heart(500,450));
		System.out.println(world.toString());
		
		GameCanvas gameCanvas = new GameCanvas(world);
		add(gameCanvas);
		gameCanvas.setBounds(0,0,MainFrame.WIDTH,MainFrame.HEIGHT);
	}

}

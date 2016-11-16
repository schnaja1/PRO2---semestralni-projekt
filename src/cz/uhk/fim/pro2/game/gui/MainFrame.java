package cz.uhk.fim.pro2.game.gui;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	
	public final static int WIDTH = 480;
	public final static int HEIGHT = 800;
	
	protected Screen actualScreen;
	
	public MainFrame(){
		setSize(WIDTH,HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setTitle("Flappy Bird");
		setResizable(false);
		
	}
	
	public void setScreen(Screen screen){
		if(actualScreen != null){
			remove(actualScreen);
		}
		actualScreen = screen;
		add(screen);
		revalidate();
	}
}

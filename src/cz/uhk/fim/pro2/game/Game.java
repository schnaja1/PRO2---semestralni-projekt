package cz.uhk.fim.pro2.game;

import cz.uhk.fim.pro2.game.gui.HomeScreen;
import cz.uhk.fim.pro2.game.gui.MainFrame;

public class Game {

	public static void main(String[] args) {
		MainFrame mainFrame =new MainFrame();
		mainFrame.setScreen(new HomeScreen(mainFrame));
	}

}



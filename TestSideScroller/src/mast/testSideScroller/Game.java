package mast.testSideScroller;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import mast.testSideScroller.states.*;

public class Game extends StateBasedGame{

	public static Game game;
	private final static int WIDTH = 512;
	private final static int HEIGHT = 512;
	
	public Game(String name) {
		super(name);
	}

	public static void main(String[] args){
		game = new Game("Platformer");
		AppGameContainer appGC;
		try {
			appGC = new AppGameContainer(game);
			appGC.setDisplayMode(WIDTH, HEIGHT, false);
			appGC.setShowFPS(false);
			appGC.setTargetFrameRate(60);
			
			appGC.setMaximumLogicUpdateInterval(20);//this makes it so that the speed of the game isn't connected to the FPS
			appGC.setMinimumLogicUpdateInterval(20);
			
			appGC.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
		// test - Marc
	}
	
	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		addState(new MainMenu());
		addState(new PlayGame());
		addState(new MapMaker());
	}

}

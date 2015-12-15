package mast.testSideScroller;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import mast.testSideScroller.states.MainMenu;

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
			appGC.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		addState(new MainMenu());
	}

}

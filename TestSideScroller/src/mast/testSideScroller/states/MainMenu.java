package mast.testSideScroller.states;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import mast.testSideScroller.tools.Button;
import mast.testSideScroller.tools.States;

public class MainMenu extends BasicGameState{
	
	Button play, make, exit;
	
	@Override
	public void init(GameContainer gc, StateBasedGame game) throws SlickException {
		
		play = new Button("res/imgs/ui/play/");
		make = new Button("res/imgs/ui/make/");
		exit = new Button("res/imgs/ui/exit/");
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException {
		g.setBackground(Color.blue);
		play.draw(g, 160, 128);
		make.draw(g, 160, 224);
		exit.draw(g, 160, 320);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int delta) throws SlickException {
		
		if(play.update(gc.getInput())){
			System.out.println("play");
			game.enterState(States.PlayGame);
			//enters the game
		}
		
		
		if(make.update(gc.getInput())){
			System.out.println("make");
			game.enterState(States.MapMaker);
			//enters MapMaker(think Mario maker type thing)
		}
		
		if(exit.update(gc.getInput())){
			System.out.println("exit");
			gc.exit();
		}
		
	}

	@Override
	public int getID() {
		return States.MainMenu;
	}

}

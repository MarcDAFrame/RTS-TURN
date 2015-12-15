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
		
		play = new Button("res/imgs/UI/play/");
		make = new Button("res/imgs/UI/make/");
		exit = new Button("res/imgs/UI/exit/");
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException {
		g.setBackground(Color.blue);
		play.draw(g, 0, 0);
		make.draw(g, 0, 64);
		exit.draw(g, 0, 128);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int delta) throws SlickException {
		
		if(play.update(gc.getInput())){
			System.out.println("play");
		}
		
		if(make.update(gc.getInput())){
			System.out.println("make");
		}
		
		if(exit.update(gc.getInput())){
			System.out.println("exit");
		}
		
	}

	@Override
	public int getID() {
		return States.MainMenu;
	}

}

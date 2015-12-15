package mast.testSideScroller.states;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import mast.testSideScroller.tools.States;

public class MapMaker extends BasicGameState{
	
	//selectedBlock 0 = nothing, 1 = dirt, 2 = stone, 3 = metal, 4 = specialBlock, 5 = air1, 6 = air2, 7 = air3, 8 = air4
	static int selectedBlock = 0;
	
	@Override
	public void init(GameContainer gc, StateBasedGame game) throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		g.setBackground(Color.red);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int delta) throws SlickException {
		// TODO Auto-generated method stub
		Input input = gc.getInput();
		if(input.isKeyDown(Input.KEY_1)){
			selectedBlock = 1;
			//dirt
		}
		if(input.isKeyDown(Input.KEY_2)){
			selectedBlock = 2;
			//stone
		}
		if(input.isKeyDown(Input.KEY_3)){
			selectedBlock = 3;
			//metal
		}
		if(input.isKeyDown(Input.KEY_4)){
			selectedBlock = 4;
			//specialBlock
		}
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return States.MapMaker;
	}

}

package mast.testSideScroller.states;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import mast.testSideScroller.entites.Player;
import mast.testSideScroller.tools.Map;
import mast.testSideScroller.tools.Resources;
import mast.testSideScroller.tools.States;

public class PlayGame extends BasicGameState{

	private Player player;
	
	@Override
	public void init(GameContainer gc, StateBasedGame game) throws SlickException {
		Map.mapInit();
		player = new Player(gc);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException {
		g.setBackground(Color.green);
		g.drawImage(Resources.returnImage("tileSheet"), 0, 0);
		player.render(g);
		Map.mapDraw(g);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int delta) throws SlickException {
		player.tick(delta);
	}

	@Override
	public int getID() {
		return States.PlayGame;
	}

}

package mast.testSideScroller.states;

import java.io.IOException;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import mast.testSideScroller.tools.Map;
import mast.testSideScroller.tools.States;

public class MapMaker extends BasicGameState {

	// selectedBlock 0 = nothing, 1 = dirt, 2 = stone, 3 = metal, 4 =
	// specialBlock, 5 = air1, 6 = air2, 7 = air3, 8 = air4
	static int selectedBlock = 0;
	String path;
	Map map;
	TextField mapNameGetter;
	private Boolean TextFieldOpen = true;

	@Override
	public void init(GameContainer gc, StateBasedGame game) throws SlickException {

		mapNameGetter = new TextField(gc, gc.getDefaultFont(), 106, 236, 300, 22);

		if (TextFieldOpen == false) {
			System.out.println("why");
			try {
				map = new Map(path);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException {
		g.setBackground(Color.red);
		if (TextFieldOpen) {
			mapNameGetter.render(gc, g);
			g.setBackground(Color.cyan);
		}

	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int delta) throws SlickException {
		Input input = gc.getInput();

		if (TextFieldOpen) {
			if (input.isKeyPressed(Input.KEY_ENTER)) {
				path = "saves/" + mapNameGetter.getText() + ".txt";
				TextFieldOpen = false;
			}
		}

		if (TextFieldOpen == false) {
			if (input.isKeyPressed(Input.KEY_GRAVE)) {// that weird french icon
				selectedBlock = 0;
				System.out.println("selected block: nothing");
				// nothing
			}
			if (input.isKeyPressed(Input.KEY_1)) {
				selectedBlock = 1;
				System.out.println("selected block: dirt");
				// dirt
			}
			if (input.isKeyPressed(Input.KEY_2)) {
				selectedBlock = 2;
				System.out.println("selected block: stone");
				// stone
			}
			if (input.isKeyPressed(Input.KEY_3)) {
				selectedBlock = 3;
				System.out.println("selected block: metal");
				// metal
			}
			if (input.isKeyPressed(Input.KEY_4)) {
				selectedBlock = 4;
				System.out.println("selected block: specalBlock");
				// specialBlock
			}
			if (input.isKeyPressed(Input.KEY_5)) {
				selectedBlock = 5;
				System.out.println("selected block: air1");
				// airBlock1
			}
		}

	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return States.MapMaker;
	}

}

package mast.testSideScroller.states;

import java.io.File;
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
	String selectedBlock = "a0";
	String path;
	int mapWidthGetterInt = 0, mapHeightGetterInt = 0;
	
	Map map;
	TextField mapNameGetter, mapWidthGetter, mapHeightGetter;
	String error = "";
	private Boolean textFieldOpen = true;

	@Override
	public void init(GameContainer gc, StateBasedGame game) throws SlickException {

		mapNameGetter = new TextField(gc, gc.getDefaultFont(), 53, 236, 415, 22);
		mapWidthGetter = new TextField(gc, gc.getDefaultFont(), 53, 322, 128, 22);
		mapHeightGetter = new TextField(gc, gc.getDefaultFont(), 331, 322, 128, 22);

	}

	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException {
		g.setBackground(Color.red);
		if (textFieldOpen) {
			g.setColor(Color.black);
			g.drawString("Map Name:", 53, 218);
			g.drawString("Map Width:", 53, 304);
			g.drawString("Map Height:", 331, 304);
			
			mapNameGetter.render(gc, g);
			mapWidthGetter.render(gc, g);
			mapHeightGetter.render(gc, g);
			g.setBackground(Color.white);
			g.setColor(Color.red);
			g.drawString(error, 53, 342);
		}

		if (textFieldOpen == false) {
			map.mapDraw(g, Map.getMapData());
		}

	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int delta) throws SlickException {
		Input input = gc.getInput();

		if (textFieldOpen) {
			
			if (input.isKeyPressed(Input.KEY_ENTER)) {
				
					if(mapNameGetter.getText() != null){
						path = "saves/" + mapNameGetter.getText() + ".txt";
						File f = new File(path);
						if(f.exists() && !f.isDirectory()) {
							
							textFieldOpen = false;
														
						}else{
							if(mapWidthGetter.getText() != "" || mapHeightGetter.getText() != ""){ // need to check the textFields TODO MARC!
								mapWidthGetterInt = Integer.parseInt(mapWidthGetter.getText()); 
								mapHeightGetterInt = Integer.parseInt(mapHeightGetter.getText());
								
								
								if(mapWidthGetterInt >= 512 && mapHeightGetterInt >= 512){
									
									textFieldOpen = false;
									System.out.println(mapWidthGetterInt);
									System.out.println(mapHeightGetterInt);
									
								}
							}else{
								error = "ERROR: specify width and height";
								System.out.println(error);
							}

						}
						
					}
					
				
				
			}
		}

		if (textFieldOpen == false) {

			if (input.isKeyPressed(Input.KEY_GRAVE)) {// that weird french icon
				selectedBlock = "00";
				System.out.println("selected block: nothing");
				// nothing
			}
			if (input.isKeyPressed(Input.KEY_1)) {
				selectedBlock = "a0";
				System.out.println("selected block: dirt");
				// dirt
			}
			if (input.isKeyPressed(Input.KEY_2)) {
				selectedBlock = "a1";
				System.out.println("selected block: stone");
				// stone
			}
			if (input.isKeyPressed(Input.KEY_3)) {
				selectedBlock = "a2";
				System.out.println("selected block: metal");
				// metal
			}
			if (input.isKeyPressed(Input.KEY_4)) {
				selectedBlock = "a3";
				System.out.println("selected block: specalBlock");
				// specialBlock
			}
			if (input.isKeyPressed(Input.KEY_5)) {
				selectedBlock = "b1";
				System.out.println("selected block: air1");
				// airBlock1
			}
			if (input.isKeyPressed(Input.KEY_6)) {
				selectedBlock = "b1";
				System.out.println("selected block: air1");
				// airBlock1
			}
			if (input.isKeyPressed(Input.KEY_7)) {
				selectedBlock = "b1";
				System.out.println("selected block: air1");
				// airBlock1
			}
			if (input.isKeyPressed(Input.KEY_8)) {
				selectedBlock = "b1";
				System.out.println("selected block: air1");
				// airBlock1
			}

			int x = input.getMouseX();
			int y = input.getMouseY();
			if (input.isMouseButtonDown(0)) {
				map.mapEdit(gc, selectedBlock, path, x, y);
			}

		}

		if (textFieldOpen == false) {
			// System.out.println("test");
			try {
				map = new Map(path, mapWidthGetterInt, mapHeightGetterInt);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return States.MapMaker;
	}

}

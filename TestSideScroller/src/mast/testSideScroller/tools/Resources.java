package mast.testSideScroller.tools;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Resources {
	private static Image tileSheet = null;
	private static Image exit = null;

	public void imageInit() {

		try {
			tileSheet = new Image("res/imgs/tiles/Tile Sheet1.png");
			exit = new Image("res/imgs/ui/play/");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Image returnImage(String getter) {

		switch (getter) {
		case "tileSheet":
			return tileSheet;
		case "exit":
			return exit;
		default:
			break;
		}

		return null;
	}

}

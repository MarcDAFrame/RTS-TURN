package mast.testSideScroller.tools;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Resources {
	private static Image tileSheet = null;
	private static Image exit = null;

	public static void imageInit() {

		try {
			tileSheet = new Image("res/imgs/tiles/Tile Sheet2.png");
			exit = new Image("res/imgs/ui/play/0.png");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Image returnImage(String getter) {
		imageInit();
		if (getter == "tileSheet") {
			return tileSheet;
		} else if (getter == "exit") {
			return exit;
		} else {
			return null;
		}

	}

}

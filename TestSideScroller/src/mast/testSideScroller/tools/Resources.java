package mast.testSideScroller.tools;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Resources {
	private static Image tileSheet = null;
	private static Image exit = null;

	public static void imageInit() {

		try {
			tileSheet = new Image("res/imgs/tiles/Tile Sheet2.png");
			exit = new Image("res/imgs/ui/play/0.png");
		} catch (SlickException e) {
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

	public static Image[][] spriteSheetCutter(Image sheet, int column, int row){
		Image[][] tileSheetArray = new Image[column/32][row/32];
		
		tileSheet = new SpriteSheet(sheet, 32, 32);
		
		for(int x = 0; x < column/32; x++){
			for(int y = 0; y < row/32; y++){
				tileSheetArray[x][y] = tileSheet.getSubImage(x*32, y*32, 32, 32);
			}
		}
		return tileSheetArray;
	}

}

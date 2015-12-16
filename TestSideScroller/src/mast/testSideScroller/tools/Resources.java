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
	
	private Image[][] spriteSheetCutter(Image sheet, int colum, int row, int width, int height){
		Image[][] listOfImages = new Image[colum * row];
		
		for(int x = 0; x < colum; x++){
			for(int y = 0; y < row; y++){
				Image[x][y] = 
			}
		}
	}

}

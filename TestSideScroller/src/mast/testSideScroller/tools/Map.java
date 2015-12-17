package mast.testSideScroller.tools;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class Map {
	
	private static Image[][] tileSheetArray;
	
	public static void mapInit(){
		tileSheetArray = Resources.spriteSheetCutter(Resources.returnImage("tileSheet"), 256, 256);
	}
	
	public static void mapParse() {
		
	}
	
	public static void mapDraw(Graphics g){
		g.drawImage(tileSheetArray[0][0], 200, 200);
	}
}

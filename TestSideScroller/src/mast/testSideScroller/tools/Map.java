package mast.testSideScroller.tools;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class Map {
	private static int mapWidth = 0, mapHeight = 0;
	private static Image[][] tileSheetArray;
	private static String[][] mapData;
	
	public static void mapInit(){
		tileSheetArray = Resources.spriteSheetCutter(Resources.returnImage("tileSheet"), 256, 256);
	}
	
	public static void mapParse() {
		String tempMapLineData = null;
		for(int i = 0; i < mapWidth; i++){
			for(int j = 0; j < mapWidth; j++){
				mapData[i][j] = tempMapLineData.split(",");
			}
			
			tempMapLineData = null;
		}
	}
	public static void mapWrite(){
		
	}
	
	public static void mapDraw(Graphics g){
		g.drawImage(tileSheetArray[0][0], 200, 200);
	}
}

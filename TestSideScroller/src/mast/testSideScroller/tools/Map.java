package mast.testSideScroller.tools;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class Map {
	private static int mapWidth = 1, mapHeight = 1;
	private static Image[][] tileSheetArray;
	private static String[][] mapData;
	
	
	public Map(String path) throws IOException{
		mapInit();
		mapParse(path);
	}
	
	public static void mapInit(){
		tileSheetArray = Resources.spriteSheetCutter(Resources.returnImage("tileSheet"), 256, 256);
	}
	
	public static void mapParse(String path) throws IOException {
		String tempMapLineData = null;
		
		FileReader fr = new FileReader("path"); 
		BufferedReader br = new BufferedReader(fr); 
		
		for(int i = 0; i < mapWidth; i++){
			tempMapLineData = br.readLine();
			for(int j = 0; j < mapHeight; j++){
				tempMapLineData.split(",");
				mapData[i/32][j/32] = tempMapLineData;
			}
			
			tempMapLineData = null;
		}
		for(int i=0; i<1; i++){
			for(int j = 0; j<1; j++){
				System.out.println(mapData[i][j]);
			}
		}
	}
	
	
	
	public static void mapWrite(){
		
	}
	
	public static void mapDraw(Graphics g){
		g.drawImage(tileSheetArray[0][0], 200, 200);
	}
}

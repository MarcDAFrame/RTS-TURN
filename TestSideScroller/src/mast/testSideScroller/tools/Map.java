package mast.testSideScroller.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class Map {
	private static int mapWidth = 512, mapHeight = 512;
	private static Image[][] tileSheetArray;
	private static String [][] mapData = new String[mapHeight/32][mapWidth/32];

	public Map(String path) throws IOException {
		mapInit();
		mapParse(path);
		tileSheetArray = Resources.spriteSheetCutter(Resources.returnImage("tileSheet"), 256, 256);

	}

	public static void mapInit() {
	}

	public static void mapParse(String path) throws IOException {
		String [] tempMapLineArray;
		String tempMapLineData;
		

		FileReader fr = new FileReader(path);
		BufferedReader br = new BufferedReader(fr);

		// File f = new File(path);
		// System.out.println(path);
		// if(f.exists() && !f.isDirectory()) {
		// System.out.println("yes");
		// }

		for (int i = 0; i < mapHeight/32; i++) {

			tempMapLineData = br.readLine();
			tempMapLineArray = tempMapLineData.split(",");

			for (int j = 0; j < mapWidth/32; j++) {
				
				System.out.println(tempMapLineArray[j]);
				mapData[i][j] = tempMapLineArray[j]; //this works now
				
			}

		}

	}

	public static void mapWrite(String path) throws IOException {
		FileWriter fw = new FileWriter(path);
		PrintWriter pw = new PrintWriter(fw);
	}

	public static void mapWrite() {

	}

	public static void mapDraw(Graphics g) {
		g.drawImage(tileSheetArray[0][0], 200, 200);
	}
}

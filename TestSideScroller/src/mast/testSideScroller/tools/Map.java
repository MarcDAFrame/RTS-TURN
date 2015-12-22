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
	private static String[][] mapData = new String[mapHeight / 32][mapWidth / 32];

	public Map(String path) throws IOException {
		System.out.println("Map");
		mapInit();
		File f = new File(path);
		if (f.exists() && !f.isDirectory()) {
			System.out.println("test");

		} else {
			System.out.println("test");
			mapCreate(path);
		}
		mapParse(path);
		tileSheetArray = Resources.spriteSheetCutter(Resources.returnImage("tileSheet"), 256, 256);

	}

	public static void mapInit() {
	}

	public static void mapParse(String path) throws IOException {
		String[] tempMapLineArray = new String[mapWidth/32];
		String tempMapLineData;

		FileReader fr = new FileReader(path);
		BufferedReader br = new BufferedReader(fr);

		// File f = new File(path);
		// System.out.println(path);
		// if(f.exists() && !f.isDirectory()) {
		// System.out.println("yes");
		// }

		for (int i = 0; i < mapHeight / 32; i++) {

			tempMapLineData = br.readLine();
			tempMapLineArray = tempMapLineData.split(",");

			for (int j = 0; j < mapWidth / 32; j++) {

				System.out.println(tempMapLineArray[j]);
				mapData[i][j] = tempMapLineArray[j]; // this works now

			}

		}

	}

	public static void mapWrite(String path) throws IOException {
		FileWriter fw = new FileWriter(path);
		PrintWriter pw = new PrintWriter(fw);

		for (int i = 0; i < 3; i++) {

			for (int j = 0; j < 3; j++) {
				pw.print(mapData[i][j] + ",");
			}
			pw.println();

		}

		pw.close();

	}

	public static void mapCreate(String path) throws IOException {

		FileWriter fw = new FileWriter(path);
		PrintWriter pw = new PrintWriter(fw);

		File f = new File(path);

		f.createNewFile();
		f.delete();
		System.out.println(f.getPath());

		for (int i = 0; i < mapWidth/32; i++) {
			for (int j = 0; j < mapHeight/32; j++) {
				pw.print("a0,");
			}
			pw.println();
		}
		pw.close();

	}

	public static void mapDraw(Graphics g, String [][] mapData) {
		
		for(int i = 0; i < mapHeight/32; i++){
			for(int j = 0; j < mapHeight/32; j++){
				if(mapData[i][j].equals("a0")){
					g.drawImage(tileSheetArray[0][0], i*32, j*32);
					//System.out.println("working");
					
				}
			}
		}
		
		
	}
	
	public static String[][] getMapData(){
		return mapData;
	}
}

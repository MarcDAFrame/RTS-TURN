package mast.testSideScroller.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class Map {
	private static int mapWidth, mapHeight;
	private static Image[][] tileSheetArray;
	private static String[][] mapData;

	public Map(String path, int mapWidth, int mapHeight) throws IOException {
		File f = new File(path);
		if (f.exists() == false && !f.isDirectory() == false) {
			mapCreate(path);
		}
		
		Map.mapWidth = mapWidth;
		Map.mapHeight = mapHeight;
		
		mapData = new String[mapHeight / 32][mapWidth / 32];
		
		mapParse(path);
		tileSheetArray = Resources.spriteSheetCutter(Resources.returnImage("tileSheet"), 256, 256);

	}

	public static void mapParse(String path) throws IOException {
		String[] tempMapLineArray = new String[mapWidth / 32];
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

				// System.out.println(tempMapLineArray[j]);
				mapData[j][i] = tempMapLineArray[j]; // this works now

			}

		}

	}

	public static void mapWrite(String path, String[][] mapData) throws IOException {
		FileWriter fw = new FileWriter(path);
		PrintWriter pw = new PrintWriter(fw);

		for (int i = 0; i < mapHeight / 32; i++) {

			for (int j = 0; j < mapWidth / 32; j++) {
				pw.print(mapData[j][i] + ",");
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
		// System.out.println(f.getPath());

		for (int i = 0; i < mapWidth / 32; i++) {
			for (int j = 0; j < mapHeight / 32; j++) {
				pw.print("a0,");
			}
			pw.println();
		}
		pw.close();

	}

	public void mapEdit(GameContainer gc, String ID, String path, int x, int y) {

		mapData[x / 32][y / 32] = ID;
		try {
			mapWrite(path, mapData);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void mapDraw(Graphics g, String[][] mapData) {

		for (int i = 0; i < mapHeight / 32; i++) {
			for (int j = 0; j < mapHeight / 32; j++) {

				if (mapData[i][j].equals("00")) { // nothing
					g.drawImage(tileSheetArray[7][7], i * 32, j * 32);
					// System.out.println("working");

				}
				if (mapData[i][j].equals("a0")) { // grass
					g.drawImage(tileSheetArray[0][0], i * 32, j * 32);
					// System.out.println("working");

				}
				if (mapData[i][j].equals("a1")) { // stone
					g.drawImage(tileSheetArray[1][0], i * 32, j * 32);

				}
				if (mapData[i][j].equals("a2")) { // metal
					g.drawImage(tileSheetArray[2][0], i * 32, j * 32);

				}
				if (mapData[i][j].equals("a3")) { // mystery block
					g.drawImage(tileSheetArray[3][0], i * 32, j * 32);

				}
				if (mapData[i][j].equals("b1")) { // air1
					g.drawImage(tileSheetArray[0][1], i * 32, j * 32);

				}
				if (mapData[i][j].equals("b2")) { // air2
					g.drawImage(tileSheetArray[1][1], i * 32, j * 32);

				}
				if (mapData[i][j].equals("b3")) { // air3
					g.drawImage(tileSheetArray[2][1], i * 32, j * 32);

				}
				if (mapData[i][j].equals("b4")) { // air4
					g.drawImage(tileSheetArray[3][1], i * 32, j * 32);

				}

			}
		}

		// g.drawImage(Resources.returnImage("tileSheet").getSubImage(32, 0, 32,
		// 32), 200, 200);

	}

	public static String[][] getMapData() {
		return mapData;
	}

}

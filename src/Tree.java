import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;


public class Tree extends Applet{
	public static int tree_xPos = 250,
					  tree_yPos = 100,
					  tree_width = 200,
					  tree_height = 800,
					  stump_width = 100,
					  stump_height = stump_width,
					  tree_levels = 20,
					  tree_x_diff = 20,
					  numberOfOrnaments = 7, 
					  Ornament_width = 10,
					  Ornament_height = Ornament_width;
	
	static int[] xPos_Right = new int[3 + ((tree_levels - 1) * 3)];
	static int[] yPos_Right = new int[3 + ((tree_levels - 1) * 3)];
	
	static int[] xPos_Left = new int[3 + ((tree_levels - 1) * 3)];
	static int[] yPos_Left = new int[3 + ((tree_levels - 1) * 3)];
	
	static int[] total_xPos,
				 total_yPos;
	
	public void paint(Graphics g){
		setSize(1000, 1000);
		genPolyPoints(g);
		drawTree(g);
	}// End of method
	
	public static void drawTree(Graphics g){
		drawStump(g, stump_width, stump_height, Color.DARK_GRAY);
		drawLevel(g, total_xPos, total_yPos);
		drawOrnaments(g, tree_xPos, tree_yPos, Ornament_width);
		drawStar(g, tree_xPos + (tree_width / 2) + (stump_width / 2) - 15, tree_yPos - 20);
	}// End of drawTree
	
	
	public static void genPolyPoints(Graphics g){
		int xOffset = tree_width / tree_levels;
		int yOffset = tree_height / tree_levels;
		
		int tree_Point_xPos = tree_xPos + (tree_width / 2) + (stump_width / 2); 
		int tree_Point_yPos = tree_yPos;
		
		xPos_Left[0] = tree_Point_xPos;
		yPos_Left[0] = tree_Point_yPos;
		
		for(int i = 0; i < tree_levels; i++){
			xPos_Left[i * 3] = tree_Point_xPos;
			yPos_Left[i * 3] = tree_Point_yPos;
			
			xPos_Left[(i * 3) + 1] = tree_Point_xPos - (xOffset * 2) - (tree_x_diff * i);
			yPos_Left[(i * 3) + 1] = tree_Point_yPos + yOffset;
			
			xPos_Left[(i * 3) + 2] = tree_Point_xPos;
			yPos_Left[(i * 3) + 2] = tree_Point_yPos + yOffset;
			
			tree_Point_xPos = xPos_Left[(i * 3) + 2];
			tree_Point_yPos = yPos_Left[(i * 3) + 2];
		}// End of loop
		
		tree_Point_xPos = tree_xPos + (tree_width / 2) + (stump_width / 2); 
		tree_Point_yPos = tree_yPos;
		
		for(int i = 0; i < tree_levels; i++){
			xPos_Right[i * 3] = tree_Point_xPos;
			yPos_Right[i * 3] = tree_Point_yPos;
			
			xPos_Right[(i * 3) + 1] = tree_Point_xPos + (xOffset * 2) + (tree_x_diff * i);
			yPos_Right[(i * 3) + 1] = tree_Point_yPos + yOffset;
			
			xPos_Right[(i * 3) + 2] = tree_Point_xPos;
			yPos_Right[(i * 3) + 2] = tree_Point_yPos + yOffset;
			
			tree_Point_xPos = xPos_Right[(i * 3) + 2];
			tree_Point_yPos = yPos_Right[(i * 3) + 2];
		}// End of loop
		
		int total_points = xPos_Right.length * 2;
		
		total_xPos = new int[total_points];
		total_yPos = new int[total_points];
	
		
		appendArray(xPos_Right, xPos_Left, total_xPos);
		appendArray(yPos_Right, yPos_Left, total_yPos);
	}// End of genPolyPoints
	
	public static void drawOrnaments(Graphics g, int xPos, int yPos, int width){
		for(int i = 0; i < tree_levels; i++){
			int Ornaments_xPos = xPos_Left[(i * 3) + 1];
			int Ornaments_yPos = yPos_Left[(i * 3) + 1];
			for(int n = 0; n < numberOfOrnaments; n++){
				g.setColor(Color.RED);
				g.fillOval(Ornaments_xPos, Ornaments_yPos, 10, 10);
				g.setColor(Color.BLACK);
				g.drawOval(Ornaments_xPos, Ornaments_yPos, 10, 10);
				Ornaments_xPos += ((xPos_Right[(i * 3) + 1] - (xPos_Left[(i * 3) + 1])) / (numberOfOrnaments - 1));
			}
		}
	}
	
	public static void appendArray(int[] array_1, int[] array_2, int[] final_array){
		for(int i = 0; i < array_1.length; i++){
			final_array[i] = array_1[i];
		}
		
		for(int i = 0; i < array_2.length; i++){
			final_array[array_1.length + i] = array_2[i];
		}
	}
	
	public static void drawStar(Graphics g, int xPos, int yPos){
		g.setColor(Color.YELLOW);
		// X Pos array for the star to be drawn 
		int Star_xPos[] = {xPos + 15, xPos + 12, xPos, xPos + 10, xPos + 7, xPos + 15, xPos + 22, xPos + 20, xPos + 30, xPos + 18};
		// Y Pos array for the star to be drawn 
		int Start_yPos[] = {yPos - 10, yPos + 5, yPos + 5, yPos + 15, yPos + 30, yPos + 21, yPos + 30, yPos + 15, yPos + 5, yPos + 5};

		g.fillPolygon(Star_xPos, Start_yPos, 10);	// Draws the 5 point star
		g.setColor(Color.BLACK);
		g.drawPolygon(Star_xPos, Start_yPos, 10);	// Draws the 5 point star 
	}
	
	public static void drawLevel(Graphics g, int[] xPos, int[] yPos){
		g.setColor(Color.GREEN);
		g.fillPolygon(xPos, yPos, xPos.length);
	
	}// End of class
	
	public static void printArray(int[] array){
		String array_words = "";
		for(int i = 0; i < array.length; i++){
			array_words += array[i] + ", ";
		}
		System.out.println(array_words);
	}
	
	public static void drawStump(Graphics g, int width, int height, Color stumpColor){
		g.setColor(stumpColor);
		g.fillRect(tree_xPos + (tree_width / 2), tree_yPos + tree_height, width, height);
	}// End of class
}// End of class

// sec 6 #1 flip image

import acm.program.*;
import acm.graphics.*;

public class sec6_1 extends GraphicsProgram {

	public void run() {
		
		setSize(800,600);
		
		GImage image = new GImage("milkmaid.jpg");
		GImage flip = flipImage(image);
		
		image.scale(.3);
		add(image, 100, 100);
		
		flip.scale(.3);
		add(flip,400,100);
	}
	
	private GImage flipImage(GImage image) {
		int[][] pixelArray = image.getPixelArray();
		int height = pixelArray.length;
		int width = pixelArray[0].length;
		for (int j = 0 ; j < height ; j++ ) {
			for (int i = 0 ; i < width / 2 ; i++ ) {
				int pixelLeft = pixelArray[j][i];
				int pixelRight = pixelArray[j][width-i-1];
				pixelArray[j][i] = pixelRight;
				pixelArray[j][width-i-1] = pixelLeft;
			}
		}
		return new GImage(pixelArray);
	}
	
	
}


import java.awt.*;


public class Scale2 {
    
    static MyImage execute(MyImage input) {
	int width1, height1, width2, height2, i, j;
	float scalex,scaley;
		
	width1 = input.width;
	height1 = input.height;
	System.out.println(width1);
	System.out.println(height1);
	//scalex = (float)(1160)/(float)(width1);//haikei,shell,haikei
	//scalex = (float)(900)/(float)(width1);//sealion2,3,4
	//scalex = (float)(500)/(float)(width1);//sealion5
	//scalex = (float)(1600)/(float)(width1);//sealion
	scalex = (float)(400)/(float)(width1);//shell5
	//scaley = (float)(1600)/(float)(height1);//haikei
	//scaley = (float)(700)/(float)(height1);//sealion2,3,4,5
	//scaley = (float)(1160)/(float)(height1);//sealion,shell
	scaley = (float)(400)/(float)(height1);//shell5
	width2 = (int)(input.width * scalex);
	height2 = (int)(input.height * scaley);
	System.out.println(width2);
	System.out.println(height2);
	MyImage output = new MyImage(width2, height2);
	
		
	for(i = 0; i < height2; i++) {
	    for(j = 0; j < width2; j++) {
		float x1, y1, r, g, b;
				
		x1 = calcX(j, i, width1, height1, scalex);
		y1 = calcY(j, i, width1, height1, scaley);

		calcRGB(input, output, x1, y1, j, i);

	    }
	}

	return output;

    }

	
    static float calcX(int x2, int y2, int width1, int height1, float scalex) {
	float x;

	x  = (float)(x2 / scalex);
	
	if(x < 0.0 || x > (float)width1) {
	    System.out.println("EXIT! x=" + x);
	    System.exit(-1);
	}

	return x;
    }

	
    static float calcY(int x2, int y2, int width1, int height1, float scaley) {
	float y;

	y = (float)(y2 / scaley);


	if(y < 0.0 || y > (float)height1) {
	    System.out.println("EXIT! y=" + y);
	    System.exit(-1);
	}

	return y;
    }




    static void calcRGB(MyImage input, MyImage output, float x1, float y1, int x2, int y2) {

	int xx = (int)(x1 + 0.5);
	if(xx < 0) xx = 0;
	if(xx >= input.width) xx = input.width - 1;
	int yy = (int)(y1 + 0.5);
	if(yy < 0) yy = 0;
	if(yy >= input.height) yy = input.height - 1;

	Color color = input.getColor(xx, yy);
	int value = color.getRGB();
	output.setColor(x2, y2, color);
	
    }

}

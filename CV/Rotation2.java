import java.awt.*;


public class  Rotation2 {
    //static double SCALEX = 2.0, SCALEY = 2.0;//縦横を２倍する場合
    static double SCALEX = 1.0, SCALEY = 1.0;//縦横を倍しない場合
	

    static MyImage execute(MyImage input) {
	int width1, height1, width2, height2, i, j;
		
	width1 = input.width;
	height1 = input.height;
	width2 = (int)(input.width * SCALEX);
	height2 = (int)(input.height * SCALEY);
	//MyImage output = new MyImage(width2, height2);//180度回転の場合
	MyImage output = new MyImage(height2, width2);//90度回転の場合
	
		
	for(i = 0; i < height2; i++) {
	    for(j = 0; j < width2; j++) {
		double x1, y1, r, g, b;
				
		//x1 = calcX(width2-1-j, i, width1, height1);//90度左回転の場合
		//y1 = calcY(width2-1-j, i, width1, height1);//90度左回転の場合
		x1 = calcX(j, height2-1-i, width1, height1);//90度右回転の場合
		y1 = calcY(j, height2-1-i, width1, height1);//90度右回転の場合
		//x1 = calcX(width2-1-j, height2-1-i, width1, height1);//180度回転の場合
		//y1 = calcY(width2-1-j, height2-1-i, width1, height1);//180度回転の場合

		//calcRGB(input, output, x1, y1, j, i);//180度回転の場合
		calcRGB(input, output, x1, y1, i, j);//90度回転の場合


	    }
	}

	return output;

    }

	
    static double calcX(int x2, int y2, int width1, int height1) {
	double x = 0.0;
	x = x2 / SCALEX;

	

	if(x < 0.0 || x > (double)width1) {
	    System.out.println("EXIT! x=" + x);
	    System.exit(-1);
	}

	return x;
    }

	
    static double calcY(int x2, int y2, int width1, int height1) {
	double y = 0.0;
	y = y2 / SCALEY;

	

	if(y < 0.0 || y > (double)height1) {
	    System.out.println("EXIT! y=" + y);
	    System.exit(-1);
	}

	return y;
    }




    static void calcRGB(MyImage input, MyImage output, double x1, double y1, int x2, int y2) {

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

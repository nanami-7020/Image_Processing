import java.awt.*;


public class Tiling2 {

    static MyImage execute(MyImage input1, MyImage input2) { 

	int width1 = input1.width;
	int width2 = input2.width;
	int height1 = input1.height;
	int height2 = input2.height;	
	int height = (height1 > height2) ? height1 : height2;
	int width = (width1 > width2) ? width1 : width2;
	
	MyImage output = new MyImage(width1+width2, height);//横につなげる場合
		

	for(int i = 0; i < height; i++) {
	    for(int j = 0; j < width1+width2; j++) {
		boolean isProcessed = false;

		if(i < height1 && j < width1) {//１枚目の画像の表示
				    
		    Color color1 = input1.getColor(j, i);
		    output.setColor(j, i, color1);
		    isProcessed = true;
		}
			    

		if(i < height2 && width1 <= j ){//２枚目の画像の表示
					
		    Color color2 = input2.getColor(j-width1, i);	
		    output.setColor(j, i, color2);
		    isProcessed = true;
		}

	    }
	} 

	/*	MyImage output = new MyImage(width, height1+height2);//縦につなげる場合

	for(int i = 0; i < width; i++) {
	    for(int j = 0; j < height1+height2; j++) {
		boolean isProcessed = false;

		if(i < width1 && j < height1) {//１枚目の画像の表示
				    
		    Color color1 = input1.getColor(i, j);
		    output.setColor(i, j, color1);
		    isProcessed = true;
		}
			    

		if(i < width2 && height1 <= j ){//２枚目の画像の表示
					
		    Color color2 = input2.getColor(i,j-height1);	
		    output.setColor(i, j, color2);
		    isProcessed = true;
		}

	    }
	    } */
	return output;

	}

    }

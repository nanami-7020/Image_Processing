import java.awt.Color;


public class GammaCorrection {

    public static MyImage execute(MyImage input) {

	MyImage output = new MyImage(input.width, input.height);
	
	for(int i = 0; i < input.height; i++) {
	    for(int j = 0; j < input.width; j++) {
				
		Color color1 = input.getColor(j, i);

		int r = (int)(255.0*Math.pow(((color1.getRed())/255.0),0.6/1.0));
		int g = (int)(255.0*Math.pow(((color1.getGreen())/255.0),0.7/1.0));
		int b = (int)(255.0*Math.pow(((color1.getBlue())/255.0),0.9/1.0));
		Color color2 = new Color(r, g, b);

		output.setColor(j, i, color2);
	    }
	}
		
	return output;
    }

}


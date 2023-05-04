package com.learnquest.demos;

public interface Color {

	byte getRed();
	void setRed(byte red);
	
	byte getGreen();
	void setGreen(byte green);
	
	byte getBlue();
	void setBlue(byte blue);
	
	default void setRGB(byte red, byte green, byte blue) {
		setRed(red);
		setGreen(green);
		setBlue(blue);
	}
	
	default double getCyan() {
		return getCYMK(this)[0];
	}

	default double getYellow() {
		return getCYMK(this)[1];
	}

	default double getMagenta() {
		return getCYMK(this)[2];
	}

	default double getBlack() {
		return getCYMK(this)[3];
	}

	static double[] getCYMK(Color rgb) {
		double r = ((double)rgb.getRed())/255;
		double g = ((double)rgb.getGreen())/255;
		double b = ((double)rgb.getBlue())/255;
		
		double k = 1 - Math.max(Math.max(r,  g), b);
		double c = (1 - r - k) / (1 - k);
		double y = (1 - g - k) / (1 - k);
		double m = (1 - b - k) / (1 - k);

		return new double[] { c, y, m, k};
	}
	
	static byte[] blend(Color color1, Color color2) {
		return new byte[] { (byte) ((color1.getRed() + color2.getRed()) / 2),
				 			(byte) ((color1.getGreen() + color2.getGreen()) / 2),
				 			(byte) ((color1.getBlue() + color2.getBlue()) / 2) };
	}
}

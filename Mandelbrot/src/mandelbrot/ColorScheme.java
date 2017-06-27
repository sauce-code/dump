package mandelbrot;

import javafx.scene.paint.Color;

public interface ColorScheme {

	public Color getColor(int iterations, int precision);

	public Color getBaseColor();

	public class NiceColors implements ColorScheme {

		private Color[] colors = new Color[] { Color.BLUE, Color.GREEN, Color.YELLOW, Color.ORANGE, Color.RED };

		@Override
		public Color getColor(int iterations, int precision) {
			if (iterations >= precision || iterations <= 0) {
				return getBaseColor();
			}
			int log = (int) ((Math.log10(iterations) / Math.log10(2.0)));
			int colorIndex1 = log % colors.length;
			int colorIndex2 = (log + 1) % colors.length;
//			if (colorIndex1 < 0 || colorIndex2 < 0) {
//				return getBaseColor();
//			}
			return getMeridian(colors[colorIndex1], colors[colorIndex2], Math.pow(2, log), Math.pow(2, log + 1),
					iterations);
		}

		@Override
		public Color getBaseColor() {
			return Color.BLACK;
		}

		private Color getMeridian(Color color1, Color color2, double lowerBorder, double upperBorder, int actualValue) {
			double percent2 = (actualValue - lowerBorder) / (upperBorder - lowerBorder);
			double percent1 = 1 - percent2;
			double red = color1.getRed() * percent1 + color2.getRed() * percent2;
			double green = color1.getGreen() * percent1 + color2.getGreen() * percent2;
			double blue = color1.getBlue() * percent1 + color2.getBlue() * percent2;
			return new Color(red, green, blue, 1.0);
		}

	}

}

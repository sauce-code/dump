package mandelbrot;

import javafx.scene.paint.Color;

public interface ColorScheme2 {

	public Color getColor(int iterations, int precision);

	public Color getBaseColor();

	public class NiceColors implements ColorScheme2 {

		private Color color1 = Color.BLUE;

		private Color color2 = Color.GREEN;

		private Color color3 = Color.YELLOW;

		private Color color4 = Color.ORANGE;

		private Color color5 = Color.RED;

		@Override
		public Color getColor(int iterations, int precision) {
			if (iterations >= precision) {
				return getBaseColor();
			}
			if (iterations < 8) {
				return getMeridian(color1, color2, 0, 7, iterations);
			}
			if (iterations < 16) {
				return getMeridian(color2, color3, 8, 15, iterations);
			}
			if (iterations < 32) {
				return getMeridian(color3, color4, 16, 31, iterations);
			}
			if (iterations < 64) {
				return getMeridian(color4, color5, 32, 63, iterations);
			}
			if (iterations < 128) {
				return getMeridian(color5, color1, 64, 128, iterations);
			}
			return Color.WHITE;
		}

		@Override
		public Color getBaseColor() {
			return Color.BLACK;
		}

		private Color getMeridian(Color color1, Color color2, int lowerBorder, int upperBorder, int actualValue) {
			double percent2 = (double) (actualValue - lowerBorder) / (upperBorder - lowerBorder);
			double percent1 = 1 - percent2;
			double red = color1.getRed() * percent1 + color2.getRed() * percent2;
			double green = color1.getGreen() * percent1 + color2.getGreen() * percent2;
			double blue = color1.getBlue() * percent1 + color2.getBlue() * percent2;
			return new Color(red, green, blue, 1.0);
		}

	}

}

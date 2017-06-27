package mandelbrot;

import org.apache.commons.math3.complex.Complex;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class GUI2 extends Application {

	private static double MANDELBROT_RE_MIN = -2;
	private static double MANDELBROT_RE_MAX = 1;
	private static double MANDELBROT_IM_MIN = -1.2;
	private static double MANDELBROT_IM_MAX = 1.2;

	private Mandelbrot mandelbrot = new Mandelbrot();

	private final static int PRECISION = 100;

	private double width = 1200;

	private double height = 800;

	@Override
	public void start(Stage primaryStage) throws Exception {
		Canvas canvas = new Canvas(width, height);
		setFill(canvas.getGraphicsContext2D());
		VBox vBox = new VBox(canvas);
		BorderPane border = new BorderPane(vBox);
		Scene scene = new Scene(border);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void setFill(GraphicsContext ctx) {
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				double re = (x - width / 2.0) * 4.0 / width;
				double im = (y - height / 2.0) * 4.0 / width;
				int iterations = mandelbrot.compute(new Complex(re, im), PRECISION, 4.0);
				ctx.setFill(getColor(iterations));
				ctx.fillRect(x, y, 1, 1);
			}
		}
	}

	private Color getColor(int iterations) {
		if (iterations < PRECISION) {
			return Color.WHITE;
		} else {
			return Color.BLACK;
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}

package mandelbrot;

import java.util.stream.IntStream;

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
import mandelbrot.ColorScheme.NiceColors;

public class GUI extends Application {

	private double zoom = 1.0;
	
	private double offsetX = -0;
	
	private double offsetY = -0;

	double radius = 4.0;
	
	private Mandelbrot mandelbrot = new Mandelbrot();

	private final static int PRECISION = 64;

	private int width = 1000;

	private int height = 800;

	private ColorScheme colors = new NiceColors();

	private int[][] pixels = new int[width][height];

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
		// @formatter:off
		IntStream.range(0, width).parallel().forEach(x -> 
			IntStream.range(0, height).parallel().forEach(y -> 
				{		
					double re = (x + (offsetX * width) - width / 2.0) * 4.0 / width;
//				double re = 4.0 * x / width + 4.0 * offsetX - 2.0;
				double im = (y + (offsetY * height) - height / 2.0) * 4.0 / width;
				pixels[x][y] = mandelbrot.compute(new Complex(re, im), PRECISION, 4.0);
				}
			)
		);
		IntStream.range(0, width).forEach(x -> 
			IntStream.range(0, height).forEach(y -> 
				{
					ctx.setFill(colors.getColor(pixels[x][y], PRECISION));
					ctx.fillRect(x, y, 1, 1);
				}
			)
		);
		// @formatter:on
	}

	public static void main(String[] args) {
		launch(args);
	}

}

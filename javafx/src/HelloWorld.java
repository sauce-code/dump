import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloWorld extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {

		// hauptfenster
		primaryStage.setTitle("2048");
		primaryStage.setResizable(false);

		// Schriftart
		Font font = Font.font("Lucida Console", 40);

		// Text
		Text[][] tiles = new Text[4][4];
		for (int row = 0; row < 4; row++) {
			for (int column = 0; column < 4; column++) {
				tiles[column][row] = new Text(0, 0, "0");
				tiles[column][row].setFont(font);
			}
		}

		// Rahmen

		Button up = new Button();
		up.setText("up");

		Button right = new Button();
		right.setText("right");

		Button down = new Button();
		down.setText("down");

		Button left = new Button();
		left.setText("left");

		GridPane buttons = new GridPane();
		buttons.add(up, 0, 0);
		buttons.add(right, 1, 0);
		buttons.add(down, 2, 0);
		buttons.add(left, 3, 0);

		Text t00 = new Text(0, 0, "00");

		Text t01 = new Text(0, 0, "01");
		Text t02 = new Text(0, 0, "02");
		Text t03 = new Text(0, 0, "03");
		Rectangle r00 = new Rectangle();
		r00.setWidth(100);
		r00.setHeight(100);
		r00.setFill(Color.WHITE);

		HBox box = new HBox();
		box.setPrefHeight(100);
		box.setPrefWidth(100);
		box.setStyle("-fx-border-color: black;\n");
//		box.getChildren().add(t00);

		GridPane field = new GridPane();
		GridPane.setHalignment(t00, HPos.CENTER);
		field.add(t00, 0, 0);
		field.add(box, 0, 0);
		field.add(t01, 1, 0);
		field.add(t02, 2, 0);
		field.add(t03, 3, 0);
		// field.add(r00, 0, 1);

		GridPane mother = new GridPane();
		mother.add(field, 0, 0);
		mother.add(buttons, 0, 1);

		// Button btn = new Button();
		// btn.setText("Say 'Hello World'");
		// btn.setOnAction(new EventHandler<ActionEvent>() {
		//
		// @Override
		// public void handle(ActionEvent event) {
		// System.out.println("Hello World!");
		// }
		// });
		//
		// Button btn2 = new Button();
		// btn2.setText("Knopf 2");

		StackPane root = new StackPane();
		root.getChildren().add(mother);

		primaryStage.setScene(new Scene(root, 300, 250));
		primaryStage.show();
	}

}

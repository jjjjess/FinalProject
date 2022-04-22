// Student names: Jesse Tripp and Indira Mekala
// Class: COSC 211
// Final Exam: Programming Exercise 16.3
// Traffic Lights - program that simulates a
// traffic light. The user can select one of three
// lights: red, yellow, or green. When button is
// selected, the light is turned on. Only one light
// can be on at the same time.
// ****************************************************
package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class Main extends Application {
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {

    // Font Creation
    Font font = Font.font("Sitka", FontWeight.BOLD, FontPosture.REGULAR, 25);

    VBox trafficLightBox = new VBox(10);
    trafficLightBox.setAlignment(Pos.CENTER);

    // Creating circle objects for lights
    Circle c1 = getCircle();
    Circle c2 = getCircle();
    Circle c3 = getCircle();

    // places circles inside traffic light body
    trafficLightBox.getChildren().addAll(c1, c2, c3);

    // Traffic Light Body object
    Rectangle trafficLightBody = new Rectangle();
    trafficLightBody.setWidth(90);
    trafficLightBody.setHeight(300);
    trafficLightBody.setFill(Color.YELLOW);
    trafficLightBody.setStroke(Color.GRAY);
    trafficLightBody.setStrokeWidth(.5);
    StackPane trafficLight = new StackPane(trafficLightBody, trafficLightBox);

    // Area for buttons
    HBox buttonArea = new HBox(5);
    buttonArea.setAlignment(Pos.CENTER);

    // creating button objects
    RadioButton red = new RadioButton("Red");
    red.setFont(font);
    RadioButton yellow = new RadioButton("Yellow");
    yellow.setFont(font);
    RadioButton green = new RadioButton("Green");
    green.setFont(font);

    // ToggleGroup creation - only one variable can be selected within ToggleGroup
    ToggleGroup group = new ToggleGroup();
    red.setToggleGroup(group);
    yellow.setToggleGroup(group);
    green.setToggleGroup(group);
    buttonArea.getChildren().addAll(red, yellow, green);

    // Creates Layout and TrafficLight Body on window
    BorderPane windowLayout = new BorderPane();
    windowLayout.setCenter(trafficLight);
    windowLayout.setBottom(buttonArea);

    // Change color events
    red.setOnAction(event -> {
      if (red.isSelected()) {
        c1.setFill(Color.RED);
        c2.setFill(Color.DARKGRAY);
        c3.setFill(Color.DARKGRAY);
        red.setStyle("-fx-text-fill:red");
        yellow.setStyle("-fx-text-fill:black");
        green.setStyle("-fx-text-fill:black");
      }
    });

    yellow.setOnAction(event -> {
      if (yellow.isSelected()) {
        c1.setFill(Color.DARKGRAY);
        c2.setFill(Color.YELLOW);
        c3.setFill(Color.DARKGRAY);
        red.setStyle("-fx-text-fill:black");
        yellow.setStyle("-fx-text-fill:yellow");
        green.setStyle("-fx-text-fill:black");
      }
    });

    green.setOnAction(event -> {
      if (green.isSelected()) {
        c1.setFill(Color.DARKGRAY);
        c2.setFill(Color.DARKGRAY);
        c3.setFill(Color.GREEN);
        red.setStyle("-fx-text-fill:black");
        yellow.setStyle("-fx-text-fill:black");
        green.setStyle("-fx-text-fill:green");
      }
    });

    // Scene creation - represents physical contents of JavaFX
    Scene scene = new Scene(windowLayout, 500, 500);
    scene.getStylesheets().add("application.css");
    primaryStage.setTitle("Jesse and Indira's Traffic Light Simulator");
    primaryStage.setScene(scene);
    primaryStage.show(); // Display window
  }

  // Constructs circles for the lights
  private Circle getCircle() {
    Circle c = new Circle(35);
    c.setFill(Color.DARKGRAY);
    c.setStroke(Color.GRAY);
    return c;
  }
}

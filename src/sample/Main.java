package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("RadioButton");

        HBox hBox = new HBox(10); // вертикальное
        hBox.setAlignment(Pos.CENTER);

        // наша группа
        ToggleGroup group = new ToggleGroup();

        // наши кнопки с текстом
        RadioButton radioButton1 = new RadioButton("RED");
        RadioButton radioButton2 = new RadioButton("GREEN");
        RadioButton radioButton3 = new RadioButton("BLUE");

        // информация по выбранной кнопке
        radioButton1.setUserData("RED");
        radioButton2.setUserData("GREEN");
        radioButton3.setUserData("BLUE");

        // добавляем наши кнопки в группу
        radioButton1.setToggleGroup(group);
        radioButton2.setToggleGroup(group);
        radioButton3.setToggleGroup(group);

        // добавляем наши кнопки на горизонтальную панель
        hBox.getChildren().addAll(radioButton1, radioButton2, radioButton3);

        // обработчик событий
        group.selectedToggleProperty().addListener(observable -> {
            radioButton1.setTextFill(Color.web((String) group.getSelectedToggle().getUserData())); // изменяем цвет кнопки
            radioButton2.setTextFill(Color.web((String) group.getSelectedToggle().getUserData()));
            radioButton3.setTextFill(Color.web((String) group.getSelectedToggle().getUserData()));
        });


        // добавление на сцены на форму
        Pane root = new Pane(); // Основное
        root.getChildren().addAll(hBox);

        Scene scene = new Scene(root, 400, 100);
        primaryStage.setScene(scene);  // размер формы и сцена
        primaryStage.show(); // отобразить
    }

    public static void main(String[] args) {
        launch(args);
    }
}
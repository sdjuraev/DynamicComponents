package com.example.dynamiccomponents;

import javafx.fxml.FXML;
import javafx.geometry.NodeOrientation;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Flow;

public class HelloController {
@FXML
Button cancelButton, jsonReader;
@FXML
    TextArea textArea;
    @FXML
    FlowPane paneView;
    @FXML
    private Label welcomeText;
    int i=1;
    @FXML
    protected void onHelloButtonClick() {
    addNewList(i,paneView , "Course name "+i,"Movie Name");
        i++;
    }
    private void addNewList(int i, FlowPane flowPane, String Btext, String labelText)
    {
        File file=new File("images/Music_Icon.jpg");
        ImageView imageView=new ImageView();
        imageView.setId(labelText);
        imageView.setFitHeight(120);
        imageView.setFitWidth(120);
        imageView.setImage(new Image(file.toURI().toString()));
        Label label=new Label();
        label.setText(labelText);
        VBox vBox=new VBox();
        Button button=new Button();
        button.setText(Btext);
        button.setId("Button"+i);
        vBox.setSpacing(20);
        vBox.getChildren().add(imageView);
        vBox.getChildren().add(label);
        vBox.getChildren().add(button);
        flowPane.getChildren().add(vBox);
        imageView.setOnMouseClicked(mouseEvent -> showCourse(labelText));
        button.setOnAction(actionEvent -> showCourse(button.getId()));
    }
    private void showCourse(String ID)
    {
        System.out.println(ID);
    }
    @FXML
    private void cancelWindow(){
        Stage stage=(Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
    @FXML
    private void setJsonReader() throws MalformedURLException {
        URL url=new URL("http://ip.jsontest.com/?callback=showMyIP");
        String message= stream(url);
        textArea.appendText(message);
    }
    private String stream(URL url){
        try (InputStream input = url.openStream()) {
            InputStreamReader isr = new InputStreamReader(input);
            BufferedReader reader = new BufferedReader(isr);
            StringBuilder json = new StringBuilder();
            int c;
            while ((c = reader.read()) != -1) {
                json.append((char) c);
            }
           return json.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    private void readingFromJson() {

    }
}
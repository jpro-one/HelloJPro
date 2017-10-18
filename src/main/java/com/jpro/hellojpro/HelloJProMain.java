package com.jpro.hellojpro;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloJProMain extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage)
    {
        //load user interface as FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/jpro/hellojpro/fxml/HelloJPro.fxml"));
        Scene scene = null;
        try
        {
            Parent root = loader.load();
            //create JavaFX scene
            scene = new Scene(root);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        stage.setTitle("Hello jpro!");
        stage.setScene(scene);

        //open JavaFX window
        stage.show();
    }

}

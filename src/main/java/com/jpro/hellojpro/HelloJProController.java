package com.jpro.hellojpro;

import com.jpro.JProApplication;
import com.jpro.webapi.WebAPI;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by TB on 25.02.16.
 */
public class HelloJProController implements Initializable
{
    public Label platformLabel;
    @FXML
    protected StackPane root;

    @FXML
    protected Node logo;

    protected JProApplication jProApplication;


    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        initLogoAnimation(this.logo);

        platformLabel.setText(String.format("Platform: %s", WebAPI.isBrowser() ? "Browser" : "Desktop"));
    }

    protected void initLogoAnimation(Node logo)
    {
        ScaleTransition st = new ScaleTransition(Duration.millis(1000), logo);
        st.setByX(-0.5);
        st.setByY(-0.5);
        st.setAutoReverse(true);
        st.setCycleCount(Animation.INDEFINITE);

        FadeTransition ft = new FadeTransition(Duration.millis(1000), logo);
        ft.setToValue(0.5);
        ft.setAutoReverse(true);
        ft.setCycleCount(Animation.INDEFINITE);
        logo.setOpacity(1);

        ParallelTransition pt = new ParallelTransition(st, ft);
        pt.play();
    }


    public void init(JProApplication jProApplication)
    {
        this.jProApplication = jProApplication;
    }
}

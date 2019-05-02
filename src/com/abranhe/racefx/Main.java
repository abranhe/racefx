/*
 * Copyright 2018 Carlos Abraham Hernandez (abraham@abranhe.com)
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.abranhe.racefx;

import java.util.Timer;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.TimerTask;
import javafx.scene.layout.Pane;
import javafx.scene.image.Image;
import javafx.application.Platform;
import javafx.scene.image.ImageView;
import javafx.application.Application;

/**
 * The entry class of the game.
 *
 * @author Carlos Abraham Hernandez
 */
public class Main extends Application {

    private final double WIDTH = 600;
    private final double HEIGHT = 600;
    private Menu game;

    @Override
    public void start(final Stage primaryStage) {

        Pane root = new Pane();
        root.setPrefSize(WIDTH, HEIGHT);

        Features feature = new Features();
        ImageView background = feature.background(1);
        Pane welcome = feature.introduction();

        game = new Menu();
        game.setVisible(false);

        Scene scene = new Scene(root);

        /**
         * Set up timers for the introduction
         */
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> root.getChildren().add(welcome));
            }
        }, 2000);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> root.getChildren().remove(welcome));
            }
        }, 5000);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> game.setVisible(true));
            }
        }, 7000);

        root.getChildren().addAll(background, game);
        primaryStage.setResizable(false);
        primaryStage.setTitle("RaceFx");
        primaryStage.getIcons().add(new Image(getClass()
                .getResourceAsStream("assets/racefx.png")
        ));
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}

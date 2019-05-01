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

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 * The Race class contains the functionality of the game at the moment of the
 * race, giving the cars images, and adding the podium for the winner car.
 *
 * @author Carlos Abraham Hernandez
 */
public class Race extends Pane {

    ImageView podium = new ImageView();
    ImageView citroenSide = new ImageView();
    ImageView corvetteSide = new ImageView();
    ImageView mustangSide = new ImageView();
    ImageView lamborghiniSide = new ImageView();
    ImageView ferrariSide = new ImageView();
    MediaPlayer mediaPlayer = new MediaPlayer(new Media(getClass()
            .getResource("assets/race.mp3").toString())
    );

    /**
     * Constructor for the {@link Race} class adding the features and all the
     * images for the cars.
     */
    public Race() {

        Features features = new Features();
        getChildren().add(features.background(2));

        /**
         * Setting up podium location in the Pane.
         */
        podium.setFitHeight(200);
        podium.setFitWidth(400);
        podium.setLayoutX(100);
        podium.setLayoutY(400);
        podium.setVisible(false);
        podium.setImage(new Image(getClass()
                .getResource("assets/podium.png")
                .toExternalForm()
        ));
        getChildren().add(podium);

        /**
         * Setting up Citroen location in the Pane.
         */
        citroenSide.setFitHeight(42);
        citroenSide.setFitWidth(111);
        citroenSide.setLayoutX(-60);
        citroenSide.setLayoutY(520);
        citroenSide.setImage(new Image(getClass()
                .getResource("assets/citroenSideView.png")
                .toExternalForm()
        ));
        getChildren().add(citroenSide);

        /**
         * Setting up Corvette location in the Pane.
         */
        corvetteSide.setFitHeight(33);
        corvetteSide.setFitWidth(111);
        corvetteSide.setLayoutX(-60);
        corvetteSide.setLayoutY(460);
        corvetteSide.setImage(new Image(getClass()
                .getResource("assets/corvetteSideView.png")
                .toExternalForm()
        ));
        getChildren().add(corvetteSide);

        /**
         * Setting up Mustang location in the Pane.
         */
        mustangSide.setFitHeight(35);
        mustangSide.setFitWidth(111);
        mustangSide.setLayoutX(-60);
        mustangSide.setLayoutY(420);;
        mustangSide.setImage(new Image(getClass()
                .getResource("assets/mustangSideView.png")
                .toExternalForm()
        ));
        getChildren().add(mustangSide);

        /**
         * Setting up Lamborghini location in the Pane.
         */
        lamborghiniSide.setFitHeight(32);
        lamborghiniSide.setFitWidth(111);
        lamborghiniSide.setLayoutX(-60);
        lamborghiniSide.setLayoutY(380);
        lamborghiniSide.setImage(new Image(getClass()
                .getResource("assets/lamborghiniSideView.png")
                .toExternalForm()
        ));
        getChildren().add(lamborghiniSide);

        /**
         * Setting up Ferrari location in the Pane.
         */
        ferrariSide.setFitHeight(38);
        ferrariSide.setFitWidth(111);
        ferrariSide.setLayoutX(-60);
        ferrariSide.setLayoutY(340);
        ferrariSide.setImage(new Image(getClass()
                .getResource("assets/ferrariSideView.png")
                .toExternalForm()
        ));
        getChildren().add(ferrariSide);

        /**
         * Button start.
         */
        final Button btnStart = new Button();
        btnStart.setLayoutX(5);
        btnStart.setLayoutY(5);
        btnStart.setPrefHeight(10);
        btnStart.setPrefWidth(80);
        btnStart.setText("Start");
        getChildren().add(btnStart);

        /**
         * Button restart.
         */
        final Button btnRestart = new Button();
        btnRestart.setLayoutX(5);
        btnRestart.setLayoutY(5);
        btnRestart.setPrefHeight(10);
        btnRestart.setPrefWidth(80);
        btnRestart.setText("Restart");
        btnRestart.setVisible(false);
        getChildren().add(btnRestart);

        /**
         * Button show results.
         */
        final Button results = new Button();
        results.setLayoutX(5);
        results.setLayoutY(5);
        results.setPrefHeight(10);
        results.setPrefWidth(80);
        results.setText("Results");
        results.setVisible(false);
        getChildren().add(results);

        /**
         * Create task for the cars movements.
         */
        Runnable car0 = new CarsMovement(ferrariSide, 0);
        Runnable car1 = new CarsMovement(lamborghiniSide, 1);
        Runnable car2 = new CarsMovement(mustangSide, 2);
        Runnable car3 = new CarsMovement(corvetteSide, 3);
        Runnable car4 = new CarsMovement(citroenSide, 4);

        /**
         * Create the threads for the cars movements.
         */
        final Thread thread1 = new Thread(car0);
        final Thread thread2 = new Thread(car1);
        final Thread thread3 = new Thread(car2);
        final Thread thread4 = new Thread(car3);
        final Thread thread5 = new Thread(car4);

        btnStart.setOnAction(e -> {
            mediaPlayer.play();
            thread1.start();
            thread2.start();
            thread3.start();
            thread4.start();
            thread5.start();
            btnStart.setVisible(false);
            mediaPlayer.seek(Duration.ZERO);
            results.setVisible(true);
        });

        Text txt = new Text();
        txt.setVisible(false);
        getChildren().add(txt);

        results.setOnAction(new EventHandler<ActionEvent>() {

            int counter = 0;
            int racePosition;

            @Override
            public void handle(ActionEvent event) {

                if (CarsMovement.positions.size() < 5) {
                    if (counter == 0) {
                        txt.setText("The race is not over!");
                    }
                    txt.setLayoutX(280);
                    txt.setLayoutY(20);
                    txt.setFont(Font.font("text", 15));
                    txt.setFill(Color.RED);
                    txt.setVisible(true);
                    ++counter;

                } else {
                    txt.setVisible(false);
                    for (int i = 0; i < CarsMovement.positions.size(); i++) {

                        if (Menu.carSelected == CarsMovement.positions.get(i)) {
                            racePosition = i;
                        }
                    }

                    podium();

                    Text text = new Text();
                    text.setLayoutX(100);
                    text.setLayoutY(270);
                    text.setFont(Font.font("text", 20));
                    text.setFill(Color.WHITE);
                    getChildren().add(text);

                    switch (racePosition) {
                        case 0:
                            text.setText(podiumMessage(Menu.name, "first", Menu.amountSelected * 1000));
                            break;
                        case 1:
                            text.setText(podiumMessage(Menu.name, "second", Menu.amountSelected * 500));
                            break;
                        case 2:
                            text.setText(podiumMessage(Menu.name, "third", Menu.amountSelected * 250));
                            break;
                        case 3:
                            text.setFont(Font.font("text", 17));
                            text.setText("Your car was in fourth place and you "
                                    + "lost your money.\n try again to get it back.");
                            break;
                        case 4:
                            text.setFont(Font.font("text", 17));
                            text.setText("Your car was in fifth place and you lost your money.\n"
                                    + "try again to get it back.");
                            break;

                    }

                    results.setVisible(false);
                    btnRestart.setVisible(true);

                }
            }

        });

        /**
         * Set the images reference to null to be collected and deleted by the
         * Garbage Collector.
         */
        btnRestart.setOnAction(e -> {
            citroenSide.setImage(null);
            corvetteSide.setImage(null);
            mustangSide.setImage(null);
            lamborghiniSide.setImage(null);
            ferrariSide.setImage(null);

            getChildren().add(new Race());
        });

        while (thread1.isAlive()) {
            btnRestart.setDisable(true);
            results.setDisable(true);
        }
    }

    /**
     * Helper to set the podium message.
     *
     * @return string with the message
     */
    private String podiumMessage(String name, String place, int amount) {
        return "Congratulation " + name + "\n" + "You won " + place + " place  $" + amount;
    }

    /**
     * Helper to set the podium message of a looser car.
     *
     * @return string with the message
     */
    private String podiumLooserMessage(String position) {
        return "Your car was in " + position + " place and you lost your money.\n Try again to get it back.";
    }

    /**
     * Show podium with me cars and messages.
     */
    private void podium() {
        podium.setVisible(true);

        if (CarsMovement.positions.get(0) == 0) {
            ferrariSide.setLayoutX(-415);
            ferrariSide.setLayoutY(380);
        } else if (CarsMovement.positions.get(1) == 0) {
            ferrariSide.setLayoutX(-555);
            ferrariSide.setLayoutY(460);
        } else if (CarsMovement.positions.get(2) == 0) {
            ferrariSide.setLayoutX(-300);
            ferrariSide.setLayoutY(470);
        }

        if (CarsMovement.positions.get(0) == 1) {
            lamborghiniSide.setLayoutX(-415);
            lamborghiniSide.setLayoutY(380);
        } else if (CarsMovement.positions.get(1) == 1) {
            lamborghiniSide.setLayoutX(-555);
            lamborghiniSide.setLayoutY(460);
        } else if (CarsMovement.positions.get(2) == 1) {
            lamborghiniSide.setLayoutX(-300);
            lamborghiniSide.setLayoutY(470);
        }

        if (CarsMovement.positions.get(0) == 2) {
            mustangSide.setLayoutX(-415);
            mustangSide.setLayoutY(380);
        } else if (CarsMovement.positions.get(1) == 2) {
            mustangSide.setLayoutX(-555);
            mustangSide.setLayoutY(460);
        } else if (CarsMovement.positions.get(2) == 2) {
            mustangSide.setLayoutX(-300);
            mustangSide.setLayoutY(470);
        }

        if (CarsMovement.positions.get(0) == 3) {
            corvetteSide.setLayoutX(-415);
            corvetteSide.setLayoutY(380);
        } else if (CarsMovement.positions.get(1) == 3) {
            corvetteSide.setLayoutX(-555);
            corvetteSide.setLayoutY(460);
        } else if (CarsMovement.positions.get(2) == 3) {
            corvetteSide.setLayoutX(-300);
            corvetteSide.setLayoutY(470);
        }

        if (CarsMovement.positions.get(0) == 4) {
            citroenSide.setLayoutX(-415);
            citroenSide.setLayoutY(380);
        } else if (CarsMovement.positions.get(1) == 4) {
            citroenSide.setLayoutX(-555);
            citroenSide.setLayoutY(460);
        } else if (CarsMovement.positions.get(2) == 4) {
            citroenSide.setLayoutX(-300);
            citroenSide.setLayoutY(470);
        }

        CarsMovement.clearPositions();
    }
}

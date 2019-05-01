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

import java.util.ArrayList;
import java.util.List;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.NodeOrientation;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 * The {@link Menu} class give the game the functionality to select cars enter
 * the users name, and set up the betting amount. This is the mayor part of the
 * UI of the game. This was the harder thing to get done :/
 *
 * @author Carlos Abraham Hernandez
 */
public class Menu extends Parent {

    public static int carSelected;
    public static int amountSelected;
    public static String name;
    private int imageOrder = 0;
    private ImageView imageView;
    private List<Cars> lists = new ArrayList<>();

    /**
     * Set up everything in the constructor, do not do this at home.
     */
    public Menu() {
        TextField nameField = new TextField();
        MediaPlayer mediaPlayer = new MediaPlayer(new Media(getClass()
                .getResource("assets/click.mp3").toString()
        ));

        VBox menu0 = new VBox(10);
        VBox menu1 = new VBox(10);
        Pane menu2 = new Pane();

        menu2.setPrefSize(600, 600);

        menu0.setTranslateX(170);
        menu0.setTranslateY(200);

        menu1.setTranslateX(-200);
        menu1.setTranslateY(100);

        DropShadow drop = new DropShadow(50, Color.WHITE);
        drop.setInput(new Glow());

        final int offset = 600;
        menu1.setTranslateX(offset);

        /**
         * Play now settings
         */
        MenuButton btnPlay = new MenuButton("PLAY NOW");

        btnPlay.setOnMouseClicked(event -> {
            getChildren().add(menu2);

            mediaPlayer.play();
            TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu0);
            tt.setToX(menu0.getTranslateX() - offset);

            TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu2);
            tt1.setToX(menu0.getTranslateX());

            nameField.requestFocus();
            tt.play();
            tt1.play();

            tt.setOnFinished(evt -> {
                getChildren().remove(menu0);
                mediaPlayer.stop();
            });
        });

        /**
         * Options settings
         */
        MenuButton btnOptions = new MenuButton("OPTIONS");
        btnOptions.setOnMouseClicked(event -> {
            getChildren().add(menu1);

            TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu0);
            tt.setToX(menu0.getTranslateX() - offset);

            TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu1);
            tt1.setToX(menu0.getTranslateX());

            tt.play();
            tt1.play();

            tt.setOnFinished(evt -> {
                getChildren().remove(menu0);
            });
        });

        /**
         * Exit settings
         */
        MenuButton btnExit = new MenuButton("EXIT");
        btnExit.setOnMouseClicked(event -> {
            System.exit(0);
        });

        /**
         * Go back settings
         */
        MenuButton btnBack = new MenuButton(" ⬅ BACK");
        btnBack.setOnMouseClicked(event -> {
            getChildren().add(menu0);

            TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu1);
            tt.setToX(menu1.getTranslateX() + offset);

            TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu0);
            tt1.setToX(menu1.getTranslateX());

            tt.play();
            tt1.play();

            tt.setOnFinished(evt -> {
                getChildren().remove(menu1);
            });
        });

        /**
         * Options of the cars to select while the user is choosing their car.
         */
        String[] cars = {"ferrari", "lamborghini", "mustang", "corvette", "citroen"};

        /**
         * Add all images to the array list to store the name of the cars and
         * the links.
         */
        for (int i = 0; i < cars.length; i++) {
            Cars c = new Cars();
            c.setImagesMenu(cars[i] + ".png");
            c.setCarNames(cars[i].toUpperCase());
            lists.add(i, c);
        }

        /**
         * Display all cars and the name in the menu when selected.
         */
        Image images[] = new Image[lists.size()];
        for (int i = 0; i < lists.size(); i++) {
            images[i] = new Image(getClass()
                    .getResource(lists.get(i)
                            .getImagesMenu())
                    .toExternalForm()
            );
        }

        imageView = new ImageView(images[0]);
        imageView.setFitHeight(230);
        imageView.setFitWidth(305);
        imageView.setLayoutX(-50);
        imageView.setLayoutY(200);

        nameField.setEffect(drop);

        Text yellowText = new Text();
        Text playerLabel = new Text();
        playerLabel.setLayoutX(-50);
        playerLabel.setLayoutY(73.0);
        playerLabel.setFill(Color.WHITE);
        playerLabel.setStrokeWidth(0.0);
        playerLabel.setFont(new Font(16.0));
        playerLabel.setText("ENTER PLAYER NAME");

        nameField.setLayoutX(-50);
        nameField.setLayoutY(88);
        nameField.setOpacity(0.7);
        nameField.setPrefHeight(27);
        nameField.setPrefWidth(209);

        Playground nameNxtBtn = new Playground();
        nameNxtBtn.addButton("Next", 195, 83);

        Text selectCarText = new Text();
        selectCarText.setFill(Color.WHITE);
        selectCarText.setLayoutX(-50);
        selectCarText.setLayoutY(152.0);
        selectCarText.setStrokeWidth(0.0);
        selectCarText.setText("SELECT YOUR CAR");
        selectCarText.setFont(new Font(16.0));

        yellowText.setFill(Color.YELLOW);
        yellowText.setLayoutX(-50);
        yellowText.setLayoutY(184.0);
        yellowText.setStrokeWidth(0.0);
        yellowText.setText("Change car with arrow keys. Press Enter to select your car.");
        yellowText.setFont(new Font(11.0));

        Text bettingAmtLabel = new Text();
        bettingAmtLabel.setLayoutX(-50);
        bettingAmtLabel.setFill(Color.WHITE);
        bettingAmtLabel.setLayoutY(480);
        bettingAmtLabel.setText("ENTER BETTING AMOUNT");
        bettingAmtLabel.setFont(new Font(16));

        TextField bettingAmtField = new TextField() {
            /**
             * Accept only numbers when entering the betting amount.
             */

            @Override
            public void replaceText(int start, int end, String text) {
                if (!text.matches("[a-z]") && !text.matches("[\\\\!\"#$%&()*+,./:;<=>?@\\[\\]^_{|}~]+")) {
                    super.replaceText(start, end, text);
                }
            }

            @Override
            public void replaceSelection(String text) {
                if (!text.matches("[a-z]") && !text.matches("[\\\\!\"#$%&()*+,./:;<=>?@\\[\\]^_{|}~]+")) {
                    super.replaceSelection(text);
                }
            }
        };

        /**
         * Limits of the betting amount which is <b>$1000</b>.
         */
        final int LIMIT = 4;

        bettingAmtField.lengthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (newValue.intValue() > oldValue.intValue()) {
                    /**
                     * Check if the new character is greater than the limit.
                     */
                    if (bettingAmtField.getText().length() >= LIMIT) {
                        bettingAmtField.setText(bettingAmtField.getText().substring(0, LIMIT));
                    }
                    try {
                        /**
                         * If the amount entered is above $1000, replace the
                         * amount entered to 1000.
                         */
                        if (Integer.parseInt(bettingAmtField.getText()) >= 1000) {
                            bettingAmtField.setText("1000");
                        }
                    } catch (Exception e) {
                        bettingAmtField.clear();
                    }
                }
            }

        });

        Rectangle bg = new Rectangle(610, 610);
        bg.setFill(Color.GREY);
        bg.setOpacity(0.4);

        bettingAmtField.setLayoutX(-50);
        bettingAmtField.setLayoutY(502.0);
        bettingAmtField.setOpacity(0.7);
        bettingAmtField.setPrefHeight(27.0);
        bettingAmtField.setPrefWidth(209.0);
        bettingAmtField.setPromptText("Maximun $1000");

        Text carMark = new Text();
        carMark.setLayoutX(127);
        carMark.setLayoutY(420.0);
        carMark.setText("FERRARI");
        carMark.setFill(Color.WHITE);
        carMark.setFont(new Font(18));

        Text dollarSign = new Text();
        dollarSign.setLayoutX(-43);
        dollarSign.setLayoutY(520.0);
        dollarSign.setStrokeWidth(0.0);
        dollarSign.setText("$");
        dollarSign.setVisible(false);

        Playground bAmountNxtBtn = new Playground();
        bAmountNxtBtn.addButton("Next", 195, 492);

        Button btnRestart = new Button();
        btnRestart.setLayoutX(60);
        btnRestart.setLayoutY(5);
        btnRestart.setText("Restart");

        /**
         * Create an event when press the <b>next</b> button for name.
         */
        nameNxtBtn.setOnMouseClicked(e0 -> {
            mediaPlayer.play();
            nameField.setEffect(null);
            mediaPlayer.stop();
            selectCarText.setEffect(drop);

            if (nameField.getText().isEmpty()) {
                nameField.setText("Player");
            }
            name = nameField.getText();

            nameNxtBtn.setFocusTraversable(false);
            imageView.requestFocus();

            /**
             * Create events to select car with keys.
             */
            imageView.setOnKeyPressed(e -> {
                
                /**
                 * Move the car to the right.
                 */
                if (e.getCode() == KeyCode.RIGHT) {
                    mediaPlayer.play();
                    imageOrder += 1;
                    if (imageOrder == lists.size()) {
                        imageOrder = 0;
                    }
                    imageView.setImage(images[imageOrder]);
                    carMark.setText(lists.get(imageOrder).getCarNames());
                    mediaPlayer.seek(Duration.ZERO);
                }
                
                /**
                 * Move the car to the left.
                 */
                if (e.getCode() == KeyCode.LEFT) {
                    mediaPlayer.play();
                    imageOrder -= 1;
                    
                    /**
                     * If image of the index -1 set the last image.
                     */
                    if (imageOrder == -1) {
                        imageOrder = lists.size() - 1;
                    }
                    
                    imageView.setImage(images[imageOrder]);
                    carMark.setText(lists.get(imageOrder).getCarNames());
                    mediaPlayer.seek(Duration.ZERO);
                }
                
                /**
                 * When the user select the car by pressing <b>enter</b> key.
                 */
                if (e.getCode() == KeyCode.ENTER) {
                    carSelected = imageOrder;
                    mediaPlayer.play();
                    selectCarText.setEffect(drop);
                    imageView.setEffect(drop);
                    bettingAmtField.setEffect(drop);
                    imageView.setFocusTraversable(false);
                    bettingAmtField.requestFocus();
                    dollarSign.setVisible(true);
                    mediaPlayer.seek(Duration.ZERO);
                    bettingAmtField.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

                    bAmountNxtBtn.setOnMouseClicked(e2 -> {
                        mediaPlayer.play();
                        amountSelected = Integer.parseInt(bettingAmtField.getText());

                        Race race = new Race();
                        menu2.getChildren().add(race);

                        TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu2);
                        tt.setToX(menu2.getTranslateX() - 170);

                        TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), race);
                        tt1.setToX(race.getTranslateX());

                        tt.play();
                        tt1.play();

                        tt.setOnFinished(evt -> {
                            getChildren().removeAll(bg, menu0, menu1);
                            mediaPlayer.stop();
                        });
                        mediaPlayer.seek(Duration.ZERO);
                    });
                }
            });
        });

        Playground information = new Playground("INFORMATION");
        information.createText("This game is a Robot Race animation with betting capabilities.\n"
                + "Every robot will represent a car. You will select your car to \n compete in the race.");
        Playground information1 = new Playground("HOW TO PLAY");
        information1.createText("Select the car you want to use for the race.\n"
                + "Then enter your name and the betting amout.");
        Playground information2 = new Playground("COPYRIGHT");
        information2.createText("2018 © AAA Group. COP 2805c.\n"
                + "Thanks for teaching us how to make this Rodolfo Cruz.");

        menu0.getChildren().addAll(btnPlay, btnOptions, btnExit);
        menu1.getChildren().addAll(btnBack, information, information1, information2);
        menu2.getChildren().addAll(imageView, playerLabel, nameField, bettingAmtLabel, selectCarText,
                yellowText, bettingAmtField, bAmountNxtBtn, nameNxtBtn, carMark, dollarSign
        );
        getChildren().addAll(bg, menu0);

    }
}

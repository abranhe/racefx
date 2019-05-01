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

import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * This is the {@link Playground} class. It allows the creation of a simple
 * square with some buttons and some effects in those buttons, with the ability
 * to listen to mouse events.
 *
 * @author Carlos Abraham Hernandez
 */
public class Playground extends Pane {

    /**
     * Allow instantiation of a the {@link Playground} class without a title.
     *
     */
    public Playground() {
    }

    /**
     * Creates default effects to the title.
     *
     * @param title with effects
     */
    public Playground(String title) {
        Text text;
        text = new Text(title);
        text.setFont(text.getFont().font(20));
        text.setFill(Color.WHITE);
        Rectangle bg = new Rectangle(280, 30);
        bg.opacityProperty().set(0);
        getChildren().addAll(bg, text);
        text.setTranslateX(-100);
        text.setTranslateY(40);
    }

    /**
     * Creates effects for the content.
     *
     * @param content with effects
     */
    public void createText(String content) {
        Text text;
        text = new Text(content);
        text.setFont(Font.font(15));
        text.setFill(Color.WHITE);
        Rectangle bg = new Rectangle(280, 80);
        bg.opacityProperty().set(0);
        getChildren().addAll(bg, text);
        text.setTranslateX(-100);
        text.setTranslateY(70);
    }

    /**
     * Creates a new button on the playground and add effects to it.
     *
     * @param title Name of the button
     * @param x coordinate
     * @param y coordinate
     */
    public void addButton(String title, double x, double y) {

        Text text;
        text = new Text(title);
        text.setLayoutX(x + 21);
        text.setLayoutY(y + 23);
        text.setFill(Color.WHITE);

        Rectangle rectangle;
        rectangle = new Rectangle();
        rectangle.setArcHeight(5.0);
        rectangle.setArcWidth(5.0);
        rectangle.setFill(Color.GRAY);
        rectangle.setHeight(37.0);
        rectangle.setLayoutX(x);
        rectangle.setLayoutY(y);
        rectangle.setOpacity(0.5);
        rectangle.setStrokeWidth(0.0);
        rectangle.setWidth(69.0);

        /**
         * On mouse entered effect.
         */
        rectangle.setOnMouseEntered(event -> {
            rectangle.setFill(Color.WHITE);
            text.setFill(Color.BLACK);
        });

        /**
         * On mouse exited effect.
         */
        rectangle.setOnMouseExited(event -> {
            rectangle.setFill(Color.BLACK);
            text.setFill(Color.WHITE);
        });

        /**
         * Button shadow effect.
         */
        DropShadow drop = new DropShadow(50, Color.WHITE);
        drop.setInput(new Glow());

        rectangle.setOnMousePressed(event -> setEffect(drop));
        rectangle.setOnMouseReleased(event -> setEffect(null));

        getChildren().addAll(text, rectangle);
    }
}

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

import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.image.ImageView;
import javafx.scene.effect.Reflection;

/**
 * The {@link Features} class adds some features to the game like the
 * introduction to the game and setting the backgrounds in the game process.
 *
 * @author Carlos Abraham Hernandez
 */
public class Features {
    
    /**
     * Returns {@link Pane} with the welcome text which is the introduction of
     * the game.
     *
     * @return introduction pane
     */
    public Pane introduction() {

        /**
         * Theme RaceFx Font Theme.
         */
        final String themeFont = "Comic Sans MS Bold";

        Pane pane = new Pane();
        Text text = new Text();
        text.setFill(javafx.scene.paint.Color.WHITE);
        text.setLayoutX(77.0);
        text.setLayoutY(282.0);
        text.setOpacity(0.70);
        text.setStroke(Color.BLACK);
        text.setStrokeWidth(2);
        text.setText("Java's RACE");
        text.setFont(new Font(themeFont, 76.0));

        Reflection reflection = new Reflection();
        reflection.setFraction(0.68);
        reflection.setTopOpacity(0.24);
        text.setEffect(reflection);

        Text text0 = new Text();
        text0.setFill(javafx.scene.paint.Color.WHITE);
        text0.setLayoutX(227.0);
        text0.setLayoutY(555.0);
        text0.setText("A COP 2805 Production.");
        pane.getChildren().addAll(text, text0);

        return pane;
    }

    /**
     * Returns the specific background images in the game process. It gets an
     * integer weather <b>1</b> or <b>2</b> and return the corresponding
     * background for the integer chosen.
     *
     * <ol>
     * <li>Menu Background</li>
     * <li>Race Background</li>
     * </ol>
     *
     * @param background integer for Menu or Race
     * @return image corresponding to the user input
     */
    public ImageView background(int background) {

        /**
         * With of the image that will be returned.
         */
        final int width = 610;

        ImageView imgView = new ImageView();
        imgView.setFitWidth(width);
        imgView.setFitHeight(width);

        /**
         * Choose between Menu Background or Race Background.
         */
        if (background == 1) {
            imgView.setImage(new Image(getClass()
                    .getResource("assets/background.png")
                    .toExternalForm())
            );
        } else if (background == 2) {
            imgView.setImage(new Image(getClass()
                    .getResource("assets/backgroundRace.png")
                    .toExternalForm()
            ));
        }

        return imgView;
    }
}

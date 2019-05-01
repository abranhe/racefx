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
import javafx.application.Platform;
import javafx.scene.image.ImageView;

/**
 * This class makes the cars move and store the values of the winners in an
 * array list.
 *
 * @author Carlos Abraham Hernandez
 */
public class CarsMovement implements Runnable {

    /**
     * Static {@code ArrayList} that store the positions of the cars.
     */
    public static ArrayList<Integer> positions = new ArrayList<>();

    /**
     * Car to be moved.
     */
    ImageView car;

    /**
     * Car number identifier
     */
    int carNumber;

    /**
     * A car ImageView and a car number are passed to the constructor to set it
     * as default.
     *
     * @param image view which represent the car
     * @param carNumber that identify the car
     */
    CarsMovement(ImageView image, int carNumber) {
        car = image;
        this.carNumber = carNumber;
    }

    final int finalLineDistanceInPxls = 680;

    @Override
    public void run() {

        /**
         * While the car is not at the final line it will increase x-coordinate
         * by a random number, this determines the speed of the cars.
         */
        while (car.getX() < finalLineDistanceInPxls) {
            Platform.runLater(new Runnable() {
                public void run() {
                    car.setX(car.getX() + Math.random() * 1.2);
                }
            });

            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        /**
         * Store the position of the car when it arrived to the final line.
         */
        storePosition(carNumber);
    }

    /**
     * Returns an {@code ArrayList} with the positions of the cars, which are
     * the cars identifiers numbers.
     *
     * @return positions array list with cars positions
     */
    final public static ArrayList<Integer> getPositions() {
        return positions;
    }

    /**
     * Store the positions of the cars, which are
     * the cars identifiers numbers inside the {@code ArrayList}.
     * 
     * @param number car number identifier
     */
    synchronized private void storePosition(int number) {
        positions.add(number);
    }

    /**
     * Clear the {@code ArrayList} to reset the race.
     */
    public static void clearPositions() {
        positions.clear();
    }
}

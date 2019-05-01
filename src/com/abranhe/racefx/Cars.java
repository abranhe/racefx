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

/**
 * This is the {@link Cars} class and contains
 * the details of each car.
 * 
 * @author Carlos Abraham Hernandez
 */
public class Cars {

    private String imagesMenu;
    private String carNames;
    
    /**
     * Set the images of the menu.
     * 
     * @param imagesMenu 
     */
    public void setImagesMenu(String imagesMenu) {
        this.imagesMenu = imagesMenu;
    }
    
    /**
     * Set the cars names.
     * 
     * @param carNames 
     */
    public void setCarNames(String carNames) {
        this.carNames = carNames;
    }
    
    /**
     * Returns the images of the menu.
     * 
     * @return images of the menu
     */
    public String getImagesMenu() {
        return imagesMenu;
    }
    
    /**
     * Returns the cars names.
     * 
     * @return cars names
     */
    public String getCarNames() {
        return carNames;
    }
}

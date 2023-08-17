package com.syaprojects.adventuretextquest;

import com.syaprojects.adventuretextquest.service.Parameter;
import com.syaprojects.adventuretextquest.service.GameLogic;

public class Solution {
    public static final String path = "/src/main/resources/data/images";
    public static void main(String[] args) {
        Parameter configParam = GameLogic.connectToFile(2, path + "/.png");
        System.out.println(configParam.getText());
        System.out.println(configParam.getPathImg());
        String id = null;
        if(id.equals(null)){
            id ="five";
        }
    }
}

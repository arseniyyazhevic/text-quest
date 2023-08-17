package com.syaprojects.adventuretextquest.service;

import java.io.*;

public class GameLogic {
    final public static String pathToText = "D://text.txt";
    final public static String pathToImg = "src/main/webapp/data/images";
    public static Parameter connectToFile(int numberOfPage, String urlToImg){
        try (FileReader fileReader = new FileReader(pathToText)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String text = "0";
            int nextLineCounter = 1;
            do {
                if (nextLineCounter == numberOfPage) {
                    text = bufferedReader.readLine();
                } else {
                    bufferedReader.readLine();
                }
                nextLineCounter++;
            } while (nextLineCounter - 1 != numberOfPage);
            Parameter parameter = new Parameter(text, urlToImg);
            return parameter;
        } catch (Exception e) {
            throw new RuntimeException("Что-то пошло не так", e);
        }
    }
}

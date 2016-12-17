package com.library.drawing.draw.controller;

import java.util.Map;
import java.util.Scanner;

import com.library.drawing.draw.helper.DrawHelper;
import com.library.drawing.draw.service.impl.DrawServiceImpl;

/**
 * 
 * @author Srijan Bajracharya<srijan.bajracharya@gmail.com>
 *
 */
public class DrawController {

    DrawServiceImpl drawServiceImpl = new DrawServiceImpl();

    DrawHelper drawHelper = new DrawHelper();

    char[][] canvas = new char[0][0];

    /**
     * main functions that handles all the commands
     * 
     * @param inputString
     * @param character
     * @author Srijan Bajracharya<srijan.bajracharya@gmail.com>
     */
    public void draw(String[] inputString, char character) {
        Scanner scanner = new Scanner(System.in);
        int arrayLength = inputString.length;
        char firstCharacter;
        try {
            if (arrayLength == 3 && (character == 'c' || character == 'C')) {
                Integer width = Integer.parseInt(inputString[1]);
                Integer height = Integer.parseInt(inputString[2]);
                canvas = drawServiceImpl.drawCanvas(width, height);
                drawServiceImpl.display(canvas);
                do {
                    System.out.println("Enter command:");
                    String command = scanner.nextLine();
                    String[] splitCommand = drawHelper.splitWhitespace(command);
                    firstCharacter = splitCommand[0].charAt(0);
                    if (Character.toLowerCase(firstCharacter) == 'l' && splitCommand.length == 5) {
                        drawLine(splitCommand, width, height);
                    } else if (Character.toLowerCase(firstCharacter) == 'r' && splitCommand.length == 5) {
                        drawRectangle(splitCommand, width, height);
                    } else if (Character.toLowerCase(firstCharacter) == 'b' && splitCommand.length == 4) {

                    } else if (Character.toLowerCase(firstCharacter) == 'q') {
                        System.out.println("Thank you for using our system.");
                    } else {
                        System.out.println("Please enter the valid command. Thank you");
                    }
                } while (Character.toLowerCase(firstCharacter) != 'q');
            }
        } catch (NumberFormatException e) {
            System.out.println("Command Format Exception:Please Enter according to the command. Thank you");
        }
    }

    /**
     * Draws Rectangle
     * 
     * @param command
     * @param width
     * @param height
     * @author Srijan Bajracharya<srijan.bajracharya@gmail.com>
     */
    public void drawRectangle(String[] command, int width, int height) {
        Integer x1 = Integer.parseInt(command[1]);
        Integer y1 = Integer.parseInt(command[2]);
        Integer x2 = Integer.parseInt(command[3]);
        Integer y2 = Integer.parseInt(command[4]);
        if (x1 >= 0 && x2 <= width && y1 >= 0 && y2 <= height) {
            canvas = drawServiceImpl.drawRectangle(canvas, x1, y1, x2, y2);
            drawServiceImpl.display(canvas);
        } else {
            System.out.println("Coordinates are outside the canvas boundary.");
        }
    }

    /**
     * Draws Line
     * 
     * @param command
     * @param width
     * @param height
     * @author Srijan Bajracharya<srijan.bajracharya@gmail.com>
     */
    public void drawLine(String[] command, int width, int height) {
        Integer x1 = Integer.parseInt(command[1]);
        Integer y1 = Integer.parseInt(command[2]);
        Integer x2 = Integer.parseInt(command[3]);
        Integer y2 = Integer.parseInt(command[4]);
        if (x1 >= 0 && x2 <= width && y1 >= 0 && y2 <= height) {
            Map<String, Integer> coordinates = drawHelper.getMaxMin(x1, y1, x2, y2);
            canvas = drawServiceImpl.drawLine(canvas, coordinates);
            drawServiceImpl.display(canvas);
        } else {
            System.out.println("Coordinates are outside the canvas boundary.");
        }
    }

    public void drawBubbleFill(String[] command) {
        Integer x = Integer.parseInt(command[1]);
        Integer y = Integer.parseInt(command[2]);
        char c = command[3].charAt(3);
        System.out.println("inside bubble fill");
    }

}

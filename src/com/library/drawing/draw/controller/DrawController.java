package com.library.drawing.draw.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.library.drawing.draw.helper.DrawHelper;
import com.library.drawing.draw.service.CanvasService;
import com.library.drawing.draw.service.DisplayService;
import com.library.drawing.draw.service.DrawService;
import com.library.drawing.draw.service.LineService;
import com.library.drawing.draw.service.RectangleService;
import com.library.drawing.draw.service.impl.CanvasServiceImpl;
import com.library.drawing.draw.service.impl.DisplayServiceImpl;
import com.library.drawing.draw.service.impl.DrawServiceImpl;
import com.library.drawing.draw.service.impl.LineServiceImpl;
import com.library.drawing.draw.service.impl.RectangleServiceImpl;

/**
 * 
 * @author Srijan Bajracharya<srijan.bajracharya@gmail.com>
 *
 */
public class DrawController {

    CanvasService canvasServiceImpl = new CanvasServiceImpl();

    DrawService drawServiceImpl = new DrawServiceImpl();

    DisplayService displayServiceImpl = new DisplayServiceImpl();

    RectangleService rectangleServiceImpl = new RectangleServiceImpl();

    LineService lineServiceImpl = new LineServiceImpl();

    char[][] canvas = new char[0][0];

    List<String> rectangles = new ArrayList<>();

    private String userCommand;

    public static final String OUTSIDE_BOUNDARY_MESSAGE = "Coordinates are outside the canvas boundary.";
    public static final String WARNING_MESSAGE = "Warning: You are trying to draw a straight line";
    public static final String NUMBER_FORMAT_EXCEPTION_MESSAGE =
            "Command Format Exception:Please Enter according to the command. Thank you";
    public static final String UNCAUGHT_ERROR = "It's not you it's us. Sorry please reload the program";
    public static final String QUIT_MESSAGE = "Thank you for using our system.";
    public static final String COMMAND_INVALID = "Please enter the valid command. Thank you";
    public static final String NOT_ALLOWED = "You are trying to draw another Canvas";

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
                int width = Integer.parseInt(inputString[1]);
                int height = Integer.parseInt(inputString[2]);
                canvas = canvasServiceImpl.drawCanvas(height, width);
                displayServiceImpl.display(canvas);
                do {
                    System.out.println("Enter command:");
                    userCommand = scanner.nextLine();
                    String[] splitCommand = DrawHelper.splitWhitespace(userCommand);
                    firstCharacter = splitCommand[0].charAt(0);
                    if (Character.toLowerCase(firstCharacter) == 'l' && splitCommand.length == 5) {
                        drawLine(splitCommand, width, height);
                    } else if (Character.toLowerCase(firstCharacter) == 'r' && splitCommand.length == 5) {
                        drawRectangle(splitCommand, width, height);
                    } else if (Character.toLowerCase(firstCharacter) == 'b' && splitCommand.length == 4) {
                        drawBubbleFill(splitCommand, width, height);
                    } else if (Character.toLowerCase(firstCharacter) == 'q') {
                        System.out.println(QUIT_MESSAGE);
                    } else if (Character.toLowerCase(firstCharacter) == 'c') {
                        System.out.println(NOT_ALLOWED);
                    } else {
                        System.out.println(COMMAND_INVALID);
                    }
                } while (Character.toLowerCase(firstCharacter) != 'q');
            }
        } catch (NumberFormatException e) {
            System.out.println(NUMBER_FORMAT_EXCEPTION_MESSAGE);
        } catch (Exception e) {
            System.out.println(UNCAUGHT_ERROR);
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
        Boolean rectangle = DrawHelper.isRectangle(x1, y1, x2, y2);
        if (rectangle) {
            if (x1 >= 0 && x2 <= width && y1 >= 0 && y2 <= height) {
                rectangles.add(userCommand);
                canvas = rectangleServiceImpl.drawRectangle(canvas, x1, y1, x2, y2);
                displayServiceImpl.display(canvas);
            } else {
                System.out.println(OUTSIDE_BOUNDARY_MESSAGE);
            }
        } else {
            System.out.println(WARNING_MESSAGE);
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
        Map<String, Integer> coordinates = DrawHelper.getMaxMin(x1, y1, x2, y2);
        Integer minX = coordinates.get("minX");
        Integer minY = coordinates.get("minY");
        Integer maxX = coordinates.get("maxX");
        Integer maxY = coordinates.get("maxY");
        if (((minX == 0 || maxX == width - 1) && (minY == 0 || maxY == height - 1))
                || ((maxY == height - 1 || minY == 0) && (minX == 0 || maxX == width - 1))
                || (minX == maxX && (maxY == height - 1 && minY == 0)) || (minY == maxY && (maxX == width - 1 && minX == 0))) {
            canvas = lineServiceImpl.drawLine(canvas, coordinates);
            rectangles.add("r" + " " + x1 + " " + y1 + " " + x2 + " " + y2);
        } else if (minX < 0 || maxX >= width || minY < 0 || maxY >= height) {
            System.out.println(OUTSIDE_BOUNDARY_MESSAGE);
        } else {
            canvas = lineServiceImpl.line(canvas, coordinates);
        }
        displayServiceImpl.display(canvas);
    }

    /**
     * handles functionality to fill the canvas
     * 
     * @param command
     * @author Srijan Bajracharya<srijan.bajracharya@gmail.com>
     */
    public void drawBubbleFill(String[] command, int width, int height) {
        Integer x = Integer.parseInt(command[1]);
        Integer y = Integer.parseInt(command[2]);
        char c = command[3].charAt(0);
        canvas = drawServiceImpl.fillAll(canvas, c);
        floodFill(rectangles, x, y, c, height, width);
    }

    /**
     * handles different conditions for flood-fill functionality
     * 
     * @param figures
     * @param x
     * @param y
     * @param c
     * @param height
     * @param width
     */
    public void floodFill(List<String> figures, int x, int y, char c, int height, int width) {
        Map<String, Integer> coordinates;
        for (String figure : figures) {
            String[] splitCommand = DrawHelper.splitWhitespace(figure);
            char firstCharacter = splitCommand[0].charAt(0);
            Integer x1 = Integer.parseInt(splitCommand[1]);
            Integer y1 = Integer.parseInt(splitCommand[2]);
            Integer x2 = Integer.parseInt(splitCommand[3]);
            Integer y2 = Integer.parseInt(splitCommand[4]);
            coordinates = DrawHelper.getMaxMin(x1, y1, x2, y2);

            if (Character.toLowerCase(firstCharacter) == 'r') {
                Boolean isInsideRectangle = rectangleServiceImpl.isInsideRectangle(x, y, coordinates, height, width);
                if (isInsideRectangle) {
                    remove(c, width, height);
                    canvas = drawServiceImpl.fillRectangle(canvas, coordinates, c, x, y);
                    break;
                } else {
                    canvas = drawServiceImpl.removeFill(canvas, coordinates);
                }

            } else if (Character.toLowerCase(firstCharacter) == 'l') {
                canvas = lineServiceImpl.removeLineFill(canvas, coordinates, width, height);
            }
        }

        displayServiceImpl.display(canvas);
    }

    /**
     * removes all character c or replaces character with empty character
     * 
     * @param c
     * @author Srijan Bajracharya<srijan.bajracharya@gmail.com>
     */
    public void remove(char c, int width, int height) {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (canvas[i][j] == c) {
                    canvas[i][j] = ' ';
                }
            }
        }
    }

}

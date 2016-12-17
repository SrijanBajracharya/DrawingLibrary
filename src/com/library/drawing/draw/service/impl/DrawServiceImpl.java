package com.library.drawing.draw.service.impl;

import java.awt.Canvas;
import java.util.Map;

import com.library.drawing.draw.service.DrawService;

/**
 * 
 * @author Srijan Bajracharya<srijan.bajracharya@gmail.com>
 *
 */
public class DrawServiceImpl implements DrawService {

    /**
     * creates canvas array
     * 
     * @param width
     * @param height
     * @return {@link Canvas}
     * @author Srijan Bajracharya<srijan.bajracharya@gmail.com>
     */
    public char[][] drawCanvas(int width, int height) {
        char[][] canvas = new char[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (x == 0 || x == width - 1) {
                    canvas[x][y] = '-';
                } else if (y == 0 || y == height - 1) {
                    canvas[x][y] = '|';
                } else {
                    canvas[x][y] = ' ';
                }
            }
        }
        return canvas;
    }

    /**
     * draws different figures
     * 
     * @param canvas
     * @author Srijan Bajracharya<srijan.bajracharya@gmail.com>
     */
    public void display(char[][] canvas) {
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                System.out.print(canvas[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * inserts "*" to a multidimensional array to draw rectangle
     * 
     * @param canvas
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return {@link Canvas}
     * @author Srijan Bajracharya<srijan.bajracharya@gmail.com>
     */
    public char[][] drawRectangle(char[][] canvas, int x1, int y1, int x2, int y2) {
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                if (j == x1 || j == x2) {
                    if (y1 <= i && y2 >= i) {
                        canvas[i][j] = '*';
                    }

                } else if (i == y1 || i == y2) {
                    if (x1 <= j && x2 >= j) {
                        canvas[i][j] = '*';
                    }
                }
            }

        }
        return canvas;
    }

    /**
     * Inserts "+" to a multi dimensional array
     * 
     * @param canvas
     * @param coordinates
     * @return {@link Canvas}
     * @author Srijan Bajracharya<srijan.bajracharya@gmail.com>
     */
    public char[][] drawLine(char[][] canvas, Map<String, Integer> coordinates) {
        Integer minX = coordinates.get("minX");
        Integer minY = coordinates.get("minY");
        Integer maxX = coordinates.get("maxX");
        Integer maxY = coordinates.get("maxY");
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                if (j == minX) {
                    if (minY <= i && i <= maxY) {
                        canvas[i][j] = '+';
                    }

                } else if (i == maxY) {
                    if (minX <= j && j <= maxX) {
                        canvas[i][j] = '+';
                    }
                }

            }
        }
        return canvas;
    }

    public char[][] fillAll(char[][] canvas) {
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                if (canvas[i][j] == ' ') {
                    canvas[i][j] = '#';
                }
            }
        }
        return canvas;
    }

    public Boolean isInsideRectangle(int x, int y, Map<String, Integer> coordinates) {
        Integer minX = coordinates.get("minX");
        Integer minY = coordinates.get("minY");
        Integer maxX = coordinates.get("maxX");
        Integer maxY = coordinates.get("maxY");
        if ((x >= minX && x <= maxX) && (y >= minY && y <= maxY)) {
            return true;
        }
        return false;
    }

}

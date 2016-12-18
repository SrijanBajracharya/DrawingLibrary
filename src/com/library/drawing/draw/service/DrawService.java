package com.library.drawing.draw.service;

import java.awt.Canvas;
import java.util.Map;

public interface DrawService {

    /**
     * creates canvas array
     * 
     * @param width
     * @param height
     * @return {@link Canvas}
     * @author Srijan Bajracharya<srijan.bajracharya@gmail.com>
     */
    public char[][] drawCanvas(int width, int height);

    /**
     * draws different figures
     * 
     * @param canvas
     * @author Srijan Bajracharya<srijan.bajracharya@gmail.com>
     */
    public void display(char[][] canvas);

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
    public char[][] drawRectangle(char[][] canvas, int x1, int y1, int x2, int y2);

    /**
     * Inserts "+" to a multi dimensional array
     * 
     * @param canvas
     * @param coordinates
     * @return {@link Canvas}
     * @author Srijan Bajracharya<srijan.bajracharya@gmail.com>
     */
    public char[][] drawLine(char[][] canvas, Map<String, Integer> coordinates);

    /**
     * detects collision and fills
     * 
     * @param canvas
     * @param x
     * @param y
     * @param c
     * @return {@link Canvas}
     * @author Srijan Bajracharya<srijan.bajracharya@gmail.com>
     */
    public char[][] collision(char[][] canvas, int x, int y, char c);

    /**
     * removes unwanted fills
     * 
     * @param canvas
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return {@link Canvas}
     * @author Srijan Bajracharya<srijan.bajracharya@gmail.com>
     */
    public char[][] removeFill(char[][] canvas, int x1, int y1, int x2, int y2);

}

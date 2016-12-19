package com.library.drawing.draw.service;

import java.awt.Canvas;
import java.util.Map;

/**
 * 
 * @author Srijan Bajracharya<srijan.bajracharya@gmail.com>
 *
 */
public interface LineService {

    /**
     * draw Line for cases which forms a block with canvas
     * 
     * @param canvas
     * @param coordinates
     * @return {@link Canvas}
     * @author Srijan Bajracharya<srijan.bajracharya@gmail.com>
     */
    public char[][] drawLine(char[][] canvas, Map<String, Integer> coordinates);

    /**
     * draw line for all that are inside canvas
     * 
     * @param canvas
     * @param coordinates
     * @return {@link Canvas}
     * @author Srijan Bajracharya<srijan.bajracharya@gmail.com>
     */
    public char[][] line(char[][] canvas, Map<String, Integer> coordinates);

    public char[][] removeLineFill(char[][] canvas, Map<String, Integer> coordinates, int width, int height);
}

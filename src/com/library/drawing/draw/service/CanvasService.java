package com.library.drawing.draw.service;

import java.awt.Canvas;

/**
 * 
 * @author Srijan Bajracharya<srijan.bajracharya@gmail.com>
 *
 */
public interface CanvasService {

    /**
     * creates canvas array
     * 
     * @param width
     * @param height
     * @return {@link Canvas}
     * @author Srijan Bajracharya<srijan.bajracharya@gmail.com>
     */
    public char[][] drawCanvas(int width, int height);
}

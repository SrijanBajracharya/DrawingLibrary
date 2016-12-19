package com.library.drawing.draw.service.impl;

import com.library.drawing.draw.service.CanvasService;

public class CanvasServiceImpl implements CanvasService {

    /**
     * {@inheritDoc}
     */
    @Override
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
}

package com.library.drawing.draw.service.impl;

import java.util.Map;

import com.library.drawing.draw.service.DrawService;

/**
 * 
 * @author Srijan Bajracharya<srijan.bajracharya@gmail.com>
 *
 */
public class DrawServiceImpl implements DrawService {

    /**
     * {@inheritDoc}
     */

    @Override
    public char[][] collision(char[][] canvas, int x, int y, char c) {
        int width = canvas.length;
        int height = canvas[0].length;
        int xr = x;
        int xl = x;
        int yt = y;
        int yb = y;
        while (true) {
            if (canvas[xr][y] != ' ') {
                break;
            } else {
                if (xr < width) {
                    xr++;
                } else {
                    break;
                }
            }
        }
        while (true) {
            if (canvas[xl][y] != ' ') {
                break;
            } else {
                if (xl > 0) {
                    xl--;
                } else {
                    break;
                }
            }

        }

        while (true) {
            if (canvas[x][yt] != ' ') {
                break;
            } else {
                if (yt > 0) {
                    yt--;
                } else {
                    break;
                }
            }
        }
        while (true) {
            if (canvas[x][yb] != ' ') {
                break;
            } else {
                if (yb < height) {
                    yb++;
                } else {
                    break;
                }
            }
        }

        for (int i = xl + 1; i < xr; i++) {
            for (int j = yt + 1; j < yb; j++) {
                // fill all
                if (canvas[i][j] == ' ') {
                    canvas[i][j] = c;
                }
            }
        }

        return canvas;
    }

    @Override
    public char[][] removeFill(char[][] canvas, Map<String, Integer> coordinates) {
        Integer minX = coordinates.get("minX");
        Integer minY = coordinates.get("minY");
        Integer maxX = coordinates.get("maxX");
        Integer maxY = coordinates.get("maxY");
        for (int i = minY + 1; i < maxY; i++) {
            for (int j = minX + 1; j < maxX; j++) {
                canvas[i][j] = ' ';
            }
        }

        return canvas;
    }

    @Override
    public char[][] fillAll(char[][] canvas, char c) {
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                if (canvas[i][j] == ' ') {
                    canvas[i][j] = c;
                }
            }
        }
        return canvas;
    }

}

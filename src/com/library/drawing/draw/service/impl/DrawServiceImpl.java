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
     * {@inheritDoc}
     */
    @Override
    public void display(char[][] canvas) {
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                System.out.print(canvas[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public char[][] drawRectangle(char[][] canvas, int x1, int y1, int x2, int y2) {
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                if (j == x1 || j == x2) {
                    if (y1 <= i && y2 >= i) {
                        canvas[i][j] = '*';
                    } else if (y1 >= i && y2 <= i) {
                        canvas[i][j] = '*';
                    }

                } else if (i == y1 || i == y2) {
                    if (x1 <= j && x2 >= j) {
                        canvas[i][j] = '*';
                    } else if (x1 >= j && x2 <= j) {
                        canvas[i][j] = '*';
                    }
                }
            }

        }
        return canvas;
    }

    /**
     * {@inheritDoc}
     */
    @Override
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
    public char[][] removeFill(char[][] canvas, int x1, int y1, int x2, int y2) {
        int minX = x1;
        int minY = y1;
        int maxX = x2;
        int maxY = y2;
        if (y1 > y2) {
            maxY = y1;
            minY = y2;
        }
        if (x1 > x2) {
            maxX = x1;
            minX = x2;
        }
        for (int i = minY + 1; i < maxY; i++) {
            for (int j = minX + 1; j < maxX; j++) {
                canvas[i][j] = ' ';
            }
        }

        return canvas;
    }

}

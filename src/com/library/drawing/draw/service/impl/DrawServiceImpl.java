package com.library.drawing.draw.service.impl;

import com.library.drawing.draw.service.DrawService;

public class DrawServiceImpl implements DrawService {

    public char[][] createArray(int width, int height) {
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

    public void display(char[][] canvas) {
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                System.out.print(canvas[i][j]);
            }
            System.out.println();
        }
    }

    public char[][] drawRect(char[][] canvas, int x1, int y1, int x2, int y2) {
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                if (i == x1 || i == x2) {
                    if (y1 <= j && y2 >= j) {
                        canvas[i][j] = '*';
                    }

                } else if (j == y1 || j == y2) {
                    if (x1 <= i && x2 >= i) {
                        canvas[i][j] = '*';
                    }
                }
            }

        }
        return canvas;
    }

    public char[][] drawLine(char[][] canvas, int x1, int y1, int x2, int y2) {
        if (y1 > y2) {
            y2 = y1;
        }
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                if (i == x1) {
                    if (y1 <= j && j <= y2) {
                        canvas[i][j] = '+';
                    }

                } else if (j == y2) {
                    if (x1 <= i && i <= x2) {
                        canvas[i][j] = '+';
                    }
                }

            }
        }
        return canvas;
    }

}

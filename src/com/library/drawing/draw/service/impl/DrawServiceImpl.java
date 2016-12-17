package com.library.drawing.draw.service.impl;

import com.library.drawing.draw.service.DrawService;

public class DrawServiceImpl implements DrawService {

    public void display() {
        System.out.println("inside display");
    }

    private int width = 0;
    private int height = 0;

    public DrawServiceImpl(int height, int width) {
        this.width = width;
        this.height = height;
    }

    public void drawCanvas(String c, int width, int height) {
        for (int x = 0; x <= width; x++) {
            for (int y = 0; y <= height; y++) {
                if (x == 0 || x == width) {
                    System.out.print("-");
                } else if (y == 0 || y == height) {
                    System.out.print("|");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public void drawRectangle(String L, int x1, int y1, int x2, int y2) {
        if ((x1 > 0) && (x2 < this.width) && (y1 > 0) && (y2 < this.height)) {
            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {
                    if (x == x1 || x == x2) {
                        System.out.print("*");
                    } else if (y == y1 || y == y2) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }

    public int getDistance(int x, int y) {
        if (x > y) {
            return x - y;
        } else
            return y - x;
    }

    public void createArray(int width, int height) {
        char[][] canvas = new char[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (x == 0 || x == width - 1) {
                    canvas[x][y] = '-';
                } else if (y == 0 || y == height - 1) {
                    canvas[x][y] = '|';
                } else {
                    canvas[x][y] = '*';
                }
            }
        }

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                System.out.print(canvas[x][y]);
            }
            System.out.println();
        }
    }

    public void draw(String L, int width1, int height1, int x1, int y1, int x2, int y2) {
        for (int x = 0; x <= width1; x++) {
            for (int y = 0; y <= height1; y++) {
                if (x == 0 || x == width1) {
                    System.out.print("-");
                } else if (y == 0 || y == height1) {
                    System.out.print("|");
                } else if (x == x1 || x == x2) {
                    if (y1 <= y && y2 >= y) {
                        System.out.print("+");
                    } else {
                        System.out.print(" ");
                    }
                } else if (y == y1 || y == y2) {
                    if (x1 <= x && x2 >= x) {
                        System.out.print("+");
                    } else {
                        System.out.print(" ");
                    }
                } else {
                    System.out.print(" ");
                }

            }
            System.out.println();
        }
    }

    public void drawHorizontalLine(int x1, int x2, int x) {
        if (x == x1 || x == x2) {
            System.out.print("*");
        }
    }

    public void drawVerticalLine(int y1, int y2, int y) {
        if (y == y1 || y == y2) {
            System.out.print("*");
        }
    }

}

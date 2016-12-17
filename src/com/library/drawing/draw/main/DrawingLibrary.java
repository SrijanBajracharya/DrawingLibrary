package com.library.drawing.draw.main;

import com.library.drawing.draw.service.impl.DrawServiceImpl;

public class DrawingLibrary {

    public static void main(String[] args) {

        System.out.println("Welcome to Draw Library");
        DrawServiceImpl drawServiceImpl = new DrawServiceImpl();
        char[][] canvas = drawServiceImpl.createArray(10, 10);
        drawServiceImpl.display(canvas);
        char[][] rectAndCanvas = drawServiceImpl.drawRect(canvas, 1, 1, 3, 3);
        drawServiceImpl.display(rectAndCanvas);
        char[][] lineAndCanvas = drawServiceImpl.drawLine(rectAndCanvas, 4, 4, 6, 6);
        drawServiceImpl.display(lineAndCanvas);
    }
}

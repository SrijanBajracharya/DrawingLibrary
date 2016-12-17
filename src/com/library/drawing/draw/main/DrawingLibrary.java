package com.library.drawing.draw.main;

import java.util.Map;

import com.library.drawing.draw.service.impl.DrawServiceImpl;

public class DrawingLibrary {

    public static void main(String[] args) {

        System.out.println("Welcome to Draw Library");
        DrawServiceImpl drawServiceImpl = new DrawServiceImpl();
        char[][] canvas = drawServiceImpl.createArray(25, 25);
        drawServiceImpl.display(canvas);
        char[][] rectAndCanvas = drawServiceImpl.drawRect(canvas, 4, 1, 8, 8);
        drawServiceImpl.display(rectAndCanvas);
        // Map<String, Integer> coordinates = drawServiceImpl.getMaxMin(4, 1, 8, 8);
        // drawServiceImpl.drawRect(rectAndCanvas, coordinates);
        Map<String, Integer> coordinates = drawServiceImpl.getMaxMin(8, 7, 3, 2);
        // char[][] lineAndCanvas = drawServiceImpl.lineOperation(rectAndCanvas, 8, 7, 6, 4);
        char[][] lineAndCanvas = drawServiceImpl.drawLine(rectAndCanvas, coordinates);
        drawServiceImpl.display(lineAndCanvas);
        Boolean result = drawServiceImpl.isInsideRectangle(5, 3, coordinates);
        System.out.println(result);
        if (result) {
            char[][] fillRect = drawServiceImpl.fill(lineAndCanvas, coordinates);
            drawServiceImpl.display(fillRect);
        }
    }
}

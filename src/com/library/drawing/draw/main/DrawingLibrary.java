package com.library.drawing.draw.main;

import java.util.Scanner;

import com.library.drawing.draw.service.impl.DrawServiceImpl;

public class DrawingLibrary {

    public static void main(String[] args) {

        System.out.println("Welcome to Draw Library");
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        System.out.println(command);
        String[] parts = command.split(" ");
        String c;
        int width = 0;
        int height = 0;
        for (int i = 0; i < parts.length; i++) {
            System.out.println(parts[i]);

        }
        c = parts[0];
        width = Integer.parseInt(parts[1]);
        height = Integer.parseInt(parts[2]);
        DrawServiceImpl drawServiceImpl = new DrawServiceImpl(height, width);
        // drawServiceImpl.drawCanvas(c, width, height);
        // drawServiceImpl.drawRectangle("l", 2, 2, 10, 10);
        // drawServiceImpl.draw("l", width, height, 2, 2, 10, 10);
        drawServiceImpl.createArray(width, height);
    }
}

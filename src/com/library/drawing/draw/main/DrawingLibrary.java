package com.library.drawing.draw.main;

import java.util.Scanner;

import com.library.drawing.draw.controller.DrawController;
import com.library.drawing.draw.helper.DrawHelper;

public class DrawingLibrary {

    public static final String ERROR_MESSAGE = "First of all you need to draw a canvas. Thank you";
    public static final String ERROR_COMMAND_MESSAGE = "Command is not correct. Please reload the program and try again. Thank you";

    public static void main(String[] args) {

        System.out.println("Welcome to Draw Library");
        System.out.println("Instructions:");
        System.out.println("Commands:\n 1.To draw Canvas: c height width \n 2.To draw Rectangle: R x1 y1 x2 y2");
        System.out.println(" 3.To draw Line: l x1 y1 x2 y2 \n 4.For bubble fill: b x y c where c is the character you want to fill with");
        System.out.println(" 5.To Quit: q");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] splitString = DrawHelper.splitWhitespace(input);
        char character = splitString[0].charAt(0);
        if (Character.toLowerCase(character) != 'c') {
            System.out.println(ERROR_MESSAGE);
        } else if (Character.toLowerCase(character) != 'c' && splitString.length > 3) {
            System.out.println(ERROR_COMMAND_MESSAGE);
        } else {
            DrawController drawController = new DrawController();
            drawController.draw(splitString, character);
        }

    }
}

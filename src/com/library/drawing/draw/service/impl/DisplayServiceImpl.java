package com.library.drawing.draw.service.impl;

import com.library.drawing.draw.service.DisplayService;

/**
 * 
 * @author Srijan Bajracharya<srijan.bajracharya@gmail.com>
 *
 */
public class DisplayServiceImpl implements DisplayService {

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
}

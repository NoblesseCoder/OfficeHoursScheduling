package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class Main {
    private static HashMap<String,String> credentials = new HashMap<>();

    public static void main(String[] args) {
        DisplayGui displayGui = new DisplayGui(credentials);
        displayGui.setVisible(true);
    }

}


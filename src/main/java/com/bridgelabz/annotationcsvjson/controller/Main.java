package com.bridgelabz.annotationcsvjson.controller;

import com.bridgelabz.annotationcsvjson.model.AnnotationExample;

import java.io.IOException;
import java.util.Scanner;

public class Main {
        public static void main(String[] args) throws IOException {
            int i = 0, choice;
            Scanner input = new Scanner(System.in);
            while (i == 0) {
                System.out.println("1. @Annotations Example\n" +
                        "2. OpenCSV Examples\n" +
                        "3. JSON Example\n" +
                        "4. Exit");
                choice = input.nextInt();
                switch (choice) {
                    case 1:
                        AnnotationExample.annotationExample();
                        break;
                    case 2:
                        com.bridgelabz.annotationcsvjson.model.OpenCSVExample.csvExample();
                        break;
                    case 3:
                        com.bridgelabz.annotationcsvjson.model.JSONExample.jsonExample();
                        break;
                    case 4:
                        i = 1;
                        break;
                    default:
                        System.out.println("Enter Valid Option please...");
                }
            }
        }
    }


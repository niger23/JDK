package org.example;

import org.apache.commons.collections4.CollectionUtils;

import java.io.IOException;
import java.io.InputStream;

public class Main {
    public void PrintFile () throws IOException {
        InputStream is = getClass().getResourceAsStream("hello.txt");

        System.out.println(new String(is.readAllBytes()));
    }

    public static void main(String[] args) throws IOException {
        new Main().PrintFile();

    }
}
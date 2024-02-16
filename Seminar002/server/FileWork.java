package Seminar002.server;

import java.io.*;

public class FileWork implements Repository{
    private static final String PATH = "Seminar002/server/log.txt";

    @Override
    public void save(String log) {
        try(FileWriter writer = new FileWriter(PATH, true)) {
            writer.write(log + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public String load() {
        StringBuilder allLog = new StringBuilder();
        try(FileReader in = new FileReader(PATH);
            BufferedReader reader = new BufferedReader(in)) {
            while (reader.ready()) {
                String line = reader.readLine();
                allLog.append(line).append("\n");
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return allLog.toString();
    }
}

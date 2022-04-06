package Lesson_5;

import java.beans.PropertyEditorSupport;
import java.io.*;
import java.util.Arrays;

public class AppData {
    private String[] header;
    private int[][] data;
    final String fileName = "fileCSV.csv";

    public AppData(String[] header, int[][] data) {
        this.header = header;
        this.data = data;
    }

    public String[] getHeader() {
        return header;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

    public int[][] getData() {
        return data;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

    public void saveDataAsCSV(AppData appData) {
        try(FileWriter csvFile = new FileWriter(fileName)) {
            for (String str : getHeader()) {
                csvFile.write(str);
                csvFile.write(';');
            }
            csvFile.write('\n');

            for (int i = 0; i < getData().length; i++) {
               for (int j = 0; j < data[i].length; j++) {
                    csvFile.write(String.valueOf(data[i][j]));
                   csvFile.write(';');

                }
                csvFile.write('\n');
            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readCSV() {
        try (FileReader cvsFile = new FileReader(fileName)) {
            int c;
            while ((c = cvsFile.read()) != -1) {
                System.out.print((char)c);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}






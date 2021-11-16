package Bytes_Read_Write;

import java.io.*;
import java.util.*;

class File_Input_Stream {

    public static final File f= new File("D:\\Study\\Novels.txt");

    public static void main(String[] args) throws FileNotFoundException, IOException {
        System.out.println("Name: " + f.getName());
        System.out.println("File size: " + (f.length()/1024) + " KB");
        System.out.println("Is file: " + f.isFile());
        System.out.println("Is executable:" + f.canExecute());
        System.out.println("Last Modified: " + new Date(f.lastModified()));
        System.out.println();
        readByFileInputStream(f);
        // readByDataInputStream(new DataInputStream(new FileInputStream(f)));
    }
    
    // Using FileInputStream
    public static void readByFileInputStream(File f) {
        try (FileInputStream fileInputStream = new FileInputStream(f)) {
            System.out.println("Available bytes to read:" + fileInputStream.available());
            System.out.println("Reading by bytes: ");
            for (byte b : fileInputStream.readAllBytes()) {
                System.out.print((char) b);
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println("Something went wrong!!");
            e.printStackTrace();
        }
    }

    // Using DataInputStream -> has methods readChar(), readInt(), readLong(),.....
    public static void readByDataInputStream(DataInputStream dataInputStream) throws IOException{
        System.out.println("Reading only the first 100 bytes through data input stream");
        for (int i = 0; i <= 100; i++) {
            System.out.print(dataInputStream.readChar());
        }
    }

}
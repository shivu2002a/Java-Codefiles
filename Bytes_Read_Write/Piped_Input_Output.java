package Bytes_Read_Write;

import java.io.*;

public class Piped_Input_Output {

    // Writing from existing file through one thread, writing it to stream through one thread and reading through another thread

    static final PipedInputStream pipedInputStream = new PipedInputStream();
    static final PipedOutputStream pipedOutputStream = new PipedOutputStream();
    
    static final File f = new File("D:\\Study\\Novels.txt");
    static final File fNew = new File("D:\\Study\\Novels_PipedStream.txt");

    public static FileOutputStream fOutputStream;
    public static FileInputStream fInputStream;

    static{
        if(!fNew.exists()){
            try{
                fNew.createNewFile();
            } catch (Exception e) {
                System.out.println("Unable to create file...");
            }
        }
    }

    public static void main(String[] args) {
        writeToNewFile();
        new Thread(() -> loader()).start();
        new Thread(() -> writer()).start();
    }

    public static void writeToNewFile(){
        System.out.println("Writing contents on new file");
        try {
            fInputStream = new FileInputStream(f);
            fOutputStream = new FileOutputStream(fNew);
            for (int i = 0; i <=fInputStream.available()/2 ; i++) {
                fOutputStream.write(fInputStream.read());
            }
        } catch (IOException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        } finally {
            try {
                if (fInputStream != null) {
                    fInputStream.close();
                }
            } catch (IOException e) {
                System.out.println("Unable to close the file input stream");
                e.printStackTrace();
            }
        }
    }

    public static void loader(){
        System.out.println("Loading contents by thread1");
        try {
            fInputStream = new FileInputStream(fNew);
            byte[] bArr = fInputStream.readAllBytes();
            for (byte b : bArr) {
                pipedOutputStream.write(b);
            }
        } catch (Exception e) {
            System.out.println("Unable to process file input stream");
        } finally{
            try {
                if (fInputStream != null) {
                    fInputStream.close();
                }
            } catch (IOException e) {
                System.out.println("Unable to close the file input stream");
                e.printStackTrace();
            }
        }
    }

    public static void writer(){
        try {
            pipedInputStream.connect(pipedOutputStream);
            System.out.println("Contents of file are read by thread two...");
            for (int i = 0; i < fNew.length(); i++) {
                System.out.print((char) pipedInputStream.read());
            }
        } catch (Exception e) {
            System.out.println("Unable to load contents of thread one by thread two");
        }
    }
}

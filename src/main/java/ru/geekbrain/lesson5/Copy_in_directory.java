/**  1,Написать функцию, создающую резервную копию всех файлов в директории
 * (без поддиректорий) во вновь созданную папку ./backup
 *
 */



package ru.geekbrain.lesson5;

import java.io.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Copy_in_directory {

    public static void main(String[] args)  {

        File directory = new File("D:/backup");
        if (directory.mkdirs()) {
            System.out.println("Создали директорию 'backup'");
        }

        String dir1 = "D://Copy";       //  исходная директория
        String dir2 = "D://backup";     // директория назначения
        boolean scan = true;
        CopyFiles.scannerDir(dir1, dir2, scan);
    }
    public static class CopyFiles {
        public static void copyFile(File in, File out) throws IOException {

            byte buffer[] = new byte[100000000];
            try {
                FileInputStream fileIn = new FileInputStream(in);   // запускаем поток указанного размера на вход
                int bytes = fileIn.read(buffer,0,100000000);
                fileIn.close();                                     // достигли предела, закрыли входящий поток

                FileOutputStream fileOut = new FileOutputStream(out);  // запускаем поток на выход ( копируем)
                fileOut.write(buffer,0,bytes);
                fileOut.close();                                        // опустошили в ноль,закрываем поток
            }
            catch (Exception e) {                                       // если диск поцарапан, бросаем исключение
            }
        }


        public static void scannerDir(String dir1, String dir2, boolean scan) {  // смотрим, что бэкапим

            int i = 0;                                                          // счетчик
            File[] list = new File(dir1).listFiles();                           // создали список. что будем бэкапить

            for (i = 0; i < Objects.requireNonNull(list).length; i++)           // считаем копируемые объекты
            {
                File f1 = new File (dir1 +"//"+ list[i].getName());  // исходный файл
                File f2 = new File (dir2 +"//"+ list[i].getName());  // будущий бэкап

                if (!f1.isDirectory()) {              // если сканирование показало. что имеется файл для копирования,то:
                    try {
                        CopyFiles.copyFile(f1, f2);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Файл " + list[i] + " был скопирован в  " +dir2);
                }
                System.gc();
            }
        }
    }
}



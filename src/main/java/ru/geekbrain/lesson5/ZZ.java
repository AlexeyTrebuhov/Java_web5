package ru.geekbrain.lesson5;

/** 3***. Предположить, что числа в исходном массиве из 9 элементов имеют диапазон[0, 3], и представляют
 * собой, например, состояния ячеек поля для игры в крестикинолики, где 0 – это пустое поле,
 * 1 – это поле с крестиком,
 * 2 – это поле с ноликом,
 *  3 – резервное значение. Такое предположение позволит хранить в одном числе типа int всё поле 3х3.
 *  Записать в файл 9 значений так, чтобы они заняли три байта
 */

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;


import java.nio.file.Paths;

class ZZ
{
    public static void main(String[] args)
    {
        Path path = Paths.get("doc.txt");
        byte[] bytes = "999".getBytes(StandardCharsets.UTF_8);

        try {
            Files.write(path, bytes);
            System.out.println("Интервал для трехмерного поля - цифра от 0 до 999");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}



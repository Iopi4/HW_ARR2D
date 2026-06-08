import java.util.Random;
import java.util.Scanner;

public class Main {

    public static final int SIZE = 8;

    public static void main(String[] args) {
        int[][] colors = new int[SIZE][SIZE];
        int[][] rotateColors = new int[SIZE][SIZE]; //Пустой массив той же размерности для повернутой матрицы

        //Создадим рандомный массив
        Random random = new Random();
        for (int i = 0; i < colors.length; i++) {
            for (int j = 0; j < colors.length; j++) {
                // для случайных значений воспользуемся готовым решением из библиотеки java.util.Random
                colors[i][j] = random.nextInt(256);
            }
        }
        //Выведем на экран рандомный массив
        System.out.println("Рандомный массив");
        printColors(colors);
        System.out.println();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите угол поворота рандомного массива на: 90, 180 или 270 градусов");

            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }
            int corner = Integer.parseInt(input);

            //Вызовем функцию поворота рандомного массива на выбранный угол 90, 180, 270 градусов по часовой стрелке
            rotateColors(colors, rotateColors, corner);

            //Выведем на экран рандомный массив повернутый на выбранный угол по часовой стрелке
            printColors(rotateColors);
            System.out.println();
        }
    }

    //Оформим вывод матрицы на экран в виде отдельного метода
    public static void printColors(int[][] color) {
        for (int i = 0; i < color.length; i++) {
            for (int j = 0; j < color.length; j++) {
                // %4d означает, что мы под каждый номер резервируем 4 знака
                // (незанятые будут заполнены пробелами)
                // таким образом, у нас получится ровная таблица
                System.out.format("%4d", color[i][j]);
            }
            System.out.println();
        }
    }

    //Оформим поворот массива на 90, 180 и 270 градусов по часовой стрелки в виде отдельного метода
    public static void rotateColors(int[][] color, int[][] rotateColor, int corner) {
        if (corner == 90) {
            for (int i = 0; i < color.length; i++) {
                for (int j = 0; j < color.length; j++) {
                    rotateColor[i][j] = color[SIZE - 1 - j][i];
                }
            }
        }
        if (corner == 180) {
            for (int i = 0; i < color.length; i++) {
                for (int j = 0; j < color.length; j++) {
                    rotateColor[i][j] = color[SIZE - 1 - i][SIZE - 1 - j];
                }
            }
        }
        if (corner == 270) {
            for (int i = 0; i < color.length; i++) {
                for (int j = 0; j < color.length; j++) {
                    rotateColor[i][j] = color[j][SIZE - 1 - i];
                }
            }
        }
    }
}
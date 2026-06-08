import java.util.Random;

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
        printColors(colors);
        System.out.println();

        //Вызовем функцию поворота рандомного массива на 90 градусов по часовой стрелке
        rotateColors(colors, rotateColors);

        //Выведем на экран рандомный массив повернутый на 90 градусов по часовой стрелке
        printColors(rotateColors);
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

    //Оформим поворот матрицы на 90 градусов по часовой стрелки в виде отдельного метода
    public static void rotateColors(int[][] color, int[][] rotateColor) {
        for (int i = 0; i < color.length; i++) {
            for (int j = 0; j < color.length; j++) {
                rotateColor[i][j] = color[SIZE - 1 - j][i];
            }
        }
    }
}
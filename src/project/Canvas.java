package project;

//Клас буде відповідальним за "відмальовування" об'єктів. З його допомогою вони малюватимуть себе.

/*
  Клас міститиме матрицю, куди ми малюватимемо.
  У матриці є ширина та висота.
  А ще в ній зберігатимемо не числа (int), а символи (char).
 */
public class Canvas {

    private int width; // довжина
    private int height; // висота

    private char[][] matrix; // матриця

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        matrix = new char[height][width];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public char[][] getMatrix() {
        return matrix;
    }
}


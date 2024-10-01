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

    // метод - setPoint буде "ставити крапку в координатах x, y кольором c".
    public void setPoint(double x, double y, char c) {
        int rX = (int) Math.round(x);
        int rY = (int) Math.round(y);
        // якщо rX та rY знаходяться в межах матриці
        if (0 <= rX && rX < matrix[0].length && 0 <= rY && rY < matrix.length) {
            matrix[rY][rX] = c;
        }
    }

    //метод - drawMatrix копіює передану йому картинку (матрицю) у матрицю Canvas.
    //І не просто копіює, а починаючи з координат x, y.
    public void drawMatrix(double x, double y, int[][] matrix, char c){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j]!=0){
                    setPoint(x+j,y+i,c);
                }
            }
        }
    }
}


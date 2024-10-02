package project;

//���� ���� ������������ �� "��������������" ��'����. � ���� ��������� ���� ������������ ����.

/*
  ���� �������� �������, ���� �� ������������.
  � ������� � ������ �� ������.
  � �� � ��� ������������ �� ����� (int), � ������� (char).
 */
public class Canvas {

    private int width; // �������
    private int height; // ������

    private char[][] matrix; // �������

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        matrix = new char[height+2][width+2];
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

    // ����� - setPoint ���� "������� ������ � ����������� x, y �������� c".
    public void setPoint(double x, double y, char c) {
        int rX = (int) Math.round(x);
        int rY = (int) Math.round(y);
        // ���� rX �� rY ����������� � ����� �������
        if (0 <= rX && rX < matrix[0].length && 0 <= rY && rY < matrix.length) {
            matrix[rY][rX] = c;
        }
    }

    //����� - drawMatrix ����� �������� ���� �������� (�������) � ������� Canvas.
    //� �� ������ �����, � ��������� � ��������� x, y.
    public void drawMatrix(double x, double y, int[][] matrix, char c){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j]!=0){
                    setPoint(x+j,y+i,c);
                }
            }
        }
    }

    //����� ��������� �������, ��� �� ��� ����� ����� ���� ��������.
    //� ����� ������� ������� �� ������� ������� �� ���������
    public void clear(){
        this.matrix = new char[height + 2][width + 2];
    }

    // ����� ����� ������� �� �����
    public void print() {
        System.out.println();
        for (int i = 0; i < height+2; i++) {
            for (int j = 0; j < width+2; j++) {
                System.out.print(" ");
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        System.out.println();
    }
}


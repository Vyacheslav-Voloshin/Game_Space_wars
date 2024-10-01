package project;

    /*
    ��� ��������� ������� ���: ���� ���������� �������� ������ ����,
    �������� ������ ���� ��� �������� ����.
    ���� ��������� ������ �������� - ���� ��� �������� �� �����.
    ���� �������� ���������� ����� dx, ��� ���������� �������� ���� �������.
    ���� dx = 1, �������� ����� ��� ��� �� 1 ��������,
    ���� dx = -1, �������� ����� ��� ��� �� 1 ������.
     */
    public class SpaceShip extends BaseObject{
        //�������� ������� ��� ��������� �� �����
        private static int[][] matrix = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0},
                {1, 0, 1, 0, 1},
                {1, 1, 1, 1, 1},
        };
        private double dx = 0; //���� ��� ���������� ������� ���� �� ������
        public SpaceShip(double x, double y) {

            super(x, y, 3);
        }

        // ����� �������� �������� ������
        public void moveLeft(){
            dx = -1;
        }

        // ����� �������� �������� ��������
        public void moveRight(){
            dx = 1;
        }

        // ����� ���������� ����� �� ����� � ������������ � �� � � ������ "M"
        @Override
        public void draw(Canvas canvas) {
            canvas.drawMatrix(x - radius + 1, y - radius + 1, matrix, 'M');
        }
        //����� ������� �������� �� �������� �� �� ���� �� �� ������� �������
        @Override
        public void move() {
            x+=dx;
            checkBorders(radius, Space.game.getWidth() - radius + 1, 1, Space.game.getHeight() + 1);

        }

        //��� ����� ����������� ���� ��������� �������� ������, �������� ������ ����� �������� ���������
        public void fire(){
            Rocket rocketLeft = new Rocket(x-2,y);
            Rocket rocketRight = new Rocket(x+2,y);
            Space.game.getRockets().add(rocketLeft);
            Space.game.getRockets().add(rocketRight);
        }
}

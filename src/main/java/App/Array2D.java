package App;

import java.util.ArrayList;
import java.util.List;

public class Array2D {
    private static Circle[][] array = new Circle[Application.WIDTH][Application.HEIGHT-Application.TEXT_AREA_HEIGHT];
    private static List<Circle> list = new ArrayList<Circle>();

    public void addCircle(Circle circle) {
        array[circle.getX()][circle.getY()] = circle;
        if (!hasCircle(circle, list)) {
            list.add(circle);
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getX() == circle.getX() && list.get(i).getY() == circle.getY()) {
                    list.remove(i);
                    list.add(circle);
                }
            }
        }
    }

    public static boolean hasCircle(Circle circle, List<Circle> list) {
        for (int i = 0; i < list.size(); i++) {
            if (circle.getY() == list.get(i).getY() && circle.getX() == list.get(i).getX()) {
                return true;
            }
        }

        return false;
    }

    public static Circle[][] getArray() {
        return array;
    }

    public static List<Circle> getList() {
        return list;
    }

    public static int getListIndex(Circle circle){
        return list.indexOf(circle);
    }

    public Circle getCircleFromArray(int x, int y) {
        return array[x][y];
    }

    public static double calculateDistance(Circle circle1, Circle circle2) {
        int x = Math.abs(circle1.getX() - circle2.getX());
        int y = Math.abs(circle1.getY() - circle2.getY());

        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    public static double calculateTotalDistance(Circle... args) {
        double distance = 0d;

        for (int i = 0; i < args.length - 1; i++) {
            distance += (calculateDistance(args[i], args[i + 1]));
        }

        return distance;
    }
}

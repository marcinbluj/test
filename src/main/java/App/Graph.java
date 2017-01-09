package App;

import java.util.*;

public class Graph {

    private Circle circleStart;
    private Circle circleEnd;
    private List<Circle> previousList = new ArrayList<Circle>();
    private double distance = 0;
    private StringBuilder builder = new StringBuilder();

    private static Map<String, Double> map = new HashMap<String, Double>();

    public Graph(Circle circleStart, Circle circleEnd) {
        this.circleStart = circleStart;
        this.circleEnd = circleEnd;
    }

    public StringBuilder getBuilder() {
        return builder;
    }

    public void addDistance(double distance) {
        this.distance += distance;
    }

    public double getDistance() {
        return distance;
    }

    public List<Circle> getPreviousList() {
        return previousList;
    }

    public Circle getCircleStart() {
        return circleStart;
    }

    public static boolean hasCircle(Circle circle, List<Circle> list) {
        for (int i = 0; i < list.size(); i++) {
            if (circle.getY() == list.get(i).getY() && circle.getX() == list.get(i).getX()) {
                return true;
            }
        }

        return false;
    }

    public void findAllPaths() {

        Circle currentPosition = getCircleStart();

        if (currentPosition.equals(circleEnd)) {
            builder.append(currentPosition);
            System.out.print(builder.toString());
            System.out.println(", distance: " + distance);

            map.put(builder.toString(), distance);

        } else if (!currentPosition.hasConnection()) {
            System.out.println("Second condition");

        } else if (hasCircle(currentPosition, previousList)) {
            System.out.println("Third condition");

        } else {
            builder.append(currentPosition + " : ");
            for (int i = 0; i < currentPosition.getConnections().size(); i++) {

                previousList.add(currentPosition);

                Graph newStart = new Graph(currentPosition.getConnections().get(i), circleEnd);

                newStart.getBuilder().append(builder);

                newStart.getPreviousList().addAll(previousList);

                newStart.addDistance(distance + Array2D.calculateDistance(this.getCircleStart(), newStart.getCircleStart()));

                newStart.findAllPaths();
            }
        }
    }

    public String shortestPath() {

        findAllPaths();

        double lowestValue = -1;
        String lowestKey = "";
        for (Map.Entry<String, Double> entry : map.entrySet()) {

            if (lowestValue == -1) {
                lowestValue = entry.getValue();
                lowestKey = entry.getKey();
            } else if (entry.getValue() < lowestValue) {
                lowestValue = entry.getValue();
                lowestKey = entry.getKey();
            }
        }
        map.clear();
        return ("Key: " + lowestKey + "\n, Value: " + lowestValue);
    }

    public void findAllPathsFormatted() {

        Circle currentPosition = getCircleStart();

        if (currentPosition.equals(circleEnd)) {
            builder.append(Array2D.getListIndex(currentPosition));
            System.out.print(builder.toString());
            System.out.println(", distance: " + distance);

            map.put(builder.toString(), distance);

        } else if (!currentPosition.hasConnection()) {
            System.out.println("Second condition");

        } else if (hasCircle(currentPosition, previousList)) {
            System.out.println("Third condition");

        } else {
            builder.append(Array2D.getListIndex(currentPosition) + ">");

            for (int i = 0; i < currentPosition.getConnections().size(); i++) {
                previousList.add(currentPosition);

                Graph newStart = new Graph(currentPosition.getConnections().get(i), circleEnd);

                newStart.getBuilder().append(builder);

                newStart.getPreviousList().addAll(previousList);

                newStart.addDistance(distance + Array2D.calculateDistance(this.getCircleStart(), newStart.getCircleStart()));

                newStart.findAllPathsFormatted();
            }
        }
    }


    public String shortestPathFormatted() {

        findAllPathsFormatted();

        double lowestValue = -1;
        String lowestKey = "";
        for (Map.Entry<String, Double> entry : map.entrySet()) {

            if (lowestValue == -1) {
                lowestValue = entry.getValue();
                lowestKey = entry.getKey();

            } else if (entry.getValue() < lowestValue) {
                lowestValue = entry.getValue();
                lowestKey = entry.getKey();
            }
        }
        map.clear();
        return ("Key: " + lowestKey + "\nValue: " + lowestValue);
    }
}

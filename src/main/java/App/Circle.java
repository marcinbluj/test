package App;

import java.util.ArrayList;
import java.util.List;

public class Circle {
    protected int x;
    protected int y;
    protected int size;
    protected List<Circle> connections = new ArrayList<Circle>();
    protected Array2D array2D = new Array2D();

    public Circle(int x, int y) {
        this.x = x;
        this.y = y;
        this.size = 20;
        array2D.addCircle(this);
    }

    public Circle(Circle circle) {
        this.x = circle.getX();
        this.y = circle.getY();
        this.size = circle.getSize();
        this.connections = circle.getConnections();
        array2D.addCircle(this);
    }

    public Circle(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
        array2D.addCircle(this);
    }

    public Circle(int x, int y, int size, Circle... connection) {
        this.x = x;
        this.y = y;
        this.size = size;
        addConnections(connection);
        array2D.addCircle(this);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<Circle> getConnections() {
        return connections;
    }

    public void addConnections(Circle... connection) {

        for (int i = 0; i < connection.length; i++) {
            if (!(connection[i].equals(this))){
                if (!(connections.contains(connection[i]))){
                    connections.add(connection[i]);
                }
            }
        }
    }

    public int getConnectionsSize() {
        return connections.size();
    }

    public boolean hasConnection() {
        if (connections.size()>0) {
            return true;
        }
        return false;
    }

    public boolean hasConnectionWith(Circle circle) {
        if (connections.contains(circle)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return  ""+'('+x+','+y+')';
    }
}

package game;

import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Location;

import java.util.Random;

/**
 * A class that represents bare dirt.
 */
public class Dirt extends Ground {

    /**
     * constructor
     */
    public Dirt() {
        super('.');
    }

    /**
     * grow bush
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        super.tick(location);
        double chance;
        GameMap map = location.map();
        int X = location.x();
        int Y = location.y();
        int x1 = 0;
        int x2 = 0;
        int x3 = 0;
        int x4 = 0;
        if (X + 1 < 79) {
            x1 = X + 1;
        } else {
            x1 = X;
        }
        if (X - 1 >= 0) {
            x2 = X - 1;
        } else {
            x2 = X;
        }
        if (X + 2 < 79) {
            x3 = X + 2;
        } else {
            x3 = X;
        }
        if (X - 2 >= 0) {
            x4 = X - 2;
        } else {
            x4 = X;
        }

        int y1 = 0;
        int y2 = 0;
        int y3 = 0;
        int y4 = 0;

        if (Y + 1 < 24) {
            y1 = Y + 1;
        } else {
            y1 = Y;
        }
        if (Y - 1 >= 0) {
            y2 = Y - 1;
        } else {
            y2 = Y;
        }
        if (Y + 2 < 24) {
            y3 = Y + 2;
        } else {
            y3 = Y;
        }
        if (Y - 2 >= 0) {
            y4 = Y - 2;
        } else {
            y4 = Y;
        }
        boolean cond1 = (map.at(x1, Y).getDisplayChar() != '+' && (map.at(X, y1).getDisplayChar() != '+') &&
                (map.at(x2, Y).getDisplayChar() != '+') && (map.at(X, y2).getDisplayChar() != '+') &&
                (map.at(x1, y1).getDisplayChar() != '+') && (map.at(x2, y2).getDisplayChar() != '+') &&
                (map.at(x1, y2).getDisplayChar() != '+') && (map.at(x2, y1).getDisplayChar() != '+'));

        boolean cond2 = (map.at(x1, Y).getDisplayChar() != 't' && (map.at(X, y1).getDisplayChar() != 't') &&
                (map.at(x2, Y).getDisplayChar() != 't') && (map.at(X, y2).getDisplayChar() != 't') &&
                (map.at(x1, y1).getDisplayChar() != 't') && (map.at(x2, y2).getDisplayChar() != 't') &&
                (map.at(x1, y2).getDisplayChar() != 't') && (map.at(x2, y1).getDisplayChar() != 't'));

        if (map.at(X, Y).getDisplayChar() == '.') {
            if (cond1 && cond2) {
                chance = 0.01;
                if (Math.random() <= chance) {
                    map.at(X, Y).setGround(new Bush());
                }
            }
        }

        boolean cond3 = (map.at(x1, Y).getDisplayChar() == '^' && map.at(x3, Y).getDisplayChar() == '^'
                || map.at(X, y1).getDisplayChar() == '^' && map.at(X, y3).getDisplayChar() == '^'
                || map.at(x2, Y).getDisplayChar() == '^' && map.at(x4, Y).getDisplayChar() == '^'
                || map.at(X, y2).getDisplayChar() == '^' && map.at(X, y4).getDisplayChar() == '^');

        if (cond1 && cond2 && cond3) {
            chance = 0.10;
            if (Math.random() <= chance) {
                map.at(X, Y).setGround(new Bush());
            }
        }

    }
}









import java.util.*;

public class Entity{
    public final static int NORTH = 0;
    public final static int EAST = 1;
    public final static int SOUTH = 2;
    public final static int WEST = 3;
    public final static int NUM_DIRS = 4;
    public final static int[] DIRS = {NORTH,EAST,SOUTH,WEST};

    protected final int[] dirY = {-1,0,1,0};
    protected final int[] dirX = {0, 1, 0, -1};


    //Point Colors -- handy contests to use to make your code more readiable
    public final static char LAB_BLACK='k';
    public final static char LAB_BLUE='b';
    public final static char LAB_RED='r';
    public final static char LAB_YELLOW='y';
    public final static char LAB_ORANGE='o';
    public final static char LAB_PINK='p';
    public final static char LAB_MAGENTA='m';
    public final static char LAB_CYAN='c';
    public final static char LAB_GREEN='g';
    public final static char LAB_GRAY='e';


    //current direction facing
    protected int dir;

    //current point in grid
    protected GridPoint point;

    //current color label for the point
    protected char lab;

    //random instance
    protected Random rand;

    //City in which this entity lives so that it can update it's
    //location and get other information it might need (like the
    //location of other entitys) when making decisions.    
    protected City city;

    //boolean to set when this entity is non existent
    protected boolean notExist;

    //how wide the steps are
    protected int stepLen;
    // Entity constructor
    public Entity(int x, int y, City cty, Random rnd){
        //DEFAULT Constructor
        point = new GridPoint(x,y);
        city = cty;
        rand = rnd;
        lab = LAB_GRAY;
        dir = rand.nextInt(NUM_DIRS);
        notExist= false;
        stepLen=1;
    }
    // Method to check if the entity does exist still
    public boolean doesExist(){
        return notExist;
    }
    // Gets Y coordinate
    public int getY(){
        return point.y;
    }
    // Gets X coordinate
    public int getX(){
        return point.x;
    }
    // Sets X coordinate
    public void setX(int n){
        point.x = n;
    }
    // Sets Y coordinate
    public void setY(int n){
        point.y = n;
    }
    // Returns the gridPoint
    public GridPoint getGridPoint(){
        //returns a copy to preseve encapsulation
        return new GridPoint(point); 
    }
    // Sets the gridPoint coordinates
    public void setGridPoint(int x, int y){
        point.x = x;
        point.y = y;
    }
    // gets the Label of the entity
    public char getLab(){
        return lab;
    }
    // Sets the direction of the entity
    public void setDir(int dir){
        this.dir = dir;
    }
    // Gets the direction of the entity
    public int getDir(){
        return this.dir;
    }
     //compute the distance to another creature
    public int dist(Entity e){
        // Returns the distance to another entity
        return point.dist(e.getGridPoint());
    }
    //make a random turn
    public void randomTurn() {
        this.dir = rand.nextInt(4);
    }

    public void move(){} 
    public void takeAction(){}

    //To String so you can output a entity to the plotter
    public String toString() {
        //output in (x,y) format
        return ""+this.point.x+" "+this.point.y+" "+lab;
    }

}
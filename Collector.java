import java.util.Random;

public class Collector extends Entity {
    // Total amount of rounds it takes
    int roundCounter = 0;

    public Collector(int x, int y, City cty, Random rnd) {
        // Calls super constructor
        super(x, y, cty, rnd);
        // Sets the label of the collector to green
        this.lab = LAB_GREEN;
        // Set the direction to random
        this.dir = rand.nextInt(NUM_DIRS);
        stepLen = 1;
    }
    public void move(){
        // Roll the random number to determine if it turns
        Random rand = new Random();
        // Sets the chance of turning to 1 in 5
        int chance = rand.nextInt(5);
        // Turn needs to occur at a number, in this case 4
        if(chance == 4){
        // Rolls a random number to determine the turning direction
        int intDir = rand.nextInt(4);
        setDir(intDir);
        } 
        // Create new coordinates after step and use % to ensure it doesn't pass WIDTH and HEIGHT
        int newX = (super.getX() + (dirX[getDir()]) * stepLen) % City.WIDTH;
        int newY = (super.getY() + (dirY[getDir()]) * stepLen) % City.HEIGHT;
        
        // Check to make sure doesn't go below zero
        if(newX < 0){
            newX += City.WIDTH;
        }
        if(newY < 0){
            newY += City.HEIGHT;
        }
        // Set the new Location
        setGridPoint(newX, newY);
        // Increments the roundCounter
        roundCounter++;

    }
    public void takeAction(){
        // The closest entity is not nearby by default
        Entity closest = null;
        // For loop to check for nearest trash within 20
        for(Entity e : city.entities){
            // Checks if the label of the creature is blue and is within 20
            if(e.lab == LAB_GRAY && dist(e) <= 20 && (closest == null || dist(e) < dist(closest))){
                // Sets closest to e if true
                closest = e;
            }
        }
        // Checks if closest is null
        if(closest != null){
           // Changes label to cyan
           this.lab = LAB_BLUE;
           if(Math.abs(closest.getX() - getX()) < (Math.abs(closest.getY() - getY()))){
               // Checks if closest.y is greater than Collector's y
               if(closest.getY() > getY()){
                   // Sets direction to 2
                   setDir(2);
               } else {
                   // Sets direction to 0 otherwise
                   setDir(0);
               }
           } else {
               // Check if closest's x is greater than Collector's x
               if(closest.getX() > getX()){
                   // Sets direction to 1
                   setDir(1);
               } else {
                   // Sets direction to 3
                   setDir(3);
               }
           }
           collectTrash(closest);
        }
    
   }
   public void collectTrash(Entity e){
       // Checks if the collector is on top of the trash
       if(e.lab == LAB_GRAY && e.getX() == getX() && e.getY() == getY()){
           // removes the trash
           e.notExist = true;
       }
   }
}

import java.util.*;

public class City{


    //Determine the City Grid based on the size of the Plotter
    public static final int WIDTH = 80;
    public static final int HEIGHT = 80;

    
    // The Grid World for your reference
    //
    //        
    //       (x)
    //        0 1 2 3 4 5 ... WIDTH
    //       .----------------...
    //  (y) 0|           ,--y
    //      1|      * (3,1) 
    //      2|         ^    
    //      3|         '-x
    //      .|
    //      .|
    //      .|       
    //HEIGHT :
    //



    //-------------------------------------
    //The simulation's Data Structures
    //
    public List<Entity> entities; //list of all creatues
    public Queue<Entity> entitiesToAdd;

    //Random instance
    private Random rand;
    
    public City(Random rand, int numTrash, int numCollector) {
        this.rand = rand;

        this.entities = new LinkedList<Entity>();
        this.entitiesToAdd = new LinkedList<Entity>();
        
        for (int i=0; i<numTrash; i++){
            addTrash();
        }
        for (int i=0; i<numCollector; i++){
            addCollector();
        }
        addNewEntities();
      
    }


    //Return the current number of creatures in the simulation
    public int numEntities(){
        return entities.size();
    }
    
    public void addTrash(){
        entitiesToAdd.add(new Trash(rand.nextInt(HEIGHT),rand.nextInt(WIDTH),this,rand));
    }
    
    public void addCollector(){
        
        entitiesToAdd.add(new Collector(rand.nextInt(HEIGHT),rand.nextInt(WIDTH),this,rand));
    }
    
   
    //use this method to queue up a create to be added
    public void addNewEntities(){
        while(!entitiesToAdd.isEmpty()){
            entities.add(entitiesToAdd.remove());
        }
    }

    //You need to realize in your code such that simulate works for
    //**ALL** levels of simulation, which means you'll need to take
    //advantage of inheritance and polymorphism.
    public void simulate() {
        //DO NOT EDIT!
        
        //You get this one for free, but you need to review this to
        //understand how to implement your various creatures

        //First, for all entities ...
        for(Entity e : entities){
            // Only moves the entities with the green label
            if(e.lab == 'g'){
                // Moves the Collector entity
                e.move(); 
            }
            
        } //move every entity besides trash forward one step in simulation
        
        //Second, for all entities ...
        for(Entity e : entities){
            if(e.lab == 'g'){
                e.takeAction(); 
            }
        }//take some action based on the new positions

        //Third, for all creatures ...
        LinkedList<Entity> nonEntities = new LinkedList<Entity>();
        for(Entity e: entities){
          if(e.doesExist()){ 
            nonEntities.add(e);
          }
        }//find those that don't exist after the action is taken

        //Four, for all entities ...
        for(Entity e: nonEntities){
            entities.remove(e);
        }//remove any entities that don't exist
        
        //Five, add in any new entities that have been added before ...
        addNewEntities();

        //Five, for all entities
        for(Entity e : entities){
            System.out.println(e);
        }//print out all entities

    }
}
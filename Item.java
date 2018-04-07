import java.util.*;
/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class models string representation of an item(s) which can be found in a room.
 * depending on the room, this class models a string description and returns it in some methods.
 *
 * @author Gabriele Sarwar
 * @version 1 october 20th, 2017
 */
public class Item
{
   
   
    private String description;
    private double weight;
    private String name;
    

    /**
     * Constructor for objects of class Item
     */
    public Item(String name, String description, double weight)
    {
        //initialize fields to the given parameters
        this.description = description; 
        this.weight = weight;
        this.name = name; 
        
    }
    /**
     * this method gives a string representation of an item (description/weight).
     * @return the String representation of the item, with weight of item.
     */
    public String representationOfItem()
    {
        String n = "";
        n = "one items description is: " + description + ", and it has a weight of " +
        weight + " pounds. ";
        
        return n;
    }
   
    public String simplerepresentationOfItem()
    {
        String n = "";
        n = name;
        return n;
    } 

}

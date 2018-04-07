import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;
import java.util.*;
/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 * 
 * @author Lynn Marshall
 * @version October 21, 2012
 * 
 * @author Gabriele Sarwar
 * @version 1 October 21, 2017
 */

public class Room 
{
    private String description;
    protected HashMap<String, Room> exits;        // stores exits of this room.
    private ArrayList<Item> items; //Roos may have any number of items 
    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * 
     * @param description The room's description.
     */
    public Room(String description) 
    {

        this.description = description;
        exits = new HashMap<String, Room>();
        items = new ArrayList<Item>(); //initalize arraylist of items
    }

    /**
     * Define an exit from this room.
     * 
     * @param direction The direction of the exit
     * @param neighbour The room to which the exit leads
     */
    public void setExit(String direction, Room neighbour) 
    {
        exits.put(direction, neighbour);
    }

    /**
     * Returns a short description of the room, i.e. the one that
     * was defined in the constructor
     * 
     * @return The short description of the room
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Return a long description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     *     
     * @return A long description of this room
     */
    public String getLongDescription()
    {
        String n = "You are " + description +
        ". There may be item(s) in this room! if so, here are the description(s)";
        
        for(Item item:items){
            //for each item in the room, give representation
            n += "\n " + item.representationOfItem() ;
        }
        
        n += "\n" + getExitString();

        return n;
    }
    public String getItem()
    {
        String n = "";
        
        for(Item item:items){
            //for each item in the room, give representation
            n += item.simplerepresentationOfItem() ;
        }
        
        return n;
    }
    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * 
     * @return Details of the room's exits
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * 
     * @param direction The exit's direction
     * @return The room in the given direction
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction); //the room in the direction typed
    }
    /**
     * add items to the array list of items
     */
    public void addItem(Item item){
        items.add(item); //add item to arraylist
    }
}


import java.util.ArrayList;
import java.util.Scanner;
import java.util.Hashtable;
import java.util.Map;

public class Item {

    static class NoItemException extends Exception {}

    private String primaryName;
    private int weight;
    private Hashtable<String,String> messages;
    private Map<String, ArrayList<String>> events;

    /**
     * Reads through a file and creates the Items that are laid out in the file.
     * @param s Scanner object used to read through file
     * @throws Item.NoItemException once the Scanner reaches the end of the Item section, Item creation is complete
     * @throws Dungeon.IllegalDungeonFormatException if the file is not in the valid format for Dungeon creation, including Item creation
     */
    Item(Scanner s) throws NoItemException,
            Dungeon.IllegalDungeonFormatException {

        messages = new Hashtable<String,String>();

        // Read item name.
        primaryName = s.nextLine();
        if (primaryName.equals(Dungeon.TOP_LEVEL_DELIM)) {
            throw new NoItemException();
        }

        // Read item weight.
        weight = Integer.valueOf(s.nextLine());

        // Read and parse verbs lines, as long as there are more.
        String verbLine = s.nextLine();
        while (!verbLine.equals(Dungeon.SECOND_LEVEL_DELIM)) {
            if (verbLine.equals(Dungeon.TOP_LEVEL_DELIM)) {
                throw new Dungeon.IllegalDungeonFormatException("No '" +
                        Dungeon.SECOND_LEVEL_DELIM + "' after item.");
            }
            String[] verbParts = verbLine.split(":");
            //start looking for events
            if(verbParts[0].contains("["))//if there is an event
            {
                String[] eventParts = verbParts[0].split("[");
                if(eventParts[1].contains(","))//if there are two events
                {
                    String[] events = eventParts[1].split(",");
                    ArrayList<String> events2 = new ArrayList<String>();
                    events2.add(events[0]);
                    String secondEvent = events[1];
                    secondEvent = secondEvent.substring(0, secondEvent.length()-1);
                    events2.add(secondEvent);
                    this.events.put(verbParts[0], events2);
                    
                }
                else//single event
                {
                    String event = eventParts[1];
                    event = event.substring(0, event.length()-1);
                    ArrayList<String> events2 = new ArrayList<String>();
                    events2.add(event);
                    this.events.put(verbParts[0], events2);
                }
            }
            //end of events
            messages.put(verbParts[0],verbParts[1]);

            verbLine = s.nextLine();
        }
    }

    /**
     * Returns if the entered nickname is equal to the this Item's primary name.
     * May be altered in the future to allow for actual nicknames.
     * @param name possible nickname 
     * @return true or false
     */
    boolean goesBy(String name) {
        // could have other aliases
        return this.primaryName.equals(name);
    }
    
    /**
     * Returns this Item's primary name
     * @return primary name
     */
    String getPrimaryName() { return primaryName; }

    /**
     * Returns the appropriate response to an action being done to this Item.
     * @param verb action that is being attempted on this Item
     * @return the message that describes what happens when specified action(verb) is done on this Item
     */
    public String getMessageForVerb(String verb) {
        return messages.get(verb);
    }

    /**
     * Returns a String describing Item.
     * @return primary name 
     */
    public String toString() {
        return primaryName;
    }
}

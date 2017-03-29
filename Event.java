
/**
 * Created by Michael Timpson on 11/8/16.
 * @author Michael
 * @return
 */
class Event {
    
    int num;
    Item item;
    boolean bol;

    /**
     *
     * @param num
     * Construtor for event class
     */
    Event(int num) {
        this.num = num;
    }

    /**
     *
     * @param item
     * Constructor for event class
     */
    Event(Item item) {
        this.item = item;
    }

    /**
     *
     * @param bol
     * Constructor for event class
     */
    Event(Boolean bol) {
        this.bol = bol;
    }

    /**
     *
     * @param score
     * @return
     *
     */
    int score(int score) {
        GameState.addScore(score);
        return GameState.getScore();
    }

    /**
     *
     * @param health
     * @return
     */
    int wound(int health) {
        GameState.addHealth(health);
        return GameState.getHealth();
    }

    /**
     *
     * @param death
     * @return
     */
    String die(boolean death) {
         if(death==true)
         {
             return "You have died...";
         }
         return null;//this should never be returned if this method is working properly
    }

    /**
     *
     * @param win
     * @return
     */
    String win(boolean win) {
        if(win == true)
        {
            return "Congratulations, you won!";
        }
        return null;//should never return null
    }

    /**
     *
     * @param item
     */
    void disappear(Item item) {
        GameState.removeFromInventory(item);
    }

    /**
     *
     * @param item
     * @return
     */
    Item transform(Item item, Item item2) {
        item = item2;
        return item;
    }

    /**
     *
     * @return
     */
    Room teleport() {
        return Dungeon.getRoom("entry");
    }

}
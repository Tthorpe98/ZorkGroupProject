/**
 * Contains Constructors and Methods for Objects of type Combat
 *
 * @author(Collin Mason)
 * @version(11/9/2016)
 */

class Combat{
   /**
    * Construct Combat Objects
    * @param pc, defines the status of the Player Object at the start of Combat
    * @param enemy, defines the NPC Object at the start of Combat
    */
   Combat(Player pc, NPC enemy){}

   /**
    * @param enemy, identifies the NPC Object that will be hit
    * @return, returns the deamage dealt to the enemy to the caller
    */
   int playerAttack(NPC enemy){return;}

   /**
    * @param pc, identifies the Player Object that will be hit
    * @return, returns the damage dealt to the player to the caller
    */
   private int enemyAttack(Player pc){return;}

   /**
    * @param invitem, identifies the Item Object that the player is using in Combat
    * @return, returns the numerical effect of the item (i.e. could heal you or hurt the enemy) to the caller
    */
   int playerUseItem(Item invitem){return;}

   /**
    * @param randact, has a random value used to determine the NPC Object's action in its turn
    * @return, returns a String representation of the NPC Object's turn to the caller
    */
   String enemyTurn(Random randact){return;}
}


class ItemSpecificCommand extends Command {

    private String verb;
    private String noun;

    ItemSpecificCommand(String verb, String noun) {
        this.verb = verb;
        this.noun = noun;
    }

    public String execute() {

        Item itemReferredTo = null;
        try {
            itemReferredTo = GameState.instance().getItemInVicinityNamed(noun);
        } catch (Item.NoItemException e) {
            return "There's no " + noun + " here.";
        }

        String msg = itemReferredTo.getMessageForVerb(verb);

        if (itemReferredTo.getEventsForVerb(verb) != null)//if there IS at least one event for this verb
        {
            String firstEvent = itemReferredTo.getEventsForVerb(verb).get(0);
            String firstThreeLetters = firstEvent.substring(0, 3);
            //7-tier if-else statement
            if (firstThreeLetters.equals("Die")) {
                Event.die(true);
            } else if (firstThreeLetters.equals("Win")) {
                Event.win(true);
            } else if (firstThreeLetters.equals("Dis")) {
                Event.disappear(itemReferredTo);
            } else if (firstThreeLetters.equals("Tra")) {
                
            }

            //call the method
            //do the same thing for the second event(if there is one)
        }

        return (msg == null
                ? "Sorry, you can't " + verb + " the " + noun + "." : msg) + "\n";

    }
}

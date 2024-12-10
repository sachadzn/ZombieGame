package Action;

/**
 * The SkipTurn class represents an action to skip a turn.
 * It implements the Action interface.
 */
public class SkipTurn implements Action {
	
    /**
     * Perform the action of skipping a turn.
     */
	public void Do() {
		System.out.println("You have skipped your turn!");
	}
	
    /**
     * Get a string representation of the action.
     *
     * @return A string representation of the action.
     */
	public String toString() {
		return "Skip your turn?";
	} 
}

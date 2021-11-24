import java.util.HashMap;

import moduloAGame.*;

public class Board {
	private Mediator gameMediator;
	private HashMap<POOmonY, String> poomons = new HashMap<>();
	
	public void putPOOmons(POOmonY poomon) {
		this.poomons.put(poomon, poomon.getName());
	}
	
	
}

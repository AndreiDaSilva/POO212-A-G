package moduloAG;
import java.awt.Image;

import javax.imageio.ImageIO;
import moduloAGame.Env;

public class POOmonT extends POOmonY {
	private final Env envorinment = Env.GROUND;
	
	public POOmonT() {
		super("Gerson, só Gerson mesmo", 
			  "Gerson era um POOmon comum, chamado gerson, até que um dia, gerson não fez nada, pois ele era só gerson.",
			  500);
	}
	
	public Env getEnvironment() {
		return this.envorinment;
	}

	
}

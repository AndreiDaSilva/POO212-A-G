package moduloAG;
import java.awt.Image;

import javax.imageio.ImageIO;
import moduloAGame.Env;

public class POOmonT extends POOmonY {
	private final Env envorinment = Env.GROUND;
	
	public POOmonT() {
		super("Gerson, s� Gerson mesmo", 
			  "Gerson era um POOmon comum, chamado gerson, at� que um dia, gerson n�o fez nada, pois ele era s� gerson.",
			  500);
	}
	
	public Env getEnvironment() {
		return this.envorinment;
	}

	
}

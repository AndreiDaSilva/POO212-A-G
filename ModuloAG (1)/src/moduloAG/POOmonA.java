package moduloAG;
import javax.imageio.ImageIO;
import moduloAGame.Env;

public class POOmonA extends POOmonY{
	private final Env envorinment = Env.AIR;

	public POOmonA () {
		super("Grossomon",
				"Comumente ele é grosso e é encontrado em todas as familias brasileiras. Se você fizer uma pergunta besta por acidente, é movito de gatilho e ele ficará com raiva.",
				500);
	}
	
	public Env getEnvironment() {
		return this.envorinment;
	}
	
		
}

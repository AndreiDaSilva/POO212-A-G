package moduloAG;
import javax.imageio.ImageIO;
import moduloAGame.Env;

public class POOmonA extends POOmonY{
	private final Env envorinment = Env.AIR;

	public POOmonA () {
		super("Grossomon",
				"Comumente ele � grosso e � encontrado em todas as familias brasileiras. Se voc� fizer uma pergunta besta por acidente, � movito de gatilho e ele ficar� com raiva.",
				500);
	}
	
	public Env getEnvironment() {
		return this.envorinment;
	}
	
		
}

package moduloAG;
import javax.imageio.ImageIO;
import moduloAGame.Env;

public class POOmonH extends POOmonY{
	private final Env envorinment = Env.WATER;
	
	public POOmonH() {
		super("Gosnaldomon",
			  "Pai de familia, divorciado, três filhos,entrou na richa de animais para ganhar algum sustentopois sua mulher tem cancêr, e cansou de trabalhar como desentortador devidro, apesar de sua principal habilidade é de ser pedreiro de lego. (Atualmente casado com Paulo-Guinamon)",
			   500);
	}
	
	public Env getEnvironment() {
		return this.envorinment;
	}
		
}

package moduloAG;
import java.awt.Image;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;
import moduloAGame.Env;

public class POOmonT extends POOmonY {

	public POOmonT() {
		super("Gerson", 
			  "Gerson era um POOmon comum, chamado gerson, até que um dia, gerson não fez nada, pois ele era só gerson.",
			  500, Env.GROUND);
	
		try {
			FileWriter fw = new FileWriter("logs/"+getName() + "logPOOmon.txt");
            BufferedWriter writer = new BufferedWriter(fw);
            writer.write("Log de Batalha "+"\nPOOmon: "+getName()+" - "+getEnvironment());
            writer.close();
        } catch (IOException ieo) {
			ieo.printStackTrace();
        }
	}
}

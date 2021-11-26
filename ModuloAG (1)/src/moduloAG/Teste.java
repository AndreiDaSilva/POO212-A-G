package moduloAG;

import java.awt.Image;
import java.awt.Toolkit;

public class Teste {
		private static Image image;
	public static void main(String[] args) {
		String minhaImage = "C:\\Users\\leo_n\\eclipse-workspace\\ModuloAG\\Imagens\\Gerson\\Gerson_Cansado.png";
		Toolkit toolkit = Toolkit.getDefaultToolkit();
	    image = toolkit.getImage(minhaImage);
	}
}

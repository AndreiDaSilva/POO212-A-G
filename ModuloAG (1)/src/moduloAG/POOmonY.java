package moduloAG;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.time.LocalDateTime;
import javax.imageio.ImageIO;
import moduloAGame.*;

public abstract class POOmonY implements POOmonBehavior {
	private String name;
	private String history;
	private Image image;
	private int energy;
	private int highestEnergy;
	private LocalDateTime highestEnergyTime;
	private int wins = 0;
	private int activations = 0;
	private Mediator mediator;
	
	public POOmonY(String name, String history, int energy) {
		setName(name);
		setHistory(history);
		setEnergy(energy);
	}
	
	public void attack(POOmonBehavior arg0, Env arg1) {
		//Estamos pensando na estratégia
	}
	
	public void takeDamage(int arg0, Env arg1) {
		
	}
	
	public void increaseActivations() {
		this.activations++;	
	}
	
	public int getActivations() {
		return this.activations;
	}

	public Env getEnvironment() {
		return null;
	}
	
	public boolean isAlive() {
		if (getEnergy() <= 0) {
			return false;
		}
		return true;
	}

	public void restoreEnergy(int arg0) {
		int energy = getEnergy();
		energy += arg0;
		setEnergy(energy); 
	}
	
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public int getHighestEnergy() {
		return highestEnergy;
	}

	public void setHighestEnergy(int highestEnergy) {
		this.highestEnergy = highestEnergy;
	}

	public LocalDateTime getHighestEnergyTime() {
		return highestEnergyTime;
	}

	public void setHighestEnergyTime(LocalDateTime highestEnergyTime) {
		this.highestEnergyTime = highestEnergyTime;
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}
	
	public void addWin() {
		this.wins += 1;
	}
	
	public void setMediator(Mediator arg0) {
		this.mediator = arg0;
	}
	
	public Image getImage() {
		String minhaImage = "C:\\Users\\leo_n\\eclipse-workspace\\ModuloAG\\Imagens\\Gerson\\Gerson_Cansado.png";
		Toolkit toolkit = Toolkit.getDefaultToolkit();
	    this.image = toolkit.getImage(minhaImage);
		return image;
	}

	public void loser() {
		
	}

	public void winner() {
		
	}
}

package moduloAG;
import java.awt.Image;
import java.nio.file.Path;
import java.time.LocalDateTime;
import moduloAGame.*;
import java.util.Random;

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
	private static Env env;
	
	public POOmonY(String name, String history, int energy, Env env) {
		setName(name);
		setHistory(history);
		setEnergy(energy);
	}
	
	//Tem que mandar para o log.
	public void attack(POOmonBehavior arg0, Env arg1) {
		Random typeOfAttack = new Random();
		int damage = 0;
		int currentEnergy = getEnergy();
		do {
			switch(typeOfAttack.nextInt(3)) {
				case 0 :
					// basico
					if (getEnvironment().equals(arg1)) {
						damage = 36;
					} else {
						damage = 30;
					}
					break;
				case 1:
					//agressivo
					if (getEnergy() > 39) {
						for(int i = 99; i >= 40; i--) {
							if (getEnergy() > i) {
								if (getEnvironment().equals(arg1)) {
									damage = i + ((i * 20) / 100);
									setEnergy(currentEnergy -= i);
								} else {
									damage = i;
									setEnergy(currentEnergy -= i);
								}
								break;
							}
						}
					}
					break;
				case 2:
					//cruel
					if (getEnergy() > 199) {
						for(int i = 200; i >= 100; i--) {
							if (getEnergy() == (i*2)) {
								if (getEnvironment().equals(arg1)) {
									damage = i + ((i * 70) / 100);
									currentEnergy = getEnergy();
									setEnergy(currentEnergy -= i);
								} else {
									damage = i + ((i * 50) / 100);
									setEnergy(currentEnergy -= i);
								}
								break;
							}
						}
					}
					break;
			} 
		} while (damage == 0);
		arg0.takeDamage(damage, arg1);
	}
	
	public void takeDamage(int arg0, Env arg1) {
		int currentEnergy = getEnergy();
		if (getEnvironment().equals(arg1)) {
			currentEnergy -= arg0 - ((arg0 * 10) / 100);
			setEnergy(currentEnergy);
		} else {
			currentEnergy -= arg0;
			setEnergy(currentEnergy);
		}
	}
	
	public void increaseActivations() {
		this.activations++;	
	}
	
	public int getActivations() {
		return this.activations;
	}

	public void setEnv(Env env) {
		this.env = env;
	}

	public Env getEnvironment() {
		return this.env;
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
		return this.history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	//À fazer
	public void setImage(Image image) {
		this.image = image;
	}

	public int getEnergy() {
		return this.energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public int getHighestEnergy() {
		return this.highestEnergy;
	}

	public void setHighestEnergy(int highestEnergy) {
		if (getHighestEnergy() < highestEnergy) {
			this.highestEnergy = highestEnergy;
			setHighestEnergyTime(LocalDateTime.now());
		}	
	}

	public LocalDateTime getHighestEnergyTime() {
		return this.highestEnergyTime;
	}

	public void setHighestEnergyTime(LocalDateTime highestEnergyTime) {
		this.highestEnergyTime = highestEnergyTime;
	}

	public int getWins() {
		return this.wins;
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
	
	//À fazer.
	public Image getImage() {
		return image;
	}

	//Imaginar o que fazer, mas referente ao log
	public void loser() {
		
	}

	//Imaginar o que fazer, mas referente ao log
	public void winner() {
		
	}
}
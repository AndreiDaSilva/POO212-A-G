package moduloAG;
import java.util.Random;

public class Atacar {
	private int energy;
	private int env;
	private int envPOO;
	private Random tipoDeAtaque;
	
	public int attack() {
		this.tipoDeAtaque = new Random();
		int damage = 0;
		int currentEnergy = getEnergy();
		do {
			switch(tipoDeAtaque.nextInt(3)) {
				case 0 :
					// basico
					if (getEnv() == getEnvPOO()) {
						damage = 36;
					} else {
						damage = 30;
					}
					break;
				case 1:
					//agressivo
					if (this.energy > 39) {
						for(int i = 99; i >= 40; i--) {
							if (this.energy > i) {
								if (getEnv() == getEnvPOO()) {
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
					if (this.energy > 199) {
						for(int i = 200; i >= 100; i--) {
							if (this.energy == (i*2)) {
								if (getEnv() == getEnvPOO()) {
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
		return damage;
	}
	
	public void setEnergy(int life) {
		this.energy = life;
	}
	
	public void setPOOmonEnv(int envPOO) {
		this.envPOO = envPOO;
	}
	
	public void setEnv(int env) {
		this.env = env;
	}
	
	public int getEnvPOO() {
		return this.envPOO;
	}
	
	public int getEnv() {
		return this.env;
	}
	
	public int getEnergy() {
		return this.energy;
	}
}

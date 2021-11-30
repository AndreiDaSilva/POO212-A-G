package moduloAG;

import java.awt.Image;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import moduloAGame.*;
import java.util.Random;

import javax.imageio.ImageIO;

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
	private POOmonBehavior oponenteAtual;

	public POOmonY(String name, String history, int energy, Env env) {
		setName(name);
		setHistory(history);
		setEnergy(energy);
	}

	public void attack(POOmonBehavior arg0, Env arg1) {
		if(arg0 != this.oponenteAtual) {
			setOponente(arg0);
		}
		Random typeOfAttack = new Random();
		int damage = 0;
		int envBost = 0;
		int currentEnergy = getEnergy();
		String typeAttack = null;
		int energySpent = 0;
		do {
			switch (typeOfAttack.nextInt(3)) {
				case 0:
					typeAttack = "Basico";
					if (getEnvironment().equals(arg1)) {
						damage = 36;
					} else {
						damage = 30;
					}
					break;
				case 1:
					typeAttack = "Agressivo";
					if (getEnergy() > 39) {
						for (int i = 99; i >= 40; i--) {
							if (getEnergy() > i) {
								if (getEnvironment().equals(arg1)) {
									envBost = ((i * 20) / 100);
									damage = i;
									energySpent = currentEnergy -= i;
									this.energy = currentEnergy -= i;
								} else {
									damage = i;
									energySpent = currentEnergy -= i;
									this.energy = currentEnergy -= i;
								}
								break;
							}
						}
					}
					break;
				case 2:
					typeAttack = "Cruel";
					if (getEnergy() > 199) {
						for (int i = 200; i >= 100; i--) {
							if (getEnergy() == (i * 2)) {
								if (getEnvironment().equals(arg1)) {
									envBost = ((i * 20) / 100);
									damage = i + ((i * 50) / 100);
									currentEnergy = getEnergy();
									energySpent = currentEnergy -= i;
									this.energy = currentEnergy -= i;
								} else {
									damage = i + ((i * 50) / 100);
									energySpent = currentEnergy -= i;
									this.energy = currentEnergy -= i;
								}
								break;
							}
						}
					}
					break;
			}
		} while (damage == 0);
		arg0.takeDamage((damage + envBost), arg1);
		if (this.oponenteAtual != arg0) {
			try {
				FileWriter fw = new FileWriter("logs/" + getName() + "logPOOmon.txt");
				BufferedWriter writer = new BufferedWriter(fw);
				writer.write("Oponente: " + arg0.getName() + " - " + arg0.getEnvironment());
				writer.close();
			} catch (IOException ieo) {
				ieo.printStackTrace();
			}
		}
		try {
			FileWriter fw = new FileWriter("logs/" + getName() + "logPOOmon.txt");
			BufferedWriter writer = new BufferedWriter(fw);
			writer.write("Ataque Efetuado: " + typeAttack + " " + damage + " (" + (damage + envBost) + ") - "
					+ arg1 + "(-" + energySpent + ")");
			writer.close();
		} catch (IOException ieo) {
			ieo.printStackTrace();
		}
	}

	public void setOponente(POOmonBehavior oponente) {
		this.oponenteAtual = oponente;
	}

	public void takeDamage(int arg0, Env arg1) {
		int currentEnergy = getEnergy();
		int envDefense = 0;
		if (getEnvironment().equals(arg1)) {
			envDefense = (arg0 * 10) / 100;
			currentEnergy -= arg0 - ((arg0 * 10) / 100);
		} else {
			currentEnergy -= arg0;
		}
		try {
			FileWriter fw = new FileWriter("logs/" + getName() + "logPOOmon.txt");
			BufferedWriter writer = new BufferedWriter(fw);
			writer.write("Ataque Recebido: " + arg0 + " - " + arg1 + "(-" + (arg0 - envDefense) + ")");
			writer.close();
		} catch (IOException ieo) {
			ieo.printStackTrace();
		}
		setImage();
		this.energy = currentEnergy + envDefense;
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
		try {
			FileWriter fw = new FileWriter("logs/" + getName() + "logPOOmon.txt");
			BufferedWriter writer = new BufferedWriter(fw);
			writer.write("Energia recebida: "+arg0);
			writer.close();
		} catch (IOException ieo) {
			ieo.printStackTrace();
		}
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

	public void setImage() {
		Image image;
		try {
			if (getEnergy() > 350) {
				image = ImageIO.read(getClass().getResource("images/" + getName() + "_Saudavel.png"));
			} else if (getEnergy() > 150) {
				image = ImageIO.read(getClass().getResource("images/" + getName() + "_Cansado.png"));	
			} else if (getEnergy() > 1) {
				image = ImageIO.read(getClass().getResource("images/" + getName() + "_Exausto.png"));
			} else {
				image = ImageIO.read(getClass().getResource("images/" + getName() + "_Morto.png"));
			}
			this.image = image;
		} catch (IOException io) {
			io.printStackTrace();
		}
	}

	public int getEnergy() {
		return this.energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		try {
			FileWriter fw = new FileWriter("logs/" + getName() + "logPOOmon.txt");
			BufferedWriter writer = new BufferedWriter(fw);
			writer.write("Minha energia vital: " + this.energy + " - "
					+ LocalDate.parse(LocalDate.now().toString(), formatter)
					+ " - " + LocalDateTime.parse(LocalDateTime.now().toString(), timeFormatter));
			writer.close();
		} catch (IOException ieo) {
			ieo.printStackTrace();
		}
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

	public Image getImage() {
		return this.image;
	}

	public void loser() {
		try {
			FileWriter fw = new FileWriter("logs/" + getName() + "logPOOmon.txt");
			BufferedWriter writer = new BufferedWriter(fw);
			writer.write(getName() + " Foi Derrotado");
			writer.close();
		} catch (IOException ieo) {
			ieo.printStackTrace();
		}
	}

	public void winner() {
		addWin();
		try {
			FileWriter fw = new FileWriter("logs/" + getName() + "logPOOmon.txt");
			BufferedWriter writer = new BufferedWriter(fw);
			writer.write("Vitória");
			writer.close();
		} catch (IOException ieo) {
			ieo.printStackTrace();
		}
		restoreEnergy(500);
	}
}
import java.time.LocalDateTime;

import javax.imageio.ImageIO;

import moduloAGame.Env;
import moduloAGame.Mediator;
import moduloAGame.POOmonBehavior;

public class POOmonA extends POOmonY{
	
		public POOmonA(String name, String history) {
		super(name, history);
	}

		@Override
		public void attack(POOmonBehavior arg0, Env arg1) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public int getActivations() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int getEnergy() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public Env getEnvironment() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getHighestEnergy() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public LocalDateTime getHighestEnergyTime() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ImageIO getImage() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getWins() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public boolean isAlive() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void restoreEnergy(int arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setMediator(Mediator arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void takeDamage(int arg0, Env arg1) {
			// TODO Auto-generated method stub
			
		}
}

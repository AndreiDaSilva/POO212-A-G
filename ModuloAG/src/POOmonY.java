import moduloAGame.*;

public abstract class POOmonY implements POOmonBehavior{
	private String name;
	private String history;
	private int energy = 500; 
	
	public POOmonY(String name, String history) {
		setName(name);
		setHistory(history);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setHistory(String history) {
		this.history = history;
		
	}
	
	@Override
	public String getHistory() {
		return this.history;
	}
	
	
	
}

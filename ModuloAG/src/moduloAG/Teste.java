
public class Teste {
	public static void main(String[] args) {
		//teste 1
		
			Atacar testeAtaque = new Atacar();
			testeAtaque.setPOOmonEnv(1);
			testeAtaque.setEnergy(39);
			testeAtaque.setEnv(0);
			System.out.println("Ataque");
			System.out.println(testeAtaque.attack());
			System.out.println("Vida");
			System.out.println(testeAtaque.getEnergy());
		
		//teste 2
		
			Atacar testeAtaque1 = new Atacar();
			testeAtaque1.setPOOmonEnv(1);
			testeAtaque1.setEnergy(500);
			testeAtaque1.setEnv(0);
			System.out.println("Ataque");
			System.out.println(testeAtaque1.attack());
			System.out.println("Vida");
			System.out.println(testeAtaque1.getEnergy());
		 
		//teste 3
		
			Atacar testeAtaque2 = new Atacar();
			testeAtaque2.setPOOmonEnv(1);
			testeAtaque2.setEnergy(200);
			testeAtaque2.setEnv(1);
			System.out.println("Ataque");
			System.out.println(testeAtaque2.attack());
			System.out.println("Vida");
			System.out.println(testeAtaque2.getEnergy());
		
		//teste 4
		
			Atacar testeAtaque3 = new Atacar();
			testeAtaque3.setPOOmonEnv(1);
			testeAtaque3.setEnergy(53);
			testeAtaque3.setEnv(1);
			System.out.println("Ataque");
			System.out.println(testeAtaque3.attack());
			System.out.println("Vida");
			System.out.println(testeAtaque3.getEnergy());
			
	}
}

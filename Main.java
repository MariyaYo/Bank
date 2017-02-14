import java.util.ArrayList;
import java.util.Random;

public class Main {
	public static void main(String[] args) {
		
		String[] names={"Pesho", "Petur", "Georgi", "Viktor", "Petko", "Petq", "Mariq", "Martina", "Drgomir", "Ceco"}; 
		double[] money = {1000,900,800,890,980,790,900,810,840,1500};
		double[] salary = {600,650,700,750,800,850,900,950,1000,1050};
		
		Bank bank = new Bank("MyBank", "Mladost2", 0);
		ArrayList<Client> clients = new ArrayList<>();
		for(int i = 0; i<= 9; i++){
			clients.add(new Client(names[i], "Pernik", money[i], salary[i]));
		}
		Random rn = new Random();
		for (Client a : clients) {
			int x = rn.nextInt(20)+80;
			a.makeAnDeposit(a.getMoney()/100*x);
			bank.acceptDeposit(a.getDeposits().get(0));
		}
			
		System.out.println(Math.round(bank.getMoney()));
		
		for(Client a : clients){
			double amount = rn.nextInt(10)*100;
			int months = rn.nextInt(6)+6;
			Credit credit = a.askForCredit(amount, months);
			if(bank.acceptCredit(credit)){
				a.addCredit(credit);
			}
			
		}
		for(Client a: clients){
			System.out.println(a.toString());
			System.out.println(a.getDeposits().toString());
			System.out.println(a.getCredits().toString());
			System.out.println();
			System.out.println();
		}
		
	}
}

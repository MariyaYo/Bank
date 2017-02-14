
public class ShortDeposit extends Deposit{ 
	
	ShortDeposit(String depositName, double money, Client client) {
		super(depositName, money, 3, 3, client);
	}
}

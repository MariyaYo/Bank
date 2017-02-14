
public class ConsumerCredit  extends Credit{
	
	ConsumerCredit (String creditName, double money, int months, Client client) {
		super(creditName, money, months, 10, client);
	}
}
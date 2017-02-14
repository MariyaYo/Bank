import java.util.ArrayList;

public class Bank {

	private String name;
	private String adress;
	private ArrayList<Products> products;
	private double money;

	Bank(String name, String adress, double money) {
		this.name = name;
		this.adress = adress;
		this.money = money;
		products = new ArrayList<>();
	}

	void acceptDeposit(Deposit a) {
		this.money += a.getMoney();
		products.add(a);
	}

	void payDepositLihvi(Deposit a) {// this name is the best name ever
		if (a.getDuration() > 0) {
			a.setMoney(a.amountTOPay());
			a.setDuration(a.getDuration()-1);
		} else {
			a.getClient().setMoney(a.getMoney());
			a = null;

		}
	}

	boolean acceptCredit(Credit a) {
		if (this.checkMyMoney(a.getMoney()) && a.getClient().getSalary() / 2 > a.getMoney()) {
			products.add(a);
			return true;
		}
		return false;

	}

	public boolean checkMyMoney(double money) {
		double moneyToCompareTo = 0;
		for (Products a : products) {
			if (a instanceof Deposit) {
				Deposit b = (Deposit) a;
				moneyToCompareTo += b.getMoney();
			}
		}
		if (this.money > moneyToCompareTo / 10) {
			return true;
		}
		return false;
	}

	public double getMoney() {
		return money;
	}
	
}


public class Deposit implements Products {

		private String name;
		private double lihva;
		private int duration;
		private double amountToPayToClient;
		private double money;
		private Client client;

		Deposit(String depositName, double money, int months, double lihva, Client client) {
			this.name = depositName;
			this.money = money;
			this.duration = months;
			this.lihva = lihva;
			this.client = client;
			this.amountToPayToClient = (this.money * lihva) - this.money;
		}

		double amountTOPay() {
			this.amountToPayToClient = (this.money * lihva) - this.money;
			return amountToPayToClient;
		}

		public double getMoney() {
			return money;
		}

		public void setMoney(double money) {
			this.money = money;
		}

		public int getDuration() {
			return duration;
		}

		public void setDuration(int duration) {
			this.duration = duration;
		}

		public Client getClient() {
			return client;
		}

		@Override
		public String toString() {
			return "Deposit with lihva: " + lihva + "% , duration:" + duration + ", Amount receved from lihvi:"
					+ Math.round(amountToPayToClient) + ", Invested money:" + Math.round(money) +  "]";
		}

	}

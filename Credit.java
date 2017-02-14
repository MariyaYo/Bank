public class Credit implements Products {

		private String name;
		private double lihva;
		private int duration;
		private double amountToPayBack;
		private double money;
		private Client client;

		Credit(String creditName, double money, int months, double lihva, Client client) {
			this.name = creditName;
			this.money = money;
			this.duration = months;
			this.lihva = lihva;
			this.amountToPayBack = (money / months) + (money - (money * lihva)/100);
			this.client = client;
		}

		public int getDuration() {
			return duration;
		}
		
		public void setDuration(int duration) {
			this.duration = duration;
		}

		public double getMoney() {
			return money;
		}

		public void setMoney(double money) {
			this.money = money;
		}

		public double getAmountToPayBack() {
			return amountToPayBack;
		}

		public Client getClient() {
			return client;
		}

		@Override
		public String toString() {
			return "Credit with lihva:" + lihva + "%, duration:" + duration + ", amountToPayBack:" + Math.round(amountToPayBack)
					+ ", money:" + money + "]";
		}
		
	}

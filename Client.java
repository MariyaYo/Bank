import java.util.ArrayList;
import java.util.Random;

public class Client {
		
		private String name;
		private String adress;
		private double money;
		private double salary;
		private ArrayList<Credit> credits;
		private ArrayList<Deposit> deposits;
		Random rn = new Random();
		
		Client (String name, String adress, double money, double salary){
			this.name = name;
			this.adress = adress;
			this.money = money;
			this.salary = salary;
			credits = new ArrayList<Credit>();
			deposits = new ArrayList<Deposit>();
		}
		
		void makeAnDeposit (double money){
			if (money < this.money){
				String depositname= this.name + deposits.size();
				Random rn = new Random();
				boolean x = rn.nextBoolean();
				if(x){
					ShortDeposit a = new ShortDeposit(depositname, money, this);
					deposits.add(a);
				}else{
					LongDeposit a = new LongDeposit(depositname, money, this);
					deposits.add(a);
				}
			}
			
		}
		
		Credit askForCredit (double money, int months){
				String creditname= this.name + credits.size();
				boolean x = rn.nextBoolean();
				if(x){
					return new HomeCredit(creditname, money, months, this);
				}else{
					return new ConsumerCredit(creditname, money, months, this);
				}
		}
		void addCredit(Credit a){
			credits.add(a);
		}
		
		void payment (double money, Credit a){
			if(a.getDuration() > 0){
				this.money -= a.getAmountToPayBack();
				double moneyLeft = a.getMoney() - money;
				a.setMoney(moneyLeft);
				int monthsLeft = a.getDuration() -1;
				a.setDuration(monthsLeft);
			} else{
				a = null;
			}
		}

		public double getMoney() {
			return money;
		}

		public void setMoney(double money) {
			this.money = money;
		}

		public double getSalary() {
			return salary;
		}



		public ArrayList<Credit> getCredits() {
			return credits;
		}

		public ArrayList<Deposit> getDeposits() {
			return deposits;
		}

		@Override
		public String toString() {
			return "Client name " + name + ", Adress: " + adress + ", money: " + money + ", salary: " + salary + "]";
		}
		
		
	}


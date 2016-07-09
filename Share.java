
public class Share {
	private final String name;
	private Performance performance;
	private long price;
	
	public Share(String name,int price){
		this.name=name;
		this.price=price;
		this.performance=Performance.CONSTANT;
	}
	
	public void setPrice(long newPrice)throws IllegalArgumentException{
		if(newPrice < 0){
			throw new IllegalArgumentException("Aktien Preis kann nicht negativ sein!");
		}
		if(price > newPrice){
			performance=Performance.DECREASING;
		}else if(price < newPrice){
			performance = Performance.INCREASING;
		}else if(price == newPrice){
			performance = Performance.CONSTANT;
		}
		price = newPrice;
	}
	
	public Performance getPerformance(){
		return performance;
	}
	
	public String getName(){
		return name;
	}
	
	public long getPrice(){
		return price;
	}
	
	@Override
	public String toString(){
		String out = name + " @ " + price + " " + performance;
		return out;
	}
	
	private enum Performance{
		INCREASING,CONSTANT,DECREASING;
	}
	
	public class WrongCurrencyException extends Exception{
		public WrongCurrencyException(String message){
			super(message);
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Share other = (Share) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}

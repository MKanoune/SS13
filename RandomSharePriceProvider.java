import java.util.ArrayList;
import java.util.Random;

public class RandomSharePriceProvider extends SharePriceProvider {
	Random random = new Random();
	SharePriceInfo app = new SharePriceCache();
	
	public RandomSharePriceProvider(){
	}
	
	private void changeSharePriceRandomly(Share share){
		long price = share.getPrice();
		long delta = random.nextInt(3) - 1;
		share.setPrice(price + delta);
	}

	@Override
	public void updateSharePrices() {
//		for(Share share : app.shares){
//			changeSharePriceRandomly(share);
//			System.out.println(share.toString());
//		}
	}
	
	
}

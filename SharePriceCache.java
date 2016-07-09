import java.util.ArrayList;
//import java.util.HashSet;
import java.util.List;
//import java.util.Set;

public class SharePriceCache implements SharePriceInfo{
	protected List<Share> shares = new ArrayList<Share>();  
	
	public SharePriceCache() {
		shares.add(new Share("Siemens", 7342));
		shares.add(new Share("BMW", 72));
		shares.add(new Share("IBM", 583));
	}
	
	
	@Override
	public boolean isShareListed(String name) {
		for(Share share : shares){
			if(share.getName().equals(name)){
				return true;
			}
		}
		return false;
	}

	@Override
	public long getCurrenSharePrice(String name) {
		for(Share share : shares){
			if(share.getName().equals(name)){
				return share.getPrice();
			}
		}
		return 0;
	}

	@Override
	public String getCurrentSharePrices() {
		String out = "";
		for(Share share : shares){
			out += share.toString()+"\n";
		}
		return out;
	}

}

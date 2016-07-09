import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public abstract class SharePriceProvider {
	Timer timer = new Timer();
	
	TimerTask action = new TimerTask(){
		@Override
		public void run() {
			updateSharePrices();
		}
	};
	
	
	public abstract void updateSharePrices();
	
	public void startUpdate(){
		timer.schedule(action,5000, 5000);
		
	}
}

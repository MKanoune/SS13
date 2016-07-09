import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class SharePricesApp extends Application{
	final SharePriceProvider provider = new RandomSharePriceProvider();
	
	public static void main(String[] args){
		
		Application.launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		SharePriceInfo shares = new SharePriceCache();
		
				
		
		
		primaryStage.setTitle("Share price provider");
		
		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		gridPane.setPadding(new Insets(25,25,25,25));
		
		gridPane.add(new Label("Share Prices (Cent): "),0,1);
		final Label label = new Label ("none");
		gridPane.add(label, 1, 1);
		HBox hbox = new HBox(10);
		hbox.setAlignment(Pos.BOTTOM_RIGHT);
		Button button = new Button("Refresh");
		hbox.getChildren().add(button);
		gridPane.add(hbox, 1, 4);
		
		button.setOnAction(new EventHandler<ActionEvent>(){

				@Override
				public void handle(ActionEvent event) {
					provider.updateSharePrices();
					String s = shares.getCurrentSharePrices();
					label.setText(s);
				}
	        	
	        });
		
		
		Scene scene = new Scene(gridPane, 500, 250);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

}

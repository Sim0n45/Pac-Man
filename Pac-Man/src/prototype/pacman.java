package prototype;


import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class pacman extends Application
{
	
	protected static double ord;
	protected static double abs;
	protected int ptvie;
	protected int nbGommeMange;
	protected boolean AllerHaut;
	protected boolean AllerBas;
	protected boolean AllerGauche;
	protected boolean AllerDroit;
	protected Node pac;
	protected Image impac;
	private static final String pacim="http:/"
			+ "/image.xboxlive.com/global/t.58410811/tile/0/28003";
	protected final double W =600,H =400;
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		impac=new Image(pacim);
		pac= new ImageView(impac);
		Group root= new Group(pac);
		guidPacman(W/2,H/2);
		Scene scene = new Scene(root,W,H,Color.AQUA);
		
		scene.setOnKeyPressed(new EventHandler<KeyEvent>()
		{

			@Override
			public void handle(KeyEvent event) {
				// TODO Auto-generated method stub
				switch(event.getCode())
				{
				case UP:AllerHaut=true; break;
				case DOWN: AllerBas=true;break;
				case LEFT:AllerGauche=true; break;
				case RIGHT: AllerDroit=true;break;
				
				default:
					break;
				}
			}

		});
		scene.setOnKeyReleased(new EventHandler<KeyEvent>()
		{

			@Override
			public void handle(KeyEvent event) {
				// TODO Auto-generated method stub
				switch(event.getCode()){
				case UP:
					AllerHaut=false; break;
				case DOWN: 
					AllerBas=false;break;
				case LEFT:
					AllerGauche=false; break;
				case RIGHT: 
					AllerDroit=false;break;
				
				default:
					break;
				}
			}

		});
		stage.setScene(scene);
		stage.show();
		
		AnimationTimer timer =new AnimationTimer()
				{
					
					@Override
					public void handle(long now) {
						// TODO Auto-generated method stub
						double ord=0,abs=0;
						if(AllerHaut)  ord-=1;
						if(AllerBas)   ord+=1;
						if(AllerGauche)abs+=1;
						if(AllerDroit) abs-=1;
						deplacPacman(ord,abs);
					}
			
				};timer.start();
		
	}
	private void deplacPacman(double dx , double dy)
	{
		if (dx==0 && dy==0) return;
		
		final double cx= pac.getBoundsInLocal().getWidth()/2;
		final double cy=pac.getBoundsInLocal().getHeight()/2;
		double x=cx+ pac.getLayoutX() +dx;
		double y=cy+ pac.getLayoutY()+dy;
		
		guidPacman(x,y);
		
	}
	private void  guidPacman(double x, double y)
	{
		final double cx= pac.getBoundsInLocal().getWidth()/2;
		final double cy=pac.getBoundsInLocal().getHeight()/2;
		
		if(x-cx >= 0 && x+ cx <= W && y-cy >=0 && y+cy<= H)
		{
			pac.relocate(x-cx, y-cy);
		}
		
	}
	
	
	
	public static void main(String[]args){ launch(args); }
}


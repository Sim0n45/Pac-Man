package pacman;


import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.event.*;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class pacman extends Application
{
	protected double ord;
	protected double abs;
	protected int ptvie;
	protected int nbGommeMange;
	protected boolean AllerHaut;
	protected boolean AllerBas;
	protected boolean AllerGauche;
	protected boolean AllerDroit;
	protected Node iv1;
	public pacman(int ord, int abs, int ptvie, int nbGommeMange, boolean allerHaut, boolean allerBas,
			boolean allerGauche, boolean allerDroit) {
		super();
		this.ord = ord;
		this.abs = abs;
		this.ptvie = ptvie;
		this.nbGommeMange = nbGommeMange;
		AllerHaut = allerHaut;
		AllerBas = allerBas;
		AllerGauche = allerGauche;
		AllerDroit = allerDroit;
	}
	public pacman()
	{
		this.ord=0;
		this.abs=0;
		this.ptvie=0;
		this.nbGommeMange=0;
		this.AllerHaut=false;
		this.AllerBas=false;
		this.AllerGauche=false;
		this.AllerDroit=false;
	}
	
	public  void deplacemenToucheDirect( KeyEvent evenemnt)
	{
		//avec les touches directionnelles
		KeyCode keycode=evenemnt.getCode();
		switch(keycode)
		{
		case UP:
		  this.AllerHaut=true; break;
		case DOWN: 
			this.AllerBas=true;break;
		case LEFT:
			this.AllerGauche=true; break;
		case RIGHT: 
			this.AllerDroit=true;break;
		}
	}

	@Override


	public void start(Stage primaryStage) throws FileNotFoundException  {
	
		final Image imgload=new Image("file:C:\\Users\\Zabsonré"
				+ "\\workspace\\ProjetPacman\\pacman.png");
		final ImageView iv1=new ImageView();
		iv1.setImage(imgload);
		Group root=new Group();
		Scene scene=new Scene(root);
		scene.setFill(Color.BLACK);
		HBox box = new HBox();
        
		
		scene.setOnKeyPressed(new EventHandler<KeyEvent>(){

			@Override
			public void handle(KeyEvent arg0) {
				// TODO Auto-generated method stub
				deplacemenToucheDirect(arg0);
			}
		});
		scene.setOnKeyReleased(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				// TODO Auto-generated method stub
				switch(event.getCode())
				{
				case UP:
				   AllerHaut=true; break;
				case DOWN: 
					AllerBas=true;break;
				case LEFT:
					AllerGauche=true; break;
				case RIGHT: 
					AllerDroit=true;break;
				}
			}
			
		});
		
		AnimationTimer timer = new AnimationTimer()
		{

			@Override
			public void handle(long now) {
				// TODO Auto-generated method stub
			double ord=0,abs=0;
				
			if (AllerHaut)
				{
					ord=ord+1;
				}
				if(AllerBas)
				{
					ord=ord-1;
				}
				if(AllerGauche)
				{
					abs=abs-1;
				}
				if(AllerDroit)
				{
				   abs= abs+1;
					
				}
				guidPacman(ord,abs);
			}
			
		};
		timer.start();
		
		
		primaryStage.setScene(scene);
		box.getChildren().add(iv1);
        
        root.getChildren().add(box);
        primaryStage.setWidth(415);
        primaryStage.setHeight(200);
		primaryStage.setTitle("test afffichage pacman");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	
	
	public void guidPacman(double x,double y)
	{
		if(x==0 && y==y)return;
		double x1= iv1.getTranslateX();
		double y1= iv1.getTranslateY();
	
		double x2 = iv1.getLayoutX() +x1;
		double y2=iv1.getLayoutY() + y1;
	
	}
	
	
	public static void main(String[] args)
	{
		launch(args);
	}
}

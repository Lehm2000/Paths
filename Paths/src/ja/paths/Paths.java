package ja.paths;

import javax.swing.JFrame;

public class Paths {

	public static void main(String[] args) {
		
		//Initialize the app
		
		
		JFrame theWindow = new JFrame("Paths");
		initWindow(theWindow);
		
		DrawSurface drawSurface = new DrawSurface();
		theWindow.add( drawSurface );
		theWindow.setVisible(true);
		
		Game theGame = new Game(drawSurface);
		theGame.Init();
		
		theGame.GameStart();

	}
	
	public static void initWindow(JFrame window)
	{
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		window.setSize(640, 480);
	}

}

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.SQLException;

import Controller.GenreController;
import model.ConnectionToDb;
import model.Genre;
import model.GlobalVariables;
import ui.MainFrame;

public class client {
	
	
	
	public static void main(String[] args) {
		
		
		ConnectionToDb cd = new ConnectionToDb();
		
	try {
		GlobalVariables.con = cd.openConnection();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {			
				MainFrame window = new MainFrame();
				window.getFrame().setVisible(true);
				Genre genre = window.getGenre();
				GenreController cc = new GenreController(genre,window);
				cc.initController();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	});
	
	
}
	

}

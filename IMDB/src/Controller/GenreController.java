package Controller;




import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;

import model.Genre;
import model.GlobalVariables;
import ui.MainFrame;

public class GenreController {
	
	Genre genre;
	MainFrame view;
	ArrayList<String> GenreJL;
	String startYear="2000",endYear="2016";
	//String tagValue;
	
	public ArrayList<String> getGenreJL() {
		return GenreJL;
	}

	public void setGenreJL(ArrayList<String> genreJL) {
		GenreJL = genreJL;
	}

	public GenreController(Genre g, MainFrame m) {
		genre = g;
		view = m;
	}
	
	public void initController()
	{
		populateGenres();
		inputYear();
	}

	private void inputYear() {		
		//startYear = view.getStartYear().getText();
		//endYear = view.getEndYear().getText();	
		view.getEndYear().addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
//				endYear = view.getEndYear().getText();
//				startYear = view.getStartYear().getText();
//				System.out.println("mouseExited " + startYear);
//				System.out.println("mouseExited  "+endYear);
//				
			}
			

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
//				endYear = view.getEndYear().getText();
//				startYear = view.getStartYear().getText();
//				System.out.println("startYear mouseClicked"+ startYear);
//				System.out.println("mouseCliked endyear  "+endYear);
//				populateCountry();
				
			}
		});
		
		view.getEndYear().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				endYear = view.getEndYear().getText();
			    genre.setEndYear(endYear);
				System.out.println("hi "+endYear);
			}
		});
		
		view.getStartYear().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				startYear = view.getStartYear().getText();
				genre.setStartYear(startYear);
				System.out.println("hi "+startYear);
				//populateCountry();
			}
		});
		
		view.getBetweenAttribute().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JComboBox cb = (JComboBox) e.getSource();
				String temp = (String)cb.getSelectedItem();
				if(temp.equals("AND"))
				{
					GlobalVariables.betweenAttribute = "INTERSECT";
				}
				else
				{
					GlobalVariables.betweenAttribute = "UNION";
				}
				
				System.out.println(GlobalVariables.betweenAttribute);
				
			}
		});
		
		view.getComboBox_Tag().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JComboBox cb = (JComboBox) e.getSource();
				String temp = (String)cb.getSelectedItem();
				
				GlobalVariables.tagLessThanGreater = temp;
				System.out.println("temp " + temp);
			}
		});
		
		view.getTagValue().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				GlobalVariables.tagValueG = view.getTagValue().getText();
				System.out.println(GlobalVariables.tagValueG);
			}
		});
	}
	
//	private void populateCountry() {
//		
//		if(startYear != "" && endYear != "" && GenreJL.size()!=0)
//		{
//			
//		}
//		
//	}

	private void populateGenres() {
		
		view.getGenreList().addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {

				if (e.getClickCount() == 1) {
					GenreJL = (ArrayList<String>) view.getGenreList().getSelectedValuesList();
					genre.setGenreSelected(GenreJL);
					System.out.println();
				}
			}
		});
		
	}

}

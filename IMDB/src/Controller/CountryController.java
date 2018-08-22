package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JComboBox;

import model.ActorAndDirector;
import model.Country;
import model.Director;
import model.MainQuery;
import model.TagAndValue1;
import model.User;
import ui.MainFrame;
import ui.ObserverCountryView;

public class CountryController {

	Country country;
	MainFrame view;
	ArrayList<String> countryJL;
	ActorAndDirector aDModel;
	String combobox;
	TagAndValue1 tv;
	ArrayList<String> tagsAndValueJL;
	ArrayList<String> actorList;
	ArrayList<String> directorList;
	Director dir;
	ArrayList<String> movieTagList;
	MainQuery mainQuery;
	
	
	public CountryController(TagAndValue1 tv1 , MainFrame v) {
		
		tv = tv1;
		view = v;
		initControllerTagAndValue();
		
	}

	private void initControllerTagAndValue() {
		
		populateTagandVale();
		
	}

	private void btnexecuteUserQuery() {
		
		view.getBtnExecuteUserQuery().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				executeUserQuery();
			}

			
		});
		
	}
	
	private void executeUserQuery() {
		// TODO Auto-generated method stub
		
			//User u = new User(mq);
			//view.getUserResultList1().setModel(u.getUserArrayList());

	}

	private void btnexecuteQuery() {
		
		
		
		
		
		
		view.getBtnExecuteMovie().addActionListener(new ActionListener() {
			
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				executeQuery();
			}

			
		});
		
	}
	
	public void executeQuery() {
		
			
		    
		
	}

	private void populateTagandVale() {
		
		view.getTagsAndList().removeAll();
		
		view.getTagsAndList().setModel(tv.getTagsAndValueJlist());
		
		view.getTagsAndList().addMouseListener(new MouseListener() {
			
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
				// TODO Auto-generated method stub
				
				if (e.getClickCount() == 1) {
					tagsAndValueJL = (ArrayList<String>) view.getTagsAndList().getSelectedValuesList();
					tv.setSelectedTagList(tagsAndValueJL);
					
					
					///System.out.println("tags selected " + tagsAndValueJL.get(0));
				}
			}
		});
		
		view.getBtnExecuteMovie().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String t = e.getActionCommand();
				tv.setTemp(t);
			}
		});
		
	}

	public CountryController(Country c, MainFrame v) {
		country = c;
		view = v;
		initCountroller();
	}

	public CountryController(ActorAndDirector a, MainFrame v) {
		aDModel = a;
		view = v;
		iniControllerActorAndDirector();
	}

	public CountryController(Director d, MainFrame view2) {
		
		dir = d;
		view = view2;
		initControllerDirector();
		
	}

	public CountryController(MainQuery m, MainFrame ui) {
		  mainQuery = m;
		view = ui;
		initControllerMainQuery();
	}

	private void initControllerMainQuery() {
		
		view.getBtnExecuteMovie().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			     String t = e.getActionCommand();
			     tv.setTemp(t);
			}
		});
		
	}

	private void initControllerDirector() {
		
		populateDirector();
		
	}

	private void populateDirector() {
		
		view.getDirectorList().setModel(dir.getDirectorList());
		
           view.getDirectorList().addMouseListener(new MouseListener() {
			
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
				// TODO Auto-generated method stub
				directorList = (ArrayList<String>) view.getDirectorList().getSelectedValuesList();
				dir.setDirectorSelectedList(directorList);
				System.out.println("Director selected");
			}
		});
		
	}

	private void iniControllerActorAndDirector() {
		
		populateActorAndDirector();

	}

	private void populateActorAndDirector() {
		
		view.getActorModel().removeAllElements();
		
		view.getActorList().setModel(aDModel.getActorsList());
				
		
		view.getActorList().addMouseListener(new MouseListener() {
			
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
				//------------------------------
				
				actorList = (ArrayList<String>) view.getActorList().getSelectedValuesList();
				aDModel.setSelectedActorList1(actorList);
				System.out.println("Actor selected");
				
			}
		});
		
		
		
		
	}

	private void initCountroller() {

		populateCountry();
	}

	private void populateCountry() {

		view.getCountryModel().clear();
		//country.getCountryList();
		
		view.getCountryList().setModel(country.getCountryList());

		view.getCountryList().addMouseListener(new MouseListener() {

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
				// TODO Auto-generated method stub
				if (e.getClickCount() == 1) {
					countryJL = (ArrayList<String>) view.getCountryList().getSelectedValuesList();
					country.setCountrySelected(countryJL);
					System.out.println("country selected");
				}
			}
		});

	}

	
	
}

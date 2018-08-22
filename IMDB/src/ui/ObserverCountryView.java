package ui;

import java.util.Observable;
import java.util.Observer;

import Controller.CountryController;
import model.ActorAndDirector;
import model.Country;

public class ObserverCountryView implements Observer {

	Country country;
	MainFrame view;
	
	
	
	
	public ObserverCountryView(Country c,MainFrame v) throws NullPointerException {
		
		if(c == null)
			throw new NullPointerException();
		
		country = c;
		view = v;
		
		country.addObserver(this);
		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		ActorAndDirector ad = new ActorAndDirector(country);
	ad.getSelectedActorList1().clear();
	
	CountryController cc = new CountryController(ad, view);
	ObserverActorAndDirector ado = new ObserverActorAndDirector(ad, view);
		
	System.out.println("country updated");
	}
	
	
}

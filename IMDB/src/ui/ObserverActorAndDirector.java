package ui;

import java.util.Observable;
import java.util.Observer;

import Controller.CountryController;
import model.ActorAndDirector;
import model.Country;
import model.Director;


public class ObserverActorAndDirector implements Observer{
	
	private ActorAndDirector ad;
	private MainFrame view;
	
	public ObserverActorAndDirector(ActorAndDirector a, MainFrame v)  throws NullPointerException{
		
		if(a == null)
			throw new NullPointerException();
		
		ad=a;
		view = v;
		
		ad.addObserver(this);
	}

	
	@Override
	public void update(Observable arg0, Object arg1) {
		
		//--TagAndValue tv = new TagAndValue(ad);	
		//ad.getSelectedActorList1().clear();
		Director d = new Director(ad);
		d.getDirectorSelectedList().clear();
		CountryController dd = new CountryController(d, view);
		
		//--CountryController cc = new CountryController(tv, view);
		observerDirector oo = new observerDirector(d, view);
		System.out.println("Actor and director update");
		
	}

}

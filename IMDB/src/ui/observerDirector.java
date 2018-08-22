package ui;

import java.util.Observable;
import java.util.Observer;

import Controller.CountryController;
import model.Director;
import model.TagAndValue1;


public class observerDirector implements Observer{
	
	private Director dir;
	private MainFrame view;
	
	public observerDirector(Director a, MainFrame v)  throws NullPointerException{
		
		if(a == null)
			throw new NullPointerException();
		
		dir=a;
		view = v;
		
		dir.addObserver(this);
	}

	
	@Override
	public void update(Observable arg0, Object arg1) {
		
		TagAndValue1 tv = new TagAndValue1(dir);	
		//ad.getSelectedActorList1().clear();
		
		
		
		CountryController cc = new CountryController(tv, view);
		//observerDirector oo = new observerDirector(dir, view);
		
		ObserverTagValue om = new ObserverTagValue(tv , view);
		
		System.out.println("tag update");
		
	}

}

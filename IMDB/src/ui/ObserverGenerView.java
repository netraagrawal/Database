package ui;

import java.awt.geom.GeneralPath;
import java.util.Observable;
import java.util.Observer;

import Controller.CountryController;
import model.Country;
import model.Genre;

public class ObserverGenerView implements Observer{

	private Genre genre;
	private MainFrame view;
	
	public Genre getGenre() {
		return genre;
	}
	 
	public ObserverGenerView(Genre observableGenre , MainFrame v) throws NullPointerException {
		
		// do not allow null Accounts
	      if ( observableGenre == null )
	         throw new NullPointerException();

	      // update account data member to new Account
	      genre = observableGenre;
	      view = v;
	      // register as an Observer to receive account updates
	      genre.addObserver( this );
	}
	
	
	 //  protected abstract void updateDisplay();
	   
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		Country country = new Country(genre);
		country.getCountrySelected().clear();
		country.getCountrySelected().add("ALL");
		CountryController cc = new CountryController(country, view);
		ObserverCountryView oc = new ObserverCountryView(country, view);
		System.out.println("update");
		
	}

}

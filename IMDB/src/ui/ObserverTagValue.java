package ui;

import java.util.Observable;
import java.util.Observer;

import Controller.CountryController;
import model.MainQuery;
import model.TagAndValue1;

public class ObserverTagValue implements Observer {
	
	TagAndValue1 tv;
	MainFrame ui;

	public ObserverTagValue(TagAndValue1 tv1, MainFrame view) throws NullPointerException {
		
		if(tv1 == null)
			throw new NullPointerException();
		
		tv = tv1;
		ui = view;
		
		tv.addObserver(this);
		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
		MainQuery m = new MainQuery(tv);
		
		CountryController cccc = new CountryController(m, ui);
		 //ObserveMovie om = new ObserveMovie();
		System.out.println("yessssssssssss");
		
	}

}

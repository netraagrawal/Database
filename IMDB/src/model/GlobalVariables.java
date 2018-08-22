
package model;

import java.sql.Connection;

import javax.swing.DefaultListModel;

public class GlobalVariables {
	
	public static String betweenAttribute="INTERSECT";
	public static String tagLessThanGreater = ">";
	public static String tagValueG = "0";
	public static DefaultListModel<String> actorsList = new DefaultListModel<>();
	public static Connection  con = null;
}

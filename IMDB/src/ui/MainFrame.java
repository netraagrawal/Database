package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.CardLayout;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.BevelBorder;

import model.Genre;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import java.awt.GridLayout;
import javax.swing.JList;
import javax.swing.border.TitledBorder;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class MainFrame {

	private JFrame frame;
	private JPanel genrePanel;
	private JList genreList;
	private JScrollPane genreScrollPane;
	private JPanel panel;
	private JLabel lblGenres;
	private JPanel datePanle;
	private JLabel lblStartYear;
	private JTextField startYear;
	private JLabel lblEndYear;
	private JTextField endYear;
	private JPanel panel_1;
	private JPanel country;
	private JLabel lblCountry;
	private JScrollPane scrollPane;
	private JList<String> countryList;
	private Genre genre;
	DefaultListModel<String> countryModel;
	private JPanel panel_2;
	
	
	private JList<String> directorList;
	public JList<String> getDirectorList() {
		return directorList;
	}

	public void setDirectorList(JList<String> directorList) {
		this.directorList = directorList;
	}

	public JList<String> getActorList() {
		return actorList;
	}

	public void setActorList(JList<String> actorList) {
		this.actorList = actorList;
	}

	private JList<String> actorList;
	
	
	DefaultComboBoxModel<String> actorModel = new DefaultComboBoxModel<>();
	private JLabel lblDirector;
	private JTextField tagValue;
	public JTextField getTagValue() {
		return tagValue;
	}

	public void setTagValue(JTextField tagValue) {
		this.tagValue = tagValue;
	}

	private JList tagsAndList;
	private JPanel panel_7;
	private JLabel lblSearchBetweenAttributes;
	private JComboBox betweenAttribute;
	public JComboBox getBetweenAttribute() {
		return betweenAttribute;
	}

	public void setBetweenAttribute(JComboBox betweenAttribute) {
		this.betweenAttribute = betweenAttribute;
	}

	private JPanel panel_8;
	private JLabel lblMovieResult;
	private JList<String> list;
	private JPanel panel_10;
	private JPanel panel_11;
	private JPanel panel_12;
	private JButton btnExecuteUserQuery;
	public JButton getBtnExecuteUserQuery() {
		return btnExecuteUserQuery;
	}

	public void setBtnExecuteUserQuery(JButton btnExecuteUserQuery) {
		this.btnExecuteUserQuery = btnExecuteUserQuery;
	}

	private JPanel panel_13;
	private JLabel lblUserResult;
	private JPanel panel_9;
	
	private JList<String> userResultList;
	private JTextArea queryStatement;
	private JList<String> MovieResultList;
	public JList<String> getMovieResultList() {
		return MovieResultList;
	}

	public void setMovieResultList(JList<String> movieResultList) {
		MovieResultList = movieResultList;
	}

	private JScrollPane scrollPane_2;
	private JList userResultList1;
	public JList getUserResultList1() {
		return userResultList1;
	}

	public void setUserResultList1(JList userResultList1) {
		this.userResultList1 = userResultList1;
	}

	private JScrollPane scrollPane_3;
	
	private JButton btnExecuteMovie;
	
	
	public JButton getBtnExecuteMovie() {
		return btnExecuteMovie;
	}

	public void setBtnExecuteMovie(JButton btnExecuteMovie) {
		this.btnExecuteMovie = btnExecuteMovie;
	}

	public JList getTagsAndList() {
		return tagsAndList;
	}

	public void setTagsAndList(JList tagsAndList) {
		this.tagsAndList = tagsAndList;
	}

	public DefaultComboBoxModel<String> getActorModel() {
		return actorModel;
	}

	public void setActorModel(DefaultComboBoxModel<String> actorModel) {
		actorModel = actorModel;
	}

	

	public DefaultListModel<String> getCountryModel() {
		return countryModel;
	}

	public void setCountryModel(DefaultListModel<String> countryModel) {
		this.countryModel = countryModel;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public JPanel getDatePanle() {
		return datePanle;
	}

	public void setDatePanle(JPanel datePanle) {
		this.datePanle = datePanle;
	}

	public JTextField getStartYear() {
		return startYear;
	}

	public void setStartYear(JTextField startYear) {
		this.startYear = startYear;
	}

	public JTextField getEndYear() {
		return endYear;
	}

	public void setEndYear(JTextField endYear) {
		this.endYear = endYear;
	}

	public JList getCountryList() {
		return countryList;
	}

	public void setCountryList(JList countryList) {
		this.countryList = countryList;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JPanel getGenrePanel() {
		return genrePanel;
	}

	public void setGenrePanel(JPanel genrePanel) {
		this.genrePanel = genrePanel;
	}

	public JList getGenreList() {
		return genreList;
	}

	public void setGenreList(JList genreList) {
		this.genreList = genreList;
	}

	DefaultComboBoxModel<String> betweenList = new DefaultComboBoxModel<>();
	JComboBox comboBox_Tag;
	
	
	
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MainFrame window = new MainFrame();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	public JComboBox getComboBox_Tag() {
		return comboBox_Tag;
	}

	public void setComboBox_Tag(JComboBox comboBox_Tag) {
		this.comboBox_Tag = comboBox_Tag;
	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 951, 622);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//frame.setVisible(true);
		
		JPanel header = new JPanel();
		header.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, SystemColor.desktop, SystemColor.desktop));
		header.setBackground(SystemColor.activeCaption);
		header.setBounds(0, 0, 626, 29);
		frame.getContentPane().add(header);
		header.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblMovieAttributes = new JLabel("Movie Attributes");
		lblMovieAttributes.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		header.add(lblMovieAttributes);
		
		genreScrollPane = new JScrollPane();
		genreScrollPane.setBounds(0, 55, 140, 181);
		frame.getContentPane().add(genreScrollPane);
		
		genrePanel = new JPanel();
		genreScrollPane.setViewportView(genrePanel);
		genrePanel.setLayout(new GridLayout(1, 0, 0, 0));
		genre = new Genre();
		
		ObserverGenerView ag= new ObserverGenerView(genre , this);
		genreList = new JList(genre.getGenreList());
		genrePanel.add(genreList);	
		
		panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBounds(0, 30, 140, 24);
		frame.getContentPane().add(panel);
		
		lblGenres = new JLabel("Genres");
		panel.add(lblGenres);
		
		datePanle = new JPanel();
		datePanle.setBorder(new LineBorder(new Color(0, 0, 0)));
		datePanle.setBounds(0, 239, 140, 95);
		frame.getContentPane().add(datePanle);
		datePanle.setLayout(new GridLayout(0, 1, 0, 0));
		
		lblStartYear = new JLabel("Start Year");
		datePanle.add(lblStartYear);
		
		startYear = new JTextField();
		datePanle.add(startYear);
		startYear.setColumns(10);
		
		lblEndYear = new JLabel("End Year");
		datePanle.add(lblEndYear);
		
		endYear = new JTextField();
		datePanle.add(endYear);
		endYear.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(141, 55, 151, 278);
		frame.getContentPane().add(scrollPane);
		
		panel_1 = new JPanel();
		scrollPane.setViewportView(panel_1);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		countryModel = new DefaultListModel<>();
		countryModel.addElement("hi");
		countryList = new JList(countryModel);
		panel_1.add(countryList);
		
		country = new JPanel();
		country.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		country.setBackground(SystemColor.activeCaption);
		country.setBounds(141, 30, 151, 24);
		frame.getContentPane().add(country);
		
		lblCountry = new JLabel("Country");
		country.add(lblCountry);	
		
		JPanel cast = new JPanel();
		cast.setBorder(new LineBorder(new Color(0, 0, 0)));
		cast.setBackground(SystemColor.activeCaption);
		cast.setBounds(293, 30, 188, 24);
		frame.getContentPane().add(cast);
		
		JLabel lblCast = new JLabel("Cast");
		cast.add(lblCast);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_2.setBounds(293, 56, 188, 278);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblActorActress = new JLabel("Actor / Actress");
		lblActorActress.setBounds(46, 11, 88, 14);
		panel_2.add(lblActorActress);
		
		actorModel.addElement("");
		
		lblDirector = new JLabel("Director");
		lblDirector.setBounds(62, 163, 46, 14);
		panel_2.add(lblDirector);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBounds(10, 25, 168, 135);
		panel_2.add(panel_14);
		panel_14.setLayout(new GridLayout(0, 1, 0, 0));
		
		JScrollPane scrollPane_4 = new JScrollPane();
		panel_14.add(scrollPane_4);
		
		
		actorList = new JList();
		scrollPane_4.setViewportView(actorList);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBounds(10, 188, 168, 79);
		panel_2.add(panel_15);
		panel_15.setLayout(new GridLayout(0, 1, 0, 0));
		
		JScrollPane scrollPane_5 = new JScrollPane();
		panel_15.add(scrollPane_5);
		
		directorList = new JList();
		scrollPane_5.setViewportView(directorList);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.activeCaption);
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(481, 30, 145, 24);
		frame.getContentPane().add(panel_3);
		
		JLabel lblTagsAndIds = new JLabel("Tags And Ids");
		panel_3.add(lblTagsAndIds);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBackground(new Color(240, 240, 240));
		panel_4.setBounds(481, 56, 145, 278);
		frame.getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.setBounds(0, 0, 145, 191);
		panel_4.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_5.add(scrollPane_1);
		
		tagsAndList = new JList();
		scrollPane_1.setViewportView(tagsAndList);
		
		
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_6.setBounds(0, 190, 145, 88);
		panel_4.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblTagWeight = new JLabel("Tag Weight");
		lblTagWeight.setBounds(10, 11, 61, 14);
		panel_6.add(lblTagWeight);
		
		DefaultComboBoxModel<String> tagModel = new DefaultComboBoxModel<>();
		tagModel.addElement("= , > , <");
		tagModel.addElement("=");
		tagModel.addElement(">");
		tagModel.addElement("<");
		comboBox_Tag = new JComboBox(tagModel);
		comboBox_Tag.setBounds(68, 8, 67, 20);
		panel_6.add(comboBox_Tag);
		
		JLabel lblValue = new JLabel("Value");
		lblValue.setBounds(10, 46, 46, 14);
		panel_6.add(lblValue);
		
		tagValue = new JTextField();
		tagValue.setBounds(59, 43, 76, 20);
		panel_6.add(tagValue);
		tagValue.setColumns(10);
		
		panel_7 = new JPanel();
		panel_7.setBackground(SystemColor.activeCaption);
		panel_7.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_7.setBounds(0, 332, 626, 39);
		frame.getContentPane().add(panel_7);
		panel_7.setLayout(null);
		
		lblSearchBetweenAttributes = new JLabel("Search Between Attributes values");
		lblSearchBetweenAttributes.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblSearchBetweenAttributes.setBackground(new Color(240, 240, 240));
		lblSearchBetweenAttributes.setBounds(31, 11, 252, 14);
		panel_7.add(lblSearchBetweenAttributes);
		
		betweenList.addElement("Select AND,OR");
		betweenList.addElement("AND");
		betweenList.addElement("OR");
		
		betweenAttribute = new JComboBox(betweenList);
		betweenAttribute.setBounds(306, 10, 138, 20);
		panel_7.add(betweenAttribute);
		
		panel_8 = new JPanel();
		panel_8.setBackground(SystemColor.activeCaption);
		panel_8.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_8.setBounds(625, 0, 310, 29);
		frame.getContentPane().add(panel_8);
		
		lblMovieResult = new JLabel("Movie Result");
		panel_8.add(lblMovieResult);
		
		
		
		panel_10 = new JPanel();
		panel_10.setBackground(new Color(51, 51, 153));
		panel_10.setBounds(0, 371, 935, 212);
		frame.getContentPane().add(panel_10);
		panel_10.setLayout(null);
		
		panel_12 = new JPanel();
		panel_12.setBounds(10, 11, 614, 127);
		panel_10.add(panel_12);
		panel_12.setLayout(new GridLayout(1, 0, 0, 0));
		
		queryStatement = new JTextArea();
		panel_12.add(queryStatement);
		
		btnExecuteMovie = new JButton("Execute movie query");
		btnExecuteMovie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnExecuteMovie.setBounds(88, 161, 137, 23);
		panel_10.add(btnExecuteMovie);
		
		btnExecuteUserQuery = new JButton("Execute User Query");
		btnExecuteUserQuery.setBounds(312, 161, 129, 23);
		panel_10.add(btnExecuteUserQuery);
		
		panel_13 = new JPanel();
		panel_13.setBounds(630, 0, 305, 212);
		panel_10.add(panel_13);
		panel_13.setLayout(new GridLayout(0, 1, 0, 0));
		
		scrollPane_3 = new JScrollPane();
		panel_13.add(scrollPane_3);
		
		userResultList1 = new JList();
		scrollPane_3.setViewportView(userResultList1);
		
		
		
		panel_11 = new JPanel();
		panel_11.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_11.setBackground(SystemColor.activeCaption);
		panel_11.setBounds(625, 332, 310, 39);
		frame.getContentPane().add(panel_11);
		
		lblUserResult = new JLabel("User Result");
		lblUserResult.setFont(new Font("Times New Roman", Font.BOLD, 17));
		panel_11.add(lblUserResult);
		
		panel_9 = new JPanel();
		panel_9.setBounds(625, 30, 310, 304);
		frame.getContentPane().add(panel_9);
		panel_9.setLayout(new GridLayout(0, 1, 0, 0));
		
		scrollPane_2 = new JScrollPane();
		panel_9.add(scrollPane_2);
		
		MovieResultList = new JList();
		scrollPane_2.setViewportView(MovieResultList);
		
		
	}
}

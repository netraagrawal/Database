package ui;


import java.awt.TextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Temp extends javax.swing.JFrame 
{
    public Temp() 
    {
        initComponents();
        connect();
        populateGenre();
        ComboBoxAndOr.setSelectedIndex(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfMovies = new javax.swing.JTextField();
        GenreScroll = new javax.swing.JScrollPane();
        GenreList = new javax.swing.JList<>();
        tfGenre = new javax.swing.JTextField();
        tfCountry = new javax.swing.JTextField();
        tfFilmLoc = new javax.swing.JTextField();
        tfRating = new javax.swing.JTextField();
        tfUserTag = new javax.swing.JTextField();
        BExecuteQuery = new javax.swing.JButton();
        ComboBoxAndOr = new javax.swing.JComboBox<>();
        BAddCountry = new javax.swing.JButton();
        CountryPanel = new javax.swing.JPanel();
        CountryScroll = new javax.swing.JScrollPane();
        CountryList = new javax.swing.JList<>();
        FilmLocPanel = new javax.swing.JPanel();
        FilmLocScroll = new javax.swing.JScrollPane();
        FilmLocList = new javax.swing.JList<>();
        BAddFilmLoc = new javax.swing.JButton();
        BAddMovieTags = new javax.swing.JButton();
        ResultScroll = new javax.swing.JScrollPane();
        ResultList = new javax.swing.JList<>();
        ResultLabel = new javax.swing.JLabel();
        QueryScroll = new javax.swing.JScrollPane();
        taQuery = new javax.swing.JTextArea();
        MovieTagPanel = new javax.swing.JPanel();
        MovieTagsListScroll = new javax.swing.JScrollPane();
        MovieTagsList = new javax.swing.JList<>();
        TagWeightLabel = new javax.swing.JLabel();
        ComboBoxTagWeight = new javax.swing.JComboBox<>();
        tfTagWeightValue = new javax.swing.JTextField();
        TagWeightValueLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        RatingLabel = new javax.swing.JLabel();
        ComboBoxRating = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        RatingValueLabel = new javax.swing.JLabel();
        tfRatingValue = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        NumRatingLabel = new javax.swing.JLabel();
        ComboBoxNumRating = new javax.swing.JComboBox();
        NumRatingValueLabel = new javax.swing.JLabel();
        tfNumRatingValue = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        MovieYearLabel = new javax.swing.JLabel();
        MovieYearFromLabel = new javax.swing.JLabel();
        tfMovieYearFrom = new javax.swing.JTextField();
        MovieYearToLabel = new javax.swing.JLabel();
        tfMovieYearTo = new javax.swing.JTextField();
        MovieSelectedFromResultScroll = new javax.swing.JScrollPane();
        MovieSelectedFromResultList = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        tfMovies.setEditable(false);
        tfMovies.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfMovies.setText("Movies");
        tfMovies.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tfMovies.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfMoviesActionPerformed(evt);
            }
        });

        GenreScroll.setViewportView(GenreList);

        tfGenre.setEditable(false);
        tfGenre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfGenre.setText("Genres");
        tfGenre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        tfCountry.setEditable(false);
        tfCountry.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfCountry.setText("Country");
        tfCountry.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        tfFilmLoc.setEditable(false);
        tfFilmLoc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfFilmLoc.setText("Filming Location Country");
        tfFilmLoc.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        tfRating.setEditable(false);
        tfRating.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfRating.setText("Critics' Rating");
        tfRating.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        tfRating.setPreferredSize(new java.awt.Dimension(89, 20));
        tfRating.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfRatingActionPerformed(evt);
            }
        });

        tfUserTag.setEditable(false);
        tfUserTag.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfUserTag.setText("Movie Tag Values");
        tfUserTag.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        BExecuteQuery.setText("Execute Query");
        BExecuteQuery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BExecuteQueryActionPerformed(evt);
            }
        });

        ComboBoxAndOr.setMaximumRowCount(3);
        ComboBoxAndOr.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select AND, OR between attributes", "AND", "OR" }));
        ComboBoxAndOr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxAndOrActionPerformed(evt);
            }
        });

        BAddCountry.setText("Add Countries");
        BAddCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAddCountryActionPerformed(evt);
            }
        });

        CountryScroll.setViewportView(CountryList);

        javax.swing.GroupLayout CountryPanelLayout = new javax.swing.GroupLayout(CountryPanel);
        CountryPanel.setLayout(CountryPanelLayout);
        CountryPanelLayout.setHorizontalGroup(
            CountryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CountryScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        CountryPanelLayout.setVerticalGroup(
            CountryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CountryScroll)
        );

        FilmLocScroll.setViewportView(FilmLocList);

        javax.swing.GroupLayout FilmLocPanelLayout = new javax.swing.GroupLayout(FilmLocPanel);
        FilmLocPanel.setLayout(FilmLocPanelLayout);
        FilmLocPanelLayout.setHorizontalGroup(
            FilmLocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FilmLocPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(FilmLocScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        FilmLocPanelLayout.setVerticalGroup(
            FilmLocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FilmLocScroll, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        BAddFilmLoc.setText("Add Filming Loc");
        BAddFilmLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAddFilmLocActionPerformed(evt);
            }
        });

        BAddMovieTags.setText("Add Movie Tags");
        BAddMovieTags.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAddMovieTagsActionPerformed(evt);
            }
        });

        ResultScroll.setViewportView(ResultList);

        ResultLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ResultLabel.setText("Result");

        taQuery.setColumns(20);
        taQuery.setRows(5);
        QueryScroll.setViewportView(taQuery);

        MovieTagPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        MovieTagsListScroll.setViewportView(MovieTagsList);

        TagWeightLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TagWeightLabel.setText("Tag Weight :");

        ComboBoxTagWeight.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select =, >, <", "=", ">", "<" }));
        ComboBoxTagWeight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxTagWeightActionPerformed(evt);
            }
        });

        tfTagWeightValue.setToolTipText("");
        tfTagWeightValue.setInheritsPopupMenu(true);

        TagWeightValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TagWeightValueLabel.setText("Value   :");

        javax.swing.GroupLayout MovieTagPanelLayout = new javax.swing.GroupLayout(MovieTagPanel);
        MovieTagPanel.setLayout(MovieTagPanelLayout);
        MovieTagPanelLayout.setHorizontalGroup(
            MovieTagPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MovieTagPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MovieTagPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MovieTagPanelLayout.createSequentialGroup()
                        .addComponent(TagWeightValueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfTagWeightValue, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MovieTagPanelLayout.createSequentialGroup()
                        .addComponent(TagWeightLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ComboBoxTagWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(MovieTagPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(MovieTagsListScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
        );
        MovieTagPanelLayout.setVerticalGroup(
            MovieTagPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MovieTagPanelLayout.createSequentialGroup()
                .addContainerGap(220, Short.MAX_VALUE)
                .addGroup(MovieTagPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboBoxTagWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TagWeightLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(MovieTagPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfTagWeightValue, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TagWeightValueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
            .addGroup(MovieTagPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(MovieTagPanelLayout.createSequentialGroup()
                    .addComponent(MovieTagsListScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 120, Short.MAX_VALUE)))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        RatingLabel.setText("RATING :");

        ComboBoxRating.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select =, >, <, >=, <=", "=", ">", "<", ">=", "<=" }));

        RatingValueLabel.setText("VALUE   :");

        NumRatingLabel.setText("NO. OF REVIEWS :");

        ComboBoxNumRating.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select =, >, <, >=, <=", "=", ">", "<", ">=", "<=" }));

        NumRatingValueLabel.setText("VALUE   :");

        MovieYearLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MovieYearLabel.setText("MOVIE YEAR");

        MovieYearFromLabel.setText("FROM    :");

        MovieYearToLabel.setText("TO         :");

        tfMovieYearTo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfMovieYearToActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(NumRatingValueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(tfNumRatingValue, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(NumRatingLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(ComboBoxNumRating, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addComponent(MovieYearToLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tfMovieYearTo, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addComponent(MovieYearFromLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tfMovieYearFrom)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(RatingValueLabel)
                        .addGap(18, 18, 18)
                        .addComponent(tfRatingValue, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel7))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(RatingLabel)
                        .addGap(18, 18, 18)
                        .addComponent(ComboBoxRating, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addComponent(MovieYearLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RatingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboBoxRating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel7))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RatingValueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfRatingValue, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ComboBoxNumRating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NumRatingLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfNumRatingValue, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(NumRatingValueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(MovieYearLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfMovieYearFrom, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(MovieYearFromLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfMovieYearTo, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(MovieYearToLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        MovieSelectedFromResultScroll.setViewportView(MovieSelectedFromResultList);

        jLabel1.setText("Search Between Attributes' Values:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tfMovies)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ResultLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(243, 243, 243))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(BAddCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(32, 32, 32))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(GenreScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tfGenre, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(0, 0, 0)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(CountryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tfCountry, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(BAddFilmLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BAddMovieTags, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(FilmLocPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfFilmLoc))
                                .addGap(0, 0, 0)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfRating, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, 0)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(MovieTagPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfUserTag)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(ComboBoxAndOr, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(QueryScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(BExecuteQuery, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ResultScroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MovieSelectedFromResultScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(tfMovies, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfCountry)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfFilmLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfRating, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfUserTag, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tfGenre))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(GenreScroll, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(FilmLocPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(MovieTagPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CountryPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BAddCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BAddFilmLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BAddMovieTags, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(MovieSelectedFromResultScroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ComboBoxAndOr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ResultLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(BExecuteQuery, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(QueryScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(ResultScroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Movie TextField
    private void tfMoviesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfMoviesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfMoviesActionPerformed

    
    private void tfRatingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfRatingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfRatingActionPerformed

    //Ececute Query
    private void BExecuteQueryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BExecuteQueryActionPerformed

        taQuery.setText("");
        DefaultListModel FinalResult = new DefaultListModel();
        FinalResult.clear();
                       
        String BetweenAttribute = "";
        if(ComboBoxAndOr.getSelectedIndex()==0 || ComboBoxAndOr.getSelectedIndex()==1)
        {
            BetweenAttribute = "INTERSECT";
        }
        else
        {
            if(ComboBoxAndOr.getSelectedIndex()==2)
            {
                BetweenAttribute = "UNION";
            }
        }
        
        int i=0;

        //Any Genre is Selected
        if(GenreAl.size()!=0)
        {
            for(i=0;i<GenreAl.size()-1;i++)
            {
                FinalSubQuery += "SELECT MG.M_id\nFROM Movie_Genres MG\nWHERE MG.Genre = '"+GenreAl.get(i)+"'\n"+BetweenAttribute+"\n";
            }

            FinalSubQuery += "SELECT MG.M_id\nFROM Movie_Genres MG\nWHERE MG.Genre = '"+GenreAl.get(i)+"'";
        }
        
        //Any Country is Selected
        if(SelectedCountryList.size()!=0)
        {
            FinalSubQuery += "\nINTERSECT\n";
            for(i=0;i<SelectedCountryList.size()-1;i++)
            {
                FinalSubQuery += "SELECT MC.M_id\nFROM Movie_Countries MC\nWHERE MC.Country = '"+SelectedCountryList.get(i)+"'\n"+BetweenAttribute+"\n";
            }

            FinalSubQuery += "SELECT MC.M_id\nFROM Movie_Countries MC\nWHERE MC.Country = '"+SelectedCountryList.get(i)+"'";
        }

        //Any Filming Location Country is Selected
        if(SelectedFilmLocList.size()!=0)
        {
            FinalSubQuery += "\nINTERSECT\n";
            for(i=0;i<SelectedFilmLocList.size()-1;i++)
            {
                FinalSubQuery += "SELECT ML.M_id\nFROM Movie_Locations ML\nWHERE ML.Location_Country = '"+SelectedFilmLocList.get(i)+"'\n"+BetweenAttribute+"\n";
            }

            FinalSubQuery += "SELECT ML.M_id\nFROM Movie_Locations ML\nWHERE ML.Location_Country = '"+SelectedFilmLocList.get(i)+"'";
        }
     
        if((ComboBoxRating.getSelectedIndex()!=0) && ((tfRatingValue.getText().length())!=0))
        {
            FinalSubQuery += "\nINTERSECT\n";
                       
            FinalSubQuery += "SELECT M.M_id\nFROM Movie M\nWHERE M.Rt_All_Critics_Ratings "+ComboBoxRating.getItemAt(ComboBoxRating.getSelectedIndex())+" '"+tfRatingValue.getText()+"' AND M.Rt_All_Critics_Ratings <> '\\N'";
        
        }
        
        if((ComboBoxNumRating.getSelectedIndex()!=0) && ((tfNumRatingValue.getText().length())!=0))
        {
            
            FinalSubQuery += "\n"+BetweenAttribute+"\n";
            
            FinalSubQuery += "SELECT M.M_id\nFROM Movie M\nWHERE M.Rt_All_Critics_Num_Reviews "+ComboBoxNumRating.getItemAt(ComboBoxNumRating.getSelectedIndex())+" '"+tfNumRatingValue.getText()+"' AND M.Rt_All_Critics_Num_Reviews <> '\\N'";
        }
        
        if(((tfMovieYearFrom.getText().length())!=0) && ((tfMovieYearTo.getText().length())!=0))
        {
            FinalSubQuery += "\nINTERSECT\n";
            
            FinalSubQuery += "SELECT M.M_id\nFROM Movie M\nWHERE M.M_Year BETWEEN '"+tfMovieYearFrom.getText()+"' AND '"+tfMovieYearTo.getText()+"'";
        }
        
         //Any Movie Tag is Selected
        if(SelectedMovieTagsList.size()!=0)
        {
            FinalSubQuery += "\nINTERSECT\n";
            for(i=0;i<SelectedMovieTagsList.size()-1;i++)
            {
                FinalSubQuery += "SELECT MT.M_id\nFROM Tags T, Movie_Tags MT\nWHERE T.Tag_id = MT.Tag_id AND Tag_Text = '"+SelectedMovieTagsList.get(i)+"'\n"+BetweenAttribute+"\n";
            }

            FinalSubQuery += "SELECT MT.M_id\nFROM Tags T, Movie_Tags MT\nWHERE T.Tag_id = MT.Tag_id AND Tag_Text = '"+SelectedMovieTagsList.get(i)+"'";
        }

        if(ComboBoxTagWeight.getSelectedIndex()!=0 && tfTagWeightValue.getText().length()!=0)
        {
            FinalSubQuery += "\nINTERSECT\n";
            FinalSubQuery += "SELECT MT.M_id\nFROM Movie_Tags MT\nWHERE MT.Tag_Weight "+ComboBoxTagWeight.getItemAt(ComboBoxTagWeight.getSelectedIndex())+"'"+tfTagWeightValue.getText()+"'";
        }
        
        FinalQuery += "SELECT DISTINCT M.M_id, M.M_Title\nFROM Movie M\nWHERE M.M_id IN (\n" + FinalSubQuery + "\n)";
       
        taQuery.setText(FinalQuery);
        taQuery.setLineWrap(true);
        
        try
        {
            System.out.println(FinalQuery);

            ps=con.prepareStatement(FinalQuery);
            rs=ps.executeQuery(FinalQuery);

            
            while(rs.next())
            {
                if(!FinalResult.contains(rs.getString("M_Title")))
                {
                    FinalResult.addElement(rs.getString("M_Title"));
                }
            }
            ResultList.setModel(FinalResult);
            
            ResultList.getSelectionModel().addListSelectionListener(new ListSelectionListener() 
            {
                @Override
                public void valueChanged(ListSelectionEvent e) 
                {
                    MovieSelectedFromResultScroll.setVisible(true);
                    
                    DefaultListModel MovieSelectedList = new DefaultListModel();
                    String SelectedMovie = ResultList.getSelectedValue();
                    
                    String MovieDetails = "SELECT DISTINCT M.M_id, M.M_Year, "
                            + "ROUND((M.Rt_All_Critics_Ratings+M.Rt_Top_Critics_Ratings+M.Rt_Audience_Rating)/3,2) AS Rating, "
                            + "ROUND((M.Rt_All_Critics_Num_Reviews+M.Rt_Top_Critics_Num_Reviews+M.Rt_Audience_Num_Ratings)/3,2) AS Num_Rating"
                            + "\nFROM Movie M\nWHERE M.M_Title ='"+SelectedMovie+"'";
                    
                    try
                    {
                        ps=con.prepareStatement(MovieDetails);
                        rs=ps.executeQuery(MovieDetails);
                        
                        String id="";
                        while(rs.next())
                        {
                            id=rs.getString("M_id");
                            MovieSelectedList.addElement("Movie Title: "+SelectedMovie);
                            MovieSelectedList.addElement("Movie Year: "+rs.getString("M_Year"));
                            MovieSelectedList.addElement("Average Rating: "+rs.getString("Rating"));
                            MovieSelectedList.addElement("Average Num Rating: "+rs.getString("Num_Rating"));
                        }
                        
                        MovieDetails = "SELECT MC.Country\nFROM Movie_Countries MC\nWHERE MC.M_id ='"+id+"'";
                        ps=con.prepareStatement(MovieDetails);
                        rs=ps.executeQuery(MovieDetails);
                        
                        while(rs.next())
                        {
                            MovieSelectedList.addElement("Movie Country:"+rs.getString("Country"));
                        }
                        
                        MovieDetails = "SELECT DISTINCT ML.Location_Country\nFROM Movie_Locations ML\nWHERE ML.M_id ='"+id+"'";
                        ps=con.prepareStatement(MovieDetails);
                        rs=ps.executeQuery(MovieDetails);
                        
                        while(rs.next())
                        {
                            MovieSelectedList.addElement("Movie Filming Location:"+rs.getString("Location_Country"));
                        }
                       
                        String GenreVal="Genres: ";
                        MovieDetails = "SELECT DISTINCT MG.Genre\nFROM Movie_Genres MG\nWHERE MG.M_id ='"+id+"'";
                        ps=con.prepareStatement(MovieDetails);
                        rs=ps.executeQuery(MovieDetails);
                        
                        while(rs.next())
                        {
                            GenreVal += rs.getString("Genre");
                            GenreVal += ", ";
                        }
                        
                        MovieSelectedList.addElement(GenreVal);
                         
                        MovieSelectedFromResultList.setModel(MovieSelectedList);
                    }
                    catch(Exception ex)
                    {
                        ex.printStackTrace();
                    }
                }
            });
            
            GenreAl.clear();
            GenreList.clearSelection();
            addCountryList.clear();
            addFilmLocList.clear();
            addMovieTagsList.clear();
            SelectedCountryList.clear();
            SelectedFilmLocList.clear();
            SelectedMovieTagsList.clear();
            
            ComboBoxRating.setSelectedIndex(0);
            tfRatingValue.setText("");
            ComboBoxNumRating.setSelectedIndex(0);
            tfNumRatingValue.setText("");
            tfMovieYearFrom.setText("");
            tfMovieYearTo.setText("");

           
            ComboBoxTagWeight.setSelectedIndex(0);
            tfTagWeightValue.setText("");
            
            FinalSubQuery="";
            FinalQuery="";
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_BExecuteQueryActionPerformed

    //Between Attributes AND OR
    private void ComboBoxAndOrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxAndOrActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_ComboBoxAndOrActionPerformed

    //Add Country
    private void BAddCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAddCountryActionPerformed
    
        if(GenreAl.size()!=0)
        {         
            String RetriveCountry = "";
            String BetweenAttribute = "";
        
            if(ComboBoxAndOr.getSelectedIndex()==0 || ComboBoxAndOr.getSelectedIndex()==1)
            {
               BetweenAttribute = "INTERSECT";
            }
            else
            {
                if(ComboBoxAndOr.getSelectedIndex()==2)
                {
                  BetweenAttribute = "UNION";
                }
            }
            //Genre Within attributes
            int i=0;
            for(i=0;i<GenreAl.size()-1;i++)
            {
                RetriveCountry += "SELECT MG.M_id\nFROM Movie_Genres MG\nWHERE MG.Genre = '"+GenreAl.get(i)+"'\n"+BetweenAttribute+"\n";
            }
            
            RetriveCountry += "SELECT MG.M_id\nFROM Movie_Genres MG\nWHERE MG.Genre = '"+GenreAl.get(i)+"'";
            
            String AddCountry = "";
          
            try
            {
                ps = con.prepareStatement(RetriveCountry);
                RetrivedGenreMid = ps.executeQuery(RetriveCountry);
                
                ResultSet rs1 = null;
                
                while(RetrivedGenreMid.next())
                {
                    AddCountry = "select MC.Country\nFROM Movie_Countries MC\nWHERE MC.M_id='"+RetrivedGenreMid.getString("M_id")+"'";
                   
                    ps=con.prepareStatement(AddCountry);
                    rs1 = ps.executeQuery(AddCountry);
                    
                    while(rs1.next())
                    {
                        if(!addCountryList.contains(rs1.getString("Country")))
                        {
                            addCountryList.addElement(rs1.getString("Country"));
                        }
                    }
                    ps.close();
                    rs1.close();
                }
                
                CountryList.setModel(addCountryList);
                RetrivedGenreMid.close();
                
          
        MouseListener mouseListener = new MouseAdapter() 
        {
            public void mouseClicked(MouseEvent e) 
	    {
               if (e.getClickCount() == 1)
               {
                 SelectedCountryList = (ArrayList<String>) CountryList.getSelectedValuesList();
               }
            }
        };
        CountryList.addMouseListener(mouseListener);
            
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_BAddCountryActionPerformed

    //Add Film Loc
    private void BAddFilmLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAddFilmLocActionPerformed
        
        if(GenreAl.size()!=0)
        {
            String RetriveFilmLoc = "";
             String BetweenAttribute = "";
        if(ComboBoxAndOr.getSelectedIndex()==0 || ComboBoxAndOr.getSelectedIndex()==1)
        {
            BetweenAttribute = "INTERSECT";
        }
        else
        {
            if(ComboBoxAndOr.getSelectedIndex()==2)
            {
                BetweenAttribute = "UNION";
            }
        }
            //Genre Within attributes
            int i=0;
            for(i=0;i<GenreAl.size()-1;i++)
            {
                RetriveFilmLoc += "SELECT MG.M_id\nFROM Movie_Genres MG\nWHERE MG.Genre = '"+GenreAl.get(i)+"'\n"+BetweenAttribute+"\n";
            }
            
            RetriveFilmLoc += "SELECT MG.M_id\nFROM Movie_Genres MG\nWHERE MG.Genre = '"+GenreAl.get(i)+"'";
            
            String AddFilmLoc = "";
          
            try
            {
                
                ps = con.prepareStatement(RetriveFilmLoc);
                RetrivedGenreMid = ps.executeQuery(RetriveFilmLoc);
                
                ResultSet rs1 = null;
                
                while(RetrivedGenreMid.next())
                {
                    AddFilmLoc = "SELECT DISTINCT ML.Location_Country\nFROM Movie_Locations ML\nWHERE ML.M_id='"+RetrivedGenreMid.getString("M_id")+"'";
                   
                    
                    ps=con.prepareStatement(AddFilmLoc);
                    rs1 = ps.executeQuery(AddFilmLoc);
                    
                    while(rs1.next())
                    {
                        if(!addFilmLocList.contains(rs1.getString("Location_Country")))
                        {
                            addFilmLocList.addElement(rs1.getString("Location_Country"));
                        }
                        
                    }
                    ps.close();
                    rs1.close();
                }
                FilmLocList.setModel(addFilmLocList);
                RetrivedGenreMid.close();
                
            MouseListener mouseListener = new MouseAdapter() 
    {
        public void mouseClicked(MouseEvent e) 
	{
               if (e.getClickCount() == 1)
	      {
                 SelectedFilmLocList = (ArrayList<String>) FilmLocList.getSelectedValuesList();
               }
        }
     };
             FilmLocList.addMouseListener(mouseListener);
                
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            } 
        }
    }//GEN-LAST:event_BAddFilmLocActionPerformed

    //Add MovieTag
    private void BAddMovieTagsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAddMovieTagsActionPerformed
        
        if(GenreAl.size()!=0)
        {
            String RetriveMovieTags = "";
             String BetweenAttribute = "";
        if(ComboBoxAndOr.getSelectedIndex()==0 || ComboBoxAndOr.getSelectedIndex()==1)
        {
            BetweenAttribute = "INTERSECT";
        }
        else
        {
            if(ComboBoxAndOr.getSelectedIndex()==2)
            {
                BetweenAttribute = "UNION";
            }
        }
                     
            //Genre Within attributes
            int i=0;
            for(i=0;i<GenreAl.size()-1;i++)
            {
                RetriveMovieTags += "SELECT MG.M_id\nFROM Movie_Genres MG\nWHERE MG.Genre = '"+GenreAl.get(i)+"'\n"+BetweenAttribute+"\n";
            }
            
            RetriveMovieTags += "SELECT MG.M_id\nFROM Movie_Genres MG\nWHERE MG.Genre = '"+GenreAl.get(i)+"'";
            
            String AddMovieTags = "";
          
            try
            {
               
                ps = con.prepareStatement(RetriveMovieTags);
                RetrivedGenreMid = ps.executeQuery(RetriveMovieTags);
                  
                ResultSet rs1 = null;
                
                while(RetrivedGenreMid.next())
                {
                    AddMovieTags = "SELECT DISTINCT T.Tag_Text\nFROM Movie_Tags MT, Tags T\nWHERE MT.Tag_id = T.Tag_id AND MT.M_id='"+RetrivedGenreMid.getString("M_id")+"'";
                   
                    ps=con.prepareStatement(AddMovieTags);
                    rs1 = ps.executeQuery(AddMovieTags);
                    
                    while(rs1.next())
                    {
                        if(!addMovieTagsList.contains(rs1.getString("Tag_Text")))
                        {
                            addMovieTagsList.addElement(rs1.getString("Tag_Text"));
                        }
                        
                    }
                    ps.close();
                    rs1.close();
                }
                MovieTagsList.setModel(addMovieTagsList);
                RetrivedGenreMid.close();
                
                
                 MouseListener mouseListener = new MouseAdapter() 
    {
        public void mouseClicked(MouseEvent e) 
	{
               if (e.getClickCount() == 1)
	      {
                 SelectedMovieTagsList = (ArrayList<String>) MovieTagsList.getSelectedValuesList();
               }
        }
     };
             MovieTagsList.addMouseListener(mouseListener);
                
               
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            } 
        }
    }//GEN-LAST:event_BAddMovieTagsActionPerformed

    private void tfMovieYearToActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfMovieYearToActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfMovieYearToActionPerformed

    private void ComboBoxTagWeightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxTagWeightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxTagWeightActionPerformed
     private void populateGenre() {
        
                   String GetGenre = "SELECT DISTINCT MG.Genre FROM Movie_Genres MG\n";
                    try {
                        ResultSet rs11 = null;
                        ps=con.prepareStatement(GetGenre);
                        rs11 = ps.executeQuery(GetGenre);

                        while(rs11.next())
                        {
                            if(!addGenreList.contains(rs11.getString("Genre")))
                            {
                                addGenreList.addElement(rs11.getString("Genre"));
                            }
                        }
                        ps.close();
                        rs11.close();
                    } catch(Exception ex) {
                        System.out.println(ex);
                    }
                    GenreList.setModel(addGenreList);
               
                  MouseListener mouseListener = new MouseAdapter() 
	 {
        public void mouseClicked(MouseEvent e) 
	    {
               if (e.getClickCount() == 1)
			   {
                 GenreAl = (ArrayList<String>) GenreList.getSelectedValuesList();
               }
        }
     };
 GenreList.addMouseListener(mouseListener);
                    
                }
    
    
    
    
    
    //Database Connection
    public static void connect() /*throws Exception*/
    {
        try
        {
            System.out.println("Connecting to Database...");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:orcl";
           
             con = DriverManager.getConnection(url,"Scott","tiger");
            
            if(con != null)
            {
                System.out.println("Connected to Database");
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    //Global Variables
    
    ArrayList<String> GenreAl = new ArrayList();
    static PreparedStatement ps = null;
    static Connection con = null;
    static ResultSet rs = null, RetrivedGenreMid = null;
    DefaultListModel addGenreList = new DefaultListModel();
    DefaultListModel addMovieTagsList = new DefaultListModel();
    DefaultListModel addFilmLocList = new DefaultListModel();
    DefaultListModel addCountryList = new DefaultListModel();
    
    ArrayList<String> SelectedCountryList =new ArrayList();
    ArrayList<String> SelectedFilmLocList =new ArrayList();
    ArrayList<String> SelectedMovieTagsList =new ArrayList();
    String FinalSubQuery = "";
    String FinalQuery = "";
     
    public static void main(String args[]) 
    {
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                new Temp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BAddCountry;
    private javax.swing.JButton BAddFilmLoc;
    private javax.swing.JButton BAddMovieTags;
    private javax.swing.JButton BExecuteQuery;
    private javax.swing.JComboBox<String> ComboBoxAndOr;
    private javax.swing.JComboBox ComboBoxNumRating;
    private javax.swing.JComboBox ComboBoxRating;
    private javax.swing.JComboBox<String> ComboBoxTagWeight;
    private javax.swing.JList<String> CountryList;
    private javax.swing.JPanel CountryPanel;
    private javax.swing.JScrollPane CountryScroll;
    private javax.swing.JList<String> FilmLocList;
    private javax.swing.JPanel FilmLocPanel;
    private javax.swing.JScrollPane FilmLocScroll;
    private javax.swing.JList<String> GenreList;
    private javax.swing.JScrollPane GenreScroll;
    private javax.swing.JList<String> MovieSelectedFromResultList;
    private javax.swing.JScrollPane MovieSelectedFromResultScroll;
    private javax.swing.JPanel MovieTagPanel;
    private javax.swing.JList<String> MovieTagsList;
    private javax.swing.JScrollPane MovieTagsListScroll;
    private javax.swing.JLabel MovieYearFromLabel;
    private javax.swing.JLabel MovieYearLabel;
    private javax.swing.JLabel MovieYearToLabel;
    private javax.swing.JLabel NumRatingLabel;
    private javax.swing.JLabel NumRatingValueLabel;
    private javax.swing.JScrollPane QueryScroll;
    private javax.swing.JLabel RatingLabel;
    private javax.swing.JLabel RatingValueLabel;
    private javax.swing.JLabel ResultLabel;
    private javax.swing.JList<String> ResultList;
    private javax.swing.JScrollPane ResultScroll;
    private javax.swing.JLabel TagWeightLabel;
    private javax.swing.JLabel TagWeightValueLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea taQuery;
    private javax.swing.JTextField tfCountry;
    private javax.swing.JTextField tfFilmLoc;
    private javax.swing.JTextField tfGenre;
    private javax.swing.JTextField tfMovieYearFrom;
    private javax.swing.JTextField tfMovieYearTo;
    private javax.swing.JTextField tfMovies;
    private javax.swing.JTextField tfNumRatingValue;
    private javax.swing.JTextField tfRating;
    private javax.swing.JTextField tfRatingValue;
    private javax.swing.JTextField tfTagWeightValue;
    private javax.swing.JTextField tfUserTag;
    // End of variables declaration//GEN-END:variables
   
}

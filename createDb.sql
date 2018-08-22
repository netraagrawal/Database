create table Movie(
Mid varchar2(50) Primary Key,
title varchar2(200),
Myear NUMBER,
rtAudienceRating NUMBER,
rtAudienceNumRatings NUMBER
);

create table Tags(
Tid varchar2(50) primary key,
Tvalue varchar2(50)
);

create table Movie_Countries(
Mid varchar2(50),
country varchar(50),
foreign key (Mid) REFERENCES  Movie(Mid)
on DELETE cascade
);

create table Movie_genres(
Mid varchar2(50),
genres varchar2(50),
foreign key (Mid) References Movie(Mid)
on DELETE cascade
);

create table Movie_Directors(
Mid varchar2(50),
DirectorId varchar(100),
DirectorName varchar2(100),
foreign key (Mid) references Movie(Mid)
on DELETE cascade
);

create table Movie_Actor(
Mid varchar2(50),
actorId varchar2(100),
actorName varchar2(100),
ranking number,
foreign key (Mid) references Movie(Mid)
on DELETE cascade
);


create table Movie_tags(
Mid VARCHAR2(50),
Tid varchar2(50),
tagWeight number,
foreign key (Mid) references Movie(Mid),
foreign key (Tid) references Tags(Tid)
on DELETE cascade
);

create table User_taggedmovies(
userId varchar2(50),
Mid varchar2(50),
Tid Varchar2(50),
date_day integer,
date_month integer,
date_year integer,
foreign key (Mid) references Movie(Mid),
foreign key (Tid) references Tags(Tid)
on DELETE cascade
);

commit;


create index indexmovieid on movies(movieid);
create index indexgenre on movie_genres(genre);
create index indexcountry on movie_countries(country);
create index indexactor on movie_actors(actorname);
create index indexdirector on movie_directors(directorname);
create index indextag on tags(tagid);
create index indexuser on user_taggedmovies(userid);

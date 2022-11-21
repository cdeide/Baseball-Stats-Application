/****************************************************************************
* NAME: Connor Deide
* CLASS: CPSC 321 Section 2
* DATE: 11/22/22
* HOMEWORK: HW6
* DESCRIPTION: This file consists of INSERT INTO statements. These statements
* fill the tables created in db_tables.sql with data that can be used for the
* MyBaseballStats application.
****************************************************************************/

-- Inserting 6 teams into the Team table
INSERT INTO Team VALUES
    ("Seattle Mariners", "0C2C56", "005C5C", "Scott Servais", 1977,
    "The M's", "T-Mobile Park", 0, 0, 3,
    "Based in Seattle, the Mariners compete in the American League West Division. 
    The Mariners name originates from the prominence of marine culture in the city of Seattle. 
    They are nicknamed the M's, a title featured in their primary logo from 1987 to 1992. 
    They adopted their current team colors – navy blue, northwest green (teal), and silver 
    – prior to the 1993 season, after having been royal blue and gold since the team's inception. 
    Their mascot is the Mariner Moose."),
    ("Houston Astros", "002D62", "EB6E1F", "Dusty Baker", 1962,
    "The 'Stros", "Minute Maid Park", 2, 4, 10,
    "Based in Houston, the Astros compete in the American League West Division. They moved to this 
    division in 2013 after playing their first 51 seasons in the National League. They are the only 
    team to win a postseason series in six straight seasons.  In addition to having the most 
    postseason appearances by an expansion team, they are the only expansion era team with an 
    all-time winning record."),
    ("New York Yankees", "FFFFFF", "132448", "Aaron Boone", 1901,
    "The Bronx Bombers", "Yankee Stadium", 27, 40, 19,
    "Based in New York, The Yankees compete in the American League East Division. 
    Arguably the most successful professional sports team in the United States and one of the most 
    highly regarded, the team has won more titles than any other franchise in the four major North 
    American sports leagues. The team has garnered enormous popularity and a dedicated fanbase, 
    as well as widespread enmity from fans of other MLB teams. The team's rivalry with the Boston 
    Red Sox is one of the most well-known rivalries in North American sports."),
    ("Los Angeles Dodgers", "005A9C", "EF3E42", "Dave Roberts", 1883,
    "The Blue Crew", "Dodger Stadium", 7, 21, 28,
    "Based in Los Angeles, the Dodgers compete in the National League West Division. They were 
    originally formed in 1883 as a member of the Inter-State Association of Proffesional Baseball 
    Clubs and did not move into the National League until 1890. The club was also originally 
    located in Brooklyn and took on a slew of names before 'The Dodgers' eventually stuck."),
    ("Toronto Blue Jays", "134A8E", "E8291C", "John Schneider", 1977,
    "The Jays", "Rodgers Centre", 2, 2, 7,
    "Based in Toronto, the Blue Jays compete in the American League East Division. 
    The name 'Blue Jays' originates from the bird of the same name, and blue is also the traditional 
    color of Toronto's collegiate and professional sports teams including the Maple Leafs 
    (ice hockey) and the Argonauts (Canadian football).  They are the second MLB franchise 
    to be based outside the United States, and currently the only team based outside the U.S. 
    after the first Canadian franchise, the Montreal Expos, became the Washington Nationals in 2005."),
    ("San Diego Padres", "2F241D", "FFC425", "Bob Melvin", 1969,
    "The Friars", "Petco Park", 0, 2, 3,
    "Based in San Diego, the Padres compete in the National League West Division. 
    On August 20, 2020, the Padres became the first team in MLB history to hit a grand slam in four 
    consecutive games earning the nickname, 'Slam Diego Padres'. Until 2021, the Padres were the last 
    team in MLB that had yet to throw a no-hitter. The record was broken on April 9, 2021, as 
    Joe Musgrove accomplished the feat against the Texas Rangers.");

-- Insert 10 users into the User table
INSERT INTO User VALUES
    ("c_deide", "123456789", "Seattle Mariners"),
    ("r_harman", "2gh487gh4", "New York Yankees"),
    ("ron_swanson", "47dh47fs3", "Seattle Mariners"),
    ();
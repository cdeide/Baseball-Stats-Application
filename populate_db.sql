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

-- Insert 25 users into the User table
INSERT INTO User VALUES
    ("c_deide", "123456789", "Seattle Mariners"),
    ("r_harman", "2gh487gh4", "New York Yankees"),
    ("ron_swanson", "47dh47fs3", "Seattle Mariners"),
    ("jason_flow", "489079fg49", "Houston Astros"),
    ("todd_jacobs", "357gheg9!v", "San Diego Padres"),
    ("paty_hull", "839fv79z99", "Toronto Blue Jays"),
    ("k_avery_56", "sdvgui46h3D", "Los Angeles Dodgers"),
    ("peteBradley_e", "v478ffuhv4", "Los Angeles Dodgers"),
    ("FloydDudley", "fsiu546ior5", "Houston Astros"),
    ("JodyKeenan", "fh56rainier48", "Seattle Mariners"),
    ("Robert_baird", "f9065vdgee4", "Toronto Blue Jays"),
    ("viv_wiley", "vuih466io8", "New York Yankees"),
    ("robynSutton", "38yb6v6asd", "New York Yankees"),
    ("ReneWalters", "vhjgs80652c", "San Diego Padres"),
    ("ClintEastwood", "dgfv596vgq2", "Los Angeles Dodgers"),
    ("Rick_newman", "fh67f8d6b4@", "Toronto Blue Jays"),
    ("him", "himothyhimhim", "Seattle Mariners"),
    ("PaulineFreeman", "fseh5487fd2", "Houston Astros"),
    ("LyleBrady", "fgvui3765ds", "Houston Astros"),
    ("p_hamilton", "f897vcsyh3", "Seattle Mariners"),
    ("jp_crawford", "Fgy74fh3c", "Seattle Mariners"),
    ("JesseWinker", "fsusgh596!f", "San Diego Padres"),
    ("Mitchell_cman", "cman1345fdh!", "Toronto Blue Jays"),
    ("Carmen_brash", "fg8467f23g", "Los Angeles Dodgers"),
    ("p_diddy", "vciuhg67g2!", "New York Yankees"),
    ("mike_thomas", "fgue24fey65", "Seattle Mariners");

-- Insert position players into the Player table
INSERT INTO Player VALUES
    -- Mariners position players
    (1, "Julio", "Rodriguez", "Dominican", "CF", 44, 21, "R", "R", 228, "6-3", -- Player Info
    132, 511, 84, 145, 75, 28, 25, 56, 40, 145, .284, .345, .509, .853), -- Player Stats
    (2, "Ty", "France", "American", "1B", 23, 28, "R", "R", 215, "5-11", 
    140, 551, 65, 151, 83, 20, 0, 48, 35, 94, .274, .338, .436, .785),
    (3, "Jesse", "Winker", "American", "LF" , 27, 29, "L", "L", 215, "6-3",
    136, 456, 51, 100, 53, 14, 0, 29, 84, 103, .219, .344, .344, .688),
    (4, "Mitch", "Haniger", "American", "RF", 17, 31, "R", "R", 214, "6-2",
    57, 224, 31, 55, 34, 11, 0, 19, 20, 65, .246, .308, .429, .737),
    (5, "Eugenio", "Suarez", "Venezuelan", "3B", 28, 31, "R", "R", 213, "5-11",
    150, 543, 76, 128, 84, 31, 0, 57, 73, 196, .236, .332, .459, .791),
    (6, "J.P.", "Crawford", "American", "SS", 3, 27, "L", "R", 202, "6-2",
    145, 518, 57, 126, 42, 6, 3, 33, 68, 80, .243, .339, .336, .675),
    (7, "Adam", "Frazier", "American", "2B", 26, 30, "L", "R", 181, "5-10",
    156, 541, 61, 129, 42, 3, 11, 29, 46, 73, .238, .301, .311, .612),
    (8, "Cal", "Raleigh", "American", "C", 29, 25, "S", "R", 235, "6-3",
    119, 370, 46, 78, 63, 27, 1, 48, 38, 122, .211, .284, .489, .773),
    -- Astros position players
    (9, "Yordan", "Alvarez", "Cuban", "LF", 44, 25, "L", "R", 225, "6-5",
    135, 470, 95, 144, 97, 37, 1, 68, 78, 106, .306, .406, .613, 1.019),
    (10, "Alex", "Bregman", "American", "3B", 2, 28, "R", "R", 192, "6-0",
    155, 548, 93, 142, 93, 23, 1, 61, 87, 77, .259, .366, .454, .820),
    (11, "Kyle", "Tucker", "American", "RF", 30, 25, "L", "R", 199, "6-4",
    150, 544, 71, 140, 107, 30, 25, 59, 59, 95, .257, .330, .478, .808),
    (12, "Jose", "Altuve", "Venezuelan", "2B", 27, 32, "R", "R", 166, "5-6",
    141, 527, 103, 158, 57, 28, 18, 67, 66, 87, .300, .387, .533, .920),
    (13, "Chas", "McCormick", "American", "CF", 20, 27, "R", "L", 208, "6-0",
    119, 359, 47, 88, 44, 14, 4, 28, 46, 106, .245, .332, .407, .739),
    (14, "Jeremy", "Pena", "Dominican", "SS", 3, 25, "R", "R", 202, "6-0",
    136, 521, 72, 132, 63, 22, 11, 44, 22, 135, .253, .289, .426, .715),
    (15, "Martin", "Maldonado", "Puerto Rican", "C", 15, 36, "R", "R", 230, "6-0",
    113, 344, 40, 64, 45, 15, 0, 27, 22, 116, .186, .248, .352, .600),
    (16, "Yuli", "Gurriel", "Cuban", "1B", 10, 38, "R", "R", 215, "6-0",
    146, 545, 53, 132, 53, 8, 8, 48, 30, 73, .242, .288, .360, .648),
    -- Yankees position players
    (17, "Gleyber", "Torres", "Venezuelan", "2B", 25, 25, "R", "R", 205, "6-1",
    140, 526, 73, 135, 76, 24, 10, 53, 39, 129, .257, .310, .451, .761),
    (18, "Giancarlo", "Stanton", "American", "OF", 27, 33, "R", "R", 245, "6-6",
    110, 398, 53, 84, 78, 31, 0, 38, 50, 137, .211, .297, .462, .759),
    (19, "Aaron", "Hicks", "American", "CF", 31, 33, "S", "R", 205, "6-1",
    130, 384, 54, 83, 40, 8, 10, 19, 62, 109, .216, .330, .313, .643),
    (20, "Anthony", "Rizzo", "American", "1B", 48, 33, "L", "L", 240, "6-3",
    130, 465, 77, 104, 75, 32, 6, 54, 58, 101, .224, .338, .480, .818),
    (21, "Isiah", "Kiner-Falefa", "American", "SS", 12, 27, "R", "R", 190, "5-11",
    142, 483, 66, 126, 48, 4, 22, 24, 35, 72, .261, .314, .327, .641),
    (22, "DJ", "LeMahieu", "American", "3B", 26, 34, "R", "R", 220, "6-4",
    125, 467, 74, 122, 46, 12, 4, 30, 67, 71, .261, .357, .377, .734),
    (23, "Jose", "Trevino", "American", "C", 39, 29, "R", "R", 215, "5-10",
    115, 335, 39, 83, 43, 11, 2, 24, 15, 62, .248, .283, .388, .671),
    (24, "Aaron", "Judge", "American", "RF", 99, 30, "R", "R", 282, "6-7",
    157, 570, 133, 177, 131, 62, 16, 90, 111, 175, .311, .425, .686, 1.111),
    -- Dodgers position players
    (25, "Mookie", "Betts", "American", "RF", 50, 30, "R", "R", 180, "5-9",
    142, 572, 117, 154, 82, 35, 12, 78, 55, 104, .269, .340, .533, .873),
    (26, "Freddie", "Freeman", "American", "1B", 5, 33, "L", "R", 220, "6-5",
    159, 612, 117, 199, 100, 21, 13, 70, 84, 102, .325, .407, .511, .918),
    (27, "Gavin", "Lux", "American", "2B", 9, 24, "L", "R", 190, "6-2",
    129, 421, 66, 116, 42, 6, 7, 33, 47, 95, .276, .346, .399, .745),
    (28, "Max", "Muncy", "American", "3B", 13, 32, "L", "R", 215, "6-0",
    136, 464, 69, 91, 69, 21, 2, 44, 90, 141, .196, .329, .384, .713),
    (29, "Trea", "Turner", "American", "SS", 6, 29, "R", "R", 185, "6-2",
    160, 652, 101, 194, 100, 21, 27, 64, 45, 131, .298, .348, .466, .809),
    (30, "Chris", "Taylor", "American", "LF", 3, 32, "R", "R", 196, "6-1",
    118, 402, 45, 89, 43, 10, 10, 38, 44, 160, .221, .304, .373, .677),
    (31, "Cody", "Bellinger", "American", "CF", 35, 27, "L", "L", 203, "6-4",
    144, 504, 70, 106, 68, 19, 14, 49, 38, 150, .210, .265, .389, .654),
    (32, "Will", "Smith", "American", "C", 16, 27, "R", "R", 195, "5-10",
    137, 508, 68, 132, 87, 24, 1, 53, 56, 96, .260, .343, .465, .808),
    -- Blue Jays position players
    (33, "Bo", "Bichette", "American", "SS", 11, 24, "R", "R", 190, "6-0",
    159, 652, 91, 189, 93, 24, 13, 68, 41, 155, .290, .333, .469, .802),
    (34, "Matt", "Chapman", "American", "3B", 26, 29, "R", "R", 215, "6-0",
    155, 538, 83, 123, 76, 27, 2, 55, 68, 170, .229, .324, .433, .757),
    (35, "Vladimir", "Guerrero", "Canadian", "1B", 27, 23, "R", "R", 240, "6-2",
    160, 638, 90, 175, 97, 32, 8, 67, 58, 116, .274, .339, .480, .819),
    (36, "Santiago", "Espinal", "Dominican", "2B", 5, 28, "R", "R", 187, "5-10",
    135, 449, 51, 120, 51, 7, 6, 32, 36, 68, .267, .322, .370, .692),
    (37, "Alejandro", "Kirk", "Mexican", "C", 30, 24, "R", "R", 245, "5-8",
    139, 470, 59, 134, 63, 14, 0, 33, 63, 58, .285, .372, .415, .787),
    (38, "George", "Springer", "American", "CF", 4, 33, "R", "R", 220, "6-3",
    133, 513, 89, 137, 76, 25, 14, 51, 54, 100, .267, .342, .472, .814),
    (39, "Whit", "Merrifield", "American", "LF", 15, 33, "R", "R", 195, "6-1",
    139, 504, 70, 126, 58, 11, 16, 40, 38, 85, .250, .298, .375, .673),
    (40, "Teoscar", "Hernandez", "Dominican", "RF", 37, 30, "R", "R", 215, "6-2",
    131, 499, 71, 133, 77, 25, 6, 61, 34, 152, .267, .316, .491, .807),
    -- Padres position players
    (41, "Juan", "Soto", "Dominican", "RF", 22, 24, "L", "L", 224, "6-2",
    153, 524, 93, 127, 62, 27, 6, 54, 135, 96, .242, .401, .452, .853),
    (42, "Trent", "Grisham", "American", "CF", 2, 26, "L", "L", 224, "5-11",
    152, 451, 58, 83, 53, 17, 7, 35, 57, 150, .184, .284, .341, .625),
    (43, "Jurickson", "Profar", "Curacaon", "LF", 10, 29, "S", "R", 184, "6-0",
    152, 575, 82, 140, 58, 15, 5, 53, 73, 103, .243, .331, .391, .722),
    (44, "Austin", "Nola", "American", "C", 26, 32, "R", "R", 197, "6-0",
    110, 347, 40, 87, 40, 4, 2, 19, 34, 60, .251, .321, .329, .650),
    (45, "Manny", "Machado", "American", "3B", 13, 30, "R", "R", 218, "6-3",
    150, 578, 100, 172, 102, 32, 9, 70, 63, 133, .298, .366, .531, .897),
    (46, "Ha-Seong", "kim", "South Korean", "SS", 7, 27, "R", "R", 168, "5-9",
    150, 517, 58, 130, 59, 11, 12, 43, 51, 100, .251, .325, .383, .708),
    (47, "Jake", "Cronenworth", "American", "2B", 9, 28, "L", "R", 187, "6-0",
    158, 587, 88, 140, 88, 17, 3, 51, 70, 131, .239, .332, .390, .722),
    (48, "Eric", "Hosmer", "American", "1B", 35, 33, "L", "L", 226, "6-4",
    104, 380, 38, 102, 44, 8, 0, 27, 37, 64, .268, .334, .382, .716);

-- Insert rosters corresponding to a team and a player into the Roster table
INSERT INTO Roster VALUES
    -- Mariners roster
    ("Seattle Mariners", 1),
    ("Seattle Mariners", 2),
    ("Seattle Mariners", 3),
    ("Seattle Mariners", 4),
    ("Seattle Mariners", 5),
    ("Seattle Mariners", 6),
    ("Seattle Mariners", 7),
    ("Seattle Mariners", 8),
    -- Astros roster
    ("Houston Astros", 9),
    ("Houston Astros", 10),
    ("Houston Astros", 11),
    ("Houston Astros", 12),
    ("Houston Astros", 13),
    ("Houston Astros", 14),
    ("Houston Astros", 15),
    ("Houston Astros", 16),
    -- Yankees roster
    ("New York Yankees", 17),
    ("New York Yankees", 18),
    ("New York Yankees", 19),
    ("New York Yankees", 20),
    ("New York Yankees", 21),
    ("New York Yankees", 22),
    ("New York Yankees", 23),
    ("New York Yankees", 24),
    -- Dodgers roster
    ("Los Angeles Dodgers", 25),
    ("Los Angeles Dodgers", 26),
    ("Los Angeles Dodgers", 27),
    ("Los Angeles Dodgers", 28),
    ("Los Angeles Dodgers", 29),
    ("Los Angeles Dodgers", 30),
    ("Los Angeles Dodgers", 31),
    ("Los Angeles Dodgers", 32),
    -- Blue Jays roster
    ("Toronto Blue Jays", 33),
    ("Toronto Blue Jays", 34),
    ("Toronto Blue Jays", 35),
    ("Toronto Blue Jays", 36),
    ("Toronto Blue Jays", 37),
    ("Toronto Blue Jays", 38),
    ("Toronto Blue Jays", 39),
    ("Toronto Blue Jays", 40),
    -- Padres roster
    ("San Diego Padres", 41),
    ("San Diego Padres", 42),
    ("San Diego Padres", 43),
    ("San Diego Padres", 44),
    ("San Diego Padres", 45),
    ("San Diego Padres", 46),
    ("San Diego Padres", 47),
    ("San Diego Padres", 48);

-- Insert watchlists corresponding to users and players into the Watchlist table
INSERT INTO Watchlist VALUES
    ("c_deide", 1),
    ("c_deide", 2),
    ("c_deide", 3),
    ("c_deide", 4),
    ("c_deide", 5),
    ("c_deide", 6),
    ("c_deide", 7),
    ("c_deide", 8),
    ("Mitchell_cman", 34),
    ("Mitchell_cman", 23),
    ("Mitchell_cman", 12),
    ("Mitchell_cman", 5),
    ("r_harman", 23),
    ("mike_thomas", 3),
    ("mike_thomas", 33),
    ("mike_thomas", 42),
    ("mike_thomas", 34);
/****************************************************************************
* NAME: Connor Deide
* CLASS: CPSC 321 Section 2
* DATE: 11/22/22
* HOMEWORK: HW6
* DESCRIPTION: This file consists of CREATE TABLE statements. These statements
* create the relational schema for my final project. It consists of 5 seperate
* relational tables.
****************************************************************************/

-- Drop table statements
DROP TABLE IF EXISTS Watchlist;
DROP TABLE IF EXISTS Roster;
DROP TABLE IF EXISTS Player;
DROP TABLE IF EXISTS User;
DROP TABLE IF EXISTS Team;

-- Create Team table
CREATE TABLE Team (
    name VARCHAR(20),
    prime_color CHAR(7) NOT NULL,
    sec_color CHAR(7) NOT NULL,
    manager VARCHAR(30) NOT NULL,
    founded YEAR NOT NULL,
    nickname VARCHAR(20) NOT NULL,
    ballpark VARCHAR(30) NOT NULL,
    world_series_titles INT NOT NULL,
    pennant_titles INT NOT NULL,
    division_titles INT NOT NULL,
    description TEXT NOT NULL,

    PRIMARY KEY (name)
);

-- Create User table
CREATE TABLE User (
    user_name VARCHAR(20),
    password VARCHAR(20) NOT NULL,
    fav_team VARCHAR(20) NOT NULL,

    PRIMARY KEY (user_name),
    FOREIGN KEY (fav_team)
        REFERENCES Team(name)
);

-- Create Player table
CREATE TABLE Player (
    player_id INT,
    -- Player info
    first_name CHAR(15) NOT NULL,
    last_name CHAR(15) NOT NULL,
    ethnicity CHAR(15) NOT NULL,
    position CHAR(15) NOT NULL,
    number INT NOT NULL,
    age INT NOT NULL,
    bats CHAR(1) NOT NULL,
    throws CHAR(1) NOT NULL,
    weight INT NOT NULL,
    height VARCHAR(10),
    -- Stats
    games INT NOT NULL,
    at_bats INT NOT NULL,
    runs INT NOT NULL,
    hits INT NOT NULL,
    home_runs INT NOT NULL,
    stolen_bases INT NOT NULL,
    extra_base_hits INT NOT NULL,
    base_on_balls INT NOT NULL,
    strike_outs INT NOT NULL,
    average FLOAT NOT NULL,
    on_base_perc FLOAT NOT NULL,
    slugging FLOAT NOT NULL,
    ops FLOAT NOT NULL,

    PRIMARY KEY (player_id)
);

-- Create Roster table
CREATE TABLE Roster (
    team VARCHAR(20),
    player INT,

    PRIMARY KEY (team, player),
    FOREIGN KEY (team)
        REFERENCES Team(name),
    FOREIGN KEY (player)
        REFERENCES Player(player_id)
);

-- Create Watchlist table
CREATE TABLE Watchlist (
    user VARCHAR(20),
    player INT,

    PRIMARY KEY (user, player),
    FOREIGN KEY (user)
        REFERENCES User(user_name),
    FOREIGN KEY (player)
        REFERENCES Player(player_id)
);
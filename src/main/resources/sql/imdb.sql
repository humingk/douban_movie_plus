/*
imdb 调整

=========================================================================================================
演员表

CREATE TABLE `name_basics` (
  `deathYear` int(11) DEFAULT NULL,
  `s_soundex` varchar(5) DEFAULT NULL,
  `birthYear` int(11) DEFAULT NULL,
  `nconst` int(11) DEFAULT NULL,
  `sn_soundex` varchar(5) DEFAULT NULL,
  `knownForTitles` text,
  `primaryName` text,
  `primaryProfession` text,
  `ns_soundex` varchar(5) DEFAULT NULL,
  KEY `ix_name_basics_nconst` (`nconst`),
  KEY `ix_name_basics_deathYear` (`deathYear`),
  KEY `ix_name_basics_birthYear` (`birthYear`),
  KEY `ix_name_basics_ns_soundex` (`ns_soundex`),
  KEY `ix_name_basics_s_soundex` (`s_soundex`),
  KEY `ix_name_basics_sn_soundex` (`sn_soundex`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

+-------------------+------------+--------+-------+-----------+---------+
| Field             | Type       | Null   | Key   |   Default | Extra   |
|-------------------+------------+--------+-------+-----------+---------|
| deathYear         | int(11)    | YES    | MUL   |    <null> |         |
| s_soundex         | varchar(5) | YES    | MUL   |    <null> |         |
| birthYear         | int(11)    | YES    | MUL   |    <null> |         |
| nconst            | int(11)    | NO     | PRI   |    <null> |         |
| sn_soundex        | varchar(5) | YES    | MUL   |    <null> |         |
| knownForTitles    | text       | YES    |       |    <null> |         |
| primaryName       | text       | YES    |       |    <null> |         |
| primaryProfession | text       | YES    |       |    <null> |         |
| ns_soundex        | varchar(5) | YES    | MUL   |    <null> |         |
+-------------------+------------+--------+-------+-----------+---------+

eg:

***************************[ 1. row ]***************************
deathYear         | None
s_soundex         | A535
birthYear         | None
nconst            | 31213
sn_soundex        | A5356
knownForTitles    | 0085546
primaryName       | Mark Anton
primaryProfession | actor,miscellaneous
ns_soundex        | M6253
***************************[ 2. row ]***************************
deathYear         | None
s_soundex         | A535
birthYear         | 1964
nconst            | 31214
sn_soundex        | A5353
knownForTitles    | 0065272,0078111,0075679,0066822
primaryName       | Matthew Anton
primaryProfession | actor
ns_soundex        | M3535
***************************[ 3. row ]***************************
deathYear         | None
s_soundex         | A535
birthYear         | None
nconst            | 31215
sn_soundex        | A5354
knownForTitles    | 0152379,0146000,0124575,0185916
primaryName       | Melanie Anton
primaryProfession | actress
ns_soundex        | M4535

=========================================================================================================

CREATE TABLE `title_akas` (
  `region` varchar(5) DEFAULT NULL,
  `language` varchar(5) DEFAULT NULL,
  `attributes` varchar(127) DEFAULT NULL,
  `titleId` int(11) DEFAULT NULL,
  `isOriginalTitle` tinyint(1) DEFAULT NULL,
  `title` text,
  `t_soundex` varchar(5) DEFAULT NULL,
  `ordering` int(11) DEFAULT NULL,
  `types` varchar(31) DEFAULT NULL,
  KEY `ix_title_akas_t_soundex` (`t_soundex`),
  KEY `ix_title_akas_region` (`region`),
  KEY `ix_title_akas_types` (`types`),
  KEY `ix_title_akas_isOriginalTitle` (`isOriginalTitle`),
  KEY `ix_title_akas_language` (`language`),
  KEY `ix_title_akas_titleId` (`titleId`),
  CONSTRAINT `title_akas_chk_1` CHECK ((`isOriginalTitle` in (0,1)))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

alter:
alter



+-----------------+--------------+--------+-------+-----------+---------+
| Field           | Type         | Null   | Key   |   Default | Extra   |
|-----------------+--------------+--------+-------+-----------+---------|
| region          | varchar(5)   | YES    | MUL   |    <null> |         |
| language        | varchar(5)   | YES    | MUL   |    <null> |         |
| attributes      | varchar(127) | YES    |       |    <null> |         |
| titleId         | int(11)      | YES    | MUL   |    <null> |         |
| isOriginalTitle | tinyint(1)   | YES    | MUL   |    <null> |         |
| title           | text         | YES    |       |    <null> |         |
| t_soundex       | varchar(5)   | YES    | MUL   |    <null> |         |
| ordering        | int(11)      | YES    |       |    <null> |         |
| types           | varchar(31)  | YES    | MUL   |    <null> |         |
+-----------------+--------------+--------+-------+-----------+---------+

eg:
***************************[ 1. row ]***************************
region          | US
language        | None
attributes      | None
titleId         | 12403
isOriginalTitle | 0
title           | Lonely Heart
t_soundex       | L5463
ordering        | 1
types           | None
***************************[ 2. row ]***************************
region          | None
language        | None
attributes      | None
titleId         | 12404
isOriginalTitle | 1
title           | The Lost Romance
t_soundex       | L2365
ordering        | 1
types           | original
***************************[ 3. row ]***************************
region          | US
language        | None
attributes      | None
titleId         | 12404
isOriginalTitle | 0
title           | The Lost Romance
t_soundex       | L2365
ordering        | 2
types           | None
***************************[ 4. row ]***************************
region          | FR
language        | None
attributes      | None
titleId         | 12404
isOriginalTitle | 0
title           | Romance d'autrefois
t_soundex       | R5236
ordering        | 3
types           | imdbDisplay



=========================================================================================================
CREATE TABLE `title_basics` (
  `startYear` int(11) DEFAULT NULL,
  `endYear` int(11) DEFAULT NULL,
  `tconst` int(11) DEFAULT NULL,
  `primaryTitle` text,
  `originalTitle` text,
  `runtimeMinutes` int(11) DEFAULT NULL,
  `titleType` varchar(16) DEFAULT NULL,
  `isAdult` tinyint(1) DEFAULT NULL,
  `genres` text,
  `t_soundex` varchar(5) DEFAULT NULL,
  KEY `ix_title_basics_startYear` (`startYear`),
  KEY `ix_title_basics_titleType` (`titleType`),
  KEY `ix_title_basics_runtimeMinutes` (`runtimeMinutes`),
  KEY `ix_title_basics_isAdult` (`isAdult`),
  KEY `ix_title_basics_tconst` (`tconst`),
  KEY `ix_title_basics_t_soundex` (`t_soundex`),
  CONSTRAINT `title_basics_chk_1` CHECK ((`isAdult` in (0,1)))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

+----------------+-------------+--------+-------+-----------+---------+
| Field          | Type        | Null   | Key   |   Default | Extra   |
|----------------+-------------+--------+-------+-----------+---------|
| startYear      | int(11)     | YES    | MUL   |    <null> |         |
| endYear        | int(11)     | YES    |       |    <null> |         |
| tconst         | int(11)     | YES    | MUL   |    <null> |         |
| primaryTitle   | text        | YES    |       |    <null> |         |
| originalTitle  | text        | YES    |       |    <null> |         |
| runtimeMinutes | int(11)     | YES    | MUL   |    <null> |         |
| titleType      | varchar(16) | YES    | MUL   |    <null> |         |
| isAdult        | tinyint(1)  | YES    | MUL   |    <null> |         |
| genres         | text        | YES    |       |    <null> |         |
| t_soundex      | varchar(5)  | YES    | MUL   |    <null> |         |
+----------------+-------------+--------+-------+-----------+---------+

eg:
***************************[ 1. row ]***************************
startYear      | 1938
endYear        | None
tconst         | 30522
primaryTitle   | Olympia Part One: Festival of the Nations
originalTitle  | Olympia 1. Teil - Fest der Völker
runtimeMinutes | 121
titleType      | movie
isAdult        | 0
genres         | Documentary,Sport
t_soundex      | O4516
***************************[ 2. row ]***************************
startYear      | 1938
endYear        | None
tconst         | 30523
primaryTitle   | Olympia Part Two: Festival of Beauty
originalTitle  | Olympia 2. Teil - Fest der Schönheit
runtimeMinutes | 96
titleType      | movie
isAdult        | 0
genres         | Documentary,Sport
t_soundex      | O4516
***************************[ 3. row ]***************************
startYear      | 1938
endYear        | None
tconst         | 30524
primaryTitle   | On with the New
originalTitle  | On with the New
runtimeMinutes | 7
titleType      | short
isAdult        | 0
genres         | Animation,Comedy,Family
t_soundex      | O535
***************************[ 4. row ]***************************
startYear      | 1938
endYear        | None
tconst         | 30525
primaryTitle   | Once Over Lightly
originalTitle  | Once Over Lightly
runtimeMinutes | 19
titleType      | short
isAdult        | 0
genres         | Comedy,Musical,Short
t_soundex      | O5216


=========================================================================================================

CREATE TABLE `title_crew` (
  `directors` text,
  `tconst` int(11) DEFAULT NULL,
  `writers` text,
  KEY `ix_title_crew_tconst` (`tconst`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

+-----------+---------+--------+-------+-----------+---------+
| Field     | Type    | Null   | Key   |   Default | Extra   |
|-----------+---------+--------+-------+-----------+---------|
| directors | text    | YES    |       |    <null> |         |
| tconst    | int(11) | YES    | MUL   |    <null> |         |
| writers   | text    | YES    |       |    <null> |         |
+-----------+---------+--------+-------+-----------+---------+

eg:
***************************[ 1. row ]***************************
directors | 0726166
tconst    | 30522
writers   | 0726166
***************************[ 2. row ]***************************
directors | 0726166
tconst    | 30523
writers   | 0726166
***************************[ 3. row ]***************************
directors | 0281487
tconst    | 30524
writers   | None
***************************[ 4. row ]***************************
directors | 0419282
tconst    | 30525
writers   | 0326371,0419282,0338876,0363519,0317970
***************************[ 5. row ]***************************
directors | 0285946
tconst    | 30526
writers   | 0067676,0128332,0867992


=========================================================================================================

CREATE TABLE `title_episode` (
  `episodeNumber` int(11) DEFAULT NULL,
  `parentTconst` int(11) DEFAULT NULL,
  `tconst` int(11) DEFAULT NULL,
  `seasonNumber` int(11) DEFAULT NULL,
  KEY `ix_title_episode_parentTconst` (`parentTconst`),
  KEY `ix_title_episode_tconst` (`tconst`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

+---------------+---------+--------+-------+-----------+---------+
| Field         | Type    | Null   | Key   |   Default | Extra   |
|---------------+---------+--------+-------+-----------+---------|
| episodeNumber | int(11) | YES    |       |    <null> |         |
| parentTconst  | int(11) | YES    | MUL   |    <null> |         |
| tconst        | int(11) | YES    | MUL   |    <null> |         |
| seasonNumber  | int(11) | YES    |       |    <null> |         |
+---------------+---------+--------+-------+-----------+---------+

eg:
***************************[ 1. row ]***************************
episodeNumber | 4
parentTconst  | 398417
tconst        | 519678
seasonNumber  | 2
***************************[ 2. row ]***************************
episodeNumber | 7
parentTconst  | 398417
tconst        | 519679
seasonNumber  | 3
***************************[ 3. row ]***************************
episodeNumber | 5
parentTconst  | 398417
tconst        | 519680
seasonNumber  | 1
***************************[ 4. row ]***************************
episodeNumber | 12
parentTconst  | 398417
tconst        | 519681
seasonNumber  | 1
***************************[ 5. row ]***************************
episodeNumber | 10
parentTconst  | 398417
tconst        | 519682
seasonNumber  | 1


=========================================================================================================

CREATE TABLE `title_principals` (
  `category` varchar(64) DEFAULT NULL,
  `tconst` int(11) DEFAULT NULL,
  `nconst` int(11) DEFAULT NULL,
  `job` varchar(1024) DEFAULT NULL,
  `characters` varchar(1024) DEFAULT NULL,
  `ordering` int(11) DEFAULT NULL,
  KEY `ix_title_principals_tconst` (`tconst`),
  KEY `ix_title_principals_nconst` (`nconst`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

+------------+---------------+--------+-------+-----------+---------+
| Field      | Type          | Null   | Key   |   Default | Extra   |
|------------+---------------+--------+-------+-----------+---------|
| category   | varchar(64)   | YES    |       |    <null> |         |
| tconst     | int(11)       | YES    | MUL   |    <null> |         |
| nconst     | int(11)       | YES    | MUL   |    <null> |         |
| job        | varchar(1024) | YES    |       |    <null> |         |
| characters | varchar(1024) | YES    |       |    <null> |         |
| ordering   | int(11)       | YES    |       |    <null> |         |
+------------+---------------+--------+-------+-----------+---------+

eg:
***************************[ 1. row ]***************************
category   | actress
tconst     | 5241
nconst     | 260827
job        | None
characters | None
ordering   | 3
***************************[ 2. row ]***************************
category   | actor
tconst     | 5241
nconst     | 284746
job        | None
characters | None
ordering   | 4
***************************[ 3. row ]***************************
category   | director
tconst     | 5241
nconst     | 813682
job        | None
characters | None
ordering   | 5
***************************[ 4. row ]***************************
category   | writer
tconst     | 5241
nconst     | 284960
job        | screenplay
characters | None
ordering   | 6
***************************[ 5. row ]***************************
category   | actor
tconst     | 5242
nconst     | 523229
job        | None
characters | None
ordering   | 1


=========================================================================================================

CREATE TABLE `title_ratings` (
  `averageRating` float DEFAULT NULL,
  `tconst` int(11) DEFAULT NULL,
  `numVotes` int(11) DEFAULT NULL,
  KEY `ix_title_ratings_averageRating` (`averageRating`),
  KEY `ix_title_ratings_tconst` (`tconst`),
  KEY `ix_title_ratings_numVotes` (`numVotes`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

+---------------+---------+--------+-------+-----------+---------+
| Field         | Type    | Null   | Key   |   Default | Extra   |
|---------------+---------+--------+-------+-----------+---------|
| averageRating | float   | YES    | MUL   |    <null> |         |
| tconst        | int(11) | YES    | MUL   |    <null> |         |
| numVotes      | int(11) | YES    | MUL   |    <null> |         |
+---------------+---------+--------+-------+-----------+---------+

eg:
***************************[ 1. row ]***************************
averageRating | 7.2
tconst        | 51515
numVotes      | 41
***************************[ 2. row ]***************************
averageRating | 7.1
tconst        | 51516
numVotes      | 2266
***************************[ 3. row ]***************************
averageRating | 5.7
tconst        | 51517
numVotes      | 33
***************************[ 4. row ]***************************
averageRating | 6.4
tconst        | 51519
numVotes      | 1099
***************************[ 5. row ]***************************
averageRating | 5.3
tconst        | 51520
numVotes      | 7


=========================================================================================================



 */


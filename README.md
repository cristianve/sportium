# Sportium 💸🎮🎰
# CIRSA 🍎🏭


# Summary 🤔

Input ("String") --> Detect sport patterns --> Output ("JSON") with classified elements.

* Require GUI: Input text + Send button and JSON Output viewer of the result (output).

*Important* : This solution must be easily expandable, to be able to accept new chains in other formats for other sports (maximize pattern abstraction).

# Examples


| Input                                                           | Pattern                                                                                                                     | Output                                                                                                                                                                                                                                                                        |
|-----------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| F.C. Barcelona 3-2 Real Madrid                                  | \<teamAName> \<teamAScore>-\<teamBScore> \<teamBName>                                                                       | { "teamAName": "F.C. Barcelona", "teamBName": "Real Madrid", "teamAScore": "3", "teamBScore": "2" }                                                                                                                                                                           |
| Anna Karolina Schmiedlova (1) 1 40-Adv 1 (0) *Varvara Lepchenko | \<teamAName> (\<teamASets>) \<teamAGames> \<teamAScore>-\<teamBScore> \<teamBGames> (\<teamBSets>) \<isServing>\<teamBName> | { "teamAName": "Anna Karolina Schmiedlova", "teamBName": "VarvaraLepchenko", "teamAScore": "40", "teamBScore": "Adv", "teamAGames": "1","teamBGames": "1", "teamBServing": true, "scoreboard": { "elements": [ { "title":"Sets", "teamAScore": "1", "teamBScore": "0" } ] } } |
| Pittsburgh Steelers 3-7 Minnesota Vikings 3rd Quarter           | \<teamAName> \<teamAScore>-\<teamBScore> \<teamBName> \<Period>                                                             | { "teamAName": "Pittsburgh Steelers", "teamBName": "Minnesota Vikings","teamAScore": "3", "teamBScore": "7", "currentPeriod": "3rd Quarter" }                                                                                                                                 |


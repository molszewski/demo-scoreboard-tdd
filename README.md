# Exercise

You are working in a sports data company, and we would like you to develop a new Live Football World Cup Score Board that shows matches and scores.  

The board supports the following operations: 

### Start a game

When a game starts, it should capture (being initial score 0 – 0): 
- Home team 
- Away team 

### Finish game

Removes a game with specified home and away teams from the scoreboard. 

### Update score

Updates the home and away teams scores for the ongoing game.  

### Get a summary of games by total score as plain text

The games with the same total score will be returned ordered by the most recently added to our system.  

As an example, with the following data in the system: 

    Mexico - Canada: 0 - 5  
    Spain - Brazil: 10 – 2 
    Germany - France: 2 – 2 
    Uruguay - Italy: 6 – 6 
    Argentina - Australia: 3 - 1  

The summary would provide with the following information as plain text:  

    Uruguay 6 - Italy 6 
    Spain 10 - Brazil 2 
    Mexico 0 - Canada 5 
    Argentina 3 - Australia 1 
    Germany 2 - France 2
 
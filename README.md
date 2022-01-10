# Tic Tac Toe

Name of the project: Tic Tac Toe
Name: Sarthak Chaudhary
Email: f20190125@goa.bits-pilani.ac.in

## Description:

The app allows a person to sign in and play tic-tac-toe. His password will be remembered on FirebaseAuth and is not visible to the developer under the current settings.



![1638901524781.png](image/README/1638901524781.png)![1638901550561.png](image/README/1638901550561.png)![1638901566190.png](image/README/1638901566190.png)![1638901610578.png](image/README/1638901610578.png)

## Bugs:

[APP DOESN'T CRASH ANYMORE]
Clicking on login twice leads to the app crashing as the second time Firebase throws an exception that the account already exists and that exception is not dealt with properly. I tried to fix it but it's been thrown inside the listener somewhere and I cannot tell.

[FIXED]
Clicking on log out closes the app as there is an error with the navigation. If I simply remove the navigation code the user is signed out but the app remains in the dashboard. Although I would fix this in the future, the app closing on logging out can be thought of a feature.

## Task Description

#### Task 1

The register feature does store emails and password on the backend but the sign in feature is not yet implemented, at least not on the same button. Having two buttons would've made it much easier as I do have the sign in code(commented after the register code) but the only way to tell if it's sign in or register is through the app crashing
The app can run offline as firebase apps automatically handle temporary network interruptions. Cached data is available while offline and Firebase resends any writes when network connectivity is restored.

Code taken from:

https://stackoverflow.com/questions/40093781/check-if-given-email-exists

https://www.youtube.com/watch?v=d88BPU4Daso

https://www.examplefiles.net/cs/1026361

https://firebase.google.com/docs/auth/android/password-auth?authuser=0

Floating Button and log out also works, along with the log out and exit feature. The dashboard doesn't work

The game works perfectly well in both layouts with persistance

#### Task 2

I made a separate TicTacToeBoard class to implement the game logic along with the AI Logic. I initially started with the idea of creating a Monte Carlo Search Tree(MCTS) Algo to play TicTacToe but I have the implementation in python and porting is hard. The TicTacToeBoard has a robust API with methods like getBoardState and whoWon and isGameOver which are all self explanatory.

The game works flawlessly(I've tested it too many times, even using monkey) and I have implemented a viewModel to hold the game state so it persists through configuration changes. There is also a popup which shows the number of turns since the game started once it ends and it also shows whether the game was a draw or a win or a tie. Navigation here is implemented well as the user is taken back to the dashboard once the game ends.

The forfeit dialog button is also implemented well. The lack of dashboard means that certain features are not there though.

#### Task 3

2 player is not implemented

#### Dependancies:

I've used Firebase and Firebase Auth and everythin else is standard. Android studio will install these while synching the gradle files

#### Time taken and difficulty

It took me 18 hours
Difficulty: 8/10

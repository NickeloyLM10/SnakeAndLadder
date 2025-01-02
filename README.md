# Snake and Ladder Game

This repository contains the implementation of a **Snake and Ladder** game based on the classic board game. The application simulates the game for multiple players, incorporating snakes, ladders, and dice rolls, all while adhering to the rules outlined below.

---

## Features
- Simulates the Snake and Ladder game with up to 100 cells.
- Random dice rolls to move players forward.
- Automatically handles snakes and ladders, adjusting player positions accordingly.
- Multiple players supported.
- Detailed output of moves for each player.
- Identifies and declares the winner when a player reaches position 100.

---

## How to Run

### Prerequisites
- Ensure you have Java installed (if the implementation is in Java) or the appropriate runtime environment for the language used.

### Steps
1. Clone the repository:
   ```bash
   git clone https://github.com/<your-username>/snake-ladder-game.git
   cd snake-ladder-game
   ```
2. Compile the code (if applicable):
   ```bash
   javac Main.java
   ```
3. Run the program:
   ```bash
   java Main
   ```
4. Input the game configuration (snakes, ladders, and players) as prompted or through a file.

---

## Input Format
The program accepts input via the command line or a file containing:
1. **Number of snakes (`s`)** followed by `s` lines of snake positions (head and tail).
2. **Number of ladders (`l`)** followed by `l` lines of ladder positions (start and end).
3. **Number of players (`p`)** followed by `p` lines of player names.

### Example Input (File or Command Line):
```
3
14 7
28 12
34 2
2
3 22
5 8
2
Alice
Bob
```

---

## Output Format
The game will print each player's move in the following format:
```
<player_name> rolled a <dice_value> and moved from <initial_position> to <final_position>
```
When a player wins, it declares the winner:
```
<player_name> wins the game
```

### Example Output:
```
Alice rolled a 4 and moved from 0 to 4
Bob rolled a 6 and moved from 0 to 6
Alice rolled a 5 and moved from 4 to 9
Bob rolled a 2 and moved from 6 to 8
Alice wins the game
```

---

## Rules
1. The board has 100 cells numbered from 1 to 100.
2. Each player starts at position 0.
3. A six-sided dice determines the number of cells a player moves forward.
4. Players encountering:
   - A **snake's head** will move down to its tail.
   - A **ladder's start** will move up to its end.
5. If a dice roll moves a player beyond position 100, the move is ignored.
6. The first player to reach position 100 wins the game.

---

## Assumptions
- No snakes at position 100.
- No overlapping snakes or ladders at the same starting position.
- Snakes and ladders do not form infinite loops.
- A player can always win the game (i.e., it is possible to reach 100).

---

## Contributing
1. Fork the repository.
2. Create a new branch for your feature or bug fix.
   ```bash
   git checkout -b feature-name
   ```
3. Commit your changes.
   ```bash
   git commit -m "Add feature"
   ```
4. Push to your branch.
   ```bash
   git push origin feature-name
   ```
5. Create a pull request.

---

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

## Contact
For any queries or suggestions, feel free to reach out to [your-email@example.com](mailto:your-email@example.com).


# 🐍 Snake and Ladder 🎲

*A modular, object-oriented implementation of the classic Snake and Ladder game in Java*

---

## 🚀 Project Highlights

* ✅ **Clean OOP Design** – Game entities like `Board`, `Player`, `Snake`, `Ladder`, `Dice`, and `Obstacle` are modeled as independent classes with clear responsibilities.
  
* ✅ **Extensible Game Architecture** – Centralized `GameController` manages game flow, making it easy to extend to new rules, players, or board variations.
  
* ✅ **Design Pattern Usage** – Implemented the **Strategy Pattern** with `ObstacleAssignmentStrategy` and `RandomObstacleAssignmentStrategy`, enabling flexible obstacle placement strategies.
  
* ✅ **Enums for Clean Code** – Used enums (`GameStatus`, `PlayerType`, `ObstacleType`) to avoid magic numbers/strings and improve maintainability.
  
* ✅ **Bot Player Support** – Includes a `Bot` class, enabling both human and AI-controlled gameplay.
  
* ✅ **Production-Style Structure** – Modular package organization (`models`, `strategy`, `controller`, `client`) mirrors real-world scalable systems.

---

## 📂 Project Structure

```
Snake-and-Ladder/
│── src/
│   ├── Client/               # Entry point (client-facing code)
│   ├── controller/           # GameController to manage game flow
│   ├── models/               # Core game models (Board, Player, Snake, Ladder, etc.)
│   ├── strategy/             # Strategy Pattern implementations for obstacles
│── .gitignore
│── Snake and Ladder.iml
```

---

## 🎮 Features

* 🎲 **Multiple Players** – Supports both `HumanPlayer` and `Bot`.
* 🐍 **Snakes & Ladders** – Classic board mechanics.
* 🔀 **Dynamic Obstacle Placement** – Via **Strategy Pattern**.
* 🏆 **Game States Tracking** – Start, In-Progress, Completed via `GameStatus`.
* 🤖 **AI Player Simulation** – Bot can automatically roll dice and move.

---

## 🛠️ Tech Stack

* **Language:** Java
* **Paradigm:** Object-Oriented Programming (OOP)
* **Patterns:** Strategy Design Pattern
* **Structure:** Modular, maintainable package organization

---

## 📸 Demo Output

Example run (with both human and bot players):

```
Game Started!
Player 1 rolls dice → 5
Player 1 moves to Cell 5
Bot rolls dice → 6
Bot moves to Cell 6
...
Winner: Player 1 🎉
```

---

## 🤝 Project Highlight

This project is more than just a game. It shows:

* **Strong fundamentals in OOP** (abstraction, inheritance, polymorphism).
* **Scalable system design** using patterns like **Strategy**.
* **Real-world project organization** that mirrors professional development practices.
* **Extendability** – easy to add new rules, obstacles, or game modes.

---

## 📌 Future Enhancements

* 🎨 GUI-based interface for interactive play.
* 🌍 Multiplayer online support.
* ⚡ Configurable board sizes & rules.

---

## 👤 Author

**Ramesh Nair**

* Backend Engineer | Java | Spring Boot | System Design Enthusiast
* Focused on building **scalable, maintainable, real-world systems**.
* Passionate about **clean architecture, design patterns, and domain modeling**.

* 📫 Reach me at: ramesh200212@gmail.com
* 🌐 GitHub: https://github.com/ramesh-nair-dev

---



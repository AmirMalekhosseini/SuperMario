


# SuperMario (Java Swing)

This is my project for AP 2023 .
I created SuperMario game with all features in three phases using Java Swing.
This game has an offline mode that is inspired from the original game.
User can connect to the server(SuperMarioServer) using a button and some online features like Chat,game lobby,online shop,online friends,... will be activated for the user.
In case user is online every user's important informations will be saved in an online database that I created using MySql.

---

## ✨ Features

- **Classic platforming gameplay** (Java Swing renderer).
- **Modular content**: enemies, items/power-ups, weapons, objects, music.
- **Optional online mode** *(client connects to a server)*:
  - **Chat** (global/room), **friends list**, **game lobby**, **shop**.
  - Player/account data saved to **MySQL** on the server side.
- **Gradle wrapper** included for reproducible builds (`./gradlew ...`).

---

## Enabling Online Mode (Chat, Lobby, Friends, Shop)

1. **Start the server**  
   Run the companion server (named **SuperMarioServer**) and ensure it can reach a **MySQL** database.  
   - Create the DB/schema and user (grant minimal privileges).
   - Configure the server’s DB connection (host, port, db name, user, password).

2. **Configure the client**  
   Edit `config-ap.json` in this repo to point the client to your server:
   - `server.host`, `server.port`
   - Any other keys the client expects (e.g., timeouts, TLS flags)

3. **Run the client**  
   Launch the game as above. When online mode is active, the UI will surface **Chat**, **Friends**, **Lobby**, and **Shop** panels. Player/account state will be saved via the server into MySQL.

> If online services are unreachable, the game **falls back to offline mode** automatically.

---

## Controls

Controls are shown in-game (and may vary by keymap). Typical defaults for desktop platformers are:
- **←/→**: Move, **Space**: Jump, **Ctrl/Shift**: Action/Run, **Esc**: Pause  
Adjust as needed in the in-game menu or key settings.

---

## Development Notes

- **Rendering/UI**: Java Swing; double-buffering and timers for the main loop.
- **Packaging**: Gradle; use the wrapper to avoid version drift.
- **Assets**: stored under `Music/`, `Objects/`, `Mario*` folders.
- **Networking** (online mode): client connects to the companion server; messages drive chat/lobby/friends/shop features.
- **Persistence**: online player data is stored server-side in **MySQL**.

---

## Troubleshooting

- **Black window / no sprites**: verify JDK version, run from an IDE to see logs.
- **No online features**: confirm the server is running and `config-ap.json` points to the correct host/port; check firewalls.
- **DB errors**: confirm the server’s MySQL credentials and schema; test with a simple DB client.

---



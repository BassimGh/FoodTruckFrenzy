package foodtruckfrenzy;

public class GameState {
    //3 game states
    public static final int PlayState = 1;
    public static final int PauseState = 2;
    public static final int TitleState = 3;

    private int state;

    public GameState() {
        this.state = TitleState; //set initial game state to titlestate
    }
    public void setState(int state) { //set the desired state
        this.state = state;
    }
    public int getState() { //get the current state
        return state;
    }
}

/* ADD THIS TO GAMELOOP TO KEEP TRACK OF GAMESTATE

GameState gameState = new GameState();

while (true) {
    if (gameState.getState() == GameState.PLAY_STATE) {
        // Update game logic and render the game
    } else if (gameState.getState() == GameState.PAUSE_STATE) {
        // Show pause screen and wait for user input
    } else if (gameState.getState() == GameState.GAMEOVER_STATE) {
        // Show gameover screen and wait for user input
    }
}

how to set state: gameState.setState(GameState.PauseState);
 */
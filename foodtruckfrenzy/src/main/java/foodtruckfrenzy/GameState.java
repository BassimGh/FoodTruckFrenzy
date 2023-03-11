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
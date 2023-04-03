// package foodtruckfrenzy.GameFramework;

// import static org.junit.jupiter.api.Assertions.*;
// import org.junit.jupiter.api.*;

// import foodtruckfrenzy.Drawable.Vehicle.FoodTruck;

// public class ScoreboardTest {

//     private Scoreboard scoreboard;
//     private FoodTruck player;

//     @BeforeEach
//     void setup() {
//         player = new FoodTruck(0, 0, null);
//         scoreboard = new Scoreboard(player);
//     }

//     // Test that the scoreboard displays the correct score when the game starts.
//     @Test
//     void startupValues() {
//         // check all values are 0
//         assertEquals(0, scoreboard.getScore());
//         assertEquals(0, scoreboard.getIngredientsFound());
//         assertEquals(0, scoreboard.getRecipesFound());
//         assertEquals(0, scoreboard.getFines());
//         assertEquals(0, scoreboard.getDamage());
//     }

//     // // Test that the scoreboard updates the ingredients found label correctly when the player collects an ingredient.
//     // @Test
//     // void ingredientsFound() {
//     //     player.addIngredientsFound();
//     //     scoreboard.update();
//     //     assertEquals(1, scoreboard.getIngredientsFound());
//     // }

//     // Test that the scoreboard updates the recipes found label correctly when the player collects a recipe.
//     @Test
//     void recipesFound() {
//         player.addRecipesFound();
//         scoreboard.update();
//         assertEquals(1, scoreboard.getRecipesFound());
//     }

//     // Test that the scoreboard updates the damage label correctly when the player hits an obstacle.
//     @Test
//     void damage() {
//         player.addDamage(2);
//         scoreboard.update();
//         assertEquals(2, Math.abs(scoreboard.getDamage()));
//     }

//     // Test that the scoreboard updates the fines label correctly when the player is fined for speeding.
//     @Test 
//     void fines() {
//         player.addFines(2);
//         scoreboard.update();
//         assertEquals(2, Math.abs(scoreboard.getFines()));
//     }

//     // Test that the scoreboard pauses and resumes correctly 
//     @Test
//     void pauseResumeTimer() {

//         scoreboard.pauseTimer();
//         // make sure timer is paused
//         assertTrue(scoreboard.isTimerPaused());
        
//         scoreboard.resumeTimer();
//         // make sure timer is no longer paused
//         assertFalse(scoreboard.isTimerPaused());
//     }
// }


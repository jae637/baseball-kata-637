import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameTest {

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void createGame(){
        Assertions.assertNotNull(game);
    }

    private void assertIllegalArgument(String number) {
        try{
            game.guess(number);
            fail();
        }catch(IllegalArgumentException ex) {

        }
    }

    @Test
    void throwExceptionWhenInputIsNull(){
        assertIllegalArgument(null);
        assertIllegalArgument("12");
        assertIllegalArgument("1234");
        assertIllegalArgument("12s");
        assertIllegalArgument("121");
    }

    @Test
    void returnSomething(){
        setGameQuestion("123");
        GuessResult result = game.guess("123");

        boolean solved = true;
        int strikes = 3;
        int balls = 0;

        assertCorrectAnswer(result, solved, strikes, balls);
    }

    @Test
    void notMatchedAllNumber(){
        setGameQuestion("123");
        GuessResult result = game.guess("456");

        boolean solved = false;
        int strikes = 0;
        int balls = 0;

        assertCorrectAnswer(result, solved, strikes, balls);
    }

    private void setGameQuestion(String number) {
        game.question = number;
    }

    private void assertCorrectAnswer(GuessResult result, boolean solved, int strikes, int balls) {
        assertThat(result).isNotNull();
        assertThat(result.isSolved()).isEqualTo(solved);
        assertThat(result.getStrikes()).isEqualTo(strikes);
        assertThat(result.getBalls()).isEqualTo(balls);
    }

}
import java.util.HashSet;
import java.util.Set;

public class Game {
    public String question;

    public GuessResult guess(String gameNumber) {
        precondition(gameNumber);

        if(question.equals(gameNumber)){
            return new GuessResult(true,3,0);
        }else{
            return new GuessResult(false,0,0);
        }
    }

    private void precondition(String gameNumber) {
        if(gameNumber ==null){
            throw new IllegalArgumentException();
        }
        if(gameNumber.length() != 3)
            throw new IllegalArgumentException();

        for(char ch : gameNumber.toCharArray()){
            if(ch<'0' || ch> '9'){
                throw new IllegalArgumentException();
            }
        }

        checkDuplicatedNumber(gameNumber);
    }

    private void checkDuplicatedNumber(String gameNumber) {
        Set<Character> seen = new HashSet<>();
        for (char c : gameNumber.toCharArray()) {
            if (!seen.add(c)) {
                throw new IllegalArgumentException();
            }
        }
    }
}

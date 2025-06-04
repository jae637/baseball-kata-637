public class Game {
    public void guess(String gameNumber) {
        if(gameNumber==null){
            throw new IllegalArgumentException();
        }
        if(gameNumber.length() != 3)
            throw new IllegalArgumentException();

        for(char ch : gameNumber.toCharArray()){
            if(ch<'0' || ch> '9'){
                throw new IllegalArgumentException();
            }
        }
    }
}

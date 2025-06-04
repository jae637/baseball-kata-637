public class GuessResult {
    private int balls;
    private int strikes;
    private boolean solved;

    public int getBalls() {
        return balls;
    }

    public int getStrikes() {
        return strikes;
    }

    public boolean isSolved() {
        return solved;
    }

    public GuessResult(boolean solved, int strikes, int balls) {
        this.balls = balls;
        this.strikes = strikes;
        this.solved = solved;
    }
}

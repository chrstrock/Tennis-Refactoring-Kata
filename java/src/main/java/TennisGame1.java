public class TennisGame1 implements TennisGame {
    
    private int player1Score = 0;
    private int player2Score = 0;
    private final String player1Name;
    private final String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            player1Score += 1;
        else
            player2Score += 1;
    }

    public String getScore() {
        String result;
        StringBuilder score = new StringBuilder();
        if (player1Score != player2Score) {
            if (inDeuceState()) {
                int minusResult = player1Score - player2Score;
                if (minusResult==1) result = "Advantage player1";
                else if (minusResult ==-1) result = "Advantage player2";
                else if (minusResult>=2) result = "Win for player1";
                else result = "Win for player2";
            } else {
                score.append(getScoreString(player1Score));
                score.append("-");
                score.append(getScoreString(player2Score));
                result = score.toString();
            }
        } else {
            result = player1Score < 3 ? getScoreString(player1Score) + "-All" : "Deuce";
        }
        return result;
    }

    private boolean inDeuceState() {
        return player1Score >= 4 || player2Score >= 4;
    }

    private String getScoreString(int playerScore) {
        return switch (playerScore) {
            case 0 -> "Love";
            case 1 -> "Fifteen";
            case 2 -> "Thirty";
            case 3 -> "Forty";
            default -> "";
        };
    }
}

public class TennisGame1 implements TennisGame {
    
    private int player1Score = 0;
    private int player2Score = 0;

    public TennisGame1() {
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            player1Score += 1;
        else
            player2Score += 1;
    }

    public String getScore() {
        String result;
        if (player1Score != player2Score) {
            if (inDeuceState()) {
                int minusResult = player1Score - player2Score;
                if (minusResult==1) result = "Advantage player1";
                else if (minusResult ==-1) result = "Advantage player2";
                else if (minusResult>=2) result = "Win for player1";
                else result = "Win for player2";
            } else {
                result = getScoreString(player1Score)+"-"+getScoreString(player2Score);
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

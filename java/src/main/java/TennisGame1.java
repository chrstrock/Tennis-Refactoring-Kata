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
        if (player1Score == player2Score)
        {
            result = (switch (player1Score) {
                case 0 -> "Love-All";
                case 1 -> "Fifteen-All";
                case 2 -> "Thirty-All";
                default -> "Deuce";
            });
        }
        else if (player1Score >=4 || player2Score >=4)
        {
            int minusResult = player1Score - player2Score;
            if (minusResult==1) result = "Advantage player1";
            else if (minusResult ==-1) result = "Advantage player2";
            else if (minusResult>=2) result = "Win for player1";
            else result = "Win for player2";
        }
        else
        {
            score.append(getScoreString(player1Score));
            score.append("-");
            score.append(getScoreString(player2Score));
            result = score.toString();
        }
        return result;
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


public class TennisGame1 implements TennisGame {
    
    private int player1Score;
    private int player2Score;

    public TennisGame1() {
        player2Score = 0;
        player1Score = 0;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            player1Score += 1;
        else
            player2Score += 1;
    }

    public String getScore() {
        StringBuilder result = new StringBuilder();
        int tempScore;
        if (player1Score == player2Score)
        {
            result = new StringBuilder(switch (player1Score) {
                case 0 -> "Love-All";
                case 1 -> "Fifteen-All";
                case 2 -> "Thirty-All";
                default -> "Deuce";
            });
        }
        else if (player1Score >=4 || player2Score >=4)
        {
            int minusResult = player1Score - player2Score;
            if (minusResult==1) result = new StringBuilder("Advantage player1");
            else if (minusResult ==-1) result = new StringBuilder("Advantage player2");
            else if (minusResult>=2) result = new StringBuilder("Win for player1");
            else result = new StringBuilder("Win for player2");
        }
        else
        {
            for (int i=1; i<3; i++)
            {
                if (i==1) tempScore = player1Score;
                else { result.append("-"); tempScore = player2Score;}
                switch(tempScore)
                {
                    case 0:
                        result.append("Love");
                        break;
                    case 1:
                        result.append("Fifteen");
                        break;
                    case 2:
                        result.append("Thirty");
                        break;
                    case 3:
                        result.append("Forty");
                        break;
                }
            }
        }
        return result.toString();
    }
}

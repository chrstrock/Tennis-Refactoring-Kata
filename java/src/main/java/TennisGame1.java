
public class TennisGame1 implements TennisGame {
    
    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {
        StringBuilder result = new StringBuilder();
        int tempScore;
        if (m_score1==m_score2)
        {
            result = new StringBuilder(switch (m_score1) {
                case 0 -> "Love-All";
                case 1 -> "Fifteen-All";
                case 2 -> "Thirty-All";
                default -> "Deuce";
            });
        }
        else if (m_score1>=4 || m_score2>=4)
        {
            int minusResult = m_score1-m_score2;
            if (minusResult==1) result = new StringBuilder("Advantage player1");
            else if (minusResult ==-1) result = new StringBuilder("Advantage player2");
            else if (minusResult>=2) result = new StringBuilder("Win for player1");
            else result = new StringBuilder("Win for player2");
        }
        else
        {
            for (int i=1; i<3; i++)
            {
                if (i==1) tempScore = m_score1;
                else { result.append("-"); tempScore = m_score2;}
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

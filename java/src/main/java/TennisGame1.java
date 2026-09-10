public class TennisGame1 implements TennisGame {
    
    private int m_score1 = 0;
    private int m_score2 = 0;
    private StringBuilder score;

    public TennisGame1() {
        score = new StringBuilder();
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            m_score1++;
        else
            m_score2++;
    }

    public String getScore() {
        if (m_score1==m_score2)
        {
            tiedScore(score);
        }
        else if (m_score1>=4 || m_score2>=4)
        {
            score = scoreDeuce();
        }
        else
        {
            displayScore(score);
        }
        return score.toString();
    }

    private void displayScore(StringBuilder score) {
        determineScore(score, m_score1);
        score.append("-");
        determineScore(score, m_score2);
    }

    private StringBuilder scoreDeuce() {
        int minusResult = m_score1-m_score2;
        if (minusResult==1) score = new StringBuilder("Advantage player1");
        else if (minusResult ==-1) score = new StringBuilder("Advantage player2");
        else if (minusResult>=2) score = new StringBuilder("Win for player1");
        else score = new StringBuilder("Win for player2");
        return score;
    }

    private void tiedScore(StringBuilder score) {
        if(m_score1 < 3){
            determineScore(score, m_score1);
            score.append("-All");
        }
        else {
            score.append("Deuce");
        }
    }

    private void determineScore(StringBuilder score, int mScore1) {
        switch (mScore1) {
            case 0:
                score.append("Love");
                break;
            case 1:
                score.append("Fifteen");
                break;
            case 2:
                score.append("Thirty");
                break;
            case 3:
                score.append("Forty");
                break;
        }
    }
}

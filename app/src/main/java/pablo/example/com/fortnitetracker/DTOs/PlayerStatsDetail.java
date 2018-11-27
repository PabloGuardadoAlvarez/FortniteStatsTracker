package pablo.example.com.fortnitetracker.DTOs;

public class PlayerStatsDetail {

    private FinalStats matches;
    private FinalStats score;
    private FinalStats kd;
    private FinalStats trnRating;

    public FinalStats getMatches() {
        return matches;
    }

    public void setMatches(FinalStats matches) {
        this.matches = matches;
    }

    public FinalStats getScore() {
        return score;
    }

    public void setScore(FinalStats score) {
        this.score = score;
    }

    public FinalStats getKd() {
        return kd;
    }

    public void setKd(FinalStats kd) {
        this.kd = kd;
    }

    public FinalStats getTrnRating() {
        return trnRating;
    }

    public void setTrnRating(FinalStats trnRating) {
        this.trnRating = trnRating;
    }
}

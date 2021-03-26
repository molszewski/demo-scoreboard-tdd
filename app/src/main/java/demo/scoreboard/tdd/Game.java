package demo.scoreboard.tdd;

import java.util.Objects;

public class Game {
    public final String homeTeam;
    public final String awayTeam;
    public final int homeScore;
    public final int awayScore;

    public Game(String homeTeam, String awayTeam, int homeScore, int awayScore) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return homeScore == game.homeScore &&
                awayScore == game.awayScore &&
                Objects.equals(homeTeam, game.homeTeam) &&
                Objects.equals(awayTeam, game.awayTeam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homeTeam, awayTeam, homeScore, awayScore);
    }

    @Override
    public String toString() {
        return "Game{" +
                "homeTeam='" + homeTeam + '\'' +
                ", awayTeam='" + awayTeam + '\'' +
                ", homeScore=" + homeScore +
                ", awayScore=" + awayScore +
                '}';
    }
}

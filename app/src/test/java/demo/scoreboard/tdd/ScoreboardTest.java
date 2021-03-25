package demo.scoreboard.tdd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ScoreboardTest {

    @Test
    void scoreboardStartsAMatch() {
        Scoreboard scoreboard = new Scoreboard();

        Game game = scoreboard.startGame("A", "B");

        assertThat(game).isEqualTo(new Game("A", "B", 0, 0));
    }

    @Test
    void scoreboardUpdatesAMatch() {
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.startGame("A", "B");

        Game game = scoreboard.updateGame("A", "B", 2, 3);

        assertThat(game).isEqualTo(new Game("A", "B", 2, 3));
    }

    @Test
    void scoreboardThrowsWhenMatchNotFoundWhenUpdating() {
        assertThatThrownBy(() -> new Scoreboard().updateGame("A", "B", 2, 3))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void scoreboardSummaryIncludesStartedMatch() {
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.startGame("A", "B");

        String summary = scoreboard.getSummaryByTotalScore();

        assertThat(summary).isEqualTo("A 0 - B 0\n");
    }

    @Test
    void scoreboardSummaryIncludesUpdatedMatch() {
        Scoreboard scoreboard = givenScoreboardHasFollowingGamesStarted(
                new Game("A", "B", 2, 3)
        );

        String summary = scoreboard.getSummaryByTotalScore();

        assertThat(summary).isEqualTo("A 2 - B 3\n");
    }

    @Test
    void scoreboardShowsSummaryOfGames() {
        Scoreboard scoreboard = givenScoreboardHasFollowingGamesStarted(
                new Game("Mexico", "Canada", 0, 5),
                new Game("Spain", "Brazil", 10, 2),
                new Game("Germany", "France", 2, 2),
                new Game("Uruguay", "Italy", 6, 6),
                new Game("Argentina", "Australia", 3, 1)
        );

        String summary = whenAskedForSummaryOfMatches(scoreboard);

        thenSummaryOfMatchesShouldBeReverseOrderedByTheTotalScore(summary);
    }

    private Scoreboard givenScoreboardHasFollowingGamesStarted(Game... games) {
        Scoreboard scoreboard = new Scoreboard();

        for (Game g : games) {
            scoreboard.startGame(g.homeTeam, g.awayTeam);
            scoreboard.updateGame(g.homeTeam, g.awayTeam, g.homeScore, g.awayScore);
        }

        return scoreboard;
    }

    private String whenAskedForSummaryOfMatches(Scoreboard scoreboard) {
        return scoreboard.getSummaryByTotalScore();
    }

    private void thenSummaryOfMatchesShouldBeReverseOrderedByTheTotalScore(String summary) {
        assertThat(summary).isEqualTo(
                "Uruguay 6 - Italy 6\n" +
                        "Spain 10 - Brazil 2\n" +
                        "Mexico 0 - Canada 5\n" +
                        "Argentina 3 - Australia 1\n" +
                        "Germany 2 - France 2\n"
        );
    }
}

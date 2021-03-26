package demo.scoreboard.tdd;

import org.junit.jupiter.api.Test;

class ScoreboardTest {
    @Test
    void scoreboardShowsSummaryOfGames() {
        Scoreboard scoreboard = givenScoreboardHasFollowingGamesStarted();

        whenAskedForSummaryOfMatches();

        thenSummaryOfMatchesShouldBeReverseOrderedByTheTotalScore();
    }
}

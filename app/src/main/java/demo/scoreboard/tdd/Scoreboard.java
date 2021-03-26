package demo.scoreboard.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Scoreboard {


    private final List<Game> games = new ArrayList<>();

    public String getSummaryByTotalScore() {
        StringBuilder builder = new StringBuilder();

        // sortowanie: totalScore, reverse

        for (Game g : games) {
            builder.append(g.homeTeam)
                    .append(" ")
                    .append(g.homeScore)
                    .append(" - ")
                    .append(g.awayTeam)
                    .append(" ")
                    .append(g.awayScore)
                    .append("\n");
        }

        return builder.toString();
    }

    public Game startGame(String homeTeam, String awayTeam) {

        Game game = new Game(homeTeam, awayTeam, 0, 0);
        games.add(game);


        return game;
    }

    public Game updateGame(String homeTeam, String awayTeam, int homeScore, int awayScore) {

        final Optional<Game> found = games.stream().filter(g -> g.homeTeam.equals(homeTeam) && g.awayTeam.equals(awayTeam)).findFirst();
        Game game = found.orElseThrow(IllegalStateException::new);

        Game newGame = new Game(game.homeTeam, game.awayTeam, homeScore, awayScore);
        int index = games.indexOf(game);
        games.add(index, newGame);

        games.remove(index + 1);

        return newGame;
    }
}

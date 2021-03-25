package demo.scoreboard.tdd;

import java.util.*;
import java.util.stream.Collectors;

public class Scoreboard {

    private final Map<String, Game> games = new LinkedHashMap<>();

    public String getSummaryByTotalScore() {

        StringBuilder builder = new StringBuilder();

        List<Game> sorted = games.values().stream()
                .sorted(Comparator.comparingInt(Game::getTotalScore))
                .collect(Collectors.toList());
        for (int i = sorted.size() - 1; i >= 0; i--) {
            Game g  = sorted.get(i);
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
        games.put(toGameKey(homeTeam, awayTeam), game);
        return game;
    }

    private static String toGameKey(String homeTeam, String awayTeam) {
        return homeTeam + awayTeam;
    }

    public Game updateGame(String homeTeam, String awayTeam, int homeScore, int awayScore) {
        String key = toGameKey(homeTeam, awayTeam);
        Game game = games.get(key);

        if (game == null) {
            throw new IllegalStateException();
        }

        Game newGame = new Game(game.homeTeam, game.awayTeam, homeScore, awayScore);
        games.put(key, newGame);

        return newGame;
    }
}

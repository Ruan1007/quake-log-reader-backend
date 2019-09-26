package com.quake.logReader.service;

import com.quake.logReader.models.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.*;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class LogReaderService {

    private static final Integer INT_ONE = 1;
    private static final String SPACE = " ";

    /**
     * Realiza a leitura do log.
     * @param lines
     * @param log
     * @return
     */
    public Log logReader(List<String> lines, Log log) {
        Game game = null;
        Player player = null;
        List<Game> games = new ArrayList<>();
        List<Player> players = new ArrayList<>();
        Integer gameNumber = 1;
        for(String line : lines) {
            if(isLineInitGame(line)){
                game = new Game();
                game.setTotalKills(BigDecimal.ZERO.intValue());
            }

            if(isLinePlayerInfo(line)){
                getPlayer(line, player, players);
            }

            if(isLineKill(line)) {
                getKill(line, players, game);
            }

            if(isLineShutdownGame(line)){
                getGame(game, players, gameNumber);
                games.add(game);
                gameNumber++;
            }
        }
        log.setGames(games);
        return log;
    }

    private void getKill(String line, List<Player> players, Game game) {
        StringTokenizer st = new StringTokenizer(line, SPACE);
        Player playerKill;
        Player playerKilled;
        Integer playerCodKill = BigDecimal.ZERO.intValue();
        Integer playerCodKilled = BigDecimal.ZERO.intValue();
        Integer typeOfDeathCod = BigDecimal.ZERO.intValue();

        while(st.hasMoreTokens()){
            if(st.nextToken().contains(TextSystemLog.TXTKILL.getTextSystem())){
                playerCodKill = new Integer(st.nextToken());
                playerCodKilled = new Integer(st.nextToken());
                typeOfDeathCod = new Integer(StringUtils.removeEnd(st.nextToken(), ":"));
            }
        }

        Integer finalPlayerCodKill = playerCodKill;
        Integer finalPlayerCodKilled = playerCodKilled;
        Integer finalTypeOfDeathCod = typeOfDeathCod;

        playerKill = players.stream().filter(playerFilter -> playerFilter.getPlayerCod().equals(finalPlayerCodKill)).findFirst().orElse(null);
        playerKilled = players.stream().filter(playerFilter -> playerFilter.getPlayerCod().equals(finalPlayerCodKilled)).findFirst().orElse(null);

        if(line.contains(TextSystemLog.TXTSUICIDE.getTextSystem())){
            playerKilled.addSuicide(INT_ONE);
        }

        if(playerKill != null) {
            playerKill.addKills(INT_ONE);
        }

        TypeOfDeath typeOfDeath = TypeOfDeath.getTypeOfDeathById(finalTypeOfDeathCod);
        if(null ==  playerKilled.getTypeOfDeaths() && CollectionUtils.isEmpty(playerKilled.getTypeOfDeaths())){
            List<String> typeOfDeathNames = new ArrayList<>();
            typeOfDeathNames.add(typeOfDeath.getName());
            playerKilled.setTypeOfDeaths(typeOfDeathNames);
        }else {
            playerKilled.getTypeOfDeaths().add(typeOfDeath.getName());
        }

        game.addTotalKills(INT_ONE);
    }

    /**
     * Monta o objeto Player.
     * @param line
     * @param player
     * @param players
     */
    private void getPlayer(String line, Player player, List<Player> players) {
        Integer playerCod = validatePlayerCod(line);
        String playerName = validatePlayerName(line);

        player = players.stream().filter(playerFilter -> playerFilter.getPlayerCod().equals(playerCod)).findFirst().orElse(null);

        if(null == player){
            player = new Player(playerCod, playerName, BigDecimal.ZERO.intValue(), BigDecimal.ZERO.intValue());
            players.add(player);
        } else {
            player = players.stream().filter(playerFilter -> playerFilter.getPlayerCod().equals(playerCod)).findFirst().get();
            player.setPlayerName(playerName);
        }
    }

    private Integer validatePlayerCod(String line) {
        StringTokenizer st = new StringTokenizer(line);
        Integer playerCode = BigDecimal.ZERO.intValue();
        while(st.hasMoreTokens()){
            if(st.nextToken().contains(TextSystemLog.CLIENT_USER_INFO_CHANGED.getTextSystem())){
                playerCode = new Integer(st.nextToken());
            }
        }
        return playerCode;
    }

    private String validatePlayerName(String line) {
        StringTokenizer st = new StringTokenizer(line,"\\\\");
        String playerName = "name";
        while(st.hasMoreTokens()){
            if(st.nextToken().contains(TextSystemLog.CLIENT_USER_INFO_CHANGED.getTextSystem())){
                playerName = (String) st.nextElement();
            }
        }
        return playerName;
    }

    /**
     * Monta o objeto Game.
     * @param game
     * @param players
     * @param gameNumber
     */
    private void getGame(Game game, List<Player> players, Integer gameNumber) {
        game.setPlayers(players);
        List<String> names = players.stream().map(p -> p.getPlayerName()).collect(Collectors.toList());
        String nameOfAllPlayers = String.join(", ", names);
        game.setPlayersName(nameOfAllPlayers);
        game.setGameNumber(gameNumber);
    }

    private boolean isLineKill(String line) {
        return line.contains(TextSystemLog.TXTKILL.getTextSystem());
    }

    /**
     * Verifica se é linha que posusi dados do jogador que esta conectado ao jogo.
     * @param line
     * @return
     */
    private boolean isLinePlayerInfo(String line) {
        return line.contains(TextSystemLog.CLIENT_USER_INFO_CHANGED.getTextSystem());
    }

    /**
     * Verifica se é linha que finaliza o log do jogo.
     * @param line
     * @return
     */
    private boolean isLineShutdownGame(String line) {
        return line.contains(TextSystemLog.SHUTDOWN_GAME.getTextSystem());
    }

    /**
     * Verifica se é linha que inicia o log do jogo.
     * @param line
     * @return
     */
    private boolean isLineInitGame(String line) {
        return line.contains(TextSystemLog.INIT_GAME.getTextSystem());
    }
}

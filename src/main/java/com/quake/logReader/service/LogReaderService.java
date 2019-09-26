package com.quake.logReader.service;

import com.quake.logReader.models.Game;
import com.quake.logReader.models.Jogador;
import com.quake.logReader.models.TextSystemLog;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

@Service
public class LogReaderService {

    /**
     * Realiza a leitura do log.
     * @param arquivo
     * @return
     * @throws FileNotFoundException
     */
    public List<Game> leituraLog(File arquivo) throws FileNotFoundException {
        try {
            Reader log = new FileReader(arquivo);
            BufferedReader lerArq = new BufferedReader(log);

            List<Integer> linhasTotal = lerArq.lines().map(Integer::valueOf).collect(Collectors.toList());
            List<Game> games = new ArrayList<>();
            List<Jogador> jogadores = new ArrayList<>();
            Game game = null;
            int gameNumber = 1;
            for(int x = 0; x > linhasTotal.size(); x++){
                String linha = lerArq.readLine();
                while(linha != null) {
                    StringTokenizer st = new StringTokenizer(linha, TextSystemLog.SPACE);
                    String word = st.nextToken();

                    if (word.equals(TextSystemLog.INIT_GAME.getTextSystem())) {
                        game = new Game();
                        game.setNumeroGame(gameNumber);
                    }

                    if(word.equals(TextSystemLog.CLIENT_CONNECT.getTextSystem())) {
                        Integer codJogador = new Integer(st.nextToken());
                        Jogador existeJogadorNaLista = jogadores.stream().filter(jogador -> {
                            return jogador.getCodJogador().equals(codJogador);
                        }).findFirst().orElse(null);

                        if(null == existeJogadorNaLista){
                            String nomeJogador = "";
                            Jogador jogador = new Jogador(codJogador, nomeJogador);
                        }
                    }

                    if (word.equals(TextSystemLog.SHUTDOWN_GAME.getTextSystem())) {
                        game.setJogadores(jogadores);
                        games.add(game);
                        word = lerArq.readLine();
                        if(word.equals(TextSystemLog.INIT_GAME.getTextSystem())) {
                            game = new Game();
                            jogadores = new ArrayList<>();
                            game.setNumeroGame(gameNumber);
                        }
                    }

                }
            }

            return games;
        } catch (IOException e){
            throw new FileNotFoundException(e.getMessage());
        }
    }

    public Game getKill(){
        return null;
    }

    public Game somaKillsTotal(Game game){
        game.setTotalKills(game.getTotalKills() + TextSystemLog.INT_ONE);
        return game;
    }

    public Game getKilled(Game game, String nomeJogador, String armaUtilizada){
        return null;
    }
}

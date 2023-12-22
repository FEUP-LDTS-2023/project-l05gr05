package com.pacxon.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LoaderArenaBuilder extends ArenaBuilder {
    private final String level;

    private final int points;
    private final List<String> lines;

    public int getLevel() {
        int newLevel = Integer.parseInt(level);
        return newLevel;
    }

    public LoaderArenaBuilder(String level, int points) throws IOException {
        this.level = level;
        this.points = points;
        InputStream is = LoaderArenaBuilder.class.getResourceAsStream("/levels/level" + level + ".lvl");
        if (is == null) {
            throw new IOException("Resource file not found: /levels/level" + level + ".lvl");
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        lines = readLines(br);
    }

    private List<String> readLines(BufferedReader br) throws IOException {
        List<String> lines = new ArrayList<>();
        for (String line; (line = br.readLine()) != null; )
            lines.add(line);
        return lines;
    }


    @Override
    protected int getPoints(){
        return points;
    }
    @Override
    protected int getWidth() {
        int width = 0;
        for (String line : lines)
            width = Math.max(width, line.length());
        return width;
    }

    @Override
    protected int getHeight() {
        return lines.size();
    }

    @Override
    protected List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == '#') walls.add(new Wall(x, y, false));
        }

        return walls;
    }

    @Override
    protected List<Monster> createMonsters() {
        List<Monster> monsters = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'M') monsters.add(new Monster(x, y));
        }

        return monsters;
    }

    @Override
    protected Pacman createPacman() {
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'H') return new Pacman(x, y);
        }
        return null;
    }

    @Override
    protected List<Coin> createCoin(){
        List<Coin> coins = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++){
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'C') coins.add(new Coin(x, y));
        }

        return coins;
    }
}
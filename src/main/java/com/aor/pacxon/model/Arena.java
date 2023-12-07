package com.aor.pacxon.model;

import com.aor.pacxon.model.Position;
import com.aor.pacxon.model.Pacman;
import com.aor.pacxon.model.Monster;
import com.aor.pacxon.model.Wall;

import java.util.*;

public class Arena {
    private final int width;
    private final int height;
    private Pacman pacman;
    private List<Position> trail;
    private Set<Position> filledPositions;

    private List<Monster> monsters;
    private List<Wall> walls;

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
        this.trail = new ArrayList<>();
        this.walls = new ArrayList<>();
        this.filledPositions = new HashSet<>();
    }

    public class TemporaryWall extends Wall {
        public TemporaryWall(Position position) {
            super(position.getX(), position.getY(), true);
        }
    }

    public void convertTemporaryWallsToPermanent() {
        for (Wall wall : walls) {
            if (wall.isTemporary()) {
                wall.makePermanent();
            }
        }
        fillInternalAreas();
    }


    public void addToTrail(Position position) {
        if (isEmpty(position)) {
            trail.add(position);
            walls.add(new TemporaryWall(position));
        }
    }
    public List<Position> getTrail() {
        return trail;
    }
    public void clearTrail() {
        trail.clear();
    }

    public void fillInternalAreas() {
        List<Position> internalStartPoints = findInternalStartPoints();
        for (Position start : internalStartPoints) {
            fillArea(start);
        }
    }

    public void fillArea(Position start) {
        Stack<Position> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            Position current = stack.pop();

            if (withinMapBounds(current) && isEmpty(current) && !filledPositions.contains(current) && !isMonster(current)) {
                filledPositions.add(current);
                setWall(current);

                stack.push(new Position(current.getX() + 1, current.getY())); // Direita
                stack.push(new Position(current.getX() - 1, current.getY())); // Esquerda
                stack.push(new Position(current.getX(), current.getY() + 1)); // Abaixo
                stack.push(new Position(current.getX(), current.getY() - 1)); // Acima
            }
        }
    }

    private List<Position> findInternalStartPoints() {
        List<Position> startPoints = new ArrayList<>();
        boolean[][] visited = new boolean[width][height];

        // Primeiro, marque todos os espaços acessíveis a partir das bordas como visitados
        for (int x = 0; x < width; x++) {
            bfsMarkVisited(new Position(x, 0), visited); // Linha superior
            bfsMarkVisited(new Position(x, height - 1), visited); // Linha inferior
        }
        for (int y = 0; y < height; y++) {
            bfsMarkVisited(new Position(0, y), visited); // Coluna esquerda
            bfsMarkVisited(new Position(width - 1, y), visited); // Coluna direita
        }

        // Agora, encontre os espaços não visitados que são internos
        for (int x = 1; x < width - 1; x++) {
            for (int y = 1; y < height - 1; y++) {
                Position pos = new Position(x, y);
                if (!visited[x][y] && isEmpty(pos)) {
                    startPoints.add(pos);
                    bfsMarkVisited(pos, visited); // Marque a área interna como visitada
                }
            }
        }

        return startPoints;
    }

    private void bfsMarkVisited(Position start, boolean[][] visited) {
        Queue<Position> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            Position current = queue.poll();

            if (!withinMapBounds(current) || visited[current.getX()][current.getY()] || !isEmpty(current)) {
                continue;
            }

            visited[current.getX()][current.getY()] = true;

            queue.add(new Position(current.getX() + 1, current.getY())); // Direita
            queue.add(new Position(current.getX() - 1, current.getY())); // Esquerda
            queue.add(new Position(current.getX(), current.getY() + 1)); // Abaixo
            queue.add(new Position(current.getX(), current.getY() - 1)); // Acima
        }
    }

    private void setWall(Position position) {
        if (withinMapBounds(position) && isEmpty(position)) {
            walls.add(new Wall(position.getX(), position.getY(), false)); // Adiciona parede permanente
        }
    }


    private boolean withinMapBounds(Position position) {
        return position.getX() >= 0 && position.getX() < width &&
                position.getY() >= 0 && position.getY() < height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Pacman getPacman() {
        return pacman;
    }

    public void setPacman(Pacman pacman) {
        this.pacman = pacman;
    }

    public List<Monster> getMonsters() {
        return monsters;
    }

    public void setMonsters(List<Monster> monsters) {
        this.monsters = monsters;
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }

    public boolean isEmpty(Position position) {
        for (Wall wall : walls)
            if (wall.getPosition().equals(position))
                return false;
        return true;
    }

    public boolean isMonster(Position position) {
        for (Monster monster : monsters)
            if (monster.getPosition().equals(position))
                return true;
        return false;
    }
}

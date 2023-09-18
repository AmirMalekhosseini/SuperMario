package Config;

import View.Game.LevelScreens;
import Model.Enemy.Enemy;
import Model.Enemy.Goompa;
import Model.Enemy.Spiny;
import Model.Enemy.Turtle;
import Model.Item.Coin;
import Model.Object.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class CreateFromConfig {

    LevelScreens screen;

    public CreateFromConfig(LevelScreens screen) {
        this.screen = screen;
    }

    public void readFromConfig() {
        try {
            String json = new String(Files.readAllBytes(Paths.get("config-ap.json")));
            ObjectMapper objectMapper = new ObjectMapper();
            ArrayList<LevelConfig> levelConfigs = objectMapper.readValue(json, new TypeReference<ArrayList<LevelConfig>>() {});

            for (LevelConfig levelConfig : levelConfigs) {

                for (BlockConfig blockConfig : levelConfig.blocks) {

                    int x = blockConfig.x;
                    int y = blockConfig.y;
                    String type = blockConfig.type;

                    // Create a block based on the type and add it to objectsInThisSection
                    ObjectsInGame block = createBlock(x, y, type);
                    screen.getObjectsInThisSection().add(block);
                }

                // Iterate over the coins in the current level config
                for (CoinConfig coinConfig : levelConfig.coins) {
                    int x = coinConfig.x;
                    int y = coinConfig.y;

                    // Create a coin and add it to itemsInThisSection
                    Coin coin = createCoin(x, y);
                    screen.getItemsInThisSection().add(coin);
                }

                // Iterate over the enemies in the current level config
                for (EnemyConfig enemyConfig : levelConfig.enemies) {
                    int x = enemyConfig.x;
                    int y = enemyConfig.y;
                    String type = enemyConfig.type;

                    // Create an enemy based on the type and add it to enemiesInThisSection
                    Enemy enemy = createEnemy(x, y, type);
                    screen.getEnemiesInThisSection().add(enemy);
                }

                // Iterate over the pipes in the current level config
                for (PipeConfig pipeConfig : levelConfig.pipes) {
                    int x = pipeConfig.x;
                    int y = pipeConfig.y;

                    // Create a pipe and add it to objectsInThisSection
                    Pipe pipe = createPipe(x, y);
                    screen.getObjectsInThisSection().add(pipe);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ObjectsInGame createBlock(int x, int y, String type) {
        ObjectsInGame block = null;

        if (type.equals("QUESTION")) {
            block = new PrizeInAir(x, y);
        } else if (type.equals("SIMPLE")) {
            block = new SimpleBlockInAir(x, y);
        } else if (type.equals("Empty")) {
            block = new EmptyBlockInAir(x, y);
        } else if (type.equals("OneCoin")) {
            block = new OneCoinBlockInAir(x, y);
        } else if (type.equals("FullOfCoin")) {
            block = new FullOfCoinBlockInAir(x, y);
        }


        return block;
    }

    public Coin createCoin(int x, int y) {

        return new Coin(x, y);
    }

    public Enemy createEnemy(int x, int y, String type) {
        Enemy enemy = null;

        if (type.equals("Turtle")) {
            enemy = new Turtle(x, y);
        } else if (type.equals("Spiny")) {
            enemy = new Spiny(x, y);
        } else if (type.equals("Goompa")) {
            enemy = new Goompa(x, y);
        }

        return enemy;
    }

    public Pipe createPipe(int x, int y) {

        return new Pipe(x, y);
    }



}

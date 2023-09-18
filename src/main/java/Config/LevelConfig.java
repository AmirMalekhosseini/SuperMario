package Config;

import java.util.ArrayList;

public class LevelConfig {

    public ArrayList<BlockConfig> blocks;
    public ArrayList<PipeConfig> pipes;
    public ArrayList<CoinConfig> coins;
    public ArrayList<EnemyConfig> enemies;

    public ArrayList<BlockConfig> getBlocks() {
        return blocks;
    }

    public void setBlocks(ArrayList<BlockConfig> blocks) {
        this.blocks = blocks;
    }

    public ArrayList<PipeConfig> getPipes() {
        return pipes;
    }

    public void setPipes(ArrayList<PipeConfig> pipes) {
        this.pipes = pipes;
    }

    public ArrayList<CoinConfig> getCoins() {
        return coins;
    }

    public void setCoins(ArrayList<CoinConfig> coins) {
        this.coins = coins;
    }

    public ArrayList<EnemyConfig> getEnemies() {
        return enemies;
    }

    public void setEnemies(ArrayList<EnemyConfig> enemies) {
        this.enemies = enemies;
    }
}

package me.desty.plugin.Functions;

import me.desty.plugin.GameTimer;
import me.desty.plugin.SteveMyers;

public class FunctionStartGame {
    private SteveMyers plugin;
    
    public FunctionStartGame(SteveMyers plugin) {
            this.plugin = plugin;
    }
    public void startGame() {
        plugin.countdown = true;
        plugin.run.resumeit();
    }
}

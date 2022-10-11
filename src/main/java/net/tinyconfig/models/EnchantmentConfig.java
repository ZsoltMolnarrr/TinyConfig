package net.tinyconfig.models;

public class EnchantmentConfig {
    public int max_level = 0;
    public int min_cost = 0;
    public int step_cost = 0;
    public float bonus_per_level = 0;

    public EnchantmentConfig() { }

    public EnchantmentConfig(int max_level, int min_cost, int step_cost, float bonus_per_level) {
        this.max_level = max_level;
        this.min_cost = min_cost;
        this.step_cost = step_cost;
        this.bonus_per_level = bonus_per_level;
    }
}

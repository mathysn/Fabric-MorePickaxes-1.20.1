package net.sij.morepickaxes.item;

import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

import java.util.function.Supplier;

public enum ModToolMaterial implements ToolMaterial {
    RUBY(MiningLevels.DIAMOND, 1500, 7.5f, 3.5f, 15,
            () -> Ingredient.ofItems(ModItems.RUBY)),
    OBSIDIAN(MiningLevels.NETHERITE, 1800, 8.5f, 5.0f, 15,
            () -> Ingredient.ofItems(Items.OBSIDIAN));

    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int miningLevel;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    ModToolMaterial(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.miningLevel = miningLevel;
        this.enchantability = enchantability;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurability() {
        return this.itemDurability;
    }
    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }
    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }
    @Override
    public int getMiningLevel() {
        return this.miningLevel;
    }
    @Override
    public int getEnchantability() {
        return this.enchantability;
    }
    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}

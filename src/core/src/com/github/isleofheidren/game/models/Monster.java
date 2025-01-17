package com.github.isleofheidren.game.models;

import java.util.Random;

public class Monster extends Character {
    private String[] attacks;
    private int numHeads;

    public Monster(String name, int hitPoints, int armorClass, int attackBonus, String[] attacks, int numHeads) {
        super(name, hitPoints, armorClass, attackBonus, null);
        this.attacks = attacks;
        this.numHeads = numHeads;
    }

    public String getRandomAttack() {
        Random random = new Random();
        int index = random.nextInt(attacks.length);
        return attacks[index];
    }

    public int calculateDamage(String attack) {
        String chosenAttack = attack;
        int damage = 0;
        switch (chosenAttack) {
            case "Bite":
                damage = (rollDice(10) + 5);
                break;
            case "Fire Breath":
                damage = (rollDice(12) + 5);
                break;
            case "Multi-attack":
                damage = (rollDice(8) + 2) * numHeads;
                break;
            case "Tail Whip":
                damage = (rollDice(8) + 1);
                break;
            case "Stomp":
                damage = (rollDice(6) + 1);
                break;
            case "Fist":
                damage = (rollDice(6) + 3);
                break;
            case "Shit Throw":
                damage = (rollDice(6) + 3);
                break;
            case "Feral Bite":
                damage = (rollDice(10) + 4);
        }
        return damage;
    }
}

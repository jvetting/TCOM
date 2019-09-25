package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Vector;

import java.util.Random;
public class Npc extends Character {
    String[] types;
    String type;
    String[] names;
    String[] bios;
    String[][] info;
    public Npc()//Npcs can be added to the player's squad for combat
    {
        Random rand = new Random();
        types = new String[]{"Ranged", "Melee", "Heavy", "Scout"};
        names = new String[]{"Blueface", "HK Police", "Lil Thicc", "Z"};
        bios = new String[]{"Yeet", "Nothing happened on April 15, 1989", "Bruh Sound Effect #2", "The scourge of rlg327"};
        type = types[rand.nextInt(4)];
        name = names[rand.nextInt(4)];
        bio = bios[rand.nextInt(4)];
    }

    public Npc(String t, String n, String b){
        type = t;
        name = n;
        bio = b;
    }


}

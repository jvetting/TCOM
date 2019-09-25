package com.mygdx.game;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.math.Vector;

import java.util.Random;
public class Player extends ApplicationAdapter
{
    //Vector<Npc> squad;//the player's squad of npcs
    Player(String name, String bio, int color)//players info can be edited upon creation, otherwise will be generated
    {
        String[] names = {"Guccius Maximus", "Yung Gravy", "Papa Sheaffer", "Dossay the Destroyer"};
        String[] bios = {"SCUM GANG", "Gravy Train", "Doesn't like clear code", "If you are caught cheating in 228, you do not want to face me"};
        if (name == "")//players name is empty be default
        {
            Random rand = new Random();
            int num = rand.nextInt(4);
            name = names[num];
            bio = bios[num];
        }
    }
}

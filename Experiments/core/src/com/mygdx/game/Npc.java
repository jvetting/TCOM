package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Vector;

import java.util.Random;
public class Npc extends Character implements Vector<Npc> {
    String[] types;
    int type;
    String[] names;
    String[] bios;
    String[][] info;
    Npc()//Npcs can be added to the player's squad for combat
    {
        Random rand = new Random();
        types = new String[]{"Ranged", "Melee", "Heavy", "Scout"};
        names = new String[]{"Blueface", "HK Police", "Lil Thicc", "Z"};
        bios = new String[]{"Yeet", "Nothing happened on April 15, 1989", "Bruh Sound Effect #2", "The scourge of rlg327"};
        type =  rand.nextInt(4);
        name = names[type];
        bio = bios[type];
    }

    @Override
    public Npc cpy() {
        return null;
    }

    @Override
    public float len() {
        return 0;
    }

    @Override
    public float len2() {
        return 0;
    }

    @Override
    public Npc limit(float limit) {
        return null;
    }

    @Override
    public Npc limit2(float limit2) {
        return null;
    }

    @Override
    public Npc setLength(float len) {
        return null;
    }

    @Override
    public Npc setLength2(float len2) {
        return null;
    }

    @Override
    public Npc clamp(float min, float max) {
        return null;
    }

    @Override
    public Npc set(Npc v) {
        return null;
    }

    @Override
    public Npc sub(Npc v) {
        return null;
    }

    @Override
    public Npc nor() {
        return null;
    }

    @Override
    public Npc add(Npc v) {
        return null;
    }

    @Override
    public float dot(Npc v) {
        return 0;
    }

    @Override
    public Npc scl(float scalar) {
        return null;
    }

    @Override
    public Npc scl(Npc v) {
        return null;
    }

    @Override
    public float dst(Npc v) {
        return 0;
    }

    @Override
    public float dst2(Npc v) {
        return 0;
    }

    @Override
    public Npc lerp(Npc target, float alpha) {
        return null;
    }

    @Override
    public Npc interpolate(Npc target, float alpha, Interpolation interpolator) {
        return null;
    }

    @Override
    public Npc setToRandomDirection() {
        return null;
    }

    @Override
    public boolean isUnit() {
        return false;
    }

    @Override
    public boolean isUnit(float margin) {
        return false;
    }

    @Override
    public boolean isZero() {
        return false;
    }

    @Override
    public boolean isZero(float margin) {
        return false;
    }

    @Override
    public boolean isOnLine(Npc other, float epsilon) {
        return false;
    }

    @Override
    public boolean isOnLine(Npc other) {
        return false;
    }

    @Override
    public boolean isCollinear(Npc other, float epsilon) {
        return false;
    }

    @Override
    public boolean isCollinear(Npc other) {
        return false;
    }

    @Override
    public boolean isCollinearOpposite(Npc other, float epsilon) {
        return false;
    }

    @Override
    public boolean isCollinearOpposite(Npc other) {
        return false;
    }

    @Override
    public boolean isPerpendicular(Npc other) {
        return false;
    }

    @Override
    public boolean isPerpendicular(Npc other, float epsilon) {
        return false;
    }

    @Override
    public boolean hasSameDirection(Npc other) {
        return false;
    }

    @Override
    public boolean hasOppositeDirection(Npc other) {
        return false;
    }

    @Override
    public boolean epsilonEquals(Npc other, float epsilon) {
        return false;
    }

    @Override
    public Npc mulAdd(Npc v, float scalar) {
        return null;
    }

    @Override
    public Npc mulAdd(Npc v, Npc mulVec) {
        return null;
    }

    @Override
    public Npc setZero() {
        return null;
    }
}

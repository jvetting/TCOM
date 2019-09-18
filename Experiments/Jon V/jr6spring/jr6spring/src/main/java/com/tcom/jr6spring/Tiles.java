package com.tcom.jr6spring;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.core.style.ToStringCreator;


@Entity
@Table(name = "tiles")
public class Tiles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotFound(action = NotFoundAction.IGNORE)
    private Integer id;

    @Column(name = "character_name")
    @NotFound(action = NotFoundAction.IGNORE)
    private String characterName;

    @Column(name = "red")
    @NotFound(action = NotFoundAction.IGNORE)
    private int red;

    @Column(name = "blue")
    @NotFound(action = NotFoundAction.IGNORE)
    private int blue;

    @Column(name = "green")
    @NotFound(action = NotFoundAction.IGNORE)
    private int green;
    
    @Column(name = "centerX")
    @NotFound(action = NotFoundAction.IGNORE)
    private int x;
    
    @Column(name = "centerY")
    @NotFound(action = NotFoundAction.IGNORE)
    private int y;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isNew() {
        return this.id == null;
    }

    public String getCharacterName() {
        return this.characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public int getRed() {
        return this.red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getBlue() {
        return this.blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public int getGreen() {
        return this.green;
    }

    public void setGreen(int green) {
        this.green = green;
    }
    
    public int getCenterX() {
        return this.centerX;
    }
    
    public void setCenterX(int centerX) {
        this.centerX = centerX;
    }
    
    public int getCenterY() {
        return this.centerY;
    }
    
    public void setCenterY(int centerY) {
        this.centerY = centerY;
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)

                .append("id", this.getId())
                .append("new", this.isNew())
                .append("character_name", this.getCharacterName())
                .append("red", Integer.toString(this.getRed()))
                .append("blue", Integer.toString(this.getBlue()))
                .append("green", Integer.toString(this.getGreen())
                .append("centerX", Integer.toString(this.getCenterX())
                .append("centerY", Integer.toString(this.getCenterY())).toString();
    }
}
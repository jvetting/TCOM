package com.jr_6.tcom;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    //@NotFound(action = NotFoundAction.IGNORE)
    private Integer id;

	//store center values and bool npc
	/**
	@Column(name = "name")
    @NotFound(action = NotFoundAction.IGNORE)
    private String name;
	**/
	

	@Column(name = "centerX")
    //@NotFound(action = NotFoundAction.IGNORE)
    private int centerX;

	@Column(name = "centerY")
    //@NotFound(action = NotFoundAction.IGNORE)
    private int centerY;
	
	@Column(name = "hasPlayer")
	//@NotFound(action = NotFoundAction.IGNORE)
	private boolean hasPlayer;
	
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isNew() {
        return this.id == null;
    }
    /**
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    **/
    public boolean getHasPlayer() {
    	return this.hasPlayer;
    }
    public void setHasPlayer(boolean hasPlayer) {
    	 this.hasPlayer = hasPlayer;
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
                .append("x", this.centerX)
                .append("y", this.centerY)
        		.append("has player", this.hasPlayer).toString();
    }
}

import java.awt.Image;

import oop.ex2.*;

/**
 * The spaceship object that is used in the SpaceWars game
 */
public class SpaceShip {
    private final static int MAXENERGY = 210;
    private final static int CURRENTENERGY = 190;
    private final static int HEALTH = 22;
    protected final static int ZERO = 0;
    private final static int NEGATIVE = -1;
    private final static int FIREROUNDS = 7;
    private final static int FIRINGCOST = 19;
    private final static int TELEPORTINGCOST = 140;
    private final static int SHIELDSCOST = 3;
    private final static int HITCOST = 10;
    private final static int BASHWIN = 18;
    protected final static int RIGHT = -1;
    protected final static int LEFT =1;
    /**
     * The maximal energy level a ship can have.
     */
    int maxEnergy;

    /**
     * The current energy level a ship has.
     */
    int currEnergy;
    /**
     * The health level of a ship.
     */
    int health;
    /**
     * The physics of a ship.
     */
    SpaceShipPhysics physics;
    /**
     * indicates if the shield is on or off.
     */
    boolean isShield;
    /**
     * indicates which round of the game we are at.
     */
    int round;
    /**
     * indicates the last round the ship had fired, initialized with the value -1.
     */
    int lastRoundFired;

    SpaceShip() {
        maxEnergy = MAXENERGY;
        currEnergy = CURRENTENERGY;
        health = HEALTH;
        physics = new SpaceShipPhysics();
        isShield = false;
        round = ZERO;
        lastRoundFired = NEGATIVE;
    }

    /**
     * Does the actions of this ship for this round.
     * This is called once per round by the SpaceWars game driver.
     *
     * @param game the game object to which this ship belongs.
     */
    public void doAction(SpaceWars game) {
        if(this.currEnergy < this.maxEnergy) {
            this.currEnergy += 1;
        }
            this.round++;


    }
    /**
     * A function that turns off the shield
     */
    protected void setShieldFalse(){
        this.isShield = false;
    }
    /**
     * This method checks if the energy doesn't go bellow zero, and updates it after a hit (either getting shot
     * or colliding)
     */
    private void upDateEnergy() {
        if (this.maxEnergy - HITCOST >= 0) {
            this.maxEnergy -= HITCOST;
        } else {
            this.maxEnergy = ZERO;
        }
        if (this.currEnergy > this.maxEnergy) {
            this.currEnergy = this.maxEnergy;
        }
    }

    /**
     * This method is called every time a collision with this ship occurs
     */
    public void collidedWithAnotherShip() {
        if (!isShield) {
            this.health--;
            upDateEnergy();
        } else {
            this.maxEnergy += BASHWIN;
            this.maxEnergy += BASHWIN;
        }
    }

    /**
     * This method is called whenever a ship has died. It resets the ship's
     * attributes, and starts it at a new random position.
     */
    public void reset() {
        maxEnergy = MAXENERGY;
        currEnergy = CURRENTENERGY;
        health = HEALTH;
        physics = new SpaceShipPhysics();
    }

    /**
     * Checks if this ship is dead.
     *
     * @return true if the ship is dead. false otherwise.
     */
    public boolean isDead() {
        if (this.health == ZERO) {
            return true;
        }
        return false;
    }

    /**
     * Gets the physics object that controls this ship.
     *
     * @return the physics object that controls the ship.
     */
    public SpaceShipPhysics getPhysics() {
        return this.physics;
    }

    /**
     * This method is called by the SpaceWars game object when ever this ship
     * gets hit by a shot.
     */
    public void gotHit() {
        if (!isShield) {
            this.health--;
            upDateEnergy();
        }
    }

    /**
     * Gets the image of this ship. This method should return the image of the
     * ship with or without the shield. This will be displayed on the GUI at
     * the end of the round.
     *
     * @return the image of this ship.
     */
    public Image getImage() {
        if (isShield) {
            return GameGUI.ENEMY_SPACESHIP_IMAGE_SHIELD;
        }
        return GameGUI.ENEMY_SPACESHIP_IMAGE;
    }

    /**
     * Attempts to fire a shot.
     *
     * @param game the game object.
     */
    public void fire(SpaceWars game) {
        if (this.round >= this.lastRoundFired + FIREROUNDS && this.currEnergy - FIRINGCOST >= ZERO) {
            this.lastRoundFired = this.round;
            this.currEnergy -= FIRINGCOST;
            game.addShot(this.physics);
        }
    }

    /**
     * Attempts to turn on the shield.
     */
    public void shieldOn() {
        if (this.currEnergy - SHIELDSCOST >= ZERO) {
            this.currEnergy -= SHIELDSCOST;
            this.isShield = true;
        }
    }

    /**
     * Attempts to teleport.
     */
    public void teleport() {
        if (this.currEnergy - TELEPORTINGCOST >= ZERO) {
            this.currEnergy -= TELEPORTINGCOST;
            SpaceShipPhysics newPhysics = new SpaceShipPhysics();
            this.physics = newPhysics;
        }
    }
}


import oop.ex2.GameGUI;
import java.awt.*;

/**
 * The human spaceship object that is used in the SpaceWars game
 */
public class HumanShip extends SpaceShip{

    /**
     * Does the actions of this ship for this round.
     * This is called once per round by the SpaceWars game driver.
     * @param game the game object to which this ship belongs.
     */
    public void doAction(SpaceWars game) {
        this.setShieldFalse();
        if(game.getGUI().isTeleportPressed()){
            teleport();
        }
        boolean acc = game.getGUI().isUpPressed();
        int turn= ZERO;
        if(game.getGUI().isRightPressed()){
            turn = RIGHT;
        }
        if(game.getGUI().isLeftPressed()){
            turn = LEFT;
        }
        this.physics.move(acc,turn);
        if(game.getGUI().isShieldsPressed()){
            shieldOn();
        }
        if(game.getGUI().isShotPressed()){
            fire(game);
        }
        super.doAction(game);
    }

    /**
     * Gets the image of this ship. This method should return the image of the
     * ship with or without the shield. This will be displayed on the GUI at
     * the end of the round.
     *
     * @return the image of this ship.
     */
    @Override
    public Image getImage() {
    if (isShield) {
        return GameGUI.SPACESHIP_IMAGE_SHIELD;
    }
    return GameGUI.SPACESHIP_IMAGE;
    }
}

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * The drunkard spaceship object that is used in the SpaceWars game
 */
public class DrunkShip extends SpaceShip{
    /**
     * Does the actions of this ship for this round.
     * This is called once per round by the SpaceWars game driver.
     * @param game the game object to which this ship belongs.
     */
    public void doAction(SpaceWars game) {
        this.setShieldFalse();
        this.physics.move(true,RIGHT);
        super.doAction(game);
    }

    /**
     * Get the Image Icon from the given path (relative to the source code)
     * @param path the relative path to the image file.
     * @param description A description of the file.
     * @return the icon with the image.
     */
    private static Image createImageIcon(String path, String description) {
        java.net.URL imgURL = SpecialShip.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description).getImage();
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    /** The image of a special spaceship */
    public static final Image CORONA = createImageIcon("corona.gif","");

    /**
     * Gets the image of this ship. This will be displayed on the GUI at
     * the end of the round.
     *
     * @return the image of this ship.
     */
    public Image getImage() {
        return CORONA;
    }

}

import java.awt.Image;
import javax.swing.ImageIcon;
/**
 * The special spaceship object that is used in the SpaceWars game
 */
public class SpecialShip extends SpaceShip{
    private final static double SCAREDDISTANCE = 0.30;

    /**
     * Does the actions of this ship for this round.
     * This is called once per round by the SpaceWars game driver.
     * @param game the game object to which this ship belongs.
     */
    public void doAction(SpaceWars game) {
        this.setShieldFalse();
        SpaceShip closest = game.getClosestShipTo(this);
        double distance = this.physics.distanceFrom(closest.physics);
        if(distance < SCAREDDISTANCE){
            this.physics.move(true,LEFT);
            fire(game);
        }
        else {
            this.physics.move(true, ZERO);
        }
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
    public static final Image ALIEN = createImageIcon("alien.gif","");

    /**
     * Gets the image of this ship. This will be displayed on the GUI at
     * the end of the round.
     *
     * @return the image of this ship.
     */
    public Image getImage() {
        return ALIEN;
   }

}

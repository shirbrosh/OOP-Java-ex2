/**
 * The Runner spaceship object that is used in the SpaceWars game
 */
public class RunnerShip extends SpaceShip{
    private final static double SCAREDANGLE = 0.23;
    private final static double SCAREDDISTANCE = 0.25;
    /**
     * Does the actions of this ship for this round.
     * This is called once per round by the SpaceWars game driver.
     * @param game the game object to which this ship belongs.
     */
    public void doAction(SpaceWars game) {
        SpaceShip closest = game.getClosestShipTo(this);
        int turn;
        double angle = this.physics.angleTo(closest.physics);
        if(angle < ZERO){
            turn = LEFT;
        }
        else {
            turn = RIGHT;
        }
        double distance = this.physics.distanceFrom(closest.physics);
        if(angle< SCAREDANGLE && angle >-SCAREDANGLE && distance < SCAREDDISTANCE){
            teleport();
        }
        this.physics.move(true,turn);
        super.doAction(game);
    }

}

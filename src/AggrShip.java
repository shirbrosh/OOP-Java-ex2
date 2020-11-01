/**
 * The Aggressive spaceship object that is used in the SpaceWars game
 */

public class AggrShip extends SpaceShip{
    private final static double SCAREDANGLE = 0.21;
    /**
     * Does the actions of this ship for this round.
     * This is called once per round by the SpaceWars game driver.
     * @param game the game object to which this ship belongs.
     */
    public void doAction(SpaceWars game) {
        this.setShieldFalse();
        SpaceShip closest = game.getClosestShipTo(this);
        int turn;
        double angle = this.physics.angleTo(closest.physics);
        if(angle < ZERO){
            turn =RIGHT ;
        }
        else {
            turn = LEFT;
        }
        double distance = this.physics.distanceFrom(closest.physics);
        this.physics.move(true,turn);
        if(angle<SCAREDANGLE && angle> - SCAREDANGLE){
            fire(game);
        }
        super.doAction(game);

    }
}


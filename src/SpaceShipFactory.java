/**
 * This class acts as the driver to create all spaceship objects
 */
public class SpaceShipFactory {

    /**
     * creates all the spaceship type objects according to the command line arguments.
     * @param args
     * @return spaceShipArray - an array with all the SpaceShips objects in the game
     */

    public static SpaceShip[] createSpaceShips(String[] args) {
        final String H="h";
        final String R="r";
        final String B="b";
        final String A="a";
        final String D="d";
        final String S="s";
        SpaceShip [] spaceShipArray = new SpaceShip[args.length];
        for(int i =0;i<args.length;i++) {
            switch (args[i]) {
                case H:
                    spaceShipArray[i] = new HumanShip();
                    break;
                case R:
                    spaceShipArray[i] = new RunnerShip();
                    break;
                case B:
                    spaceShipArray[i] = new BasherShip();
                    break;
                case A:
                    spaceShipArray[i] = new AggrShip();
                    break;
                case D:
                    spaceShipArray[i] = new DrunkShip();
                    break;
                case S:
                    spaceShipArray[i] = new SpecialShip();
                    break;

            }
        }
        return spaceShipArray;
    }
}

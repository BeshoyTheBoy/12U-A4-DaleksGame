
import java.awt.Color;

/**
 * This class manages the interactions between the different pieces of the game:
 * the Board, the Daleks, and the Doctor. It determines when the game is over
 * and whether the Doctor won or lost.
 */
public class CatchGame {

    /**
     * Instance variables go up here Make sure to create a Board, 3 Daleks, and
     * a Doctor
     */
    //new board
    private Board board = new Board(12, 12);
    //spawn random daleks
    private Dalek dalek1;
    private Dalek dalek2;
    private Dalek dalek3;
    //spawn Doctor
    private Doctor doctor;

    /**
     * The constructor for the game. Use it to initialize your game variables.
     * (create people, set positions, etc.)
     */
    public CatchGame() {
        dalek1 = new Dalek((int) (Math.random() * 12), (int) (Math.random() * 12));
        dalek2 = new Dalek((int) (Math.random() * 12), (int) (Math.random() * 12));
        dalek3 = new Dalek((int) (Math.random() * 12), (int) (Math.random() * 12));

        doctor = new Doctor((int) (Math.random() * 12), (int) (Math.random() * 12));
        //make doctor
        board.putPeg(Color.GREEN, doctor.getRow(), doctor.getCol());

        //make dalek pegs
        board.putPeg(Color.BLACK, dalek1.getRow(), dalek1.getCol());
        board.putPeg(Color.BLACK, dalek2.getRow(), dalek2.getCol());
        board.putPeg(Color.BLACK, dalek3.getRow(), dalek3.getCol());



    }

    /**
     * The playGame method begins and controls a game: deals with when the user
     * selects a square, when the Daleks move, when the game is won/lost.
     */
    public void playGame() {
        while (true) {

            // *** DOCTOR CRASHES WITH DALEKS ***
            if (doctor.getRow() == dalek1.getRow() && doctor.getCol() == dalek1.getCol()) {
                //Make doctor yellow
                board.removePeg(doctor.getRow(), doctor.getCol());
                board.putPeg(Color.yellow, doctor.getRow(), doctor.getCol());
                board.displayMessage("                              GAME OVER");
                break;
            }

            if (doctor.getRow() == dalek2.getRow() && doctor.getCol() == dalek2.getCol()) {
                //Make doctor yellow
                board.removePeg(doctor.getRow(), doctor.getCol());
                board.putPeg(Color.yellow, doctor.getRow(), doctor.getCol());
                board.displayMessage("                              GAME OVER");
                break;
            }

            if (doctor.getRow() == dalek3.getRow() && doctor.getCol() == dalek3.getCol()) {
                //Make doctor yellow
                board.removePeg(doctor.getRow(), doctor.getCol());
                board.putPeg(Color.yellow, doctor.getRow(), doctor.getCol());
                board.displayMessage("                              GAME OVER");
                break;
            }

            //  *** DALEKS CRASH WITH EACH OTHER ***
            if (dalek1.getRow() == dalek2.getRow() && dalek1.getCol() == dalek2.getCol()) {
                //make crash site red
                board.putPeg(Color.RED, dalek1.getRow(), dalek1.getCol());
                //set daleks crash
                dalek1.crash();
                dalek2.crash();
            }

            if (dalek1.getRow() == dalek3.getRow() && dalek1.getCol() == dalek3.getCol()) {
                //make crash site red
                board.putPeg(Color.RED, dalek1.getRow(), dalek1.getCol());
                dalek1.crash();
                dalek3.crash();
            }

            if (dalek3.getRow() == dalek2.getRow() && dalek3.getCol() == dalek2.getCol()) {
                //make crash site red
                board.putPeg(Color.RED, dalek3.getRow(), dalek3.getCol());
                dalek3.crash();
                dalek2.crash();

            }
            //register clicks
            Coordinate click = board.getClick();
            int clickRow = click.getRow();
            int clickCol = click.getCol();

            //REMOVE old DOCTOR peg
            board.removePeg(doctor.getRow(), doctor.getCol());
            //make doctor move
            doctor.move(clickRow, clickCol);
            //put peg where doctor moved
            board.putPeg(Color.GREEN, doctor.getRow(), doctor.getCol());

            //MOVE DALEK 1
            //remove dalek pegs
            board.removePeg(dalek1.getRow(), dalek1.getCol());
            //move dalek towards doctor
            dalek1.advanceTowards(doctor);
            //put new dalek pegs down
            board.putPeg(Color.BLACK, dalek1.getRow(), dalek1.getCol());


            //MOVE DALEK 2
            //remove dalek pegs
            board.removePeg(dalek2.getRow(), dalek2.getCol());
            //move dalek towards doctor
            dalek2.advanceTowards(doctor);
            //put new dalek pegs down
            board.putPeg(Color.BLACK, dalek2.getRow(), dalek2.getCol());


            //MOVE DALEK 3
            //remove dalek pegs
            board.removePeg(dalek3.getRow(), dalek3.getCol());
            //move dalek towards doctor
            dalek3.advanceTowards(doctor);
            //put new dalek pegs down
            board.putPeg(Color.BLACK, dalek3.getRow(), dalek3.getCol());


            //Did Doctor win Game??
            if (dalek1.hasCrashed() && dalek2.hasCrashed() && dalek3.hasCrashed()) {
                board.putPeg(Color.RED, dalek1.getRow(), dalek1.getCol());
                board.displayMessage("        YOU WON!!!!");
                break;
            }
        }
    }
}

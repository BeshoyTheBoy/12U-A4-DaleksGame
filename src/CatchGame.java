
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
    private Dalek dalek1 = new Dalek((int) (Math.random() * 12), (int) (Math.random() * 12));
    private Dalek dalek2 = new Dalek((int) (Math.random() * 12), (int) (Math.random() * 12));
    private Dalek dalek3 = new Dalek((int) (Math.random() * 12), (int) (Math.random() * 12));
    //spawn Doctor
    private Doctor doctor = new Doctor((int) (Math.random() * 12), (int) (Math.random() * 12));

    /**
     * The constructor for the game. Use it to initialize your game variables.
     * (create people, set positions, etc.)
     */
    public CatchGame() {
        this.board = board;
        this.dalek1 = dalek1;
        this.dalek2 = dalek2;
        this.dalek3 = dalek3;
        this.doctor = doctor;
    }

    /**
     * The playGame method begins and controls a game: deals with when the user
     * selects a square, when the Daleks move, when the game is won/lost.
     */
    public void playGame() {
        while (true) {
            //make doctor
            board.putPeg(Color.GREEN, doctor.getRow(), doctor.getCol());
            //make dalek pegs
            board.putPeg(Color.BLACK, dalek1.getRow(), dalek1.getCol());
            board.putPeg(Color.BLACK, dalek2.getRow(), dalek2.getCol());
            board.putPeg(Color.BLACK, dalek3.getRow(), dalek3.getCol());
            //register clicks
            Coordinate click = board.getClick();           
            int clickRow = click.getRow();
            int clickCol = click.getCol();         
            //remove old peg
            board.removePeg(doctor.getRow(),doctor.getCol());
            //make doctor move
            doctor.move(clickRow, clickCol);
            //put peg where doctor moved
            board.putPeg(Color.GREEN, doctor.getRow(), doctor.getCol());
            
            //remove dalek pegs
            board.removePeg(dalek1.getRow(), dalek1.getCol());
            board.removePeg(dalek2.getRow(), dalek2.getCol());
            board.removePeg(dalek3.getRow(), dalek3.getCol());
            
            //move daleks towards doctor
            dalek1.advanceTowards(doctor);
            dalek2.advanceTowards(doctor);
            dalek3.advanceTowards(doctor);
            
            //put new dalek pegs down
            board.putPeg(Color.BLACK, dalek1.getRow(), dalek1.getCol());
            board.putPeg(Color.BLACK, dalek2.getRow(), dalek2.getCol());
            board.putPeg(Color.BLACK, dalek3.getRow(), dalek3.getCol());
            
            //If 2 daleks crash
        }
    }
}

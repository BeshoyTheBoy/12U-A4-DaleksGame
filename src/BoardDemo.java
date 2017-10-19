
import java.awt.Color;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author awadb3223
 */
public class BoardDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Board b = new Board(8, 8);

        for (int i = 0; i < 8; i++) {
        }
        b.putPeg(Color.WHITE, 3, 5);
        b.putPeg(Color.yellow, 3, 5);

        b.removePeg(3, 5);

        //message
        b.displayMessage("Kiran is a fake fan");

        while (true) {
            //recieve a click from the user
            Coordinate click = b.getClick();
            int clickRow = click.getRow();
            int clickCol = click.getCol();
            //put a peg down
            b.putPeg(Color.white, clickRow, clickCol);
        }
    }
}

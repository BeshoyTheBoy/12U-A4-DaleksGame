
/**
 * This class models the Doctor in the game. A Doctor has a position and can
 * move to a new position.
 */
public class Doctor {

    private int row, col;

    /**
     * Initializes the variables for a Doctor.
     *
     * @param theRow The row this Doctor starts at.
     * @param theCol The column this Doctor starts at.
     */
    public Doctor(int theRow, int theCol) {
        this.row = theRow;
        this.col = theCol;
    }

    /**
     * Move the Doctor. If the player clicks on one of the squares immediately
     * surrounding the Doctor, the peg is moved to that location. Clicking on
     * the Doctor does not move the peg, but instead allows the Doctor to wait
     * in place for a turn. Clicking on any other square causes the Doctor to
     * teleport to a random square (perhaps by using a �sonic screwdriver�).
     * Teleportation is completely random.
     *
     * @param newRow The row the player clicked on.
     * @param newCol The column the player clicked on.
     */
    public void move(int newRow, int newCol) {
        //find the difference between previous and current row
        int diffRow = this.row - newRow;
        int diffCol = this.col - newCol;

        //if same position, stay put
        if (diffRow == 0 && diffCol == 0) {
            //same coordinates
            this.row = newRow;
            this.col = newCol;
            //if square surrounding doctor, move
        } else if (Math.abs(diffRow) == 1 && Math.abs(diffCol) == 1 || 
                   Math.abs(diffRow) == 0 && Math.abs(diffCol) == 1 || 
                   Math.abs(diffRow) == 1 && Math.abs(diffCol) == 0) {
            this.row = newRow;
            this.col = newCol;
        } //else teleport doctor using math.random
        else {
            this.row = (int) (Math.random() * 12);
            this.col = (int) (Math.random() * 12);
        }
    }

    /**
     * Returns the row of this Doctor.
     *
     * @return This Doctor's row.
     */
    public int getRow() {
        return this.row;
    }

    /**
     * Returns the column of this Doctor.
     *
     * @return This Doctor's column.
     */
    public int getCol() {
        return this.col;
    }
}

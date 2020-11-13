package pieces;
import board.Board;
/* King.java
 * By: Faun Schutz
 * Start: 10/11/2020
 * Finish:
 */
public class King extends Piece{
    public King(int x, int y, boolean is_white, String file_path, Board board){
        super(x, y, is_white, file_path, board);
    }

    public boolean canMove(int destination_x, int destination_y){
        // rules to be written here.
        // reminder can move one square up, right, left, or down, or diagonally
        // and can not put himself in danger.

        return true;
    }
}

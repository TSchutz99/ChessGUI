package pieces;
import board.Board;
/* Bishop.java
 * By: Faun Schutz
 * Start: 10/11/2020
 * Finish:
 */
public class Bishop extends Piece{
    public Bishop(int x, int y, boolean is_white, String file_path, Board board){
        super(x, y, is_white, file_path, board);
    }

    public boolean canMove(int destination_x, int destination_y){
        // rules to be written here.
        // reminder can move as many squares diagonally as it wants without jumping over another piece

        return true;
    }
}

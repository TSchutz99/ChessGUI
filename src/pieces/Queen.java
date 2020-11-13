package pieces;
import board.Board;
/* King.java
 * By: Faun Schutz
 * Start: 10/11/2020
 * Finish:
 */
public class Queen extends Piece{
    public Queen(int x, int y, boolean is_white, String file_path, Board board){
        super(x, y, is_white, file_path, board);
    }

    public boolean canMove(int destination_x, int destination_y){
        // rules to be written here.
        // reminder Queen can move backward, sideways, or diagonally, without jumping over any pieces.


        return true;
    }
}

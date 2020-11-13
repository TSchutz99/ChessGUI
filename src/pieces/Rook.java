package pieces;
import board.Board;
/* Rook.java
 * By: Faun Schutz
 * Start: 10/11/2020
 * Finish:
 */
public class Rook extends Piece{
    public Rook(int x, int y, boolean is_white, String file_path, Board board){
        super(x, y, is_white, file_path, board);
    }

    public boolean canMove(int destination_x, int destination_y){
        // rules to be written here.
        // reminder can move as many squares as he wants either forward, or sideways without jumping any pieces

        return true;
    }
}

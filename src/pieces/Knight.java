package pieces;
import ChessGUI.Board;
/* Knight.java
 * By: Faun Schutz
 * Start: 10/11/2020
 * Finish:
 */
public class Knight extends Piece{
    public Knight(int x, int y, boolean is_white, String file_path, Board board){
        super(x, y, is_white, file_path, board);
    }

    public boolean canMove(int destination_x, int destination_y){
        // rules to be written here.
        // reminder knight moves in an L shape.
        //  * *       * * *           *       *
        //  *             *       * * *       *
        //  *                                 * *

        return true;
    }
}

package pieces;
import board.Board;
/* Knight.java
 * By: Faun Schutz
 * Start: 10/11/2020
 * Finish:
 */
public class Knight extends Piece{
    public Knight(int x, int y, boolean is_white, String file_path, Board board){
        super(x, y, is_white, file_path, board);
    }

    @Override
    public boolean canMove(int destination_x, int destination_y){
        // reminder knight moves in an L shape.
        //  * *       * * *           *       *
        //  *             *       * * *       *
        //  *                                 * *
        // This Prevents the Rook from taking his own pieces.
        Piece possiblePiece = board.getPiece(destination_x, destination_y);
        if(possiblePiece != null) {
            if(possiblePiece.isWhite() && isWhite())
                return false;
            if(possiblePiece.isBlack() && isBlack())
                return false;
        }

        return true;
    }
}

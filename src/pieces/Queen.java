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

    @Override
    public boolean canMove(int destination_x, int destination_y){
        // Reminder Queen can move backward, sideways, or diagonally, without jumping over any pieces.
        // This Prevents the Queen from taking her own pieces.
        Piece possiblePiece = board.getPiece(destination_x, destination_y);
        if(possiblePiece != null) {
            if(possiblePiece.isWhite() && isWhite())
                return false;
            if(possiblePiece.isBlack() && isBlack())
                return false;
        }

        // This keeps the Queen moving in a straight or diagonal lines as this piece only can.


        return true;
    }
}

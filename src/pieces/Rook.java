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

    @Override
    public boolean canMove(int destination_x, int destination_y){
        // reminder can move as many squares as he wants either forward, or sideways without jumping any pieces
        Piece possiblePiece = board.getPiece(destination_x, destination_y);

        // This Prevents the Rook from taking his own pieces.
        if(possiblePiece != null) {
            if(possiblePiece.isWhite() && isWhite())
                return false;
            if(possiblePiece.isBlack() && isBlack())
                return false;
        }

        // This keeps the rook moving in a straight line as its piece only can.
        if(this.getX() != destination_x && getY() != destination_y)
            return false;

        // This keeps the rook from jump over other piece as a Rook can not do that.
        String direction = "";
        if(destination_y > getY())
            direction = "south";
        else if(destination_y < getY())
            direction = "north";
        else if(destination_x > getX())
            direction = "east";
        else if(destination_x < getX())
            direction = "west";

        if(direction.equals("south")){
            int spaces_to_move = Math.abs(destination_y - getY());

            for(int i = 0; i < spaces_to_move; i++){
                Piece p = board.getPiece(getX(), getY() + i);

                if(p != null)
                    return false;
            }
        }


        return true;
    }
}

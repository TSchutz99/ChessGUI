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
            if(possiblePiece.isWhite() && this.isWhite())
                return false;
            if(possiblePiece.isBlack() && this.isBlack())
                return false;
        }

        // This keeps the rook moving in a straight line as its piece only can.
        if(this.getX() != destination_x && this.getY() != destination_y)
            return false;

        // This keeps the rook from jump over other piece as a Rook can not do that.
        String direction = "";
        if(destination_y > this.getY())
            direction = "down";
        else if(destination_y < this.getY())
            direction = "up";
        else if(destination_x > this.getX())
            direction = "right";
        else if(destination_x < this.getX())
            direction = "left";

        if(direction.equals("down")){

        }


        return true;
    }
}

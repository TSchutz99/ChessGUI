package pieces;
import board.Board;
/* Bishop.java
 * By: Faun Schutz
 * Start: 10/11/2020
 * Finish: 17/11/2020
 */
public class Bishop extends Piece{
    public Bishop(int x, int y, boolean is_white, String file_path, Board board){
        super(x, y, is_white, file_path, board);
    }

    @Override
    public boolean canMove(int destination_x, int destination_y){
        // reminder can move as many squares diagonally as it wants without jumping over another piece
        // This Prevents the Bishop from taking his own pieces.
        Piece possiblePiece = board.getPiece(destination_x, destination_y);
        if(possiblePiece != null) {
            if(possiblePiece.isWhite() && isWhite())
                return false;
            if(possiblePiece.isBlack() && isBlack())
                return false;
        }

        // This keeps the Bishop moving in diagonal lines as its piece only can and from jumping over other pieces.
        if(getX() == destination_x || getY() == destination_y)
            return false;

        String direction = "";
        int distance;

        if(getX() > destination_x && getY() > destination_y)
            direction = "north-west";
        else if(getX() > destination_x && getY() < destination_y)
            direction = "south-west";
        else if(getX() < destination_x && getY() < destination_y)
            direction = "south-east";
        else if(getX() < destination_x && getY() > destination_y)
            direction = "north-east";

        // For test proposes
        // System.out.println(direction);

        if(direction.equals("north-west")){
            distance = Math.abs(getX() - destination_x);

            if(destination_x != getX() - distance || destination_y != getY() - distance)
                return false;

            for(int i = 1; i < distance; i++) {
                Piece p = board.getPiece(getX() - i, getY() - i);

                if(p != null)
                    return false;
            }
        }
        else if(direction.equals("south-west")){
            distance = Math.abs(getX() - destination_x);

            if(destination_x != getX() - distance || destination_y != getY() + distance)
                return false;

            for(int i = 1; i < distance; i++) {
                Piece p = board.getPiece(getX() - i, getY() + i);

                if(p != null)
                    return false;
            }
        }
        else if(direction.equals("south-east")){
            distance = Math.abs(destination_x - getX());

            if(destination_x != getX() + distance || destination_y != getY() + distance)
                return false;

            for(int i = 1; i < distance; i++) {
                Piece p = board.getPiece(getX() + i, getY() + i);

                if(p != null)
                    return false;
            }
        }
        else if(direction.equals("north-east")){
            distance = Math.abs(destination_x - getX());

            if(destination_x != getX() + distance || destination_y != getY() - distance)
                return false;

            for(int i = 1; i < distance; i++) {
                Piece p = board.getPiece(getX() + i, getY() - i);

                if(p != null)
                    return false;
            }
        }

        return true;
    }
}

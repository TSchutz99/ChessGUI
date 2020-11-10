package pieces;
/* BoardFrame.java
 * By: Faun Schutz
 * Start: 09/11/2020
 * Finish:
 */
public class Piece {
    private int x;
    private int y;
    final private boolean is_white;
    private String file_path;
    public Board board;

    public Piece(int x, int y, boolean is_white, String file_path, Board board){
        this.is_white = is_white;
        this.x = x;
        this.y = y;
        this.file_path = file_path;
        this.board = board;
    }

    public String getFile_path(){
        return file_path;
    }
    public void setFile_path(String file_path){
        this.file_path = file_path;
    }
    public boolean isWhite(){
        return is_white;
    }
    public boolean isBlack(){
        return !is_white;
    }

}

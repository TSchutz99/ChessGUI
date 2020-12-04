package board;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

/* board.Records.java
 * By: Faun Schutz
 * Start: 09/11/2020
 * Finish: 04/12/2020
 *
 *
 */
public class Records {
    public static void save_match_details(String match_info){
        File inFile	= new File("previous_matches.data");
        File outFile = new File("previous_matches.data");

        try {
            FileInputStream inStream = new FileInputStream(inFile);
            ObjectInputStream objectInStream = new ObjectInputStream(inStream);

            ArrayList<String> previous_match_details = (ArrayList<String>) objectInStream.readObject();

            inStream.close();

            FileOutputStream outStream = new FileOutputStream(outFile);
            ObjectOutputStream objectOutStream = new ObjectOutputStream(outStream);

            previous_match_details.add(match_info);

            objectOutStream.writeObject(previous_match_details);

            outStream.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getStackTrace());
            JOptionPane.showMessageDialog(null,"File could not be found!",
                    "Problem Finding File!",JOptionPane.ERROR_MESSAGE);
        } catch (IOException ioe) {
            System.out.println(ioe.getStackTrace());
            JOptionPane.showMessageDialog(null,"File could not be written!",
                    "Problem Writing to File!",JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
            JOptionPane.showMessageDialog(null, "Could not find the appropriate class!",
                    "Problem Finding the Class!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void load_previous_match_details(){
        File inFile	= new File("previous_matches.data");

        try {
            FileInputStream inStream = new FileInputStream(inFile);
            ObjectInputStream objectInStream = new ObjectInputStream(inStream);

            ArrayList<String> previous_match_details = (ArrayList<String>) objectInStream.readObject();

            String Previous_five_matches = "";

            if(previous_match_details.size() >= 5)
                for(int i = 0; i < 5; i++)
                    Previous_five_matches += previous_match_details.get(previous_match_details.size() - i) + "\n";

            else
                for(int i = 0; i < previous_match_details.size(); i++)
                    Previous_five_matches += previous_match_details.get(previous_match_details.size() - i) + "\n";

            JOptionPane.showMessageDialog(null, Previous_five_matches,
                    "Details of some Previous Matches", JOptionPane.INFORMATION_MESSAGE);

            inStream.close();
        }
        catch(FileNotFoundException fnfe){
            fnfe.printStackTrace();
            JOptionPane.showMessageDialog(null,"File could not be found!",
                    "Problem Finding File!",JOptionPane.ERROR_MESSAGE);
        }
        catch(IOException ioe){
            ioe.printStackTrace();
            JOptionPane.showMessageDialog(null,"File could not be read!",
                    "Problem Reading From File!",JOptionPane.ERROR_MESSAGE);
        }
        catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
            JOptionPane.showMessageDialog(null,"Could not find the appropriate class!",
                    "Problem Finding the Class!",JOptionPane.ERROR_MESSAGE);
        }
        catch (ClassCastException cce) {
            cce.printStackTrace();
            JOptionPane.showMessageDialog(null,"Could not convert the object to the appropriate class!",
                    "Problem Converting Object!",JOptionPane.ERROR_MESSAGE);
        }
    }
}

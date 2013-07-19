/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import FileIO.Nonogram;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Owner
 */
public class GUI {

    public GUI() {
        Nonogram n = new Nonogram("test.bmp");
        JFrame frame = new JFrame("FrameDemo");

//2. Optional: What happens when the frame closes?
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//3. Create components and put them in the frame.
//...create emptyLabel...
        GridPane grid = new GridPane(n);
        frame.setContentPane(grid);
        
        //frame.getContentPane().add(panel, BorderLayout.CENTER);
        
//4. Size the frame.
        frame.pack();
        

//5. Show it.
        frame.setVisible(true);
        
    }
    
    public static void main(String args[]){
        GUI gui = new GUI();
    }
}

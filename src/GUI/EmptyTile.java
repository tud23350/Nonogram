/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**Used for filler
 *
 * @author David Osinski
 */
public class EmptyTile extends JPanel {
    
    
    public EmptyTile(Dimension dim){
        super();
        
        setEnabled(true);
        setBackground(Color.WHITE);
        setPreferredSize(dim);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

    }
    
}

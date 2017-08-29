/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testgui;

import javax.swing.ButtonGroup;

/**
 *
 * @author keaton
 */
public class CheckboxGroupHelper {
    public static ButtonGroup cbg = new ButtonGroup();
    // Creates a new instance of Group
    public CheckboxGroupHelper() {
    }
    // Returns a Checkbox Group
    public static ButtonGroup returnGroup() {
        return cbg;
    }
}

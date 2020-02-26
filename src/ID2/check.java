package ID2;

import javax.swing.JLabel;

public class check {
    
    JLabel showLabel;
    
    public check(JLabel JLabel1) {
        showLabel = JLabel1;
    }
    
    public void setMessage(String str) {
        showLabel.setText(str);
    }
    
}

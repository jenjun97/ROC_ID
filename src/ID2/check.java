package ID2;

import javax.swing.JLabel;

public class check {

    JLabel jLabel1;

    public check(JLabel JLabel1) {
        this.jLabel1 = jLabel1;
    }

    public void getInput(String str) {
        jLabel1.setText(str);
    }

}

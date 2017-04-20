import com.sun.deploy.util.StringUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by nata on 20.04.2017.
 */
public class CalculatorEngine implements ActionListener {

    Calculator parent;

    double first;
    double second;
    String action;

    private double calculate(double f, double s, String a){
        switch(a){
            case "+": return f+s;
            case "-":return f-s;
            case "*":return f*s;
            case "/":return Double.isFinite(f/s)?f/s:0;
        }
        return 0;
    }

    public CalculatorEngine(Calculator parent){this.parent = parent;}
    @Override
    public void actionPerformed(ActionEvent e) {
        String btnTxt = ((JButton)e.getSource()).getText();
        if((btnTxt=="-")&&(parent.getDisplayedText().equals(""))) {
            parent.setDisplayedText("-");
        }else if((btnTxt == "+")||(btnTxt == "-")||(btnTxt == "/")||(btnTxt == "*")){
            first = Double.parseDouble(parent.getDisplayedText());
            action = btnTxt;
            parent.setDisplayedText("");
        } else if (btnTxt == "="){
            second = Double.parseDouble(parent.getDisplayedText());
            parent.setDisplayedText(Double.toString(calculate(first,second,action)));
        }else if (btnTxt=="C"){
            first=0;
            second=0;
            parent.setDisplayedText("");
        }
        else
        parent.setDisplayedText(parent.getDisplayedText()+btnTxt);
//      System.out.println(e.getSource().toString());

    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by nata on 20.04.2017.
 */
public class Calculator extends JFrame{

    private int curBtnX = 0;
    private int curBtnY = 1;

    private ActionListener alEngine;

    private GridBagLayout gb;

    private String[] btnNames = {"MC","7","8","9","/","C",
            "MR","4","5","6","*","%",
            "MS","1","2","3","-","1/x",
            "M+" ,"0","+/-",".","+","="};

    private String[] btnState = {"","7","8","9","/","C",
            "","4","5","6","*","",
            "","1","2","3","-","",
            "" ,"0","",".","+","="};

    private JButton btns [] = new JButton[24];

    JTextField displayField;

    public String getDisplayedText(){return displayField.getText();}

    public void setDisplayedText(String text){displayField.setText(text);}



//    void setEngine(ActionListener al){
//        this.alEngine = al;
//        for (JButton btn : btns){
//            btn.addActionListener(al);
//        }
//
//    }

    private void addNextBtn(String text){
        if (curBtnX==6){
            curBtnX=0;
            curBtnY++;
        }

        JButton btn = new JButton();
        btn.setText(text);
        btns[(curBtnY-1)*6+curBtnX] = btn;

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridheight = 1;
        gbc.gridwidth = 1;


        gbc.insets = new Insets(1,1,1,1);
        gbc.insets.left = (curBtnX==0)?10:0;
        gbc.insets.right = ((curBtnX==0)||(curBtnX==5))?10:0;
        gbc.insets.top = (curBtnY==1)?10:0;
        gbc.insets.bottom = (curBtnY==4)?10:0;

        gbc.gridx=curBtnX++;
        gbc.gridy=curBtnY;
        gbc.fill = gbc.BOTH;
        gbc.anchor = gbc.CENTER;
        gbc.ipadx = 10;
        gbc.ipady = 10;



        gb.setConstraints(btn, gbc);

        //CalculatorEngine calcEngine = new CalculatorEngine();
        //btn.addActionListener(calcEngine);
        btn.addActionListener(alEngine);

        this.add(btn);

    }

    public Calculator(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        gb = new GridBagLayout();
        this.setLayout(gb);

        displayField = new JTextField();

        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.gridheight = 1;
        gbc1.gridwidth = 6;
        gbc1.gridx=0;
        gbc1.gridy=0;
        gbc1.fill = gbc1.BOTH;
        gbc1.anchor = gbc1.CENTER;
        gbc1.ipadx = 100;
        gbc1.ipady = 10;
        gbc1.insets = new Insets(1,10,1,10);

        gb.setConstraints(displayField, gbc1);

        this.add(displayField);

        alEngine = new CalculatorEngine(this);

        for (String txt:btnNames)
            addNextBtn(txt);

        for (int i=0;i<btnState.length;i++) {
            if (btnState[i] == "") {
                btns[i].setEnabled(false);
            }
        }


        pack();

        setTitle("Calculator");
        setVisible(true);
    }

    public static void main(String[] args) {

        Calculator frm = new Calculator();
        //frm.setEngine(new CalculatorEngine(frm));
        //frm.setVisible(true);


    }
}


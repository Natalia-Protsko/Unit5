import javax.swing.*;
import java.awt.*;

/**
 * Created by nata on 20.04.2017.
 */
public class SimpleCalculatorGridBag extends JFrame{

     private int curBtnX = 0;
     private int curBtnY = 1;

     private GridBagLayout gb;

     private String[] btnNames = {"MC","7","8","9","/","sqrt",
                                  "MR","4","5","6","*","%",
                                  "MS","1","2","3","-","1/x",
                                  "M+" ,"0","+/-",".","+","="};

     private void addNextBtn(String text){
         GridBagConstraints gbc = new GridBagConstraints();
         gbc.gridheight = 1;
         gbc.gridwidth = 1;

         if (curBtnX==6){
             curBtnX=0;
             curBtnY++;
         }

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


         JButton btn = new JButton();
         btn.setText(text);

         gb.setConstraints(btn, gbc);

         this.add(btn);
     }

    public SimpleCalculatorGridBag(){
        gb = new GridBagLayout();
        this.setLayout(gb);

        JTextField displayField = new JTextField();

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

        for (String txt:btnNames)
           addNextBtn(txt);


        pack();

        setTitle("Calculator");
        setVisible(true);
    }

    public static void main(String[] args) {

        SimpleCalculatorGridBag frm = new SimpleCalculatorGridBag();


    }
}

import java.awt.Frame;
import java.awt.Label;
import java.awt.Button;
import java.awt.TextField;
import java.awt.Panel;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmDeposit extends Frame{
    Label labelUserName, labelMoney;
    TextField txtUserName, txtMoney;
    Button btnSubmit, btnBack, btnClear;
    Font font = new Font("Arial", Font.BOLD, 18);

    public frmDeposit(){
        //Panel 1
        Panel p1 = new Panel();
        p1.setLayout(new FlowLayout());
        labelUserName = new Label("Username: ");
        labelUserName.setFont(font);
        labelMoney = new Label("Money: ");
        labelMoney.setFont(font);
        txtUserName = new TextField(30);
        txtMoney = new TextField(15);
        p1.add(labelUserName);
        p1.add(txtUserName);
        p1.add(labelMoney);
        p1.add(txtMoney);
        p1.add(new Label("$"));

        //Panel 2
        Panel p2 = new Panel();
        p2.setLayout(new FlowLayout());
        btnSubmit = new Button("Submit");
        btnBack = new Button("Back");
        btnClear = new Button("Clear");
        p2.add(btnBack);
        p2.add(btnSubmit);
        p2.add(btnClear);

        //Panel p12
        Panel p = new Panel();
        p.setLayout(new BorderLayout());
        p.add(p1, BorderLayout.NORTH);
        p.add(p2, BorderLayout.CENTER);

        //window close
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });

        btnBack.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new frmProduct();
            }
        });

        btnClear.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                txtUserName.setText("");
                txtMoney.setText("");
                txtUserName.requestFocus();
            }
        });

        btnSubmit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                userData.name = txtUserName.getText();
                userData.money = Double.parseDouble(txtMoney.getText());

                new frmCart();
            }
        });

        //frame
        setSize(720, 720);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Add to Cart");
        add(p);
    }
    public static void main(String[] args){new frmProduct();}
}

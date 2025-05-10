import java.awt.Frame;
import java.awt.Label;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.Button;
import java.awt.Font;
import java.awt.TextField;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmCart extends Frame {
    Label labelProfile, labelProduct;
    TextField txtMoney, txtPrice, txtResult;
    Button btnPurchased;
    Font font = new Font("Arial", Font.BOLD, 20);

    public frmCart(){
        //Panel 1
        Panel p1 = new Panel();
        p1.setLayout(new FlowLayout());
        labelProfile = new Label(userData.name + ": $");
        txtMoney = new TextField(userData.money + "");
        labelProfile.setFont(font);
        p1.add(labelProfile);
        p1.add(txtMoney);

        //Panel 2
        Panel p2 = new Panel();
        p2.setLayout(new FlowLayout());
        labelProduct = new Label("Product: ");
        txtPrice = new TextField(productData.totalProd + "");
        p2.add(labelProduct);
        p2.add(txtPrice);

        //Panel 3
        Panel p3 = new Panel();
        p3.setLayout(new FlowLayout());
        btnPurchased = new Button("Purchase");
        p3.add(btnPurchased);

        //Panel 4
        Panel p4 = new Panel();
        p4.setLayout(new FlowLayout());
        txtResult = new TextField(40);
        p4.add(txtResult);

        //Panel 1 + 2
        Panel p12 = new Panel();
        p12.setLayout(new BorderLayout());
        p12.add(p1, BorderLayout.NORTH);
        p12.add(p2, BorderLayout.CENTER);

        //Panel 3 + 4
        Panel p34 = new Panel();
        p34.setLayout(new BorderLayout());
        p34.add(p3, BorderLayout.NORTH);
        p34.add(p4, BorderLayout.CENTER);

        //Panel
        Panel p = new Panel();
        p.setLayout(new BorderLayout());
        p.add(p12, BorderLayout.NORTH);
        p.add(p34, BorderLayout.CENTER);

 ;       //Frame
        setSize(720, 720);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Cart");
        add(p);

        btnPurchased.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String result;
                if(userData.money >= productData.totalProd) {
                    result = "Purchased is successes";
                    userData.money = userData.money - productData.totalProd;
                    txtMoney.setText(userData.money + "");
                    txtResult.setText(result);
                }
                else{
                    result = "Purchased is failed";
                    txtResult.setText(result);
                }
            }
        });

        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
    }

    public static void main(String[] args){new frmCart();}
}

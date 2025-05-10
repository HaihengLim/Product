import java.awt.Frame;
import java.awt.Color;
import java.awt.Label;
import java.awt.Button;
import java.awt.TextField;
import java.awt.Panel;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class frmProduct extends Frame{
    Label disLabel, quantityLabel;
    TextField txtQuantity;
    Button btnAdd, btnRemove, btnClear, btnAddToCart, btnDeposit, btnAddX5, btnAddX10;
    Font font = new Font("Arial", Font.BOLD, 30);
    Checkbox pro1, pro2, pro3;
    CheckboxGroup g = new CheckboxGroup();
    int Quantity = 0;

    public frmProduct(){
        //Panel 1
        Panel p1 = new Panel();
        p1.setLayout(new FlowLayout());
        disLabel = new Label("NIKA Gaming Shop");
        disLabel.setFont(font);
        disLabel.setForeground(Color.BLACK);
        p1.add(disLabel);

        //Panel 2
        Panel p2 = new Panel();
        p2.setLayout(new FlowLayout());
        p2.add(pro1 = new Checkbox("Product1: $29.99", g, false));
        p2.add(pro2 = new Checkbox("Product2: $49.99", g, false));
        p2.add(pro3 = new Checkbox("Product3: $59.99", g, false));

        //Panel 3
        Panel p3 = new Panel();
        p3.setLayout(new FlowLayout());
        quantityLabel = new Label("Quantity: ");

        //row counter
        Panel rowCounter = new Panel();
        rowCounter.setLayout(new FlowLayout(FlowLayout.LEFT));
        txtQuantity = new TextField(Quantity + "");
        txtQuantity.setEditable(false);
        btnAdd = new Button("Add");
        btnAddX5 = new Button("5+");
        btnAddX10 = new Button("10+");
        btnRemove = new Button("Remove");
        btnClear = new Button("Clear");
        rowCounter.add(txtQuantity);
        rowCounter.add(btnAdd);
        rowCounter.add(btnAddX5);
        rowCounter.add(btnAddX10);
        rowCounter.add(btnRemove);
        rowCounter.add(btnClear);

        p3.add(quantityLabel);
        p3.add(rowCounter);

        //Panel 4
        Panel p4 = new Panel();
        p4.setLayout(new FlowLayout());
        btnAddToCart = new Button("Add to Cart");

        //DepositPanel
        Panel depositPanel = new Panel();
        depositPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        btnDeposit = new Button("Deposit");
        p4.add(btnAddToCart);
        p4.add(btnDeposit);

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

        //Frame
        setSize(720, 720);
        setLocationRelativeTo(null);
        setTitle("NIKA Gaming Shop");
        setVisible(true);
        setResizable(false);
        add(p);

        btnAdd.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Quantity++;
                txtQuantity.setText(Quantity + "");
            }
        });

        btnAddX5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Quantity = Quantity + 5;
                txtQuantity.setText(Quantity + "");
            }
        });

        btnAddX10.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Quantity = Quantity + 10;
                txtQuantity.setText(Quantity + "");
            }
        });

        btnRemove.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Quantity--;
                txtQuantity.setText(Quantity + "");
            }
        });

        btnClear.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Quantity = 0;
                txtQuantity.setText(Quantity + "");
            }
        });

        btnDeposit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new frmDeposit();
            }
        });

        btnAddToCart.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(pro1.getState()){
                    productData.prod1 = 29.99;
                    productData.totalProd = productData.prod1 * Quantity;
                }
                else if(pro2.getState()){
                    productData.prod2 = 49.99;
                    productData.totalProd = productData.prod2 * Quantity;
                }
                else if(pro3.getState()){
                    productData.prod3 = 59.99;
                    productData.totalProd = productData.prod3 * Quantity;
                }
                new frmDeposit();
            }
        });

        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
    }

    public static void main(String[] args){new frmProduct();}
}

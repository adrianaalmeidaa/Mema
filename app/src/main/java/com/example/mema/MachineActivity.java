package com.example.mema;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mema.models.Drawer;
import com.example.mema.models.Machine;
import com.example.mema.models.Product;
import com.example.mema.models.User;

import java.util.ArrayList;

public class MachineActivity extends AppCompatActivity {

    private User user;
    private ArrayList<Product> produtos;
    private Drawer drawer1;
    private Machine machine;
    TextView textViewBalanceValue;
    TextView textViewSaborValue;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_machine);
        this.user = (User) getIntent().getSerializableExtra("user");
        Log.v("Machine Activity User", String.valueOf(this.user.getBalance()));

        //Product product1 = new Product();
        //Product product2 = new Product("qfa");
        //Product product3 = new Product("qdq","pringleBacon",1,"2024-03-01");

        //Log.v("Producto1",product1.toString());
        //Log.v("Producto2",product2.toString());
        //Log.v("Producto3",product3.toString());

        //this.produtos = new ArrayList<Product>();
        //produtos.add(product1);
        //produtos.add(product2);

        //this.drawer1 = new Drawer("bacon",produtos,0);

        //Log.v("drawer1",drawer1.toString());
        //Log.v("drawer1",String.valueOf(drawer1.productsQuantity()));

        machine = new Machine("Bacon", "Alho", "Ketchup", "Mostarda");
        Log.v("machine", String.valueOf(machine.getDrawers().size()));

        this.buildMachine();

        this.textViewBalanceValue = findViewById(R.id.text_view_balance_value);
        this.textViewBalanceValue.setText(String.valueOf(this.user.getBalance()));
        textViewBalanceValue.setTextColor(Color.parseColor("#FFFFFF"));

        if(this.user.alertBalance()){
            textViewBalanceValue.setTextColor(Color.parseColor("#FF0000"));
        }

    }
    private void buildMachine() {
        Product produto1 = new Product("037000184935", "Bacon", 1, "2024-03-01");
        Product produto2 = new Product("037000184935", "Bacon", 1, "2024-03-01");
        Product produto3 = new Product("7896004006482", "Normais", 1, "2024-03-01");
        Product produto4 = new Product("7896004006482", "Normais", 1, "2024-03-01");
        Product produto5 = new Product("7896004006239", "Sabor creme e cebola", 1, "2024-03-01");
        Product produto6 = new Product("7896004008998", "Cheddar e Bacon", 1, "2024-03-01");

        this.machine.addProductToDrawer(0,produto1);
        this.machine.addProductToDrawer(0,produto2);
        this.machine.addProductToDrawer(1,produto3);
        this.machine.addProductToDrawer(1,produto4);
        this.machine.addProductToDrawer(2,produto5);
        this.machine.addProductToDrawer(3,produto6);

        //Verificar se os produtos foram adicionados a gaveta do indice 0
        Log.v("QuantidadeGaveta", String.valueOf(this.machine.verifyQuantityAvailable(0)));
        Log.v("QuantidadeGaveta", String.valueOf(this.machine.verifyQuantityAvailable(1)));
        Log.v("QuantidadeGaveta", String.valueOf(this.machine.verifyQuantityAvailable(2)));
        Log.v("QuantidadeGaveta", String.valueOf(this.machine.verifyQuantityAvailable(3)));
    }

    public void buyProduct1(View view ){
        Log.v("QuantidadeP-0",String.valueOf(this.machine.verifyQuantityAvailable(0)));

        this.textViewSaborValue = findViewById(R.id.text_view_data_selected_drawer);
        this.textViewSaborValue.setText(String.valueOf(this.machine.getDrawers().get(0).getFlavour()));
    }
    public void buyProduct2(View view ){
        Toast.makeText(this, "Comprar 2", Toast.LENGTH_SHORT).show();
    }
    public void buyProduct3(View view ){
        Toast.makeText(this, "Comprar 3", Toast.LENGTH_SHORT).show();
    }
    public void buyProduct4(View view ){
        Toast.makeText(this, "Comprar 4", Toast.LENGTH_SHORT).show();
    }
}
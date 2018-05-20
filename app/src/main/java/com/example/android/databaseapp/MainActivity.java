package com.example.android.databaseapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText productInput;
    TextView productOutput;
    Button addButton, deleteButton;
    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        productInput = (EditText) findViewById(R.id.productInput);
        productOutput = (TextView) findViewById(R.id.productOutput);
        addButton = (Button) findViewById(R.id.addButton);
        deleteButton = (Button) findViewById(R.id.deleteButton);

        dbHandler = new MyDBHandler(this, null, null, 1);
        printDatabase();
    }

    /*add a product  to the database*/
    public void addButtonClicked(View view) {
        String product = productInput.getText().toString();
        Product p = new Product(product);
        dbHandler.addProduct(p);
        printDatabase();
    }

    /*delete items*/
    public void deleteButtonClicked(View view) {
        String inputText = productInput.getText().toString();
        dbHandler.deleteProduct(inputText);
        printDatabase();
    }

    public void printDatabase() {
        String dbString = dbHandler.databaseToString();
        productOutput.setText(dbString);
        productInput.setText("");
    }
}

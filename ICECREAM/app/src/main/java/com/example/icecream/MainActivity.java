package com.example.icecream;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int qua=0;
    boolean flag=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * This method is called when the order button is clicked.
     */
    public void email_order(View view)
    {
        EditText text = (EditText)findViewById(R.id.editTextTextPersonName);
        String str = text.getText().toString();
        TextView  order_text_sum= (TextView) findViewById(R.id.order_summary);
        int asd=5*qua;
        String final_text="ORDER SUMMARY\n"+"Name : "+str+"\n"+"Quantities : "+qua+"\n"+"Price :  ₹"+asd;
        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_TEXT, final_text);
        email.setType("message/rfc822");
        startActivity(Intent.createChooser(email, "Send Mail Using :"));
    }

    public void increment(View view)
    {
        if(qua* 5 < 100) {
            qua++;
        }
        display(qua);
        displayPrice(qua * 5);
    }

    public void decreament(View view)
    {
        qua--;
        if(qua<0)
            qua=0;

        display(qua);
        displayPrice(qua * 5);
    }

    public void submitOrder(View view) {
        String qwe="Thank you :)";
        displayMessage(qwe);
        EditText text = (EditText)findViewById(R.id.editTextTextPersonName);
        String str = text.getText().toString();
        TextView  order_text_sum= (TextView) findViewById(R.id.order_summary);
        int asd=5*qua;
        order_text_sum.setText("ORDER SUMMARY\n"+"Name : "+str+"\n"+"Quantities : "+qua+"\n"+"Price :  ₹"+asd);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText("₹"+number);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message)
    {
        if(flag==false)
        {
            TextView priceTextView = (TextView) findViewById(R.id.tex);
            priceTextView.setText(message);
            TextView Reset = (TextView) findViewById(R.id.order_button);
            Reset.setText("RESET");
            TextView Price_t=(TextView) findViewById(R.id.price_text);
            Price_t.setText("TOTAL");
            TextView  order_text_sum= (TextView) findViewById(R.id.order_summary);
            order_text_sum.setText("ORDER SUMMARY");
            flag=true;
        }
        else
        {
            TextView R_priceTextView =(TextView) findViewById(R.id.tex);
            R_priceTextView.setText("QUANTITY");
            TextView R_Reset=(TextView) findViewById(R.id.order_button);
            R_Reset.setText("PREVIEW");
            TextView Pric_t=(TextView) findViewById(R.id.price_text);
            Pric_t.setText("PRICE");
            qua=0;
            display(qua);
            displayPrice(qua * 5);
            flag=false;
        }
    }
}
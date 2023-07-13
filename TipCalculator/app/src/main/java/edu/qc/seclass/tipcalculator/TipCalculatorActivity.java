package edu.qc.seclass.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TipCalculatorActivity extends AppCompatActivity {

    private EditText checkAmount, partySize;
    private EditText fifteenPercentTip,twentyPercentTip,twentyfivePercentTip;
    private EditText fifteenPercentTotal,twentyPercentTotal,twentyfivePercentTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Happens when the "COMPUTE TIP" button is pressed
    public void pressButton(View v) {
        // Assign EditText objects to their respective ids
        checkAmount = (EditText)findViewById(R.id.checkAmountValue);
        partySize = (EditText)findViewById(R.id.partySizeValue);

        fifteenPercentTip = (EditText)findViewById(R.id.fifteenPercentTipValue);
        twentyPercentTip = (EditText)findViewById(R.id.twentyPercentTipValue);
        twentyfivePercentTip = (EditText)findViewById(R.id.twentyfivePercentTipValue);

        fifteenPercentTotal = (EditText)findViewById(R.id.fifteenPercentTotalValue);
        twentyPercentTotal = (EditText)findViewById(R.id.twentyPercentTotalValue);
        twentyfivePercentTotal = (EditText)findViewById(R.id.twentyfivePercentTotalValue);

        // Invalid input: Empty input, negative numbers, Party size = 0 (divide by 0)
        if (checkAmount.getText().toString().equals("") || partySize.getText().toString().equals("") || Integer.parseInt(partySize.getText().toString()) == 0) {
            Toast.makeText(TipCalculatorActivity.this,"Empty or incorrect value(s)!",Toast.LENGTH_SHORT).show();
        }

        // Compute tips and totals
        else {
            /* Calculations (Rounded to nearest integer)
            Tip: splitWithoutTip * percentage
            Total: splitWithoutTip + tip */
            double check = Double.parseDouble(checkAmount.getText().toString());
            int party = Integer.parseInt(partySize.getText().toString());

            double splitWithoutTip = check / party;

            int fifteenTip = (int) Math.round(splitWithoutTip * .15);
            int fifteenTotal = (int) splitWithoutTip + fifteenTip;

            int twentyTip = (int) Math.round(splitWithoutTip * .20);
            int twentyTotal = (int) splitWithoutTip + twentyTip;

            int twentyfiveTip = (int) Math.round(splitWithoutTip * .25);
            int twentyfiveTotal = (int) splitWithoutTip + twentyfiveTip;

            // Output calculations
            fifteenPercentTip.setText(String.valueOf(fifteenTip));
            twentyPercentTip.setText(String.valueOf(twentyTip));
            twentyfivePercentTip.setText(String.valueOf(twentyfiveTip));

            fifteenPercentTotal.setText(String.valueOf(fifteenTotal));
            twentyPercentTotal.setText(String.valueOf(twentyTotal));
            twentyfivePercentTotal.setText(String.valueOf(twentyfiveTotal));
        }
   }
}
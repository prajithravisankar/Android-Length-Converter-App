package com.prajithravisankar.lengthconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {


    private EditText input;
    private Spinner left;
    private Spinner right;
    private Button button;
    private TextView finalResult;
    private String leftSelected;
    private String rightSelected;
    private double inputInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initiateVariable();
        setUpListenersForSpinners();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertAndDisplayResults();
            }
        });
    }

    private void initiateVariable() {
        input = findViewById(R.id.edittext_input);
        left = findViewById(R.id.spinner_from);
        right = findViewById(R.id.spinner_to);
        button = findViewById(R.id.button_convert);
        finalResult = findViewById(R.id.textview_final);
        addListOfOptionsToSpinners();
    }

    private void addListOfOptionsToSpinners() {
        // add cm, m, km, mile, yard, foot, inch to the list in both left and right spinners
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.length_units,
                android.R.layout.simple_spinner_dropdown_item);
        left.setAdapter(adapter);
        right.setAdapter(adapter);
    }

    private void setUpListenersForSpinners() {

        left.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                leftSelected = adapterView.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // do nothing
            }
        });

        right.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                rightSelected = adapterView.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // do nothing
            }
        });
    }

    private void convertAndDisplayResults() {
        String inputString = input.getText().toString().trim();
        if (inputString.isEmpty()) {
            Toast.makeText(MainActivity.this, "give an integer", Toast.LENGTH_LONG).show();
        }
        try {
            inputInt = Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            Toast.makeText(MainActivity.this, "please enter a valid integer", Toast.LENGTH_LONG).show();
        }

        convertInputFromTo(inputInt, leftSelected, rightSelected);
    }

    private void convertInputFromTo(double inputInt, String from, String to) {
        String result;
        if (from.equals(to)) {
            result = inputInt + " " + from + " is " + inputInt + " " + to;
            finalResult.setText(result);
        } else {
            doAppropriateConversions(inputInt, from, to);
        }
    }

    private void doAppropriateConversions(double inputInt, String from, String to) {

        switch (from) {
            case "centimeter":
                fromCentimeter(inputInt, from, to);
                break;
            case "meter":
                fromMeter(inputInt, from, to);
                break;
            case "kilometer":
                fromKiloMeter(inputInt, from, to);
                break;
            case "mile":
                fromMile(inputInt, from, to);
                break;
            case "yard":
                fromYard(inputInt, from, to);
                break;
            case "foot":
                fromFoot(inputInt, from, to);
                break;
            case "inch":
                fromInch(inputInt, from, to);
                break;
        }
    }

    private void fromInch(double inputInt, String from, String to) {
        double output;
        String result;
        // inch
        if (from.equals("inch") && to.equals("meter")) {
            output = inputInt * 0.0254;
            result = inputInt + " " + from + " is " + output + " " + to;
            finalResult.setText(result);
        } else if (from.equals("inch") && to.equals("kilometer")) {
            output = inputInt / 39370.1;
            result = inputInt + " " + from + " is " + output + " " + to;
            finalResult.setText(result);
        } else if (from.equals("inch") && to.equals("mile")) {
            output = inputInt / 63360;
            result = inputInt + " " + from + " is " + output + " " + to;
            finalResult.setText(result);
        } else if (from.equals("inch") && to.equals("yard")) {
            output = inputInt / 36;
            result = inputInt + " " + from + " is " + output + " " + to;
            finalResult.setText(result);
        } else if (from.equals("inch") && to.equals("foot")) {
            output = inputInt / 12;
            result = inputInt + " " + from + " is " + output + " " + to;
            finalResult.setText(result);
        } else if (from.equals("inch") && to.equals("centimeter")) {
            output = inputInt * 2.54;
            result = inputInt + " " + from + " is " + output + " " + to;
            finalResult.setText(result);
        } else {
            // do nothing
        }
    }

    private void fromFoot(double inputInt, String from, String to) {
        double output;
        String result;
        // foot
        if (from.equals("foot") && to.equals("meter")) {
            output = inputInt * 0.3048;
            result = inputInt + " " + from + " is " + output + " " + to;
            finalResult.setText(result);
        } else if (from.equals("foot") && to.equals("kilometer")) {
            output = inputInt * 0.0003048;
            result = inputInt + " " + from + " is " + output + " " + to;
            finalResult.setText(result);
        } else if (from.equals("foot") && to.equals("mile")) {
            output = inputInt * 0.000189394;
            result = inputInt + " " + from + " is " + output + " " + to;
            finalResult.setText(result);
        } else if (from.equals("foot") && to.equals("yard")) {
            output = inputInt * 0.333333;
            result = inputInt + " " + from + " is " + output + " " + to;
            finalResult.setText(result);
        } else if (from.equals("foot") && to.equals("centimeter")) {
            output = inputInt * 30.48;
            result = inputInt + " " + from + " is " + output + " " + to;
            finalResult.setText(result);
        } else if (from.equals("foot") && to.equals("inch")) {
            output = inputInt * 12;
            result = inputInt + " " + from + " is " + output + " " + to;
            finalResult.setText(result);
        } else {
            // do nothing
        }
    }

    private void fromYard(double inputInt, String from, String to) {
        double output;
        String result;
        // yard
        if (from.equals("yard") && to.equals("meter")) {
            output = inputInt * 0.9144;
            result = inputInt + " " + from + " is " + output + " " + to;
            finalResult.setText(result);
        } else if (from.equals("yard") && to.equals("kilometer")) {
            output = inputInt * 0.0009144;
            result = inputInt + " " + from + " is " + output + " " + to;
            finalResult.setText(result);
        } else if (from.equals("yard") && to.equals("mile")) {
            output = inputInt * 0.000568182;
            result = inputInt + " " + from + " is " + output + " " + to;
            finalResult.setText(result);
        } else if (from.equals("yard") && to.equals("centimeter")) {
            output = inputInt * 91.44;
            result = inputInt + " " + from + " is " + output + " " + to;
            finalResult.setText(result);
        } else if (from.equals("yard") && to.equals("foot")) {
            output = inputInt * 3;
            result = inputInt + " " + from + " is " + output + " " + to;
            finalResult.setText(result);
        } else if (from.equals("yard") && to.equals("inch")) {
            output = inputInt * 36;
            result = inputInt + " " + from + " is " + output + " " + to;
            finalResult.setText(result);
        } else {
            // do nothing
        }
    }

    private void fromMile(double inputInt, String from, String to) {
        String result;
        double output;
        // mile
        if (from.equals("mile") && to.equals("meter")) {
            output = inputInt * 1609.34;
            result = inputInt + " " + from + " is " + output + " " + to;
            finalResult.setText(result);
        } else if (from.equals("mile") && to.equals("kilometer")) {
            output = inputInt * 1.609339999412218;
            result = inputInt + " " + from + " is " + output + " " + to;
            finalResult.setText(result);
        } else if (from.equals("mile") && to.equals("centimeter")) {
            output = inputInt * 160934;
            result = inputInt + " " + from + " is " + output + " " + to;
            finalResult.setText(result);
        } else if (from.equals("mile") && to.equals("yard")) {
            output = inputInt * 1760;
            result = inputInt + " " + from + " is " + output + " " + to;
            finalResult.setText(result);
        } else if (from.equals("mile") && to.equals("foot")) {
            output = inputInt * 5280;
            result = inputInt + " " + from + " is " + output + " " + to;
            finalResult.setText(result);
        } else if (from.equals("mile") && to.equals("inch")) {
            output = inputInt * 63360;
            result = inputInt + " " + from + " is " + output + " " + to;
            finalResult.setText(result);
        } else {
            // do nothing
        }
    }

    private void fromKiloMeter(double inputInt, String from, String to) {
        double output;
        String result;
        // kilometer
        if (from.equals("kilometer") && to.equals("meter")) {
            output = inputInt * 1000;
            result = inputInt + " " + from + " is " + output + " " + to;
            finalResult.setText(result);
        } else if (from.equals("kilometer") && to.equals("centimeter")) {
            output = inputInt * 100000;
            result = inputInt + " " + from + " is " + output + " " + to;
            finalResult.setText(result);
        } else if (from.equals("kilometer") && to.equals("mile")) {
            output = inputInt / 1.60934;
            result = inputInt + " " + from + " is " + output + " " + to;
            finalResult.setText(result);
        } else if (from.equals("kilometer") && to.equals("yard")) {
            output = inputInt * 1093.61;
            result = inputInt + " " + from + " is " + output + " " + to;
            finalResult.setText(result);
        } else if (from.equals("kilometer") && to.equals("foot")) {
            output = inputInt * 3280.84;
            result = inputInt + " " + from + " is " + output + " " + to;
            finalResult.setText(result);
        } else if (from.equals("kilometer") && to.equals("inch")) {
            output = inputInt * 39370.1;
            result = inputInt + " " + from + " is " + output + " " + to;
            finalResult.setText(result);
        } else {
            // do nothing
        }
    }

    private void fromMeter(double inputInt, String from, String to) {
        double output;
        String result;
        // meter
        if (from.equals("meter") && to.equals("centimeter")) {
            output = inputInt * 100;
            result = inputInt + " " + from + " is " + output + " " + to;
            finalResult.setText(result);
        } else if (from.equals("meter") && to.equals("kilometer")) {
            output = inputInt /1000;
            result = inputInt + " " + from + " is " + output + " " + to;
            finalResult.setText(result);
        } else if (from.equals("meter") && to.equals("mile")) {
            output = inputInt /1609.34;
            result = inputInt + " " + from + " is " + output + " " + to;
            finalResult.setText(result);
        } else if (from.equals("meter") && to.equals("yard")) {
            output = inputInt * 1.09361;
            result = inputInt + " " + from + " is " + output + " " + to;
            finalResult.setText(result);
        } else if (from.equals("meter") && to.equals("foot")) {
            output = inputInt * 3.28084;
            result = inputInt + " " + from + " is " + output + " " + to;
            finalResult.setText(result);
        } else if (from.equals("meter") && to.equals("inch")) {
            output = inputInt * 0.0254;
            result = inputInt + " " + from + " is " + output + " " + to;
            finalResult.setText(result);
        } else {
            // do nothing
        }
    }

    private void fromCentimeter(double inputInt, String from, String to) {
        double output;
        String result;
        // centimeter
        if (from.equals("centimeter") && to.equals("meter")) {
            output = inputInt /100;
            result = inputInt + " " + from + " is " + output + " " + to;
            finalResult.setText(result);
        } else if (from.equals("centimeter") && to.equals("kilometer")) {
            output = inputInt /100000;
            result = inputInt + " " + from + " is " + output + " " + to;
            finalResult.setText(result);
        } else if (from.equals("centimeter") && to.equals("mile")) {
            output = inputInt /160934.4;
            result = inputInt + " " + from + " is " + output + " " + to;
            finalResult.setText(result);
        } else if (from.equals("centimeter") && to.equals("yard")) {
            output = inputInt /91.44;
            result = inputInt + " " + from + " is " + output + " " + to;
            finalResult.setText(result);
        } else if (from.equals("centimeter") && to.equals("foot")) {
            output = inputInt /30.48;
            result = inputInt + " " + from + " is " + output + " " + to;
            finalResult.setText(result);
        } else if (from.equals("centimeter") && to.equals("inch")) {
            output = inputInt /2.54;
            result = inputInt + " " + from + " is " + output + " " + to;
            finalResult.setText(result);
        } else {
            // do nothing
        }
    }
}
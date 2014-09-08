package com.kdk.tipcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class TipCalculator extends Activity {

	private double price;
	private int percent;
	private int split;
	private static final int DEFAULT_TIP_PERCENT = 15;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);
        EditText etPrice = (EditText) findViewById(R.id.etPrice);
        EditText etCustomTip = (EditText) findViewById(R.id.etCustomTip);
        EditText etSplit = (EditText) findViewById(R.id.etSplit);
        percent = DEFAULT_TIP_PERCENT;
        split = 1;
        
        etPrice.addTextChangedListener(new TextWatcher(){

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				//NOP
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				//NOP
			}

			@Override
			public void afterTextChanged(Editable s) {
				try{
					price = Double.parseDouble(s.toString());
					calcTip();
				}catch(NumberFormatException e){
					s.clear();
				}
			}
        	
        });
        etCustomTip.addTextChangedListener(new TextWatcher(){

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// NOP
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				//NOP
			}

			@Override
			public void afterTextChanged(Editable s) {
				try{
					percent = Integer.parseInt(s.toString());
					calcTip();
				}catch(NumberFormatException e){
					s.clear();
				}
			}
        	
        });
        
        etSplit.addTextChangedListener(new TextWatcher(){

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void afterTextChanged(Editable s) {
				try{
					split = Integer.parseInt(s.toString());
					calcTip();
				}catch(Exception e){
					s.clear();
					s.append("1");
					calcTip();
				}
				
			}
        	
        });
    }
    
    private void calcTip(){
		TextView tvTip = (TextView) findViewById(R.id.tvTip);

    	try{
        	EditText etPrice = (EditText) findViewById(R.id.etPrice);
        	price =  Double.valueOf(etPrice.getText().toString());
        	tvTip.setText(String.format("%.2f", (price*percent/100)/split));
    	}catch (NumberFormatException e){
    		Log.d("TipCalc", "caught");
    		tvTip.setText("");
    	}
    }
    
    public void setTip10Percent(View v){
    	Log.d("TipCalc", "10%");
    	percent = 10;
    	calcTip();
    }
    
    public void setTip15Percent(View v){
    	Log.d("TipCalc", "15%");
    	percent = 15;
    	calcTip();
    }
    
    public void setTip20Percent(View v){
    	Log.d("TipCalc", "20%");
    	percent = 20;
    	calcTip();
    }
}
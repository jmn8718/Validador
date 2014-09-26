package com.upm.fi.jmn.validador;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ToggleButton;

public class MainActivity extends Activity {
 
	ToggleButton toggleButtonclientePromo;
	Button buttonEnviar, buttonBorrar;
	EditText editTextNumTarjeta, editTextExpira, editTextCcv;
	Spinner spinnerTipoTarjeta;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        buttonEnviar = (Button) findViewById(R.id.botonEnviar);
        buttonEnviar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
			}
		});
        
        spinnerTipoTarjeta = (Spinner) findViewById(R.id.spinnerTipoTarjeta);        
        editTextExpira = (EditText) findViewById(R.id.editTextExpira);
        editTextCcv = (EditText) findViewById(R.id.editTextCcv);
        
        editTextNumTarjeta = (EditText) findViewById(R.id.editTextNumTarjeta);
        editTextNumTarjeta.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				boolean resul = false;
				String n = editTextNumTarjeta.getText().toString();
				if(n.length()==16){
					int c = Integer.parseInt(n.substring(0, 1));
					if (c>=3 || c<=6){
						for(int i=0;i<n.length();i++){
							int p = 0; c=0;
							if (i%2==0){ //es impar
								p = Integer.parseInt(n.substring(i, i+1))*2;
								if (p>9)
									p-=9;
								c +=p;
							} else { //es par
								c += Integer.parseInt(n.substring(i, i+1));
							}
						}
						resul = c%10==0 && c<=150;
					}
				}
				buttonEnviar.setEnabled(resul);
			}
		});
        
        toggleButtonclientePromo = (ToggleButton) findViewById(R.id.toggleButtonClientePromo);
        toggleButtonclientePromo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            }
        });
        
        buttonBorrar = (Button) findViewById(R.id.botonBorrar);
        buttonBorrar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				editTextCcv.setText("");
				editTextExpira.setText("");
				editTextNumTarjeta.setText("");
			}
		});
        
    }	
}

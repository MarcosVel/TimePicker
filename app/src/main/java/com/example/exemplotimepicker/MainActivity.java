package com.example.exemplotimepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    TimePicker tpHora;
    Button btnHora;
    TextView tvHora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvHora = (TextView)findViewById(R.id.lblHora);
        tpHora = (TimePicker)findViewById(R.id.tpTimer);
        btnHora = (Button)findViewById(R.id.cmdHora);

        tpHora.setIs24HourView(true);

        btnHora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int hora, minuto;
                String am_pm;
                if(Build.VERSION.SDK_INT>23) {
                     hora = tpHora.getHour();
                     minuto = tpHora.getMinute();
                } else {
                    hora = tpHora.getCurrentHour();
                    minuto = tpHora.getCurrentMinute();
                }

                if(hora > 12) {
                    am_pm = "PM";
                    hora = (hora - 12);
                } else {
                    am_pm = "AM";
                }
                tvHora.setText("Hora selecionada " + hora + ":" + minuto + " " + am_pm);
            }
        });
    }
}
package app.rstone.com.myappbmi;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Bmi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi);
        final Context this__ = Bmi.this;
        final EditText height = findViewById(R.id.height);
        final EditText weight = findViewById(R.id.weight);
        final TextView result = findViewById(R.id.result);
        final class Calc{
            double hei,wei;
            String res;
            public void execute(){
                double sum = wei / (hei * hei);
                if (sum <= 18.5) {
                    res = "Low";
                } else if (sum > 18.5 && sum < 23) {
                    res = "Normal";
                } else if (sum >= 23 && sum < 25) {
                    res = "Before obesity";
                } else if (sum >= 25 && sum < 30) {
                    res = "First Phase obesity";
                } else if (sum >= 30 && sum < 35) {
                    res = "Second Phase obesity";
                } else if (sum >= 35) {
                    res = "Third Phase obesity";
                }


            }
        }
        findViewById(R.id.btn).setOnClickListener(
            (View v)->{
                double hei = (Double.parseDouble(height.getText().toString()))*0.01;
                double wei = Double.parseDouble(weight.getText().toString());
                Log.d("입력받은 키:: ",""+hei);
                Log.d("입력받은 몸무게:: ",""+wei);
                Calc c = new Calc();
                c.hei = hei;
                c.wei = wei;
                c.execute();
                result.setText("BMI 단계는 : "+c.res);
            }
        );
    }
}


/*
new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(this__,"AAA",Toast.LENGTH_LONG)
                        .show();
            }
        }
* */
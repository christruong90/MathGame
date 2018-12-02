package bcit.mathgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

import static java.lang.Math.random;

public class MainActivity extends AppCompatActivity {

    Button myBtn;
    TextView num1;
    TextView num2;
    TextView operator;
    TextView answer1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myBtn = (Button) findViewById(R.id.button);
        num1 = (TextView) findViewById(R.id.firstNum);
        num2 = (TextView) findViewById(R.id.secondNum);
        answer1 = (TextView) findViewById(R.id.answer1);
        operator = (TextView) findViewById(R.id.operator);
        final String[] operatorArray = getResources().getStringArray(R.array.operators);


//        final int min = 0;
//        final int max = 100;
//        final int random = new Random().nextInt((max-min) +1) + min;




        myBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                num1.setText("" + random.nextInt(101));
                num2.setText("" + random.nextInt(101));

                int value1 = Integer.valueOf(num1.getText().toString());
                int value2 = Integer.valueOf(num2.getText().toString());

                int myAnswer = 0;


                String op = operatorArray[new Random().nextInt(operatorArray.length)];

                operator.setText(op);

//                double answer = num1.getText() + operator.getText() + num2.getText();
//
//
//                answer1.setText(num1.getText() + operator.getText() + num2.getText());


                switch(op) {
                    case("+"): myAnswer = value1 + value2; break;
                    case("-"): myAnswer = value1 - value2;break;
                    case("*"): myAnswer = value1 * value2;break;
                    case("/"): myAnswer = value1 / value2;break;
                }

                answer1.setText("" + myAnswer);




            }


        });




    }



}

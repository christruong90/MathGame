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


        myBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int firstNum = random.nextInt(101);
                int secondNum = random.nextInt(101);

                if (firstNum == secondNum) {
                    do {
                        firstNum = random.nextInt(101);
                        secondNum = random.nextInt(101);
                    } while(firstNum == secondNum);
                }


                String op = operatorArray[new Random().nextInt(operatorArray.length)];


                if (op.equals("-")) {
                    do {
                        firstNum = random.nextInt(101);
                        secondNum = random.nextInt(101);
                    } while(firstNum < secondNum);
                }

                if (op.equals("/")) {
                    do {
                        secondNum = random.nextInt(101);
                    } while(secondNum ==0);
                }




                num1.setText("" + firstNum);
                num2.setText("" + secondNum);

                int value1 = Integer.valueOf(num1.getText().toString());
                int value2 = Integer.valueOf(num2.getText().toString());

                int myAnswer = 0;


                operator.setText(op);


                switch(op) {
                    case("+"): myAnswer = value1 + value2;
                                break;
                    case("-"): myAnswer = value1 - value2;
                                break;
                    case("*"): myAnswer = value1 * value2;
                                break;
                    case("/"): myAnswer = value1 / value2;
                                break;

                }
                answer1.setText("" + myAnswer);
            }


        });




    }



}

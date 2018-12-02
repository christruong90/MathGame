package bcit.mathgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

import static java.lang.Math.random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

//    Button myBtn;
    Button op1;
    Button op2;
    Button op3;
    TextView num1;
    TextView num2;
    TextView scoreBoard;
    TextView operator;
    TextView answer1;
    TextView rounds;
    int score = 0;
    String[] operatorArray = {"+", "-", "*", "/"};
    int round = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        myBtn = findViewById(R.id.button);
        scoreBoard = findViewById(R.id.scoreBoard);
        num1 = findViewById(R.id.firstNum);
        rounds = findViewById(R.id.round);
        num2 = findViewById(R.id.secondNum);
        answer1 = findViewById(R.id.answer1);
        operator = findViewById(R.id.operator);
        op1 = findViewById(R.id.option1);
        op2 = findViewById(R.id.option2);
        op3 = findViewById(R.id.option3);
        String answerString;


        generateRandomValues();
        answerString = calculate();
        answer1.setText(answerString);
        multipleChoice();


        op1.setOnClickListener(this);
        op2.setOnClickListener(this);
        op3.setOnClickListener(this);





//        String[] operatorArray = getResources().getStringArray(R.array.operators);




//        myBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Random random = new Random();
//                int myAnswer = 0;
//                int firstNum = random.nextInt(101);
//                int secondNum = random.nextInt(101);
//
//                // Numbers must both be distinct
//                if (firstNum == secondNum) {
//                    do {
//                        firstNum = random.nextInt(101);
//                        secondNum = random.nextInt(101);
//                    } while(firstNum == secondNum);
//                }
//                String op = operatorArray[new Random().nextInt(operatorArray.length)];
//
//                // if operator minus, first num must be greater than second num to prevent negative answer.
//                if (op.equals("-")) {
//                    do {
//                        firstNum = random.nextInt(101);
//                        secondNum = random.nextInt(101);
//                    } while(firstNum < secondNum);
//                }
//
//                // second number cannot be zero if it is a division operator.
//                if (op.equals("/")) {
//                    do {
//                        secondNum = random.nextInt(101);
//                    } while(secondNum ==0);
//                }
//
//                num1.setText("" + firstNum);
//                num2.setText("" + secondNum);
//                operator.setText(op);
//
//                switch(op) {
//                    case("+"): myAnswer = firstNum + secondNum;
//                                break;
//                    case("-"): myAnswer = firstNum - secondNum;
//                                break;
//                    case("*"): myAnswer = firstNum * secondNum;
//                                break;
//                    case("/"): myAnswer = firstNum / secondNum;
//                                break;
//                }
//                answer1.setText("" + myAnswer);
//            }
//        });
    }

    public void multipleChoice() {
        Random random = new Random();
        int randomChoice = random.nextInt(3);
        int wrong1= (Integer.parseInt(calculate()) + random.nextInt(11));
        int wrong2= (Integer.parseInt(calculate()) - random.nextInt(11));

        if (randomChoice == 0) {
            op1.setText(calculate());
            op2.setText("" + wrong1);
            op3.setText("" + wrong2);
        } else if(randomChoice==1) {
            op2.setText(calculate());
            op1.setText(""+ wrong2);
            op3.setText("" + wrong1);
        } else {
            op3.setText(calculate());
            op2.setText("" + wrong2);
            op1.setText("" + wrong1);
        }
    }

    public void generateRandomValues() {
        Random random = new Random();
                int myAnswer = 0;
                int firstNum = random.nextInt(101);
                int secondNum = random.nextInt(101);

                // Numbers must both be distinct
                if (firstNum == secondNum) {
                    do {
                        firstNum = random.nextInt(101);
                        secondNum = random.nextInt(101);
                    } while(firstNum == secondNum);
                }
                String op = operatorArray[new Random().nextInt(operatorArray.length)];

                // if operator minus, first num must be greater than second num to prevent negative answer.
                if (op.equals("-")) {
                    do {
                        firstNum = random.nextInt(101);
                        secondNum = random.nextInt(101);
                    } while(firstNum < secondNum);
                }

                // second number cannot be zero if it is a division operator.
                if (op.equals("/")) {
                    do {
                        secondNum = random.nextInt(101);
                    } while(secondNum ==0);
                }

                num1.setText("" + firstNum);
                num2.setText("" + secondNum);
                operator.setText(op);
    }

    public String calculate() {
        String myAnswer ="";

        switch(operator.getText().toString()) {

                    case("+"): myAnswer ="" + (Integer.parseInt(num1.getText().toString()) + Integer.parseInt(num2.getText().toString()));
                                break;
                    case("-"): myAnswer = "" + (Integer.parseInt(num1.getText().toString()) - Integer.parseInt(num2.getText().toString()));
                                break;
                    case("*"): myAnswer = "" + (Integer.parseInt(num1.getText().toString()) * Integer.parseInt(num2.getText().toString()));
                                break;
                    case("/"): myAnswer = "" + (Integer.parseInt(num1.getText().toString()) / Integer.parseInt(num2.getText().toString()));
                                break;
                }

                return myAnswer;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.option1:
                if(op1.getText().toString().equals(calculate())) {
                    Toast.makeText(this, "option1 is RIGHT", Toast.LENGTH_SHORT).show();
                    setScore();
                } else {
                    Toast.makeText(this, "option1 is WRONG", Toast.LENGTH_SHORT).show();
                }

                generateRandomValues();
                multipleChoice();
                answer1.setText(calculate());
                setRounds();
                break;
            case R.id.option2:
                if(op2.getText().toString().equals(calculate())) {
                    Toast.makeText(this, "option2 is RIGHT", Toast.LENGTH_SHORT).show();
                    setScore();
                } else {
                    Toast.makeText(this, "option2 is WRONG", Toast.LENGTH_SHORT).show();
                }
                generateRandomValues();
                multipleChoice();
                answer1.setText(calculate());
                setRounds();
                break;
            case R.id.option3:
                if(op3.getText().toString().equals(calculate())) {
                    Toast.makeText(this, "option3 is RIGHT", Toast.LENGTH_SHORT).show();
                    setScore();
                } else {
                    Toast.makeText(this, "option3 is WRONG", Toast.LENGTH_SHORT).show();
                }
                generateRandomValues();
                multipleChoice();
                answer1.setText(calculate());
                setRounds();
                break;
        }

    }

    public void setScore() {
        if (round < 5) {
            score+= 1;
        } else {
            score = 0;
        }
        scoreBoard.setText("" + score);
    }

    public void setRounds() {
        if (round <5) {
            round +=1;
        } else {
            round = 1;
        }
        rounds.setText("" + round);
    }
}

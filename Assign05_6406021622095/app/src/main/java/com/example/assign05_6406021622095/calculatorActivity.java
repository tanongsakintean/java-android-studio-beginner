package com.example.assign05_6406021622095;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Stack;

public class calculatorActivity extends AppCompatActivity implements View.OnClickListener {

    //// ประกาศ
    TextView result;
    int[] ids = {R.id.zeroNumber, R.id.oneNumber, R.id.twoNumber, R.id.threeNumber, R.id.fourNumber, R.id.fiveNumber, R.id.sixNumber, R.id.sevenNumber, R.id.eightNumber,
            R.id.nineNumber,R.id.clearBtn,R.id.delBtn,R.id.modBtn,R.id.divisionBtn,R.id.multiplyBtn,R.id.minusBtn,R.id.plusBtn,R.id.dotBtn,R.id.calculateBtn};

    Button[] btn;
    Button btnBack ;
    String messageInfix = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        btn = new Button[ids.length];
        btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        
        result =  (TextView) findViewById(R.id.result);
        result.setText("0");

        for (int i = 0; i < ids.length ; i++) {
            btn[i] = (Button) findViewById(ids[i]);
            btn[i].setOnClickListener(this);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        Intent calculatorActivity = new Intent(calculatorActivity.this,calculatorActivity.class);
        Intent matchingGameActivity = new Intent(calculatorActivity.this,matchingGameActivity.class);

        if(item.getItemId() == R.id.exit) finishAffinity();
        if(item.getItemId() == R.id.calculator) startActivity(calculatorActivity);
        if(item.getItemId() == R.id.matchingGame) startActivity(matchingGameActivity);
        return true;
    }

    @Override
    public void onClick(View v) {
        int clickedId = v.getId();

        if(messageInfix.equals("can not devide by zero")) messageInfix="0";

        if (clickedId == R.id.zeroNumber) {
            messageInfix += "0";
        } else if (clickedId == R.id.oneNumber) {
            messageInfix += "1";
        } else if (clickedId == R.id.twoNumber) {
            messageInfix += "2";
        } else if (clickedId == R.id.threeNumber) {
            messageInfix += "3";
        } else if (clickedId == R.id.fourNumber) {
            messageInfix += "4";
        } else if (clickedId == R.id.fiveNumber) {
            messageInfix += "5";
        } else if (clickedId == R.id.sixNumber) {
            messageInfix += "6";
        } else if (clickedId == R.id.sevenNumber) {
            messageInfix += "7";
        } else if (clickedId == R.id.eightNumber) {
            messageInfix += "8";
        } else if (clickedId == R.id.nineNumber) {
            messageInfix += "9";
        } else if (clickedId == R.id.clearBtn) {
            messageInfix="";
        } else if (clickedId == R.id.delBtn) {
            if(messageInfix.length() > 0){
                messageInfix = messageInfix.substring(0, messageInfix.length() - 1);
            }else {
                messageInfix = "0";
            }
        }else if (clickedId == R.id.divisionBtn) {
            messageInfix+="÷";
        }else if (clickedId == R.id.modBtn) {
            messageInfix+="%";
        }else if (clickedId == R.id.multiplyBtn) {
            messageInfix+="×";
        }else if (clickedId == R.id.minusBtn) {
            messageInfix+="−";
        }else if (clickedId == R.id.plusBtn) {
            messageInfix+="+";
        }else if (clickedId == R.id.dotBtn) {
            messageInfix+=".";
        }else if (clickedId == R.id.calculateBtn) {
            // call infix class
            Calculator calculator = new Calculator(messageInfix);
            messageInfix = calculator.getResult();
        }
        result.setText(messageInfix);
    }
}

class Calculator {
    private String  message = "";
    Calculator(String message){
        String postFix = infixToPostfix(message);
        this.message = evaluatePostfix(postFix);
    }


    private  String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char ch : infix.toCharArray()) {
            if (Character.isDigit(ch) || ch == '.') {
                postfix.append(ch);
            } else if (isOperator(ch)) {
                postfix.append(",");
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(ch)) {
                    postfix.append(stack.pop());
                    postfix.append(",");
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            if (!postfix.substring(postfix.length()-1,postfix.length()).equals(",")) postfix.append(",");
            postfix.append(stack.pop());
        }
        return postfix.toString();
    }

    private  String evaluatePostfix(String postfix) {
        Stack<Double> stack = new Stack<>();

        for (String token : postfix.split(",")) {
            if (Character.isDigit(token.charAt(0))) {
                stack.push(Double.parseDouble(token));
            } else if (isOperator(token.charAt(0))) {
                double operand2 = 0;
                double operand1 = 0;

                if (stack.size() == 1 && token.equals("%")) {
                    operand1 = stack.pop();
                    stack.push(performOperation(operand1, operand2, token.charAt(0)));
                } else if (stack.size() == 1) {
                    operand1 = stack.pop();
                    stack.push(operand1);
                } else {
                    operand2 = stack.pop();
                    operand1 = stack.pop();
                    stack.push(performOperation(operand1, operand2, token.charAt(0)));
                }
            }
        }

        double total = stack.pop();

        if (total == 9999999.99) {
           return "can not devide by zero" ;
        }
        return Double.toString(total) ;
    }

    private  boolean isOperator(char ch) {
        return ch == '+' || ch == '−' || ch == '×' || ch == '÷' || ch == '%';
    }

    private  int precedence(char operator) {
        if (operator == '+' || operator == '−') {
            return 1;
        } else if (operator == '×' || operator == '÷' || operator == '%') {
            return 2;
        }
        return 0;
    }

    private  double performOperation(double operand1, double operand2, char operator) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '−':
                return operand1 - operand2;
            case '×':
                return operand1 * operand2;
            case '%':
                return operand1 / 100.00;
            case '÷':
                if (operand2 == 0) {
                    return 9999999.99;
                }
                return operand1 / operand2;

        }
        return operand1;
    }
  String getResult(){
        return this.message;
  }
}
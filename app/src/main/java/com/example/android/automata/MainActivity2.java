package com.example.android.automata;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2  extends AppCompatActivity {

    LinearLayout rootLayout;
    LinearLayout[] rows;
    Button button1, button2, button3, button4;
    int size = 0;
    String states[] = {"q0", "q1", "q2", "q3", "q4", "q5", "q6", "q7", "q8", "q9"};
    EditText transitions, initial, fin;
  //  final EditText noofstates;
    TextView state;
    String initialState, finalStates[];
    Boolean isDrawn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rootLayout = findViewById(R.id.rootLayout);
       // button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.draw);
        transitions = findViewById(R.id.transitions);
        final EditText noofstates = findViewById(R.id.no_of_states);
        state = findViewById(R.id.states);
        initial = findViewById(R.id.initial_state);
        fin = findViewById(R.id.final_state);

        setValidateAction(initial, noofstates);
        setValidateAction(fin, noofstates);
        setValidateAction(transitions, noofstates);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validationSuccess(noofstates)){
                    enter(noofstates);
                }
                else {
                    Toast.makeText(MainActivity2.this,"Please enter the no of states",Toast.LENGTH_SHORT).show();
                }
                if (validationSuccess(transitions)){
                    drawtable();
                }
                else {
                    Toast.makeText(MainActivity2.this, "Please enter the number of transitions",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void setValidateAction(final EditText edit_action, final EditText noofstates) {
        edit_action.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus && noofstates.getText().length()==0){
                    noofstates.requestFocus();
                }
            }
        });
    }
    public void enter(final EditText noofstates){
        int no = 0;
        String stat = noofstates.getEditableText().toString().trim();
        if (stat !=null)
        no = Integer.valueOf(stat);
        if (no<1 || no>10){
            Toast.makeText(MainActivity2.this,"Please enter values in the range!",Toast.LENGTH_SHORT).show();
            return;
        }
        String ans = states[0];
        for (int i=1;i<no;++i){
            ans = ans + ", " + states[i];
        }
        state.setText(ans);
    }

    private Boolean validationSuccess(EditText editText) {
        if (editText.getText().toString().equalsIgnoreCase("")) {
           // Toast.makeText(getApplicationContext(), "Please enter all details", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

        public void drawtable(){
        if (isDrawn==false)
        isDrawn = true;
        else {
            //((ViewGroup) rootLayout.getParent()).removeView(rootLayout);
            isDrawn = true;
            return;
        }
        rootLayout = findViewById(R.id.rootLayout);
        initialState = initial.getEditableText().toString();
        String temp = fin.getEditableText().toString();
        finalStates = temp.split(",");
        String s = transitions.getEditableText().toString();
//        Log.d("tag",s);
//        if(s.equals("")) size = 0;
//        else
            size = Integer.valueOf(s)+1;
        if (size<1 || size>25){
            Toast.makeText(MainActivity2.this,"Please enter a value in the range!",Toast.LENGTH_SHORT).show();
        }
        Log.d("tag",size+"");
        rows = new LinearLayout[size];
        for (int i = 0; i < size; ++i) {
            LinearLayout linearLayout = new LinearLayout(MainActivity2.this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 100, 1);
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            linearLayout.setLayoutParams(params);
            if (i==0)
            linearLayout.setBackgroundColor(getResources().getColor(R.color.dark_red));
            else linearLayout.setBackgroundColor(Color.BLACK);
            rows[i] = linearLayout;
            rootLayout.addView(linearLayout);
        }

        TextView l = new TextView(MainActivity2.this);
        l.setText("Initial State");
        l.setTextSize(15);
        l.setTextColor(Color.WHITE);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1);
        l.setLayoutParams(params);
        l.setPadding(15,15,15,15);
        rows[0].addView(l);
        TextView m = new TextView(MainActivity2.this);
        m.setText("Current Symbol");
        m.setLayoutParams(params);
        m.setTextSize(15);
        m.setTextColor(Color.WHITE);
        m.setPadding(15,15,15,15);
        rows[0].addView(m);
        TextView n = new TextView(MainActivity2.this);
        n.setText("Final State");
        n.setLayoutParams(params);
        n.setTextSize(15);
        n.setTextColor(Color.WHITE);
        n.setPadding(15,15,15,15);
        rows[0].addView(n);
        for (int i=1;i<size;++i){
            for (int j=0;j<3;++j){
                EditText l1 = new EditText(MainActivity2.this);
                    LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1);
                    l1.setLayoutParams(params1);
                    l1.setBackgroundColor(Color.BLACK);
                    l1.setTextColor(Color.WHITE);
                    l1.setHintTextColor(Color.WHITE);
                    l1.setHint("_________");
                    l1.setPadding(15,15,15,15);
                    rows[i].addView(l1);
            }
        }
    }

}

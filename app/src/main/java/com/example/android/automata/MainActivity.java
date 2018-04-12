package com.example.android.automata;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    LinearLayout rootLayout;
    LinearLayout[] rows;
    Button button,button1, definition, diagram, simulation;
    int size = 0, noofstate = 0;
    String states[] = {"q0", "q1", "q2", "q3", "q4", "q5", "q6", "q7", "q8", "q9"};
    EditText transitions, initial, fin;
  //  final EditText noofstates;
    TextView state, textView;
    String initialState, finalStates[];
    Boolean isDrawn = false;
    List<EditText> qi = new ArrayList<EditText>(), symbol= new ArrayList<EditText>(), qf= new ArrayList<EditText>();
    ArrayList<String> initialStates = new ArrayList<>(), symbols=new ArrayList<>(), finalState = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rootLayout = findViewById(R.id.rootLayout);
        button1 = findViewById(R.id.button1);
        button = findViewById(R.id.draw);
        definition = findViewById(R.id.definition);
        diagram =  findViewById(R.id.diagram);
        simulation =  findViewById(R.id.simulation);
        transitions = findViewById(R.id.transitions);
        textView = findViewById(R.id.text);
        final EditText noofstates = findViewById(R.id.no_of_states);
//        String str = noofstates.getEditableText().toString().trim();
//        noofstate = Integer.getInteger(str);
        state = findViewById(R.id.states);
        initial = findViewById(R.id.initial_state);
        fin = findViewById(R.id.final_state);

        setValidateAction(initial, noofstates);
        setValidateAction(fin, noofstates);
        setValidateAction(transitions, noofstates);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validationSuccess(noofstates)){
                    enter(noofstates);
                }
                else {
                    Toast.makeText(MainActivity.this,"Please enter the no of states",Toast.LENGTH_SHORT).show();
                }
                if (validationSuccess(transitions)){
                    drawtable();
                    textView.setVisibility(View.VISIBLE);
                }
                else {
                    Toast.makeText(MainActivity.this, "Please enter the number of transitions",Toast.LENGTH_SHORT).show();
                }
            }
        });

        definition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flag = transitionDiagram();
                if (flag==false) return;
                Intent intent = new Intent(MainActivity.this,DefinitionActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("size",size);
                bundle.putInt("noofstates",noofstate);
                bundle.putStringArrayList("Initial", initialStates);
                bundle.putStringArrayList("Symbols", symbols);
                bundle.putStringArrayList("Final", finalState);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        diagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flag = transitionDiagram();
                if (flag==false) return;
                Intent intent = new Intent(MainActivity.this,TransitionDiagram.class);
                Bundle bundle = new Bundle();
                bundle.putInt("size",size);
                bundle.putInt("noofstates",noofstate);
                bundle.putStringArrayList("Initial", initialStates);
                bundle.putStringArrayList("Symbols", symbols);
                bundle.putStringArrayList("Final", finalState);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        simulation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flag = transitionDiagram();
                if (flag==false) return;
                Intent intent = new Intent(MainActivity.this,SimulationActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("size",size);

                bundle.putInt("noofstates",noofstate);
                bundle.putStringArrayList("Initial", initialStates);
                bundle.putStringArrayList("Symbols", symbols);
                bundle.putStringArrayList("Final", finalState);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        initial.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (hasWindowFocus()){
                    enter(noofstates);
                }
            }
        });

    }

    public boolean transitionDiagram(){
        for (int i=0;i<qi.size();++i){
            EditText editText = qi.get(i);
            String str = editText.getText().toString().trim();
            Boolean flag = false;
            for (int j=0;j<size;++j){
                if (str.equals(states[j])){
                    flag = true;
                    break;
                }
            }
            if (flag == false){
                Toast.makeText(MainActivity.this,"Enter correct states in the transition table",Toast.LENGTH_SHORT).show();
                return false;
            }
            initialStates.add(str);
        }

        for (int i=0;i<symbol.size();++i){
            EditText editText = symbol.get(i);
            String str = editText.getText().toString().trim();
            Boolean flag = false;
//            for (int j=0;j<size;++j){
//                if (str.equals(states[j])){
//                    flag = true;
//                    break;
//                }
//            }
//            if (flag == false){
//                Toast.makeText(MainActivity.this,"Enter correct states in the transition table",Toast.LENGTH_SHORT).show();
//                return;
//            }
            symbols.add(str);
        }

        for (int i=0;i<qf.size();++i){
            EditText editText = qf.get(i);
            String str = editText.getText().toString().trim();
            Boolean flag = false;
            for (int j=0;j<size;++j){
                if (str.equals(states[j])){
                    flag = true;
                    break;
                }
            }
            if (flag == false){
                Toast.makeText(MainActivity.this,"Enter correct states in the transition table",Toast.LENGTH_SHORT).show();
                return false;
            }
            finalState.add(str);
        }

        return true;
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
            Toast.makeText(MainActivity.this,"Please enter values in the range!",Toast.LENGTH_SHORT).show();
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
            return false;
        }
        return true;
    }

    public boolean drawtable(){
        if (isDrawn==false)
        isDrawn = true;
        else {
            //((ViewGroup) rootLayout.getParent()).removeView(rootLayout);
            isDrawn = true;
            return false;
        }
        rootLayout = findViewById(R.id.rootLayout);
        initialState = initial.getEditableText().toString();
        if (initialState.equals("")){
            Toast.makeText(MainActivity.this, "Enter a valid initial state",Toast.LENGTH_SHORT).show();
            return false;
        }
        boolean flag = false;
        for (int i=0;i<noofstate;++i){
            if (initialState.equals(states[i])){
                flag = true;
                break;
            }
        }
//        if (flag == false){
//            Toast.makeText(MainActivity.this, "Enter a valid initialstate",Toast.LENGTH_SHORT).show();
//            return false;
//        }
        String temp = fin.getEditableText().toString();
        finalStates = temp.split(",");
        for (int i=0;i<finalStates.length;++i){
            finalStates[i] = finalStates[i].trim();
            Log.d("tag",finalStates[i]);
        }
//        for (int j=0;j<finalStates.length;++j){
//            flag = false;
//            for (int i=0;i<noofstate;++i){
//                if (finalStates[j].equals(states[i])){
//                    flag = true;
//                    break;
//                }
//            }
//            if (flag == false){
//                Toast.makeText(MainActivity.this, "Enter a valid final state",Toast.LENGTH_SHORT).show();
//                return false;
//            }
//        }

        String s = transitions.getEditableText().toString();
        size = Integer.valueOf(s)+1;
        if (size<1 || size>25){
            Toast.makeText(MainActivity.this,"Please enter a value in the range!",Toast.LENGTH_SHORT).show();
            return false;
        }
        Log.d("tag",size+"");
        rows = new LinearLayout[size];
        for (int i = 0; i < size; ++i) {
            LinearLayout linearLayout = new LinearLayout(MainActivity.this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 100, 1);
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            linearLayout.setLayoutParams(params);
            if (i==0)
            linearLayout.setBackgroundColor(getResources().getColor(R.color.dark_red));
            else linearLayout.setBackgroundColor(Color.BLACK);
            rows[i] = linearLayout;
            rootLayout.addView(linearLayout);
        }

        TextView l = new TextView(MainActivity.this);
        l.setText("Initial State");
        l.setTextSize(15);
        l.setTextColor(Color.WHITE);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1);
        l.setLayoutParams(params);
        l.setPadding(15,15,15,15);
        rows[0].addView(l);
        TextView m = new TextView(MainActivity.this);
        m.setText("Current Symbol");
        m.setLayoutParams(params);
        m.setTextSize(15);
        m.setTextColor(Color.WHITE);
        m.setPadding(15,15,15,15);
        rows[0].addView(m);
        TextView n = new TextView(MainActivity.this);
        n.setText("Final State");
        n.setLayoutParams(params);
        n.setTextSize(15);
        n.setTextColor(Color.WHITE);
        n.setPadding(15,15,15,15);
        rows[0].addView(n);
        for (int i=1;i<size;++i){
            for (int j=0;j<3;++j){
                EditText l1 = new EditText(MainActivity.this);
                    LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1);
                    l1.setLayoutParams(params1);
                    l1.setBackgroundColor(Color.BLACK);
                    l1.setTextColor(Color.WHITE);
                    l1.setHintTextColor(Color.WHITE);
                    l1.setHint("_________");
                    l1.setPadding(15,15,15,15);
                    switch (j){
                        case 0: qi.add(l1);
                        break;
                        case 1: symbol.add(l1);
                        break;
                        case 2: qf.add(l1);
                        break;
                    }
                    rows[i].addView(l1);
            }
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.reset:
                Intent intent = new Intent(MainActivity.this,MainActivity.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}

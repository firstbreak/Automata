package com.example.android.automata;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.android.automata.Automatons.DFA.DFA;
import com.example.android.automata.Automatons.NFA.NFA;
import com.example.android.automata.Automatons.NPDA.NPDA;
import com.example.android.automata.Automatons.PDA.PDA;
import com.example.android.automata.Automatons.TuringMachine.Turing;

public class MainActivity extends AppCompatActivity {

    TextView dfa,nfa,pda,npda,turing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dfa = findViewById(R.id.dfa);
        nfa = findViewById(R.id.nfa);
        pda = findViewById(R.id.pushdown);
        npda = findViewById(R.id.npda);
        turing = findViewById(R.id.turing);
        dfa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DFA.class);
                startActivity(intent);
            }
        });

        nfa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,NFA.class);
                startActivity(intent);
            }
        });

        pda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,PDA.class);
                startActivity(intent);
            }
        });

        npda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,NPDA.class);
                startActivity(intent);
            }
        });

        turing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Turing.class);
                startActivity(intent);
            }
        });
    }
}

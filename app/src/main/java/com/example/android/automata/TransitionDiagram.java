package com.example.android.automata;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import net.xqhs.graphs.graph.Node;
import net.xqhs.graphs.graph.SimpleEdge;
import net.xqhs.graphs.graph.SimpleNode;

import java.util.ArrayList;

import giwi.org.networkgraph.GraphSurfaceView;
import giwi.org.networkgraph.beans.NetworkGraph;

public class TransitionDiagram extends AppCompatActivity {

    int size, noofstates;
    String states[] = {"q0", "q1", "q2", "q3", "q4", "q5", "q6", "q7", "q8", "q9"};
    ArrayList<String> initialStates = new ArrayList<>(), symbols = new ArrayList<>(), finalStates = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition_diagram);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        size = bundle.getInt("size");
        noofstates = bundle.getInt("noofstates");
        initialStates = bundle.getStringArrayList("Initial");
        symbols = bundle.getStringArrayList("Symbols");
        finalStates = bundle.getStringArrayList("Final");

        NetworkGraph graph = new NetworkGraph();
        ArrayList<Node> nodes = new ArrayList<>();

        for (int i=0;i<noofstates;++i){
            Node node = new SimpleNode(states[i]);
            nodes.add(node);
        }

//        for (int i=0;i<size;++i){
//           // graph.addEdge(new SimpleEdge(initialStates[i],symbols[i],finalStates[i]));
//        }
//
//        Node v1 = new SimpleNode("18");
//        Node v2 = new SimpleNode("24");
//        graph.getVertex().add(new Vertex(v1, ContextCompat.getDrawable(this, R.drawable.one)));
//        graph.getVertex().add(new Vertex(v2, ContextCompat.getDrawable(this, R.drawable.one)));
//        graph.addEdge(new SimpleEdge(v1, v2, "12"));
//
//        Node v3 = new SimpleNode("7");
//        graph.getVertex().add(new Vertex(v3, ContextCompat.getDrawable(this, R.drawable.one)));
//        graph.addEdge(new SimpleEdge(v2, v3, "23"));
//
//        v1 = new SimpleNode("14");
//        graph.getVertex().add(new Vertex(v1, ContextCompat.getDrawable(this, R.drawable.one)));
//        graph.addEdge(new SimpleEdge(v3, v1, "34"));
//
//        v1 = new SimpleNode("10");
//        graph.getVertex().add(new Vertex(v1, ContextCompat.getDrawable(this, R.drawable.one)));
//        graph.addEdge(new SimpleEdge(v3, v1, "35"));
//
//        v1 = new SimpleNode("11");
//        graph.getVertex().add(new Vertex(v1, ContextCompat.getDrawable(this, R.drawable.one)));
//        graph.addEdge(new SimpleEdge(v1, v3, "36"));
//        graph.addEdge(new SimpleEdge(v3, v1, "6"));

       // GraphSurfaceView surface = (GraphSurfaceView) findViewById(R.id.mysurface);
        //surface.init(graph);
    }
}

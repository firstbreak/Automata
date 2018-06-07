package com.example.android.automata;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.common.graph.Graphs;
import com.google.common.graph.MutableValueGraph;
import com.google.common.graph.ValueGraphBuilder;

//import org.graphstream.graph.*;
//import org.graphstream.graph.implementations.*;

import net.xqhs.graphs.graph.Node;
import net.xqhs.graphs.graph.SimpleEdge;
import net.xqhs.graphs.graph.SimpleNode;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import giwi.org.networkgraph.GraphSurfaceView;
import giwi.org.networkgraph.beans.NetworkGraph;
//import guru.nidi.graphviz.engine.Format;
//import guru.nidi.graphviz.engine.Graphviz;
//import guru.nidi.graphviz.model.Graph;
//
//import static guru.nidi.graphviz.model.Factory.graph;
//import static guru.nidi.graphviz.model.Factory.node;
//import net.xqhs.graphs.graph.Graph;
import net.xqhs.graphs.graph.Node;
import net.xqhs.graphs.graph.SimpleEdge;
import net.xqhs.graphs.graph.SimpleGraph;
import net.xqhs.graphs.graph.SimpleNode;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

//import amicity.graphs.android.GraphView;
//import amicity.graphs.android.common.Dimension;

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

//        NetworkGraph graph = new NetworkGraph();
//        ArrayList<Node> nodes = new ArrayList<>();
//
//        for (int i=0;i<noofstates;++i){
//            Node node = new SimpleNode(states[i]);
//            nodes.add(node);
//        }

//        SimpleGraph g = new SimpleGraph();
//        Node n1 = new SimpleNode("MyNodeA");
//        Node n2 = new SimpleNode("MyNodeB");
//        g.addNode(n1).addNode(n2).addEdge(new SimpleEdge(n1, n2, "my-edge"));
//
//        Graphs graphs;
        MutableValueGraph<String, String> graph =
                ValueGraphBuilder.directed().allowsSelfLoops(true).build();


        for (int i=0;i<size-1;++i){
            graph.putEdgeValue(initialStates.get(i), symbols.get(i), finalStates.get(i));
        }

//        Graph graph1 = new SingleGraph("I can see dead pixels");
//        graph1.addNode("A" );
//        graph1.addNode("B" );
//        graph1.addNode("C" );
//        graph1.addEdge("AB", "A", "B");
//        graph1.addEdge("BC", "B", "C");
//        graph1.addEdge("CA", "C", "A");
//        graph.display();
//        Viewer viewer = graph1.display();
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

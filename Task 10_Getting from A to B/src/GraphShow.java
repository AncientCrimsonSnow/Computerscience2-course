public class GraphShow {
    public static void main(String[] args) {
        GraphWeighted graphWeighted = new GraphWeighted(true);
        
        
        VerticeWeighted zero = new VerticeWeighted(0, "0");
        VerticeWeighted one = new VerticeWeighted(1, "1");
        VerticeWeighted two = new VerticeWeighted(2, "2");
        VerticeWeighted three = new VerticeWeighted(3, "3");
        VerticeWeighted four = new VerticeWeighted(4, "4");
        VerticeWeighted five = new VerticeWeighted(5, "5");
        VerticeWeighted six = new VerticeWeighted(6, "6");

        // Our addEdge method automatically adds Nodes as well.
        // The addNode method is only there for unconnected Nodes,
        // if we wish to add any
        graphWeighted.addEdge(zero, one, 8);
        graphWeighted.addEdge(one, zero, 11);
        graphWeighted.addEdge(two, two, 3);
        graphWeighted.addEdge(three, three, 8);
        graphWeighted.addEdge(two, four, 28);
        graphWeighted.addEdge(five, four, 9);
        graphWeighted.addEdge(four, six, 25);
        graphWeighted.addEdge(one, two, 2);
        graphWeighted.addEdge(two, three, 6);
        graphWeighted.addEdge(three, four, 1);
        graphWeighted.addEdge(four, five, 7);
        graphWeighted.addEdge(five, six, 8);
        
        graphWeighted.printEdges();

        int amountOfTests = 3;
        
        for(int i = 0; i<amountOfTests;i++) {
            graphWeighted.randomShortestPath();  
            graphWeighted.randomCheapestPath();
        }

    	RandomGraph randomGraph = new RandomGraph (true, 10, 50);
    	
    	randomGraph.printEdges();
    	
        for(int i = 0; i<amountOfTests;i++) {
            randomGraph.randomShortestPath();  
            randomGraph.randomCheapestPath();
        }
				
		
    }
}

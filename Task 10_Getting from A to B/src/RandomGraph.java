public class RandomGraph extends GraphWeighted{
	
	public RandomGraph(boolean directed, int vertices, int edges) {
		super(directed);
		
		getRandomGraph(vertices, edges);
		
        printEdges();

		VerticeWeighted randomV1 = getRandomVertice();
		VerticeWeighted randomV2 = getRandomVertice();
        DijkstraCheapestPath(randomV1, randomV2);
		resetVerticeVisited();
        DijkstraShortestPath(randomV1, randomV2);
	}

}

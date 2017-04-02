 import java.util.Scanner;
	import java.util.Random;
	import java.io.*;

public class DVAlgorithm
 {
    private static int distances[][];
    private static  int numberofvertices;
    public static final int MAX_VALUE = 999;
    static int n = 0;
    static int scnode; //scnode - source node to find shortest path from
    static int dnode; // dnode - destination node to find shortest path to

    public static void initialize(int numberofvertices1)
    {
        numberofvertices = numberofvertices1;
        distances = new int[numberofvertices1 + 1][numberofvertices1 + 1];
    }

    public static void Calculation(int adjacencymatrix[][])
    {
        int index;
        for (index = 1; index <= numberofvertices; index++)
        for (int node = 1; node <= numberofvertices; node++)
        {
            distances[index][node] = MAX_VALUE;
        }

        for(index = 1; index <= numberofvertices; index++)
        {
            distances[index][index] = 0;
            for (int node = 1; node <= numberofvertices - 1; node++)
            {
                for (int sourcenode = 1; sourcenode <= numberofvertices; sourcenode++)
                {
                    for (int destinationnode = 1; destinationnode <= numberofvertices; destinationnode++)
                    {
                        if (adjacencymatrix[sourcenode][destinationnode] != MAX_VALUE)
                        {
                            if (distances[index][destinationnode] > distances[index][sourcenode] + adjacencymatrix[sourcenode][destinationnode])
                                distances[index][destinationnode] = distances[index][sourcenode] + adjacencymatrix[sourcenode][destinationnode];
                            System.out.println("Index: " +index);
                            System.out.print("\tSource node: " +sourcenode);
                            System.out.print("\tDesination node: " +destinationnode);
                            System.out.println("Distance between index and destination node inside if loop" +distances[index][destinationnode]);
                        }
                    }
                }
            }
        }
    }

    public static void printMatrix()
    {
        int index;
        System.out.println("The final matrix after DV algorithm is: ");
        for (index = 1; index <= numberofvertices; index++)
        {
            System.out.print("\n");
                for (int vertex = 1; vertex <= numberofvertices; vertex++)
                {
                    System.out.print(" "+ distances[index][vertex]+" ");
                }
        }
    }

    public static void main(String... arg) throws IOException
    {
        int numberofvertices = 0;
        int source;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of vertices");
        numberofvertices = scanner.nextInt();

        int adjacencymatrix[][] = new int[numberofvertices + 1][numberofvertices + 1];

        System.out.println("Enter the adjacency matrix");
        for (int sourcenode = 1; sourcenode <= numberofvertices; sourcenode++)
        {
            for (int destinationnode = 1; destinationnode <= numberofvertices; destinationnode++)
            {
                adjacencymatrix[sourcenode][destinationnode] = scanner.nextInt();
            if (sourcenode == destinationnode)
                {
                    adjacencymatrix[sourcenode][destinationnode] = 0;
                    continue;
                }
            if (adjacencymatrix[sourcenode][destinationnode] == 0)
                {
                    adjacencymatrix[sourcenode][destinationnode] = MAX_VALUE;
                }
            }
        }

        initialize(numberofvertices);
        Calculation(adjacencymatrix);

        System.out.println("1. Print Matrix ");
        System.out.println("2. Failure Simulation ");
        System.out.println("3. Display shortest path between specific nodes: ");
        System.out.println("Enter choice: ");
        source = scanner.nextInt();
        int Fnode;
    //    String ValContinue="n";
    //do{
       //     printMatrix();

            switch(source)
            {
                case 1:
                    printMatrix();
                break;

                case 2:
                    System.out.println("Enter the number of the router whose failure is to be simulated : ");
                    Fnode = scanner.nextInt();
                    for(int i=1;i<numberofvertices;i++)
                        adjacencymatrix[Fnode][i]=MAX_VALUE;

                    for(int i=1;i<numberofvertices;i++)
                        adjacencymatrix[i][Fnode]=MAX_VALUE;

                    initialize(numberofvertices);
                    Calculation(adjacencymatrix);
                    printMatrix();

                break;

                case 3:
                    System.out.println("Enter the source node: ");
                    scnode = scanner.nextInt();
                    System.out.println("Enter the destination node: ");
                    dnode = scanner.nextInt();


                    break;

                default:
                    System.out.println("Invalid choice ");
            }

 /*        System.out.println("\nDo you want to Continue (y/n) : ");
         ValContinue = scanner.next();
        }while(ValContinue.equals("n"));
  */       scanner.close();

//        printMatrix();
    }
}
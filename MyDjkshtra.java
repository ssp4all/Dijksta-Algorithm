
package ssp;
//add a package ssp 
import java.util.*;
public class MyDjkshtra 
{
    public static int G[][]=new int[10][10];

    public static final int  INFINITY = 9999;
    
    public static void main(String[] args) 
    {
                
        Scanner sc=new Scanner(System.in);
        
        System.out.print("Enter No. of Vertises : ");
        int n=sc.nextInt();
        
        System.out.println("Enter Adjaency Matrix : ");
        for (int i = 0; i < n; i++) 
        {
            for (int j = 0; j < n; j++) 
            {
                G[i][j]=sc.nextInt();     
            }            
        }
        System.out.print("Enter Starting Node : ");
        int s=sc.nextInt();
        
        dij(G,n,s);
    }
    public static void dij(int G[][], int n, int s) 
    {        
        int cost[][]=new int[10][10];
        int distance[]=new int[10];
        int pred[]=new int[10];
        int visited[]=new int[10];
        
        int count , minidistance,nextnode = 0;

        for (int i = 0; i < n; i++) 
        {
            for (int j = 0; j < n; j++)
            {
                if(G[i][j] == 0)
                {
                    cost[i][j] = INFINITY;
                }
                else
                {
                    cost[i][j]=G[i][j];
                }
            }
        }
        for (int i = 0; i < n; i++) 
        {
            distance[i]=cost[s][i];
            pred[i]=s;
            visited[i]=0;            
        }
        
        distance[s]=0;
        visited[s]=1;   //next node gives next node at minidistance
        count=1;
        
        while (count < n) 
        {
            minidistance =INFINITY;
            for (int i = 0; i < n; i++) 
            {
                if(distance[i]< minidistance  && visited[i] != 1 )
                {
                    minidistance = distance[i];
                    nextnode = i;
                }
            }
            //Check if better path exist or not
            visited [ nextnode]=1;
            for (int i = 0; i < n; i++) 
            {
                if( visited[i] != 1 )
                {
                    if(minidistance +cost[nextnode][i] <= distance[i])
                    {
                        distance[i]=minidistance+cost[nextnode][i];
                        pred[i]=nextnode;
                    }      
                }
            }
            count++;
        }
        //Print the path and distance of each node
        for (int i = 0; i < n; i++) 
        {
            if(i != s)
            {
                System.out.println("");
                System.out.println("Distance of node "+i+"  From "+s+" = "+distance[i]);
                System.out.print("path : "+i);
                int j = i;
                do
                {
                    j= pred[j];
                    System.out.print("<-"+j);
                    
                }while(j != s);            
            }
        }
        System.out.println("");
    }
}
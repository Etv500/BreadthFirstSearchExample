/**

 * VacuumBFS class is used to do the breadth-First-Search for the vacuum world.

 * Sep-2019

 */

import java.util.*;

 

public class VacuumBFS

{

                  //3 actions of the robot or vacuum: move left, move right, suck dirt

                  int[] actionLeft =new int[] {1,1,3,3,5,5,7,7};

                  int[] actionRight=new int[] {2,2,4,4,6,6,8,8};

                  int[] actionSuck =new int[] {3,6,3,8,7,6,7,8};

                 

                  //if the state is the goal test, return true

                  public boolean goalTest(int s)

                  {

                                   boolean bool=(s==7 || s==8); //when the node is 7 or 8->goal is found

                                   return bool;

                  }

                 

                  //If the goal is found, return true

                  public boolean BFS()

                  {

                                   int initState=1;

                                   if(goalTest(initState))

                                                     return true;

                                   ArrayList<String> frontier=new ArrayList<String>();

                                   frontier.add("1"); //add element 1 as the initial node state

                                    ArrayList<String> explored=new ArrayList<String>();

                                  

                                   while(true)

                                   {

                                                     if(frontier.isEmpty())

                                                                       return false; //no solution

                                                     String node_string=frontier.remove(0);//remove 0th element of frontier

                                                     int node=Integer.parseInt(node_string);

                                                    

                                                     explored.add(node_string);

                                                     System.out.println("\nhere node state="+node);

                                                     System.out.println("here frontier="+frontier);

                                                     System.out.println("here explored="+explored);

                                                    

                                                     //Expand the node; Make children contain 3 states

                                                     int[] children=new int[] {actionLeft[node-1],actionRight[node-1],actionSuck[node-1]};

                                                     System.out.println("children="+Arrays.toString(children));

                                                    

                                                     for (int i=0; i<children.length; i++)

                                                     {

                                                                      System.out.println("i="+i+",children[i]="+children[i]);

                                                                      

                                                                       if (goalTest(children[i]))

                                                                       {

                                                                                        System.out.println("Solution found: the state is ");

                                                                                        System.out.println(children[i]);

                                                                                        return true;

                                                                       }

                                                                      

                                                                       if( !(frontier.contains(Integer.toString(children[i]))) && !(explored.contains(Integer.toString(children[i]))) )

                                                                       {

                                                                                        frontier.add(Integer.toString(children[i]));

                                                                                        System.out.println("\tnew frontier="+frontier);

                                                                       }

                                                     }//end of for

                                   }//end of while

                                  

                  }//end of BFS()

 

}//end of class
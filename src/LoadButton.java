import java.io.IOException; 
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;

////////////////////ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
//Title:           p04 Dorm Designer
//Files:           none
//Course:          CS 300 spring 2018
//
//Author:          Omjaa Rai
//Email:           orai@wisc.edu
//Lecturer's Name: Mouna Ayari Ben Hadj Kacem
//
////////////////////PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
//Partner Name:    Sahana Iyer
//Partner Email:   siyer6@wisc.edu
//Lecturer's Name: Mouna Ayari Ben Hadj Kacem
//
//VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//_X__ Write-up states that pair programming is allowed for this assignment.
//_X__ We have both read and understand the course Pair Programming Policy.
//_X__ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
//Students who get help from sources other than their partner must fully
//acknowledge and credit those sources of help here.  Instructors and TAs do
//not need to be credited here, but tutors, friends, relatives, room mates
//strangers, etc do.  If you received no outside help from either type of
//source, then please explicitly indicate NONE.
//
//Persons:         none
//Online Sources:  none
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

public class LoadButton extends Button{

    //initializes final variables
    private static final int WIDTH = 96;
    private static final int HEIGHT = 32;

    //initializes variables
    private PApplet processing;
    private float[] position;
    private String label;


    //initializes bounds
    private int xUp;
    private int yUp;
    private int xDown;
    private int yDown;


    public LoadButton(float x, float y, PApplet processing) {
        super(x,y,processing);
        //initializes position information
        position = new float[2];
        position[0] = x;
        position[1] = y;

        //assigns processing variable
        this.processing = processing;     

        int hWidth=WIDTH/2;
        int hHeight=HEIGHT/2;

        //creates label
        super.label="Load Room";

        //initializes bounds
        xUp=(int)x-hWidth;
        yUp=(int)y-hHeight;
        xDown=(int)x+hWidth;
        yDown=(int)y+hHeight;

        processing.fill(100);
        processing.rect(xUp,yUp,xDown,yDown);
    }


 public void update() { 
     super.update();
   }

   
    public void mouseDown(Furniture[] furniture) { 
        //if mouse is over, returns furniture
        super.mouseDown(furniture);
        if (isMouseOver() == true) {
            loadFile(furniture);             
        }
    }   


   

    public void loadFile(Furniture[] furniture) {

        //opens try block
        try
        {
            //initializes furniture objects to null
            for(int i = 0; i < furniture.length; i++)
            {
                if(furniture[i] != null)
                {
                    furniture[i] = null; 
                }
            }

            Scanner inFS = null;

            //reads RoomData.ddd file
            FileReader fileCharStream = new FileReader("RoomData.ddd");
            inFS = new Scanner(fileCharStream);
            int i = 0; 


            while(inFS.hasNext() != false)
            {
                //reads first line of file
                String inputString = inFS.nextLine(); 

                //skips over empty lines
                if(inputString.isEmpty())
                {
                    continue; 
                }

                //splits up strings with colon and comma 
                String [] splitColon = inputString.split("(:)|(,)"); 

                //removes white spaces in file
                for(int k = 0; k < splitColon.length; k++)
                {
                    splitColon[k] = splitColon[k].trim();
                }

                //assigns the values of the room data to variables to be passed 
                String furnitureType = splitColon[0]; 
                float xPosition = Float.parseFloat(splitColon[1]);
                float yPosition = Float.parseFloat(splitColon[2]);
                int numOfRotations = Integer.parseInt(splitColon[3]);

                //checks if end is a colon
                if(furnitureType == "" || !inputString.contains(":"))
                {
                    System.out.println("WARNING: Found incorrectly formatted line in file: " + inputString);
                    continue; 
                }

                //initializes furniture object
                Furniture furnObject = new Furniture(furnitureType, processing, xPosition, yPosition, numOfRotations); 

                //if type is invalid, then continues
                if(furnObject.getType() == "invalid")
                {
                    continue; 
                }

                //assigns array value
                furniture[i] = furnObject;

                i++; //increments

                //checks if the file is loading more than 6 furniture objects 
                if(i == 6)
                {
                    //error message
                    System.out.println("WARNING: Unable to load more furniture.");
                    break;
                }
            }
            //closes file
            fileCharStream.close(); 
        }
        catch (FileNotFoundException e)
        {
            //prints warning message
            System.out.println("WARNING: Could not load room contents from file RoomData.ddd.");
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        } 

    }



}


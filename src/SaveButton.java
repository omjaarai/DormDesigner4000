import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

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

public class SaveButton extends Button{

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

    public SaveButton(float x, float y, PApplet processing) {
        super(x,y,processing);
        super.label="Save Room";

        int hWidth=WIDTH/2;
        int hHeight=HEIGHT/2;

        //creates label name
        //label="Save Room";

        //assigns values of bounds
        xUp=(int)x-hWidth;
        yUp=(int)y-hHeight;
        xDown=(int)x+hWidth;
        yDown=(int)y+hHeight;

        processing.fill(100);
        processing.rect(xUp,yUp,xDown,yDown);
    }


    // public void update() { 

    //initializes button
    // processing.fill(100);
    // this.processing.rect(xUp, yUp, xDown, yDown);

    //changes how button looks when mouse is on top
    //  if (this.isMouseOver()){
    //  processing.fill(200);
    //  this.processing.rect(xUp,yUp,xDown, yDown);
    // }

    //creates label
    // processing.fill(0);
    // processing.text(label, position[0], position[1]);
    //  }

    // public void mouseUp(){}
    public void mouseDown(Furniture[] furniture) { 
        // returns furniture if mouse over
        super.mouseDown(furniture);
        //if (isMouseOver() == true) { 
            saveFile(furniture);                 
        //}
    }   
    // public boolean isMouseOver() { 
    //if mouse is over, returns true
    // if (processing.mouseX > (position[0] - WIDTH/2) 
    // && processing.mouseX < (position[0] + WIDTH/2) 
    // && processing.mouseY > (position[1] - HEIGHT/2)
    //  && processing.mouseY < (position[1] + HEIGHT/2)) {
    // return true;                  
    // }else{
    // return false; //if mouse is not over
    //  }
    //}   


    public void saveFile(Furniture[] furniture) {

        //opens try block
        try {
            FileOutputStream fileByteStream=new FileOutputStream("RoomData.ddd");
            PrintWriter outFile =new PrintWriter(fileByteStream);

            //saves all furniture in file
            for(int i=0;i<furniture.length;i++) {
                if(furniture[i]==null) {
                    break;
                }

                //writes in file
                outFile.write(furniture[i].getType()+":");
                outFile.write(furniture[i].getXPositionString()+",");
                outFile.write(furniture[i].getYPositionString()+",");
                outFile.write(furniture[i].getRotations()+"\n");
            }

            outFile.close();//closes PrintWriter file
        }catch(FileNotFoundException e) {
            //error message
            System.out.println("WARNING: Could not save room contents to file RoomData.ddd.");
        }

    }





}

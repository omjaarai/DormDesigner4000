
import java.io.File;

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

public class Furniture implements DormGUI{

    //initializes variables
    private PApplet processing;
    private PImage image;
    private float[] position;
    private boolean isDragging;
    private int rotations;
    private String type;

    PImage bedImage;


    public void setType(String type) {
        //assigns variable type
        this.type=type;
    }

    public String getType() {
        //returns variable type
        return this.type;
    }

    public void setXPosition(float[] position) {

        //assigns position element
        this.position[0]=position[0];
    }

    public float getXPositon() {

        //returns position element
        return position[0];
    }

    public String getXPositionString() {

        //assigns value of strX
        String strX=String.valueOf(position[0]);
        return strX;
    }

    public void setYPosition(float[] position) {

        //assigns position element
        this.position[0]=position[0];
    }

    public float getYPosition() {

        //returns position element
        return position[1];
    }

    public String getYPositionString() {

        //assigns strY
        String strY=String.valueOf(position[1]);
        return strY;
    }

    public void setRotations(int rotations) {

        //assigns rotation variable
        this.rotations=rotations;
    }

    public int getRotations() {

        //returns rotation variable
        return rotations;
    }





    public Furniture(String furnitureType, PApplet processing) {

        //assigns processing variable
        this.processing = processing;

        type=furnitureType;

        //creates position information
        position = new float[2];
        position[0] = 400.0f;
        position[1] = 300.0f;

        //initializes default values
        isDragging = false;   

        rotations = 0;

        image = processing.loadImage("images"+File.separatorChar+type+".png");



    }

    //initializes fiels of new bed object
    public Furniture(String furnitureType, PApplet newProcessing,float x, float y, int rotations) {


        type=furnitureType;
        File inFile= new File("images"+File.separatorChar+type+".png");

        if(inFile.exists()==false) {
            System.out.println("WARNING: Could not find an image for a furniture object of type: "+type);
            type="invalid";
        }else {
            processing=newProcessing;
            image=processing.loadImage("images"+File.separatorChar+type+".png");

            isDragging=false;
            position=new float[2];

            this.rotations=rotations;

            position[0]=x;
            position[1]=y;
        }

    }

    //draws bed at current position
    public void update() {

        if(type != "invalid") {
            processing.image(image, position[0], position[1], rotations*PApplet.PI/2);

            if (isDragging){
                float mouseX = processing.mouseX;    
                float mouseY = processing.mouseY;

                position[0] = mouseX;
                position[1] = mouseY;
            }

            if(rotations==0) {
                processing.image(image, position[0], position[1]);
            }else {
                processing.image(image, position[0], position[1], rotations*PApplet.PI/2);
            }
        }
    }


    public void mouseDown(Furniture[] furniture) { 

        //if mouse is over, isDragging is true
        if(isMouseOver()) {
            isDragging = true;
        }else {
            isDragging=false;
        }
    } 

    public void mouseUp() {
        //isDragging is false with method call
        isDragging = false;
    }


    //determines whether mouse is over bed
    public boolean isMouseOver() { 


        float mouseX = processing.mouseX;    
        float mouseY = processing.mouseY;

        int height = image.height;
        int width = image.width;

        //helps determine if mouse is in vicinity of bed
        //when bed is horizontal
        if(rotations%2 != 0){
            int tempHeight = height;
            height = width;
            width = tempHeight;         
        }

        if (mouseX > position[0] - width / 2
            && mouseX < position[0] + width
            / 2
            && mouseY > position[1] - height
            / 2
            && mouseY < position[1] + height
            / 2) {
            return true;


        }else {
            return false;
        }
    }


    public void rotate() {
        //increments rotations with method call
        rotations++;
    }




}

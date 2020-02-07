
//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
    //
 // Title:           p04 Dorm Designer
 // Files:           none
 // Course:          CS 300 spring 2018
 //
 // Author:          Omjaa Rai
 // Email:           orai@wisc.edu
 // Lecturer's Name: Mouna Ayari Ben Hadj Kacem
 //
 //////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
 //
 // Partner Name:    Sahana Iyer
 // Partner Email:   siyer6@wisc.edu
 // Lecturer's Name: Mouna Ayari Ben Hadj Kacem
 //
 // VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
 //   _X__ Write-up states that pair programming is allowed for this assignment.
 //   _X__ We have both read and understand the course Pair Programming Policy.
 //   _X__ We have registered our team prior to the team registration deadline.
 //
 ///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
 //
 // Students who get help from sources other than their partner must fully
 // acknowledge and credit those sources of help here.  Instructors and TAs do
 // not need to be credited here, but tutors, friends, relatives, room mates
 // strangers, etc do.  If you received no outside help from either type of
 // source, then please explicitly indicate NONE.
 //
 // Persons:         none
 // Online Sources:  none
 //
 /////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

 public class CreateFurnitureButton extends Button{

     //initializes final variables
     private static final int WIDTH = 96;
     private static final int HEIGHT = 32;

     //initializes variables
     private PApplet processing;
     private float[] position;
     //private String label;

     public CreateFurnitureButton(String type, float x, float y, PApplet processing) {
         super(x,y,processing);
         position = new float[2];
         position[0] = x;
         position[1] = y;
         //creates label
         super.label = type;

         //assigns processing variable
         this.processing = processing;       

     }
     
     public void update() { 
      super.update();
     }

     public void mouseDown(Furniture[] furniture) {
         super.mouseDown(furniture);
         // if mouse over, returns furniture
         for (int row = 0; row < furniture.length; row++) {
             if (furniture[row] == null) {
                 if (processing.mouseX > (position[0] - WIDTH/2) 
                     && processing.mouseX < (position[0] + WIDTH/2) 
                     && processing.mouseY > (position[1] - HEIGHT/2)
                     && processing.mouseY < (position[1] + HEIGHT/2)) {
                     furniture[row]= new Furniture(label, processing);                  
                 }
                 else {
                     furniture[row]= null;
                 }
                 break;
             }
         }
     }   




 }



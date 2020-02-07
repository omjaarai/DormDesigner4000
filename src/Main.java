import java.io.File;
import java.util.ArrayList;
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


public class Main 
{

    private PApplet processing;
    private PImage backgroundImage;
    //   private Furniture[] furniture;
    private CreateFurnitureButton bedButton;
    private CreateFurnitureButton sofaButton;
    private LoadButton loadButton;
    private SaveButton saveButton;
    private CreateFurnitureButton dresserButton;
    private CreateFurnitureButton deskButton;
    private CreateFurnitureButton sinkButton;
    private ClearButton clearRoom;


    private ArrayList<DormGUI> guiObjects;


    public Main(PApplet processing) 
    {
        //creates background
        this.processing = processing;
        processing.background(100,150,250);

        //creates background color
        backgroundImage=processing.loadImage("images"+File.separatorChar+"background.png");
        processing.image(backgroundImage, processing.width/2, processing.height/2);
        // furniture = new Furniture[6];

        //initializes array values
        //  for (int row = 0; row < furniture.length; row++) {
        //   furniture[row] = null; 
        // }

        //creates buttons
        bedButton = new CreateFurnitureButton("bed",50, 24, processing);//bed button
        sofaButton = new CreateFurnitureButton("sofa",150, 24, processing);//sofa button
        dresserButton = new CreateFurnitureButton("dresser",250, 24, processing);
        deskButton = new CreateFurnitureButton("desk",350, 24, processing);
        sinkButton = new CreateFurnitureButton("sink",450, 24, processing);
        loadButton = new LoadButton(750, 24, processing);//load button
        saveButton = new SaveButton(650, 24, processing);//save button
        clearRoom= new ClearButton(550,24, processing);

        guiObjects=new ArrayList<DormGUI>();

        guiObjects.add(bedButton);
        guiObjects.add(sofaButton);
        guiObjects.add(loadButton);
        guiObjects.add(saveButton);
        guiObjects.add(dresserButton);
        guiObjects.add(deskButton);
        guiObjects.add(sinkButton);
        guiObjects.add(clearRoom);

    }


    public static void main(String[] args) {
        //activates window
        Utility.startApplication();
    }


    public void update() {


        //makes background
        processing.background(100, 150, 250);
        processing.image(backgroundImage, processing.width / 2,processing.height / 2);

        //updates beds
        for (int row = 0; row < guiObjects.size(); row++) {
            if(guiObjects.get(row)!= null) {
                guiObjects.get(row).update();
                
            }
        }
        //        bedButton.update();
        //        sofaButton.update();
        //        saveButton.update();
        //        loadButton.update();

    }

    public void mouseDown() {


        Furniture[] furniture1=new Furniture[6];

        //extract method


        furniture1=extractFurnitureFromGUIObjects();
        for(int i=guiObjects.size()-1;i>=0;i--) {
            //extractFurnitureFromGUIObjects();
            if(guiObjects.get(i)!=null) {
                if(guiObjects.get(i).isMouseOver()) {
                    guiObjects.get(i).mouseDown(furniture1);
                    break;
                }
            } 
        }

        replaceFurnitureInGUIObjects(furniture1);



        //        //if user clicks on furniture, furniture is moved
        //        for (int i = 0; i<guiObjects.size(); i++){
        //            if (guiObjects.get(i)!=null){
        //                if (guiObjects.get(i).isMouseOver()){
        //                    guiObjects.get(i).mouseDown(furniture1);
        //                    break;
        //                }
        //            }
        //        }

        //        //makes bed when button is activated
        //        if (bedButton.isMouseOver()) {
        //            bedButton.mouseDown(this.furniture1);
        //
        //        }
        //
        //
        //        //makes sofa when button is activated
        //        if (sofaButton.isMouseOver()) {
        //            sofaButton.mouseDown(this.furniture1);
        //
        //
        //        }
        //
        //        //if clicked, methods saveButton and loadButton are called
        //        if(saveButton.isMouseOver()==true) {
        //            saveButton.mouseDown(furniture1);
        //        }
        //        if(loadButton.isMouseOver()==true) {
        //            loadButton.mouseDown(furniture1);
        //        }


    }


    public void mouseUp() {
        // tracks when mouse is up
        //         for (int row=0; row<furniture.length; row++){
        //            if (furniture[row] != null){
        //                furniture[row].mouseUp();
        //            }
        //        }

        for(int i=0;i<guiObjects.size();i++) {
            if(guiObjects.get(i)!=null) {
                guiObjects.get(i).mouseUp();
            }
        }

    }


    public void keyPressed() {
        //deletes furniture
        /*if (processing.key == 'D' || processing.key == 'd'){
            for (int row = 0; row < furniture.length; row++) {
                if (furniture[row] != null){
                    if (furniture[row].isMouseOver()) {
                        this.furniture[row] = null;
                        break;
                    }
                }
            } 
        }*/
        Furniture[] furniture1=new Furniture[6];

        furniture1=extractFurnitureFromGUIObjects();
        if (processing.key == 'D' || processing.key == 'd'){
            for(int i=0;i<furniture1.length;i++) {
                if(furniture1[i]!= null) {
                    if(furniture1[i].isMouseOver()) {
                        furniture1[i]=null;
                        break;
                    }
                }
            }
            replaceFurnitureInGUIObjects(furniture1);
        } 






        //rotates furniture
        if (processing.key == 'R' || processing.key == 'r'){
            for (int i=0;i<furniture1.length;i++) {
                if(furniture1[i]!=null) {
                    if(furniture1[i].isMouseOver()) {
                        furniture1[i].rotate();
                        break;
                    }
                }

            }
            replaceFurnitureInGUIObjects(furniture1);
        }

    }


    // Max number of furniture that LoadButton will be allowed to load at once.    
    private final static int MAX_LOAD_FURNITURE = 100;        
    /**
     * This method creates a new Furniture[] for the old mouseDown() methods
     * to make use of.  It does so by copying all Furniture references from
     * this.guiObjects into a temporary array of size MAX_LOAD_FURNITURE.
     * @return that array of Furniture references.
     */
    private Furniture[] extractFurnitureFromGUIObjects() {
        Furniture[] furniture = new Furniture[MAX_LOAD_FURNITURE];
        int nextFreeIndex = 0;
        for(int i=0;i<guiObjects.size() && nextFreeIndex < furniture.length;i++)
            if(guiObjects.get(i) instanceof Furniture)
                furniture[nextFreeIndex++] = (Furniture)guiObjects.get(i);        
        return furniture;        
    }    
    /**
     * This method first removes all Furniture references from this.guiObjects,
     * and then adds back in all of the non-null references from it's parameter.
     * @param furniture contains the only furniture that will be left in 
     *   this.guiObjects after this method is invoked (null references ignored).
     */
    private void replaceFurnitureInGUIObjects(Furniture[] furniture) {
        for(int i=0;i<guiObjects.size();i++)
            if(guiObjects.get(i) instanceof Furniture)
                guiObjects.remove(i--);
        for(int i=0;i<furniture.length;i++)
            if(furniture[i] != null)
                guiObjects.add(furniture[i]);
    }
}

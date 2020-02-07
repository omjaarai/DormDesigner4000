
public class ClearButton extends Button {
    //    public ClearButton(float x, float y, PApplet processing) {
    //        super(x, y, processing);
    //        super.label= "Clear Room";
    //    }

    private static final int WIDTH = 96;
    private static final int HEIGHT = 32;


    private PApplet processing;
    private float[] position;

    public ClearButton(float x, float y, PApplet processing) {

        super(x,y,processing);

        position = new float[2];
        position[0] = x;
        position[1] = y;
        super.label = "Clear Room";

        //assigns processing variable
        this.processing = processing;  


    }

    public void mouseDown(Furniture[] furniture) {
        super.mouseDown(furniture);
        // if mouse over, returns furniture
        for (int row = 0; row < furniture.length; row++) {
            if (furniture[row] != null) {
                if (processing.mouseX > (position[0] - WIDTH/2) 
                    && processing.mouseX < (position[0] + WIDTH/2) 
                    && processing.mouseY > (position[1] - HEIGHT/2)
                    && processing.mouseY < (position[1] + HEIGHT/2)) {
                    for(int i=0;i<furniture.length;i++) {
                        furniture[i]= null;                  
                    }
                }
                break;
            }
        }

        //        for(int i=0;i<furniture.length;i++) {
        //            if(furniture[i]!= null) {
        //                if(furniture[i].isMouseOver()) {
        //                    furniture[i]=null;
        //                    break;
        //                }
        //           }
        //  furniture[i]=null;

        //       }
    }


    public void update() { 
        //updates the look of the button
        super.update();
    }

}
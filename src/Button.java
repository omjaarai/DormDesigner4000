
public class Button implements DormGUI {
    private static final int WIDTH = 96;
    private static final int HEIGHT = 32;
    protected PApplet processing;
    private float[] position;
    protected String label;

    public Button(float x, float y, PApplet processing) {
        //initializes position information
        position = new float[2];
        position[0] = x;
        position[1] = y;
        label = "Button";
        //assigns processing variable
        this.processing = processing; 
    }

    public void update() {
        //updates the look of the button
        if (this.isMouseOver()){
            processing.fill(100);
        }else{processing.fill(200);}
        this.processing.rect(position[0]-WIDTH/2, position[1]+HEIGHT/2, 
            position[0]+WIDTH/2, position[1]-HEIGHT/2);

        processing.fill(0);
        this.processing.text(label, position[0], position[1]);
    }
    public void mouseDown(Furniture[] furniture) {
        if (isMouseOver() == true) { 
            System.out.println("A button is pressed");                 
        }
    }

    public void mouseUp() {

    }
    public boolean isMouseOver() {
        //if mouse is over, returns true
        if (processing.mouseX > (position[0] - WIDTH/2) 
            && processing.mouseX < (position[0] + WIDTH/2) 
            && processing.mouseY > (position[1] - HEIGHT/2)
            && processing.mouseY < (position[1] + HEIGHT/2)) {
            return true;                  
        }else{
            return false; 
        }
    }
}

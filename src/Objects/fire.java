package Objects;

import javafx.geometry.Bounds;

public abstract class fire extends gameObject {
    
    public int effects;

    public int getEffects() {
        return effects;
    }

    public void setEffects(int effects) {
        this.effects = effects;
    }

    

    public fire(String imageFilePath, double startingX, double startingY , double speed ) {
        super(imageFilePath, startingX, startingY );
        this.setSpeed(speed);

    }


    public abstract Bounds getBoundrs() ;

}

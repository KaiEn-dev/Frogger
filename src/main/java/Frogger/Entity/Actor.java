package Frogger.Entity;

import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;

import java.util.ArrayList;

import Frogger.World.World;

/**
 * base class for actors
 * @author leeka
 *
 */
public abstract class Actor extends ImageView{

	/**
	 * move actor
	 * @param x axis movement
	 * @param y axis movement
	 */
    public void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }

    /**
     * get World of actor
     * @return world
     */
    public World getWorld() {
        return (World) getParent();
    }

    /**
     * check when actors intersect
     * @param <A>
     * @param cls
     * @return list of actors that intersected
     */
    //if actors intersects return the list of actors
    public <A extends Actor> java.util.List<A> getIntersectingObjects(java.lang.Class<A> cls){
        ArrayList<A> someArray = new ArrayList<A>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
            }
        }
        return someArray;
    }
    
    /**
     * give actors run time functionalities
     * @param animation time
     */
    public abstract void act(long now);

}

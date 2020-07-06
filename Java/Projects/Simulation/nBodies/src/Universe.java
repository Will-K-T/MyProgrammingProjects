import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

//File format: (double)mass (double)radius (double)startingX (double)startingY (double)startingZ (double)startingXV (double)startingYV (double)startingZV

/* has everything to size
Sun 1.989e30 696.34e5 0 0 0 5.89e9 0 0
Mercury 0.330e24 2.439e6 5.79e10 0 0 0 0 4.74e4
Venus 4.87e24 6.052e6 1.0816e11 0 0 0 0 3.5e4
Earth 5.97e24 6.378e6 1.496e11 0 0 0 0 2.98e4
Mars 0.642e24 3.397e6 2.2793664e11 0 0 0 0 2.41e4
Jupiter 1898e24 7.1492e7 7.78369e11 0 0 0 0 1.31e4
Saturn 568e24 6.0268e7 1.427034e12 0 0 0 0 9.7e3
Uranus 86.8e24 2.5559e7 2.870658186e12 0 0 0 0 6.8e3
Neptune 102e24 2.4766e7 4.496976e12 0 0 0 0 5.4e3
 */

public class Universe extends Application{

    //region WindowVars
    private static final int WIDTH = 1400;
    private static final int HEIGHT = 800;
    //endregion

    //region MouseVars
    private double anchorX, anchorY;
    private double anchorAngleX = 0, anchorAngleY = 0;
    private final DoubleProperty angleX = new SimpleDoubleProperty(0);
    private final DoubleProperty angleY = new SimpleDoubleProperty(0);
    //endregion

    //region UnusedVars
    private final Sphere sphere = new Sphere(150);//EarthSphereObj
    //private static ArrayList<Body> bodies;
    //endregion

    //region JavaFxVars
    private SmartGroup universe = new SmartGroup();//A group to hold all of the bodies
    private Camera camera = new PerspectiveCamera(true);//A new camera
    //endregion

    //region PlanetTrackingVars
    private int indexOfSphereWithGreatestMass;//Stores the index of the Body with the greatest mass inside the bodies ArrayList
    private Body followPlanet = null;//Stores the planet that the camera is currently tracking
    private int currPlanet = 0;//Keeps track of which body is being tracked out of the total bodies
    //endregion

    //region MiscVars
    private ArrayList<Body> bodies = new ArrayList<>();//Stores all of the Body objects that keep track of the pos, vel, and acc of a particular body
    private boolean pauseTimer = false;//Keeps track if the simulation is paused or not
    //endregion

    @Override
    public void start(Stage primaryStage) throws Exception {

        //region Prepares the Bodies and the Universe
        prepareBodies();
        prepareUniverse();
        //endregion

        //region Camera
        camera.translateXProperty().set(0);
        camera.translateYProperty().set(0);

        camera.setNearClip(1);
        camera.setFarClip(Integer.MAX_VALUE);
        //endregion

        //region Groups
        Group root = new Group();
        root.getChildren().add(universe);
        //endregion

        //region Scene
        Scene scene = new Scene(root, WIDTH, HEIGHT, true);
        scene.setFill(Color.BLACK);
        scene.setCamera(camera);
        //endregion

        //region Creates mouse and keyboard input
        initMouseControl(universe, scene, primaryStage);//Starts the mouse control
        
        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            switch (event.getCode()){
                case W:
                    //camera.translateYProperty().set(camera.getTranslateY()+100);
                    universe.translateYProperty().set(universe.getTranslateY()+1e11);
                    break;
                case A:
                    //camera.translateXProperty().set(camera.getTranslateX()-100);
                    universe.translateXProperty().set(universe.getTranslateX()+1e11);
                    break;
                case S:
                    //camera.translateYProperty().set(camera.getTranslateY()-100);
                    universe.translateYProperty().set(universe.getTranslateY()-1e11);
                    break;
                case D:
                    //camera.translateXProperty().set(camera.getTranslateX()+100);
                    universe.translateXProperty().set(universe.getTranslateX()-1e11);
                    break;
                case SPACE:
                    Body curr = bodies.get(currPlanet++);
                    followPlanet = curr;
                    universe.translateYProperty().set(0);
                    universe.translateXProperty().set(0);
                    angleX.set(0);
                    angleY.set(0);
                    System.out.printf("Planet: %s\n", curr.getName());
                    if(currPlanet>bodies.size()-1){
                        currPlanet = 0;
                    }
                    break;
                case SHIFT:
                    pauseTimer = !pauseTimer;
                    System.out.println(pauseTimer);
                    break;
            }
        });//Pans the universe based on keyboard input
        //endregion

        //region Stage
        primaryStage.setTitle("N-Body Sim");
        primaryStage.setScene(scene);
        primaryStage.show();
        //endregion

        prepareAnimation();//Starts the animation

    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////Methods below this line///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    /**
     * Creates lines to represent the x y and z axis
     */
    private void createAxis(){
        for (int i = 0; i < 10000; i++) {
            Box temp = new Box(100, 100, 100);
            temp.setTranslateX(0);
            temp.setTranslateY(i*110);
            temp.setTranslateZ(0);
            temp.setMaterial(new PhongMaterial(Color.RED));
            universe.getChildren().add(temp);
        }
        for (int i = 0; i < 10000; i++) {
            Box temp = new Box(100, 100, 100);
            temp.setTranslateX(i*110);
            temp.setTranslateY(0);
            temp.setTranslateZ(0);
            temp.setMaterial(new PhongMaterial(Color.ORANGE));
            universe.getChildren().add(temp);
        }
        for (int i = 0; i < 10000; i++) {
            Box temp = new Box(100, 100, 100);
            temp.setTranslateX(0);
            temp.setTranslateY(0);
            temp.setTranslateZ(i*110);
            temp.setMaterial(new PhongMaterial(Color.GREEN));
            universe.getChildren().add(temp);
        }
    }

    /**
     * Adds all of the bodies to the universe Group
     */
    private void prepareUniverse() {
        double greatestMass = Double.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < bodies.size(); i++) {
            universe.getChildren().add(bodies.get(i).getSphere());
            if(bodies.get(i).getMass()>greatestMass){
                greatestMass = bodies.get(i).getMass();
                index = i;
            }
        }
        indexOfSphereWithGreatestMass = index;
    }

    /**
     * Creates the bodies that will be added to the universe Group
     * @throws FileNotFoundException
     */
    private void prepareBodies() throws FileNotFoundException {
        Scanner file = new Scanner(new File("src\\Bodies"));

        /*
        for (int i = 0; i < 500; i++) {
            bodies.add(new Body("",Math.random()*10000, Math.random()*100, Math.random()>.5 ? Math.random()*10000 : Math.random()*-10000, Math.random()>.5 ? Math.random()*10000 : Math.random()*-10000, Math.random()>.5 ? Math.random()*10000 : Math.random()*-10000, Math.random()*100, Math.random()*100, Math.random()*100, new Sphere()));
        }//Creates n number of random bodies
        */

        while(file.hasNextLine()){
            bodies.add(new Body(file.next(), file.nextDouble(), file.nextDouble() * 500, file.nextDouble(), file.nextDouble(), file.nextDouble(), file.nextDouble(), file.nextDouble(), file.nextDouble() * 1e6, new Sphere()));
        }//Creates bodies by using a file

        for (int i = 0; i < bodies.size(); i++) {
            PhongMaterial mat = new PhongMaterial();
            Color color = Color.rgb((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255));
            mat.setDiffuseColor(color);
            bodies.get(i).setColor(color);
            bodies.get(i).getSphere().setMaterial(mat);
        }//Applies a random color to every body
    }

    /**
     * Handles the animations
     */
    private void prepareAnimation() {
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if(!pauseTimer) {
                    for (int i = 0; i < bodies.size(); i++) {
                        Body a = bodies.get(i);
                        a.resetForce();
                        for (int j = 0; j < bodies.size(); j++) {
                            if (i != j) {
                                Body b = bodies.get(j);
                                a.addForce(b);
                            }
                        }
                        a.update(100000);//Inputs the step timer (a value of 1 is real time)
                    }//Updates the forces and position of every body in the simulation

                    for (int i = 0; i < bodies.size(); i++) {
                        Sphere s = new Sphere(bodies.get(i).getRadius() * .20);
                        Sphere curr = bodies.get(i).getSphere();
                        s.translateXProperty().set(curr.getTranslateX());
                        s.translateYProperty().set(curr.getTranslateY());
                        s.translateZProperty().set(curr.getTranslateZ());
                        s.setMaterial(new PhongMaterial(bodies.get(i).getColor()));
                        universe.getChildren().add(s);
                    }//Creates trails behind each body

                    //region Sets the camera to follow the body with the largest mass until the user presses the space bar
                    if (followPlanet == null) {
                        camera.translateXProperty().set(bodies.get(indexOfSphereWithGreatestMass).getX());
                        camera.translateYProperty().set(bodies.get(indexOfSphereWithGreatestMass).getY());
                        camera.translateZProperty().set(bodies.get(indexOfSphereWithGreatestMass).getZ() - bodies.get(indexOfSphereWithGreatestMass).getRadius() * 10);
                    }
                    else {
                        camera.translateXProperty().set(followPlanet.getX());
                        camera.translateYProperty().set(followPlanet.getY());
                        camera.translateZProperty().set(followPlanet.getZ() - followPlanet.getRadius() * 10);
                    }
                    //endregion
                }
            }
        };
        timer.start();//Starts the animation timer
    }

    /**
     * Creates the background image
     * @return
     */
    private ImageView prepareImageView(){
        Image image = new Image(getClass().getResourceAsStream("/resources/galaxy.jpg"));
        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);
        imageView.getTransforms().add(new Translate(-image.getWidth()/2, -image.getHeight()/2, Integer.MAX_VALUE));
        return imageView;
    }

    /**
     * Creates the earth
     * @return
     */
    private Node prepareEarth() {
        PhongMaterial mat = new PhongMaterial();
        mat.setDiffuseMap(new Image(getClass().getResourceAsStream("/resourcesEarth/2k_earth_daymap.jpg")));
        sphere.setRotationAxis(Rotate.Y_AXIS);
        sphere.setMaterial(mat);
        return sphere;
    }

    /**
     * Handles all mouse controls
     * @param group
     * @param scene
     * @param stage
     */
    private void initMouseControl(SmartGroup group, Scene scene, Stage stage){
        Rotate xRotate;
        Rotate yRotate;
        group.getTransforms().addAll(
                xRotate = new Rotate(0, Rotate.X_AXIS),
                yRotate = new Rotate(0, Rotate.Y_AXIS)
        );
        xRotate.angleProperty().bind(angleX);
        yRotate.angleProperty().bind(angleY);
        scene.setOnMousePressed(event -> {
            anchorX = event.getSceneX();
            anchorY = event.getSceneY();
            anchorAngleX = angleX.get();
            anchorAngleY = angleY.get();
        });

        scene.setOnMouseDragged(event -> {
            angleX.set(anchorAngleX - (anchorY - event.getSceneY()));
            angleY.set(anchorAngleY + (anchorX - event.getSceneX()));
        });//Handles the rotation of the universe with mouse dragging

        stage.addEventHandler(ScrollEvent.SCROLL, event -> {
            double movement = event.getDeltaY()*1e9;
            //double movement = event.getDeltaY()*500;
            group.translateZProperty().set(group.getTranslateZ() - movement);
        });//Handles the zooming with the mouse scroll wheel
    }

    class SmartGroup extends Group {
        Rotate r;
        Transform t = new Rotate();

        void rotateByX(int ang){
            r = new Rotate(ang, Rotate.X_AXIS);
            t = t.createConcatenation(r);
            this.getTransforms().clear();
            this.getTransforms().addAll(t);
        }

        void rotateByY(int ang){
            r = new Rotate(ang, Rotate.Y_AXIS);
            t = t.createConcatenation(r);
            this.getTransforms().clear();
            this.getTransforms().addAll(t);
        }
    }//Group that contains the planets

}
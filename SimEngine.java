import java.util.Vector;

/**
 * Created by Wojcik94 on 2017-04-04.
 */
public class SimEngine {
    private double mass, coefficientOfElasticity, dampingFactor, springFreeLength, gravitationalAcceleration;

    private Vector2D massPosition, massVelocity, pointOfSuspension;

    public SimEngine(double mass, double coefficientOfElasticity, double dampingFactor, double springFreeLength,
                     Vector2D massPosition, Vector2D massVelocity, Vector2D pointOfSuspension, double gravitationalAcceleration) {
        this.mass = mass;
        this.coefficientOfElasticity = coefficientOfElasticity;
        this.dampingFactor = dampingFactor;
        this.springFreeLength = springFreeLength;
        this.massPosition = massPosition;
        this.massVelocity = massVelocity;
        this.pointOfSuspension = pointOfSuspension;
        this.gravitationalAcceleration = gravitationalAcceleration;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public double getCoefficientOfElasticity() {
        return coefficientOfElasticity;
    }

    public void setCoefficientOfElasticity(double coefficientOfElasticity) {
        this.coefficientOfElasticity = coefficientOfElasticity;
    }

    public double getDampingFactor() {
        return dampingFactor;
    }

    public void setDampingFactor(double dampingFactor) {
        this.dampingFactor = dampingFactor;
    }

    public double getSpringFreeLength() {
        return springFreeLength;
    }

    public void setSpringFreeLength(double springFreeLength) {
        this.springFreeLength = springFreeLength;
    }

    public Vector2D getMassPosition() {
        return massPosition;
    }

    public void setMassPosition(Vector2D massPosition) {
        this.massPosition = massPosition;
    }

    public Vector2D getMassVelocity() {
        return massVelocity;
    }

    public void setMassVelocity(Vector2D massVelocity) {
        this.massVelocity = massVelocity;
    }

    public Vector2D getPointOfSuspension() {
        return pointOfSuspension;
    }

    public void setPointOfSuspension(Vector2D pointOfSuspension) {
        this.pointOfSuspension = pointOfSuspension;
    }

    public double getGravitationalAcceleration() {
        return gravitationalAcceleration;
    }

    public void setGravitationalAcceleration(double gravitationalAcceleration) {
        this.gravitationalAcceleration = gravitationalAcceleration;
    }

    public void track (double dt) {
        Vector2D wyp=new Vector2D();
        Vector2D gravity= new Vector2D(0, mass*gravitationalAcceleration);   //siła grawitacji
        Vector2D elasticyStrength = new Vector2D();     //siła sprężystości
        Vector2D dampingPower = new Vector2D();     //siła tłumienia

        elasticyStrength=pointOfSuspension.difference(massPosition).normalized().product(coefficientOfElasticity*
                (massPosition.difference(pointOfSuspension)).getLength()-10);

        dampingPower= massVelocity.product(-dampingFactor);

        wyp=elasticyStrength.sum(dampingPower).sum(gravity);

        massVelocity=massVelocity.sum(wyp.product(dt/mass));
        massPosition=massPosition.sum(massVelocity.product(dt));
    }

    public void zerowanie(){
        massPosition.x=0;
        massPosition.y=0;
    }
}

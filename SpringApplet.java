/**
 * Created by Wojcik94 on 2017-04-04.
 */
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class SpringApplet extends JApplet {
    public void init(){
        double dlugosc1, dlugosc2;

        Vector2D pierwszy=new Vector2D(3,4);
        Vector2D drugi=new Vector2D(6,8);

        Vector2D trzeci=pierwszy.sum(drugi);
        Vector2D czwarty=drugi.difference(pierwszy);

        Vector2D piaty=pierwszy.normalized();
        Vector2D szosty=drugi.normalized();

        dlugosc1=pierwszy.getLength();
        dlugosc2=drugi.getLength();

        Vector2D siodmy=pierwszy.product(5);

        java.util.List<Vector2D> vectors=new ArrayList<Vector2D>();
        vectors.add(pierwszy);
        vectors.add(drugi);
        vectors.add(trzeci);
        vectors.add(czwarty);
        vectors.add(piaty);
        vectors.add(szosty);
        vectors.add(siodmy);

        for(Vector2D i: vectors){
            System.out.println("x: "+ i.x+" y: "+i.y+" dlugosc: "+ i.getLength());
        }
    }

    public void paint(Graphics g){

    }
}

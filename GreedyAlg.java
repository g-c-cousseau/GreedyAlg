import java.util.Collections;
import java.util.ArrayList;
//
public class GreedyAlg
{
    ArrayList <GreedyAlgItem> items = new ArrayList<>();


    public void densityCompute(ArrayList <GreedyAlgItem> algItems) 
    {   
        for(int i=0; i < algItems.size(); i++)
            algItems.get(i).density = (float) items.get(i).value / items.get(i).weight;

        Collections.sort(algItems.density, Collections.reverseOrder()); 
    }

public static void main(String[] args)
{
    GreedyAlgItem a = new GreedyAlgItem("a", 3, 8, 2, 0);
    GreedyAlgItem b = new GreedyAlgItem("b", 4, 10, 4, 0);
    GreedyAlgItem c = new GreedyAlgItem("c", 2, 12, 3, 0);
    
    ArrayList <GreedyAlgItem> items = new ArrayList<>();
        items.add(a);
        items.add(b);
        items.add(c);

    
    for(GreedyAlgItem flt : items)
        System.out.println(flt);
}




    

}
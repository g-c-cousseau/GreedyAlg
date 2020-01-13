public class GreedyAlg
{

    public static void fractionalKnapsack(GreedyAlgItem items[], int wC)
    {

        int nOfItems = items.length;

        //calculate density
        
        for(int i = 0; i < nOfItems; i++)
            items[i].density = (float) items[i].value / items[i].weight;

        //sort by density in descending order
        GreedyAlgItem temp;
        for(int i = 1; i < nOfItems; i++)
        {
            for(int j = 0; j < nOfItems - i; j++)
                if(items[j+1].density > items[j].density)
                {
                    temp = items[j+1];
                    items[j+1] = items[j];
                    items[j] = temp;
                }
        }

        double weightLeft, totalWeight = 0;
        float value;

        float totalValue = 0;
        int weightCapacity = wC;

        //checking for the weight constraint and printing the picked ones
        for(int i = 0; i < nOfItems; i++)
        {
            if(items[i].weight + totalWeight <= wC)
            {
                totalWeight += items[i].weight;
                totalValue += items[i].value;

                System.out.println("Selected Item: " + items[i].name + " Item's weight: " + items[i].weight + " and value: " + items[i].value);
            }
            else
            {
                weightLeft = wC - totalWeight;
                value = (float) (weightLeft * (float) items[i].density);

                totalValue += value;

                System.out.println("Selected Item: " + items[i].name + " Item's weight: " + items[i].weight + " and value: " + items[i].value);
                break;
            }
        }

        System.out.println("Total Value: " + totalValue);
        
    }
    public static void main(String[] args)
    {
        GreedyAlgItem o1 = new GreedyAlgItem("o1", 3, 4, 0);
        GreedyAlgItem o2 = new GreedyAlgItem("o2", 4, 2, 0);
        GreedyAlgItem o3 = new GreedyAlgItem("o3", 7, 5, 0);
        GreedyAlgItem o4 = new GreedyAlgItem("o4", 3, 3, 0);
        GreedyAlgItem o5 = new GreedyAlgItem("o5", 3, 1, 0);
        GreedyAlgItem o6 = new GreedyAlgItem("o6", 5, 6, 0);

        GreedyAlgItem[] items = {o1, o2, o3, o4, o5, o6};
        fractionalKnapsack(items, 20);

    }
}

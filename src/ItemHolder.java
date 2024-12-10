import java.util.ArrayList;

public class ItemHolder {
    private ArrayList<Item> items= new ArrayList<>();

    public ItemHolder(ArrayList<Item> items) {
        this.items = items;
    }
    public ItemHolder(Item[] items) {
        for (Item item : items) {
            this.items.add(item);
        }

    }

    public ArrayList<Item> getItems() {
        return items;
    }
    public void addItems(Item it) {
        if (!items.contains(it)){
            items.add(it);
        }
    }
    public void delItem(Item it) {
        if (items.contains(it)){
            items.remove(it);
        }
    }
    public void printItems(){
        for (Item i : items) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

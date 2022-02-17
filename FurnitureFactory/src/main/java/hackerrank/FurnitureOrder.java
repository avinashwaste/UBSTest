package hackerrank;

import java.util.HashMap;
import java.util.Objects;
import java.util.stream.Collectors;

public class FurnitureOrder implements FurnitureOrderInterface {
    /**
     * TODO: Create a map of Furniture items to order quantities
     */
    private HashMap<Furniture,Integer> ordersMapList;

    /**
     * Initialize a new mapping of Furniture types to order quantities.
     */
    FurnitureOrder() {
        // TODO: Complete the constructor
        // Don't know initial size of map
        ordersMapList= new HashMap<>();
    }

    public void addToOrder(final Furniture type, final int furnitureCount) {
        // TODO: Complete the method
        this.ordersMapList.put(type,furnitureCount);
    }

    public HashMap<Furniture, Integer> getOrderedFurniture() {
        // TODO: Complete the method
        return this.ordersMapList;
    }

    public float getTotalOrderCost() {
        // TODO: Complete the method
        return (float) this.ordersMapList
                .entrySet()
                .stream()
                .map(furniture -> furniture.getKey().cost() * furniture.getValue())
                .collect(Collectors.summarizingDouble(x -> x))
                .getSum();
    }

    public int getTypeCount(Furniture type) {
        // TODO: Complete the method
        return Objects.isNull(this.ordersMapList.get(type))?0:this.ordersMapList.get(type);
    }

    public float getTypeCost(Furniture type) {
        // TODO: Complete the method
        return Objects.isNull(this.ordersMapList.get(type))?0:(this.ordersMapList.get(type) * type.cost());
    }

    public int getTotalOrderQuantity() {
        // TODO: Complete the method
        return this.ordersMapList
                .values()
                .stream()
                .mapToInt(integer -> integer)
                .sum();
    }
}

package ProblemSolving;

import java.util.*;

class Item {
    Integer pos;
    Integer item;

    public Item(int pos, int item) {
        this.pos = pos;
        this.item = item;
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        Item other = (Item) obj;
        return this.pos == other.pos && this.item == other.item;
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return pos.hashCode() + item.hashCode();
    }

}

public class ValidGrid {

    public static void main(String[] args) {
        int grid[][] = {
                { 1, 2, 3, 4 },
                { 3, 4, 1, 2 },
                { 2, 3, 4, 1 },
                { 4, 1, 2, 3 }
        };
        long time1 = System.currentTimeMillis();
        System.out.println(validate(grid));
        long time2 = System.currentTimeMillis();
        System.out.println(time2-time1);
    }

    public static boolean validate(int grid[][]){
        Set<Item> rowSet = new HashSet<>();
        Set<Item> colSet = new HashSet<>();
        Set<Item> subgridSet = new HashSet<>();
        int subGridLength = (int) Math.sqrt(grid.length);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if(grid[i][j] == '.')
                    continue;
                
                Item item = new Item(i, grid[i][j]-'0');
                if(rowSet.contains(item))
                    return false;
                else{
                    rowSet.add(item);
                }
                item = new Item(j, grid[i][j]-'0');
                if(colSet.contains(item))
                    return false;
                else{
                    colSet.add(item);
                }
                int pos = (i/subGridLength)*subGridLength;

                item = new Item( pos + j/subGridLength,   grid[i][j]-'0');
                if(subgridSet.contains(item))
                    return false;
                else{
                    subgridSet.add(item);
                }
            }    
        }
        return true;
    }
}

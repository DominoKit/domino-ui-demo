package org.dominokit.domino.datatable.client.views.model;

import org.dominokit.domino.datatable.client.views.ui.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TreeGridSample implements TreeNode<TreeGridSample> {

    private int id;
    private String name;
    private List<TreeGridSample> items = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setItems(List<TreeGridSample> items) {
        this.items = items;
    }

    @Override
    public List<TreeGridSample> getItems() {
        return items;
    }

    public static List<TreeGridSample> create() {
        List<TreeGridSample> items = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            TreeGridSample sample = new TreeGridSample();
            sample.setId(i);
            sample.setName("first " + i);
            List<TreeGridSample> children = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                TreeGridSample subItem = new TreeGridSample();
                subItem.setId(j + 1);
                subItem.setName("child " + i + j);
                List<TreeGridSample> children2 = new ArrayList<>();
                for (int k = 0; k < 2; k++) {
                    TreeGridSample subItem2 = new TreeGridSample();
                    subItem2.setId(k + 1);
                    subItem2.setName("child " + i + j + k);
                    List<TreeGridSample> children22 = new ArrayList<>();
                    for (int s = 0; s < 2; s++) {
                        TreeGridSample subItem22 = new TreeGridSample();
                        subItem22.setId(s + 1);
                        subItem22.setName("child " + i + j + k + s);
                        children22.add(subItem22);
                    }
                    subItem2.setItems(children22);
                    children2.add(subItem2);
                }
                subItem.setItems(children2);
                children.add(subItem);
            }
            sample.setItems(children);
            items.add(sample);
        }
        return items;
    }
}

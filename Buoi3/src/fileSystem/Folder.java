package fileSystem;

import java.util.ArrayList;
import java.util.List;

class Folder implements IFileSystem {
    private String name;
    private List<IFileSystem> children = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void add(IFileSystem component) {
        children.add(component);
    }

    public void remove(IFileSystem component) {
        children.remove(component);
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "+ [Folder] " + name);
        for (IFileSystem component : children) {
            component.display(indent + "   "); // Thụt dòng để hiển thị cây
        }
    }
}
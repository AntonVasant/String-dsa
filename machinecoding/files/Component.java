package machinecoding.files;

public interface Component {

    void ls();
    void mkdir(String name);
    void cd(String path);
    void delete();
    void addContent(String content);
    void modifyContent(String content);
    void restore(Component component);

}

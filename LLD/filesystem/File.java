package LLD.filesystem;

import java.util.Date;
import java.util.List;

public class File {
    private String path;
    private String name;
    private String type;
    private Date createdDate;
    private Date modified;
    private List<String> permissions;
    private byte[] content;
    private int size;

    public File(String name,String path,String type,List<String> permissions) {
        this.name = name;
        this.path = path;
        this.type = type;
        this.permissions = permissions;
        modified = new Date();
        createdDate = new Date();
        content = new byte[0];
        size = 0;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}

package cn.leithda.model;

/**
 * Created with IntelliJ IDEA.
 * User: leithda
 * Date: 2021/2/25
 * Description: 权限
 */
public class Permission {

    private Integer pid;

    private String name;

    private String url;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

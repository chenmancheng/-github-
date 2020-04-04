package soft.pojo;

import java.util.Date;

public class Comment {
    private Integer id;

    private String pid;

    private String name;

    private String headportrait;

    private String content;

    private Date sendtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeadportrait() {
        return headportrait;
    }

    public void setHeadportrait(String headportrait) {
        this.headportrait = headportrait;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getSendtime() {
        return sendtime;
    }

    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", pid='" + pid + '\'' +
                ", name='" + name + '\'' +
                ", headportrait='" + headportrait + '\'' +
                ", content='" + content + '\'' +
                ", sendtime=" + sendtime +
                '}';
    }

    public Comment(Integer id, String pid, String name, String headportrait, String content, Date sendtime) {
        this.id = id;
        this.pid = pid;
        this.name = name;
        this.headportrait = headportrait;
        this.content = content;
        this.sendtime = sendtime;
    }

    public Comment() {
    }
}
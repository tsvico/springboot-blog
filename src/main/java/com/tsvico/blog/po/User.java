package com.tsvico.blog.po;

import javax.persistence.*;
import java.sql.DatabaseMetaData;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author tsvico
 * @email tsxygwj@gmail.com
 * @time 2019/8/13 12:52
 * 功能
 */
@Entity
@Table(name = "t_user")
public class User {

    @Id  //声明主键
    @GeneratedValue
    private Long id;
    private String nickname;
    private String username;
    private String password;
    private String email;
    private String avatar; //头像
    private Integer type; //权限分类
    @Temporal(TemporalType.TIMESTAMP)  //指定数据库存储时间类型
    private Date createTime;
    @Temporal(TemporalType.TIMESTAMP)  //指定数据库存储时间类型
    private Date updateTime;

    @OneToMany(mappedBy = "user") //关系被维护端
    private List<Blog> blogs = new ArrayList<>();
    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", avatar='" + avatar + '\'' +
                ", type=" + type +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}

package asai.kola.pojo;

public class LoginInfo {
    private Integer id;  // 员工ID
    private String username;  //用户名
    private String user;  //姓名
    private String token;  //令牌


    public LoginInfo() {
    }

    public LoginInfo(Integer id, String username, String user, String token) {
        this.id = id;
        this.username = username;
        this.user = user;
        this.token = token;
    }

    /**
     * 获取
     *
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取
     *
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取
     *
     * @return user
     */
    public String getUser() {
        return user;
    }

    /**
     * 设置
     *
     * @param user
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * 获取
     *
     * @return token
     */
    public String getToken() {
        return token;
    }

    /**
     * 设置
     *
     * @param token
     */
    public void setToken(String token) {
        this.token = token;
    }

    public String toString() {
        return "LoginInfo{id = " + id + ", username = " + username + ", user = " + user + ", token = " + token + "}";
    }
}

package soft.pojo;

public class User {
    private Integer id;

    private String tel;

    private String password;

    private String name;

    private String gender;

    private Integer age;

    private String signature;

    private String question;

    private String answer;

    private String headportrait;

    private String address;

    private Integer permissions;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getHeadportrait() {
        return headportrait;
    }

    public void setHeadportrait(String headportrait) {
        this.headportrait = headportrait;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPermissions() {
        return permissions;
    }

    public void setPermissions(Integer permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", tel='" + tel + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", signature='" + signature + '\'' +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", headportrait='" + headportrait + '\'' +
                ", address='" + address + '\'' +
                ", permissions=" + permissions +
                '}';
    }

    public User() {
    }

    public User(Integer id, String tel, String password, String name, String gender, Integer age, String signature, String question, String answer, String headportrait, String address, Integer permissions) {
        this.id = id;
        this.tel = tel;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.signature = signature;
        this.question = question;
        this.answer = answer;
        this.headportrait = headportrait;
        this.address = address;
        this.permissions = permissions;
    }
}
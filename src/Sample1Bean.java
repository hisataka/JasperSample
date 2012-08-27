public class Sample1Bean {
    
    public Sample1Bean() {

    }

    public Sample1Bean(String code, String name, String num) {
        this.code = code;
        this.name = name;
        this.num = num;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    private String code;
    private String name;
    private String num;
}
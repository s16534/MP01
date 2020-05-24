public class Agency extends ObjectPlusPlus {
    private String name;
    private String regon;
    private String nip;
    private String phone;
    private String mail;


    public Agency(String name, String regon, String nip, String phone, String mail) {
        super();
        this.name = name;
        this.regon = regon;
        this.nip = nip;
        this.phone = phone;
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "Agency{" +
                "name='" + name + '\'' +
                ", regon='" + regon + '\'' +
                ", nip='" + nip + '\'' +
                ", phone='" + phone + '\'' +
                ", mail='" + mail + '\'' +
                "}\n";
    }
}

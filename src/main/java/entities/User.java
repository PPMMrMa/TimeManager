package entities;

public class User {
 private  String id;
 private String name;
 private String phoneNumber;
 private char  sex;
 private String password;
 private String address;
 private String organization;
 private String remark;
 private  String  head;



    private  String[] groupId;
 private  String[] friendsId;
    public String[] getGroupId() {
        return groupId;
    }

    public void setGroupId(String[] groupId) {
        this.groupId = groupId;
    }

    public String[] getEventId() {
        return eventId;
    }

    public void setEventId(String[] eventId) {
        this.eventId = eventId;
    }

    private  String[] eventId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex='男';
        if(sex=='女'){
            this.sex='女';
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String[] getFriendsId() {
        return friendsId;
    }

    public void setFriendsId(String[] friendsId) {
        this.friendsId = friendsId;
    }
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


}

package User;

public class Group {
    private String id;
    private  String name;
    private  String ownerId;
    private  String[] usersId;





    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String[] getUsersId() {
        return usersId;
    }

    public void setUsersId(String[] usersId) {
        this.usersId = usersId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}

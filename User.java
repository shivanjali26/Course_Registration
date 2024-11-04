public class User
{
    String Name;
    String Email;
    String Id;

    User(String Id,String Name,String Email)
    {
        this.Id=Id;
        this.Name=Name;
        this.Email=Email;
    }
    public String getId()
    {
        return Id;
    }
//    public String getName()
//    {
//        return Name;
//    }
//    public String getEmail()
//    {
//        return Email;
//    }
}
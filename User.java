public abstract class User
{
    private final String Name;
    private final String Email;
    private final String Id;

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
    public String getName()
    {
        return Name;
    }
    public String getEmail()
    {
        return Email;
    }
    public abstract void showInfo();
}
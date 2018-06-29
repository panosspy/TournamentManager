package tournament;

public class Players {
    
    String name;
    String nickname;
    String mail;
    String playgame;

    public void setMmail(String mail)
    {
        this.mail = mail;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setNickname(String nickname){
        this.nickname = nickname;
    }

    public void setPlaygame(String playgame){
        this.playgame = playgame;
    }

    public String getMail()
    {
        return mail;
    }

    public String getName()
    {
        return name;
    }

    public String getNickname()
    {
        return nickname;
    }

    public String getPlaygame()
    {
        return playgame;
    }

   
}
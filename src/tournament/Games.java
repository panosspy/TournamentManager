
package tournament;

import java.util.Date;


class Games{

    String name_game;
    String type;
    int max_num;
    Date game_date;
    Date time;
    String game_place;
    String moderator;
    int duration;

    public int getMax_num() {
        return max_num;
    }

    public void setMax_num(int max_num) {
        this.max_num = max_num;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
    
    public String getName_game()
    {
        return name_game;
    }

    public void setName_game(String name_game)
    {
        this.name_game = name_game;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }



    public Date getGame_date()
    {
        return game_date;
    }

    public void setGame_date(Date game_date)
    {
        this.game_date = game_date;
    }

    public Date getTime()
    {
        return time;
    }

    public void setTime(Date time)
    {
        this.time = time;
    }

    public String getGame_place()
    {
        return game_place;
    }

    public void setGame_place(String game_place)
    {
        this.game_place = game_place;
    }

    public String getModerator()
    {
        return moderator;
    }

    public void setModerator(String moderator)
    {
        this.moderator = moderator;
    }
}
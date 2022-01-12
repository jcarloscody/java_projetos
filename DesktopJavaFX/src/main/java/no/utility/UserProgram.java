package no.utility;

import no.entities.User;

public final class UserProgram {
     User user ;

    public UserProgram(User user){
        this.user = user;
    }

    public void setUserName(User u){
        this.user = u;
    }

    public User getUser(){
        return this.user;
    }
}

package com.mygdx.game;
/**
 * login object class for storing a user name to its corisponding
 * passcode
 *
 * Currently unused as frame work
 *
 * @author John Barmen
 */
public class login {

    private String uname = "";
    private String passcode = "";
    private String temp = "";

    /**
     * creates a new login object with defualt "nullName" and "nullPass"
     * @constructor
     */
    public login() {
        setUname();
        setPasscode();
    }

    /**
     * takes a user name and pass word and creates a new login object
     * @constructor
     * @param user
     * @param pass
     */
    public login(String user, String pass) {
        uname = user;
        passcode = pass;
    }

    /**
     * returns passcode
     * @return
     */
    private String getPasscode() {
        return passcode;
    }

    /**
     * returns uname
     * @return
     */
    public String getUname() {
        return uname;
    }

    /**
     * sets uname to the default of "nullName"
     */
    public void setUname() {
        setUname("nullName");
    }

    /**
     * takes a new user name and sets uname to that
     * @param newName
     */
    public void setUname(String newName) {
            uname = newName;

    }

    /**
     * sets passcode to the defualt of "nullPass"
     */
    public void setPasscode(){
        setPasscode("nullPass");
    }

    /**
     * takes a new pass word and sets passcode to that
     * @param passcode
     */
    public void setPasscode(String passcode) {
        this.passcode = passcode;
    }

    /**
     *
     */
    //private string secScramble(string in) {
    //    temp = in;
    //    return temp;
    //}

    /**
     * a string of uname and pass code
     * @return
     */
    public String sendUser() {
        temp = getUname();
        temp.concat("//");
        temp.concat(getPasscode());
       // temp = secScramble(temp);
        return temp;
    }
}

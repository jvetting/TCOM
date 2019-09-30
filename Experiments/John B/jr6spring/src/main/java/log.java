public class log{

    private String uname = new String();
    private String passcode = new String();
    private String temp = new String;
    public log() {

    }

    public log(String user; String pass) {
        uname = user;
        pass = passcode;
    }

    private String getPasscode() {
        return passcode;
    }

    public String getUname(){
        return uname;
    }
    public void setUname(String newName; String pass) {
        if (pass == passcode){
            uname = newName;
        }
    }

    public void setPasscode(String passcode) {
        this.passcode = passcode;
    }

    private string secScramble(string in){
        temp = in;
        return temp;
    }

    public String sendUser(){
        temp = getUname();
        temp.concat("//");
        temp.concat(getPasscode());
        temp = secScramble(temp)
        return temp;
    }
}
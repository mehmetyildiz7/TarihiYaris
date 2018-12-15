package com.example.karahan.tarihiyaris;

import java.nio.file.attribute.UserDefinedFileAttributeView;

public class Users {

//cevap,fotoğrafyolu,doğru cevapladığı,yanlış cevapladığı,
private String UserId;
    private String UserName;
    private String UserSurName;
    private String UserEmail;
    private String UserPassword;
    private  String UserAge;
    private  String UserGender;
    private String ImagePath;
    private String friends; //ıdsine göre arkadaşı eklicek veya silecek...
    private  String score;
    private boolean verify;


    public Users(String usname,String usmail,String usrSurName,String userPassword){
        this.UserName=usname;
        this.UserEmail=usmail;
        this.UserSurName=usrSurName;
        this.UserPassword=userPassword;
    }
    public Users(){

    }
    public  String getUserId()
    {
        return  UserId;
    }
    public void setUserId(String userid)
    {
        this.UserId=userid;
    }
    public  String getUserName()
    {
        return  UserName;
    }
    public  void setUserName(String username)
    {
        this.UserName=username;
    }
    public String getUserEmail()
    {
        return  UserEmail;
    }
    public void setUserEmail(String usermail)
    {
        this.UserEmail=usermail;
    }

    public void setUserSurName(String userSurName) {
        UserSurName = userSurName;
    }

    public String getUserSurName() {
        return UserSurName;
    }

    public Users(String usid, String usname, String usmail, String userPassword, String userGender, String userAge)
    {
        this.UserId=usid;
        this.UserName=usname;
        this.UserEmail=usmail;

    }
    public Users(String usid, String usname,String usrSurName, String usmail, String userPassword)
    {
        this.UserId=usid;
        this.UserName=usname;
        this.UserEmail=usmail;
        this.UserSurName=usrSurName;
        this.UserPassword=userPassword;

    }

    public Users(String usid,String usname,String usmail,String passwd,String imagePath,String userGender,String userAge)
    {
        this.UserId=usid;
        this.UserName=usname;
        this.UserEmail=usmail;
        this.UserPassword=passwd;
        this.ImagePath=imagePath;
        this.UserGender=userGender;
        this.UserAge=userAge;

    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getFriends() {
        return friends;
    }

    public void setFriends(String friends) {
        this.friends = friends;
    }

    public String getUserPassword()
    {
        return UserPassword;
    }
    public void setUserPassword(String userPassword)
    {
        this.UserPassword=userPassword;
    }
    public  String getUserAge()
    {
        return UserAge;
    }
    public void  setUserAge(String userage)
    {
        this.UserAge=userage;
    }
    public String getUserGender()
    {
        return UserGender;
    }
    public  void setUserGender(String usergender)
    {
        this.UserGender=usergender;
    }
    public String getImagePath()
    {
        return ImagePath;
    }
    public void  setImagePath(String imagePath)
    {
        this.ImagePath=imagePath;
    }


}


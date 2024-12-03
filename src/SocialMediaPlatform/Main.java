package SocialMediaPlatform;

import Model.DataBase;
import View.Welcome;

public class Main {
    public static void main(String[] args) {
        new Welcome(new DataBase());
    }
}

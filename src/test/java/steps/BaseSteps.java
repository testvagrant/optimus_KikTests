package steps;

import com.testvagrant.optimus.device.OptimusController;
import com.testvagrant.optimus.entity.SmartBOT;
import entities.Credentials;
import entities.User;
import io.appium.java_client.AppiumDriver;
import pages.LoginPage;
import utils.OptimusImpl;

import java.util.LinkedHashMap;
import java.util.List;

import static utils.JsonMapper.getCredentials;

public class BaseSteps {


    protected static OptimusImpl optimus;
    protected static OptimusController controller;
    protected static List<SmartBOT> smartBOTs;
    private LinkedHashMap<String,String> conversation;

    protected AppiumDriver getDriverInstanceFor(String appConsumer) {
        return getSmartBOTBelongingTo(appConsumer).getDriver();
    }

    protected SmartBOT getSmartBOTBelongingTo(String appConsumer) {
        return optimus.findBOTFor(appConsumer);
    }

    protected AppiumDriver getDriverForUser1() {
        return getDriverInstanceFor("user1");
    }

    protected AppiumDriver getDriverForUser2() {
        return getDriverInstanceFor("user2");
    }

    protected User user1(String userDetails) {
        Credentials credentials = getCredentials(userDetails);
        User user1 = credentials.getUser1();
        return user1;
    }

    protected User user2(String userDetails) {
        Credentials credentials = getCredentials(userDetails);
        User user2 = credentials.getUser2();
        return user2;
    }

    protected void loginAsUser1(String username,String password){
        new LoginPage(getDriverForUser1()).enterUsername(username);
        new LoginPage(getDriverForUser1()).enterPassword(password);
        new LoginPage(getDriverForUser1()).tapOnLogin();
    }

    protected void loginAsUser2(String username,String password){
        new LoginPage(getDriverForUser2()).enterUsername(username);
        new LoginPage(getDriverForUser2()).enterPassword(password);
        new LoginPage(getDriverForUser2()).tapOnLogin();
        try {
            new LoginPage(getDriverForUser2()).tapOnNotNowButton();
            new LoginPage(getDriverForUser2()).tapOnConfirmButton();
        } catch (Exception e) {

        }
    }

    protected void loginAsUser1(String userDetails) {
        System.out.println("Navigating to login page...");
        User user1 = user1(userDetails);
        System.out.println("Logging in as user1...");
        System.out.println("With name -- " + user1.getUsername());
        new LoginPage(getDriverForUser1()).enterUsername(user1.getUsername());
        System.out.println("With password -- " + user1.getPassword());
        new LoginPage(getDriverForUser1()).enterPassword(user1.getPassword());
        new LoginPage(getDriverForUser1()).tapOnLogin();
    }

    protected void loginAsUser2(String userDetails) {
        System.out.println("Navigating to login page...");
        User user2 = user2(userDetails);
        System.out.println("Logging in as user2...");
        System.out.println("With name -- " + user2.getUsername());
        new LoginPage(getDriverForUser2()).enterUsername(user2.getUsername());
        System.out.println("With password -- " + user2.getPassword());
        new LoginPage(getDriverForUser2()).enterPassword(user2.getPassword());
        new LoginPage(getDriverForUser2()).tapOnLogin();
        try {
            new LoginPage(getDriverForUser2()).tapOnNotNowButton();
            new LoginPage(getDriverForUser2()).tapOnConfirmButton();
        } catch (Exception e) {

        }
    }

    protected LinkedHashMap<String,String> getConversation(){
        conversation = new LinkedHashMap<>();
        conversation.put("Hi","Hey");
        conversation.put("Have you heard about Optimus?","What is it?");
        conversation.put("It's the cool new inter-app testing framework created by TestVagrant","Wow!Tell me more.");
        conversation.put("Testing apps never got so easy!","If it's so,I gotta use it!");
        return conversation;
    }
}

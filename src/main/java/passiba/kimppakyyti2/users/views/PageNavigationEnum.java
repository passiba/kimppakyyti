/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passiba.kimppakyyti2.users.views;

/**
 *
 * @author pauline
 */
public enum PageNavigationEnum {
    CREATE_ACCOUNT("register"),
    HOME("home");

    /**
     * Navigation Step
     */
    private String navigationStep;

    /**
     * Creates a new navigation step
     * @param navigationStep - navigation step
     */
    private PageNavigationEnum(String navigationStep) {
        this.navigationStep = navigationStep;
    }

    /**
     * Returns the navigation step
     * @return navigation step
     */
    public String toString() {
        return navigationStep;
    }

    
}

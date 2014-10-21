/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passiba.kimppakyyti2.users.views;

import java.util.ResourceBundle;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;

/**
 *
 * @author pauline
 */
public class MessageBundleProvider {
    
    /**
     * Resource bundle
     */
    private transient ResourceBundle bundle;

    /**
     * Produces message bundles for the application
     * @return Resource Bundle
     */
    @Produces @MessageBundle
    public ResourceBundle getBundle() {
        if (bundle == null) {
            FacesContext context = FacesContext.getCurrentInstance();
            bundle = context.getApplication().getResourceBundle(context, "msg");
        }
        return bundle;
    }
    
}

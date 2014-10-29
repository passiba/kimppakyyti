package passiba.kimppakyyti2.users.views;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Size;
import org.primefaces.event.SelectEvent;
import passiba.kimppakyyti2.driver.service.DriverSessionBeanLocal;
import passiba.kimppakyyti2.entities.Drivers;
import passiba.kimppakyyti2.entities.Users;
import passiba.kimppakyyti2.login.bean.AnonymousUser;
import passiba.kimppakyyti2.login.bean.AuthenticatedUser;
import passiba.kimppakyyti2.login.service.TravellerSessionBeanLocal;
import passiba.kimppakyyti2.users.beans.UsersFacade;
import passiba.kimppakyyti2.users.views.util.JsfUtil;
import passiba.kimppakyyti2.users.views.util.JsfUtil.PersistAction;

@Named("usersController")
@ConversationScoped
public class UsersController implements Serializable{

    @Inject
    private passiba.kimppakyyti2.users.beans.UsersFacade ejbFacade;
    
    @Inject @MessageBundle
    private transient ResourceBundle bundle;
    
      
    private List<Users> items = null;
    
    
    private User user = new User();
    
    /**
     * User
     */
     @Inject @AuthenticatedUser
    private Users currentUser;

    
    private Users selected;
    
     /** Navigation Step - 2
     */
    private static final String NAVIGATION_STEP_2 = "step2";

    /**
     * Navigation Step - 3
     */
    private static final String NAVIGATION_STEP_3 = "step3";


    
     /**
     * Conversation - this bean is conversationally scoped.
     */
    @Inject
    private Conversation conversation;

    /**
     * User email - creates the account
     */
    @EJB
    private TravellerSessionBeanLocal userService;

    @EJB
    private  DriverSessionBeanLocal driverSerivce;

   // private PhoneNumber phoneNumber;
    
     /**
     * True if step 1 has been completed
     */
    private boolean step1;

    /**
     * True if step 2 has been completed
     */
    private boolean step2;


     /**
     * Starts the conversation for creating a new account
     */
    @PostConstruct
    public void beginAccountCreateConversation() {
        if(conversation.getId() == null) {
            conversation.begin();
        }
    }
    
    
    

    public UsersController() {
    }
    
    
    
        /**
     * Processes the first step which is entry of the login information.
     * @return step2
     */
    public String processFirstStep() {
        
        
        if(user!=null && user.getPassword() !=null  && user.getPasswordConfirm()!=null
               
               && ! (user.getPassword().compareTo(user.getPasswordConfirm())==0)) {
            String passwordMustMatch = "Passwords must match";
            //bundle.getString(ResourceBundleKeys.step1_passwordMustMatch.getKey());
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,passwordMustMatch,passwordMustMatch));
            // TODO check the database to see if we already have a user with the same name

            
            return null;
            
        }
    
        step1 = true;
        return NAVIGATION_STEP_2;
    }
    
     /**
     * Process the second step which is entry of the biographical data
     * @return step3
     */
    public String processSecondStep() {
        // comparing travelling from and travelling to values
        
        if(user!=null && user.getTravellingTo() !=null  && user.getTravellingFrom() !=null
               
               &&  (user.getTravellingTo().compareTo(user.getTravellingFrom())==0)) {
            String departureAndDestinaionMustNotMatch ="Departure and Destination cannot be the same";
                    //bundle.getString(ResourceBundleKeys.step1_passwordMustMatch.getKey());
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,departureAndDestinaionMustNotMatch,departureAndDestinaionMustNotMatch));
            return null; 
        }
        
        //check that traveltime is not set to pastr
        
        if(user.getTravelltime().before(Calendar.getInstance().getTime()))
        {
             String traveltimeIsInPast = "Travel time can not be  in past ";
//bundle.getString(ResourceBundleKeys.step2_traveltimeIsInPast.getKey());
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,traveltimeIsInPast,traveltimeIsInPast));
            return null; 
                    
        }
        step2 = true;
        return NAVIGATION_STEP_3;
    }
    
      /**
     * Creates the bidder
     * @return home page
     */
    public String create2() {
        if(!step1 || !step2) {
            String txt = "skipped the steps";
                //bundle.getString(ResourceBundleKeys.step3_skippedSteps.getKey());
            FacesContext.getCurrentInstance().addMessage("",
                new FacesMessage(txt,txt));
            return PageNavigationEnum.CREATE_ACCOUNT.toString();
        }
        
      /*  BazaarAccount user = new BazaarAccount(firstName,lastName,username,password,address,new Date(),true);
        user.addBillingInfo(creditCard*/
        
        
        if(currentUser!= null && currentUser instanceof AnonymousUser && user!=null)
        {
            currentUser.setPassword(user.getPassword());
            currentUser.setPhonenumber(user.getPhoneNumber());
            currentUser.setGuest(false);
            userService.createUser(currentUser);
            
            //check whatever the user is driver
            if(user.isDriver)
            {
                
                driverSerivce.createDriver(user,currentUser);
            }
              
        }
       
        conversation.end();
        //confirmation phonenumber
        String txt="Confirmation message sent to customer";
//bundle.getString(ResourceBundleKeys.step3_confirmatinPhonenumber.getKey());
        FacesContext.getCurrentInstance().addMessage("",new FacesMessage(txt,txt));
        return PageNavigationEnum.HOME.toString();
    }

    /**
     * Cancels creation - closes out the bean etc.
     * @return home
     */
    public String cancel() {
        conversation.end();
        return PageNavigationEnum.HOME.toString();
    }
    public Users getSelected() {
        return selected;
    }

    public void setSelected(Users selected) {
        this.selected = selected;
    }

   

    private UsersFacade getFacade() {
        return ejbFacade;
    }

    public Users prepareCreate() {
        selected = new Users();
      
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("UsersCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("UsersUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("UsersDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Users> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Users getUsers(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<Users> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Users> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Users.class)
    public static class UsersControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            UsersController controller = (UsersController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "usersController");
            return controller.getUsers(getKey(value));
        }

        java.lang.Long getKey(String value) {
            java.lang.Long key;
            key = Long.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Long value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Users) {
                Users o = (Users) object;
                return getStringKey(o.getUserId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Users.class.getName()});
                return null;
            }
        }

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
       
    

}

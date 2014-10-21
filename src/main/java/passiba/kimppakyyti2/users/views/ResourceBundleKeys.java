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
public enum ResourceBundleKeys {
    
    step3_skippedSteps("step3_skippedSteps"),
    step1_passwordMustMatch("step1_passwordMustMatch"),
    step2_departureAndDestinaionMustNotMatch("step2_departureAndDestinaionMustNotMatch"),
    step2_traveltimeIsInPast("step2_traveltimeIsInPast"),
    step3_confirmatinPhonenumber("step3_confirmatinPhonenumber");

    /**
     * Key
     */
    private String key;

    /**
     * Creates a new enumeration
     * @param key - resource key
     */
    private ResourceBundleKeys(String key) {
        this.key = key;
    }

    /**
     * Returns the key
     * @return key
     */
    public String getKey() {
        return key;
    }

    
}

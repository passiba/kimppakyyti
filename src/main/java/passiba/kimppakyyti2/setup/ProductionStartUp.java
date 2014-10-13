/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passiba.kimppakyyti2.setup;

import java.util.logging.Logger;

/**
 *
 * @author pauline
 */
public class ProductionStartUp {
    
      /**
     * Logger
     */
    private static final Logger logger = Logger.getLogger("SystemStartup");
    
    /**
     * Performs initialization
     */
    public void init() {
        logger.info("Production system startup - initializing the system.");
    }
    
}

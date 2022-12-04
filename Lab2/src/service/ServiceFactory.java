package service;

import service.impl.ApplianceServiceImpl;

/**
 * Factory for creating an instance of ApplianceService
 */
public final class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    /**
     * Private constructor
     */
    private ServiceFactory() {
    }

    /**
     * Gets new instance of ApplianceService
     *
     * @return mew ApplianceService object
     */
    public ApplianceService getApplianceService() {

        return new ApplianceServiceImpl();
    }

    /**
     * Gets current instance of ServiceFactory
     *
     * @return instance of ServiceFactory
     */
    public static ServiceFactory getInstance() {
        return instance;
    }

}
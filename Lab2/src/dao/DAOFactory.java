package dao;

import dao.impl.ApplianceDAOImpl;

/**
 * A factory for creating ApplianceDAO.
 */
public final class DAOFactory {
    /**
     * Singletone instance of DAOFactory
     */
    private static final DAOFactory instance = new DAOFactory();

    private DAOFactory() {}

    /**
     * @return instance of DAOFactory 
     */
    public static DAOFactory getInstance() {
        return instance;
    }

    public ApplianceDAO getApplianceDAO() {
        return new ApplianceDAOImpl();
    }
}
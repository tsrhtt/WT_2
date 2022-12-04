package service.impl;

import dao.ApplianceDAO;
import dao.DAOFactory;
import entity.Appliance;
import entity.criteria.Criteria;
import service.ApplianceService;
import service.validation.Validator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The type of appliance xml service.
 */
public class ApplianceServiceImpl implements ApplianceService{
    /**
     * Finds all appliances that fit the criteria if criteria are valid.
     * @param criteria
     * @return list of found appliances
     */
    @Override
    public List<Appliance> find(Criteria criteria) {
        if (Validator.validCriteria(criteria)) {
            ApplianceDAO applianceDAO = DAOFactory.getInstance().getApplianceDAO();
            return applianceDAO.find(criteria);
        }
        else
            return null;
    }

    @Override
    public List<Appliance> sort(Comparator<Appliance> comparator) {
        List<Appliance> appliances = DAOFactory.getInstance().getApplianceDAO().parseAll();
        appliances.sort(comparator);
        return appliances;
    }

    @Override
    public List<Appliance> sort(Comparator<Appliance> comparator, List<Appliance> appliances) {
        appliances.sort(comparator);
        return appliances;
    }

    @Override
    public List<Appliance> getMin(Comparator<Appliance> comparator) {
        List<Appliance> appliances = DAOFactory.getInstance().getApplianceDAO().parseAll();
        Appliance min = appliances.stream().min(comparator).orElse(null);
        if (min != null) {
            return appliances.stream()
                    .filter(p -> comparator.compare(p, min) == 0)
                    .collect(Collectors.toList());
        }

        return new ArrayList<>();
    }

    @Override
    public List<Appliance> getMin(Comparator<Appliance> comparator, List<Appliance> appliances) {
        Appliance min = appliances.stream().min(comparator).orElse(null);
        if (min != null) {
            return appliances.stream()
                    .filter(p -> comparator.compare(p, min) == 0)
                    .collect(Collectors.toList());
        }

        return new ArrayList<>();
    }

    @Override
    public void save(List<Appliance> appliances){
        DAOFactory.getInstance().getApplianceDAO().save(appliances);
    }
}